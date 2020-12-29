package com.col.domein.member.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.col.domein.business.model.service.BusinessService;
import com.col.domein.business.model.vo.Business;
import com.col.domein.mail.model.vo.EmailCheck;
import com.col.domein.mail.model.vo.SignUpVerificationEmail;
import com.col.domein.member.model.dao.MemberDao;
import com.col.domein.member.model.vo.Member;
import com.col.domein.member.model.vo.MemberLog;
import com.col.domein.member.oauth.model.vo.KakaoAccount;
import com.col.domein.member.oauth.model.vo.KakaoAccountProfile;
import com.col.domein.member.oauth.model.vo.KakaoOauthResult;
import com.col.domein.member.oauth.model.vo.NaverProfile;
import com.col.domein.member.oauth.model.vo.SnsInfo;
import com.col.domein.product.model.service.ProductService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

@Service
public class MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private MemberDao md;
	@Autowired
	private SqlSession session;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	@Autowired
	private ProductService ps;
	@Autowired
	private BusinessService bs;
	
	private String googleClientId = "1048798785374-akhqjnf6p4g1fdo3mkf2pudg9ffh5ger.apps.googleusercontent.com";

	public boolean isEmptyData(Map<String, String> map) {

		return md.isEmptyData(session, map);
	}

	public boolean insertMemberPoint(int memberKey, int pointDifference) {
		boolean flag = false;
		Map<String, Integer> values = new HashMap<String, Integer>();
		values.put("memberKey", memberKey);
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
		if (!createKeyFlag)
			return false;

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper messageHelper;
		try {
			messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom("domein2020@gmail.com");
			messageHelper.setTo(m.getEmail());
			messageHelper.setSubject("[도매-인]이메일 인증 메일입니다");
			messageHelper.setText(new SignUpVerificationEmail(m, request, encodedRandomKey).emailContent(), true);

			mailSender.send(message);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return flag;
	}

	public List<Map> selectMemberList(int cPage, int numperPage) {

		return md.selectMemberList(session, cPage, numperPage);

	}
	

	
	public List<Map> searchUser(String keyword,String searchOption){
		return md.searchUser(session,keyword,searchOption);
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
		EmailCheck ec = md.selectEmailCheck(session, memberKey);
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
		if (ec.getDateDif() != 0) {

			boolean flag = sendNewEmailVerification(memberKey, request);
			if (!flag)
				return 9;

			return 4;
		}
//		1-1)
		if (!ec.getConfirmationKey().equals(confirmationKey)) {
			if (ec.getTryCount() == 4) {
//				딜리트 후 새로 인서트
				boolean flag = sendNewEmailVerification(memberKey, request);
				if (!flag)
					return 9;

				return 3;
			} else {
//				try_count 1회 증가 로직
				md.updateTryCount(session, memberKey);
				return 2;
			}
		}

//		정상적으로 인증되었을 시 로직

		boolean flag = md.updateMemberToConfirmed(session, memberKey);
		if (!flag)
			return 9;

		flag = md.deleteEmailCheck(session, memberKey);
		if (!flag)
			return 9;

//		정상 상태 코드 1
		return 1;
	}

	public boolean sendNewEmailVerification(int memberKey, HttpServletRequest request) {
		boolean flag = md.deleteEmailCheck(session, memberKey);
		if (!flag)
			return false;

		Member m = md.selectMemberByMemberKey(session, memberKey);
		if (m == null)
			return false;

		flag = sendEmailVerification(m, request);
		if (!flag)
			return false;

		return true;
	}

	//////////////////////////////////////////////////////////
	public Member selectMemberByMemberKey(int memberKey) {
		return md.selectMemberByMemberKey(session, memberKey);
	}

	//////////////////////////////////////////////////////////
	///////////////////// 간편 로그인 ////////////////////////
	//////////////////////////////////////////////////////////
//		코드 1: 정상 로그인, 
//		코드 2: 이미 가입되어있는 이메일/연결 여부 묻기,
//		코드 3: 미가입 -> 자동 가입(이메일 인증 X)
//		코드 9: 커넥션 에러 등

//////////////////////////////////////////////////////////////////////
// 구글 로그인 / 회원 가입
	public int googleSignIn(HttpSession httpSession, String idToken) {
		Member m = null;
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new JacksonFactory())
				.setAudience(Collections.singletonList(googleClientId)).build();
		GoogleIdToken token = null;
		Payload payload = null;

		try {
			token = verifier.verify(idToken);
		} catch (Exception e) {
			// TODO: handle exception
//			커넥션 와중 에러 9
			return 9;
		}

		if (token != null) {
//			정보 받아오기
			payload = token.getPayload();
			String id = payload.getSubject();

//			이 구글 유니크 아이디가 벌써 등록되어있는지 체크
//			로그인 소스 1은 구글 2는 네이버 3은 카카오
			int loginSourceNo = 1;

			int memberKey = checkMemberThroughSnsId(loginSourceNo, id);
////////////////////////////////////////////////////////////////////////////
//			Code 1
			if (memberKey > 0) {
				m = md.selectMemberByMemberKey(session, memberKey);
				signInSuccess(httpSession, loginSourceNo, m);
				System.out.println(m);
				return 1;
			}
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
//			Code 2
//			구글 페이로드에서 더 많은 정보 받아오기
//			만약 해당 이메일로 이미 회원정보가 있으면 패스워드를 확인한 뒤 그걸로 가입하게만듬. 
//			(이메일은 유니크이므로 중복값을 없게하기 위함이기도 함) 
//			-만약 패스워드 잃어버렸으면 다시 찾아야함
			String email = payload.getEmail();
			String pictureURL = (String) payload.get("picture");
			String familyName = (String) payload.get("family_name");
			String givenName = (String) payload.get("given_name");
			String name = familyName + " " + givenName;

			SnsInfo sns = new SnsInfo();
			sns.setLoginSourceNo(loginSourceNo);
			sns.setSnsId(id);
			sns.setSnsName(name);
			sns.setSnsProfilePic(pictureURL);

			Member emailFoundMember = md.selectMemberByEmail(session, email);
			if (emailFoundMember != null) {
				httpSession.setAttribute("emailFoundMember", emailFoundMember);
				httpSession.setAttribute("snsForEmailFoundMember", sns);
				return 2;
			}
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
//			Code 3
//			멤버 객체 만들기

			Member newSnsMember = new Member();
			newSnsMember.setEmail(email);
			newSnsMember.setUserName(name);
			newSnsMember.setProfileUrl(pictureURL);
			httpSession.setAttribute("newSnsMember", newSnsMember);
			httpSession.setAttribute("snsForNewSnsMember", sns);
			return 3;
		}

		return 9;
	}

