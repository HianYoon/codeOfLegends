package com.col.domein.member.controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.col.domein.member.model.service.MemberService;
import com.col.domein.member.model.vo.Member;
import com.col.domein.member.oauth.model.vo.OauthKey;

@RestController
@RequestMapping("/rest/member")
public class MemberRestController {

	@Autowired
	private MemberService ms;
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	
	@PostMapping("/signup/id")
	public boolean isEmptyIdName(@RequestParam String data) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("target", "ID");
		map.put("data", data);
		return ms.isEmptyData(map);
	}

	@PostMapping("/signup/nickname")
	public boolean isEmptyNickName(@RequestParam String data) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("target", "NICKNAME");
		map.put("data", data);
		return ms.isEmptyData(map);
	}

	@PostMapping("/signup/phone")
	public boolean isEmptyPhone(@RequestParam String data) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("target", "PHONE");
		map.put("data", data);
		return ms.isEmptyData(map);
	}

	@PostMapping("/signup/email")
	public boolean isEmptyEmail(@RequestParam String data) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("target", "EMAIL");
		map.put("data", data);
		return ms.isEmptyData(map);
	}
////////////////////////////////////////
//	oauth 2.0
//	1. Google
	@PostMapping("/oauth/google")
	public int googleSignIn(HttpSession session, String idToken) {
		int result = ms.googleSignIn(session, idToken);
		return result;
	}
	
	@PostMapping("/oauth/google/addition")
	public int addGoogleSignIn(HttpSession session, String idToken) {
		Member m = (Member)session.getAttribute("signedInMember");
		int result = ms.addGoogleSignIn(session, m.getMemberKey(), idToken);
		return result;
	}
	
// 	2. Kakao

	@PostMapping("/oauth/kakao")
	public String kakaoSignIn(HttpSession session, HttpServletRequest request) {
		String state = generateState();
		session.setAttribute("kakaoState", state);
		
		OauthKey keys = new OauthKey(request);
		
		String clientId = keys.getKakaoClientId();
		String redirectUrl = keys.getKakaoCallbackUri();
		String url = "https://kauth.kakao.com/oauth/authorize?client_id="+clientId+"&response_type=code&redirect_uri="+redirectUrl+"&state="
				+ state;

		return url;
	}
	
	@PostMapping("/oauth/kakao/leave")
	public String kakaoLeave(HttpSession session) {

		return "";
	}
	
	
// 	3. Naver
	@PostMapping("/oauth/naver")
	public String naverSignIn(HttpSession session, HttpServletRequest request) {
		String state = generateState();
		session.setAttribute("naverState", state);
		OauthKey keys = new OauthKey(request);
		String clientId = keys.getNaverClientId();
		String redirectUrl = keys.getNaverCallbackUri();
		String url = "https://nid.naver.com/oauth2.0/authorize?client_id="+clientId+"&response_type=code&redirect_uri="+redirectUrl+"&state="
				+ state;
		return url;
	}

//	네이버용 상태 토큰
	public String generateState() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}
	
	
//	/////////////////////////////////////////////////////////////
	
	@PostMapping("/mypage/account/password")
	public boolean passwordChecker(HttpSession session, String password) {
		Member m = (Member)session.getAttribute("signedInMember");
		return pwEncoder.matches(password, m.getPassword());
	}
}
