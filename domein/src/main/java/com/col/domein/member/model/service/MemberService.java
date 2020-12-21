package com.col.domein.member.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.col.domein.mail.model.vo.SignUpVerificationEmail;
import com.col.domein.member.model.dao.MemberDao;
import com.col.domein.member.model.vo.EmailCheck;
import com.col.domein.member.model.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberDao md;
	@Autowired
	private SqlSession session;
	@Autowired
	private JavaMailSender mailSender;

	public boolean isEmptyData(Map<String, String> map) {

		return md.isEmptyData(session, map);
	}
	
	public boolean insertMemberPoint(int memberKey, int pointDifference) {
		boolean flag = false;
		Map<String, Integer> values = new HashMap<String, Integer>();
		values.put("memberKey",memberKey);
		values.put("pointDifference", pointDifference);
		flag = md.insertMemberPoint(session, values);
		return flag;
	}
	
	public int insertMember(Member m) {

		int memberKey = md.getSeqMemberKeyNextVal(session);
		
		m.setMemberKey(memberKey);
		
		boolean flag = false;
		try {
			flag = md.insertMember(session, m);
			flag = insertMemberPoint(m.getMemberKey(), 3000);
		} catch (Exception e) {
//			에러가 나면 -1로 멤버키를 보낸다. 컨트롤러에서 이를 보고 비지니스를 애드할지에 대해서 판단!
			memberKey = -1;
		}
		
		if (flag == false)
			memberKey = -1;

		return memberKey;
	}

	public boolean sendEmailVerification(Member m, HttpServletRequest request) {
		int memberKey = m.getMemberKey();
		boolean flag = false;
		String encodedRandomKey = createConfirmationKey();
		///////////////////////////////////////////////

		boolean createKeyFlag = insertConfirmationKey(memberKey, encodedRandomKey);
		if (!createKeyFlag) return false;

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper messageHelper;
		try {
			messageHelper = new MimeMessageHelper(message, true,"UTF-8");
			messageHelper.setFrom("domein2020@gmail.com");
			messageHelper.setTo(m.getEmail());
			messageHelper.setSubject("[도매-인]이메일 인증 메일입니다");
			messageHelper.setText(new SignUpVerificationEmail(m, request, encodedRandomKey).emailContent(),true);
			
			mailSender.send(message);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return flag;
	}
	
	public List<Map> selectMemberList(int cPage, int numperPage){
		
		return md.selectMemberList(session,cPage,numperPage);
		
	}

	public String createConfirmationKey() {
//		confirmation_key 만드는 로직
		List<Character> randomKey = new ArrayList<Character>();
		while (randomKey.size() < 6) {
			char c = (char) (int) (Math.random() * 'z' + 1);
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
				randomKey.add(c);
		}
		String stringRandomKey = "";

		for (char c : randomKey)
			stringRandomKey += c;

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedRandomKey = encoder.encode(stringRandomKey);

		return encodedRandomKey;
	}

	public boolean insertConfirmationKey(int memberKey, String encodedRandomKey) {

//		DB에 생성된 키 넣기
		Map<String, String> keys = new HashMap<String, String>();
		keys.put("memberKey", "" + memberKey);
		keys.put("confirmationKey", encodedRandomKey);

		boolean createKeyFlag = md.insertConfirmationKey(session, keys);

		return createKeyFlag;
	}
	
	public int accountVerify(int memberKey, String confirmationKey, HttpServletRequest request) {
		
//		1.먼저 해당 멤버키의 Email_check데이터가 있는지 확인하고, 그것을 받아온다.
		EmailCheck ec = md.selectEmailCheck(session,memberKey);
//		2.
//		1)try_count가 5회 이하
//      2)reg_date가 24시간을 넘지 않았고 
//		3)인증키가 일치하면 인증 -> 멤버 is_confirmed를 1로 바꿔줌 / 인증키 지움 ->1
//		 else 1-1)인증키가 일치하지 않으면 try_count를 1회 증가 ->2
//			-> 현재 try_count가 4번이었으면/ 기존 인증키 제거 후 / 새로운 인증키 자동 발송 ->3
//		 2-2)인증키가 만료되었다고 알려주고 / 기존 인증키 제거 후 / 새로운 인증키 자동 발송 ->4
//		db와 커넥션 중 에러 -> 9
//		3)tryCount는 5에 도달할 시 삭제되어지도록 구성되어 있기 때문에 존재하지 않음
//		2-1)
		if(ec.getDateDif()!=0) {
			
			boolean flag = sendNewEmailVerification(memberKey, request);
			if(!flag) return 9;
			
			return 4;
		}
//		1-1)
		if(!ec.getConfirmationKey().equals(confirmationKey)) {
			if(ec.getTryCount()==4) {
//				딜리트 후 새로 인서트
				boolean flag = sendNewEmailVerification(memberKey, request);
				if(!flag) return 9;
				
				return 3;
			} else {
//				try_count 1회 증가 로직
				md.updateTryCount(session, memberKey);
				return 2;
			}
		}
		
//		정상적으로 인증되었을 시 로직
		
		boolean flag = md.updateMemberToConfirmed(session, memberKey);
		if(!flag) return 9;
		
		flag = md.deleteEmailCheck(session, memberKey);
		if(!flag) return 9;
		
//		정상 상태 코드 1
		return 1;
	}
	
	
	public boolean sendNewEmailVerification(int memberKey, HttpServletRequest request) {
		boolean flag = md.deleteEmailCheck(session, memberKey);
		if(!flag) return false;
		 
		Member m = md.selectMemberByMemberKey(session, memberKey);
		if(m == null) return false;
		
		flag = sendEmailVerification(m, request);
		if(!flag) return false;
		
		return true;
	}
	
	
	//////////////////////////////////////////////////////////
	public Member selectMemberByMemberKey(int memberKey) {
		return md.selectMemberByMemberKey(session,memberKey);
	}
	
}