//	2.Kakao
	
	public int kakaoSignIn(HttpSession httpSession, KakaoOauthResult result) {
		
		Member m = null;
		int loginSourceNo = 2;
//		카카오 아이디가 이미 있는지 체크
		int memberKey = checkMemberThroughSnsId(loginSourceNo, result.getId());
///////////////////////////////////////////////////////
//		Code 1
		if(memberKey>0) {
			if(memberKey>0) {
				m = md.selectMemberByMemberKey(session, memberKey);
				signInSuccess(httpSession, loginSourceNo, m);

				return 1;
			}
		}
		
//////////////////////////////////////////////////////////////
//		Code 2
		KakaoAccount account = result.getKakao_account();
		KakaoAccountProfile profile = account.getProfile();
		
		String email = account.getEmail();
		String pictureURL = profile.getProfile_image_url();
		String name = profile.getNickname();
		String id = result.getId();
		
		SnsInfo sns = new SnsInfo();
		sns.setLoginSourceNo(loginSourceNo);
		sns.setSnsId(id);
		sns.setSnsName(name);
		sns.setSnsProfilePic(pictureURL);
		
		Member emailFoundMember = md.selectMemberByEmail(session, email);
		if (emailFoundMember != null) {
			httpSession.setAttribute("emailFoundMember", emailFoundMember);
			httpSession.setAttribute("snsForEmailFoundMember", sns);
			return 2;
		}
		
///////////////////////////////////////////////////////////////
//Code 3
		
		Member newSnsMember = new Member();
		newSnsMember.setEmail(email);
		newSnsMember.setUserName(name);
		newSnsMember.setProfileUrl(pictureURL);
		httpSession.setAttribute("newSnsMember", newSnsMember);
		httpSession.setAttribute("snsForNewSnsMember", sns);
		return 3;
	
	}
	
	
