package com.col.domein.member.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.col.domein.member.model.dao.MemberDao;
import com.col.domein.member.model.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberDao md;
	@Autowired
	private SqlSession session;
	

	public boolean isEmptyData(Map<String, String> map) {

		return md.isEmptyData(session, map);
	}

	public int insertMember(Member m) {

		int memberKey = md.getSeqMemberKeyNextVal(session);
		m.setMemberKey(memberKey);
		boolean flag = false;
		try {
			flag = md.insertMember(session, m);
		} catch (Exception e) {
//			에러가 나면 -1로 멤버키를 보낸다. 컨트롤러에서 이를 보고 비지니스를 애드할지에 대해서 판단!
			memberKey=-1;
		}
		
		if(flag == false) memberKey=-1;
		
		return memberKey;
	}
	
	public boolean sendEmailVerification(int memberKey) {
		
//		confirmation_key 만드는 로직
		List<Character> randomKey = new ArrayList<Character>(); 
		while(randomKey.size()<6) {
			char c= (char)(int)(Math.random()*'z'+1);
			if((c>='A'&&c<='Z')||(c>='a'&&c<='z')) randomKey.add(c);
		}
		String stringRandomKey="";
		
		for(char c : randomKey) stringRandomKey+=c;
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedRandomKey = encoder.encode(stringRandomKey);
		///////////////////////////////////////////////
		
		Map<String, String> keys = new HashMap<String, String>();
		keys.put("memberKey", ""+memberKey);
		keys.put("confirmationKey", encodedRandomKey);
	
		return md.sendEmailVerification(session,keys);
	}
	
	public List<Map> selectMemberList(int cPage, int numperPage){
		
		return md.selectMemberList(session,cPage,numperPage);
		
	}

}