//	3.Naver
	
	public int naverSignIn(HttpSession httpSession, NaverProfile profile) {
		
		Member m = null;
		int loginSourceNo = 3;
//		네이버 아이디가 이미 있는지 체크
		int memberKey = checkMemberThroughSnsId(loginSourceNo, profile.getId());
////////////////////////////////////////////////////////////////////////////
//Code 1
		if(memberKey>0) {
			m = md.selectMemberByMemberKey(session, memberKey);
			signInSuccess(httpSession, loginSourceNo, m);

			return 1;
		}
		
/////////////////////////////////////////////////////////////////////////
//Code 2
		String email = profile.getEmail();
		String pictureURL = profile.getProfile_image();
		String name = profile.getName();
		String id = profile.getId();
		if(email==null) email="";
		if(pictureURL == null) pictureURL = "";
		if(name == null) name ="";
		if(id == null) id = "";
		
		SnsInfo sns = new SnsInfo();
		sns.setLoginSourceNo(loginSourceNo);
		sns.setSnsId(id);
		sns.setSnsName(name);
		sns.setSnsProfilePic(pictureURL);
		
		Member emailFoundMember = md.selectMemberByEmail(session, email);
		if (emailFoundMember != null) {
			httpSession.setAttribute("emailFoundMember", emailFoundMember);
			httpSession.setAttribute("snsForEmailFoundMember", sns);
			return 2;
		}
		
///////////////////////////////////////////////////////////////
//Code 3
		

		Member newSnsMember = new Member();
		newSnsMember.setEmail(email);
		newSnsMember.setUserName(name);
		newSnsMember.setProfileUrl(pictureURL);
		httpSession.setAttribute("newSnsMember", newSnsMember);
		httpSession.setAttribute("snsForNewSnsMember", sns);
		return 3;
	}
	
	
	
	
	
	
	public int checkMemberThroughSnsId(int loginSourceNo, String id) {
		SnsInfo sns = new SnsInfo(-1, loginSourceNo, null, id, null, null, null);
		return md.checkMemberThroughSnsId(session, sns);
	}

	public boolean signInSuccess(HttpSession httpSession, int loginSource, Member m) {

//		1. 세션어트리뷰트로 signedInMember에 m 담아주기
		httpSession.setAttribute("signedInMember", m);

//		2. 로그인 로그 남기기
		MemberLog log = new MemberLog(m.getMemberKey(), null, 1, null, loginSource, null);
		boolean flag = md.insertMemberLog(session, log);
		
//		2-1로그오프를 위해서 로그인 소스 담기
		httpSession.setAttribute("loginSource", loginSource);
//		3. 장바구니 불러오기 - 리스너로

		return flag;
	}

	public boolean insertNewOauthMember(HttpSession httpSession, Member m, SnsInfo sns) {
		long currentTime = System.currentTimeMillis();
		m.setId(sns.getLoginSourceNo() + "_" + currentTime);
		m.setPassword(pwEncoder.encode("" + currentTime));
		m.setUserName(sns.getSnsName() != null ? sns.getSnsName() : "" + currentTime);
		m.setNickname("" + currentTime);
		m.setPhone("000-0000-0000");

		int memberKey = insertMember(m);
		boolean flag = md.updateMemberToConfirmed(session, memberKey);
		if (!flag)
			return false;

		sns.setMemberKey(memberKey);
		if (sns.getSnsProfilePic() != null)
			flag = updateMemberProfileUrl(sns);

		flag = md.insertSnsInfo(session, sns);
		if (!flag)
			return false;

		Member signedUpMember = md.selectMemberByMemberKey(session, memberKey);
		flag = signInSuccess(httpSession, sns.getLoginSourceNo(), signedUpMember);
		httpSession.removeAttribute("newSnsMember");
		httpSession.removeAttribute("snsForNewSnsMember");
		return flag;
	}

	public boolean updateMemberProfileUrl(SnsInfo sns) {
		return md.updateMemberProfileUrl(session, sns);
	}

	public boolean insertSnsInfoForEmailFoundMember(HttpSession httpSession, Member m, SnsInfo sns) {
		boolean flag = insertSnsInfo(httpSession, m, sns);
		if (!flag)
			return false;
		httpSession.removeAttribute("emailFoundMember");
		httpSession.removeAttribute("snsForEmailFoundMember");
		return flag;
	}

	public boolean insertSnsInfo(HttpSession httpSession, Member m, SnsInfo sns) {
		sns.setMemberKey(m.getMemberKey());
		boolean flag = md.insertSnsInfo(session, sns);
		if (!flag)
			return false;

		return signInSuccess(httpSession, sns.getLoginSourceNo(), m);
	}
	
	public Member selectMemberById(String id) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("id", id);
		return md.selectMemberById(session, values);
	}
	
	public boolean logoutMember(Member m, int loginSource) {
		
		MemberLog log= new MemberLog(m.getMemberKey(), null, 9, null, loginSource, null);
		return md.insertMemberLog(session, log);
	}
	
	//////////////////////////////////////////////////
//	멤버 삭제
	
	@SuppressWarnings("rawtypes")
	public boolean deleteMember(Member m) {
		
		int memberKey = m.getMemberKey();
//		1. sns 연결 모두 삭제
		
		
		md.deleteMemberFromSnsLogin(session, memberKey);
		
//		2. 멤버의 라이크 모두 삭제
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("memberKey", ""+memberKey);
		
		values.put("target","AUCTION_COMMENT_LIKE");
		md.deleteMemberFromTarget(session, values);
		values.put("target","BCM_ARTICLE_LIKE");
		md.deleteMemberFromTarget(session, values);
		values.put("target","BCM_LIKE");
		md.deleteMemberFromTarget(session, values);
		values.put("target","BDI_ARTICLE_LIKE");
		md.deleteMemberFromTarget(session, values);
		values.put("target","BDI_LIKE");
		md.deleteMemberFromTarget(session, values);
		values.put("target","BDS_REVIEW_LIKE");
		md.deleteMemberFromTarget(session, values);
		values.put("target","BKB_ARTICLE_LIKE");
		md.deleteMemberFromTarget(session, values);
		values.put("target","BKB_LIKE");
		md.deleteMemberFromTarget(session, values);
		values.put("target","BUSINESS_LIKE");
		md.deleteMemberFromTarget(session, values);
		values.put("target","MEMBER_LIKE");
		md.deleteMemberFromTarget(session, values);
		
//		3. business에 연결된 product 및 auction 모두 비활성화
		for(Business b : m.getBusinesses()) {
//			1-1) 모든 프로덕트 중지 처리
			int businessKey =b.getBusinessKey();
			Set<Integer> articleNumbers = new HashSet<Integer>(); 
			List<Map> productList = ps.selectProductByBusinessKey(businessKey);
			for(Map map : productList) {
				articleNumbers.add((int)map.get("ARTICLE_NO"));
			}
			
			for(int articleNo : articleNumbers) {
				ps.updateProductStatusToStoppedByArticleNo(articleNo);
			}
//			1-2) 모든 아티클 중지 처리
			ps.updateSaleStatusToStoppedByBusinessKey(businessKey);
			
//			2) auction 모두 종료 상태로 처리 코드 3
//			2-1)참여 bid 중단
			ps.updateBidStatusToStoppedByBusinessKey(businessKey);
//			2-2)auction 중단
			ps.updateAuctionStatusToStoppedByBusinessKey(businessKey);
		}
		
		
//		4. business 비활성화
		
		bs.updateBusinessToStoppedByMemberKey(memberKey);
		
//		5. 멤버 account_status_no 9로 변경 & email의 앞자리에 deleted: 삽입 하여 업데이트
		m.setEmail("deleted: "+m.getEmail());
		m.setAccountStatusNo(9);
		int result = md.updateMemberToDeleted(session, m);
		
		
		return result == 1;
	}
	
	public boolean updateMemberPassword(Member m) {
		return md.updateMemberPassword(session, m);
	}
	
}
