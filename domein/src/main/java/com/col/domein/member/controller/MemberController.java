package com.col.domein.member.controller;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.col.domein.business.model.service.BusinessService;
import com.col.domein.business.model.vo.Business;
import com.col.domein.business.model.vo.BusinessCategory;
import com.col.domein.common.model.vo.ErrorUriMaker;
import com.col.domein.member.model.service.MemberService;
import com.col.domein.member.model.vo.Member;
import com.col.domein.member.oauth.model.vo.KakaoOauthResult;
import com.col.domein.member.oauth.model.vo.KakaoToken;
import com.col.domein.member.oauth.model.vo.NaverAccessTokenRequest;
import com.col.domein.member.oauth.model.vo.NaverOauthResult;
import com.col.domein.member.oauth.model.vo.NaverProfile;
import com.col.domein.member.oauth.model.vo.OauthKey;
import com.col.domein.member.oauth.model.vo.SnsInfo;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService ms;
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	@Autowired
	private BusinessService bs;

	@RequestMapping("/memberLogin.do")
	public String memberLogin() {
		return "member/memberLogin";
	}

//	현재 멤버 다시 불러오기
	public void loadMemberAgain(HttpSession session) {
		Member m = (Member) session.getAttribute("signedInMember");
		Member modifiedM = ms.selectMemberByMemberKey(m.getMemberKey());
		session.setAttribute("signedInMember", modifiedM);
	}
	
/////////////////////////////////////////////////////////
////////////회원가입 로직 ///////////////////////////////	
/////////////////////////////////////////////////////////
	@RequestMapping("/signUp/signUp.do")
	public String signUp() {
		return "member/signUp/signUpConsent";
	}

	@RequestMapping("/signUp/register-form.do")
	public String registerForm() {
		return "member/signUp/registrationForm";
	}

	@RequestMapping("/signUp/signUpEnd.do")
	public String confirmEmail(HttpSession session, HttpServletRequest request, Member m, String isSubscribed,
			String additionalInfo) {

		String url = "confirmEmail.do";

		if (isSubscribed != null)
			m.setIsSubscribed(1);

//		비밀번호 암호화
		m.setPassword(pwEncoder.encode(m.getPassword()));

		session.setAttribute("newMember", m);
		if (additionalInfo != null) {
			url = "additionalInfo.do";
		} else {
			int memberKey = ms.insertMember(m);

			if (memberKey == -1) {
//			에러시 기본 화면으로 이동/ 추후 에러페이지로 이동!
				return new ErrorUriMaker(request, "뭔가 잘못되었어요..", null, null).getRedirectErrorUri();
			}
			/////////////////////////////
			boolean emailFlag = ms.sendEmailVerification(m, request);

//		에러 상황시
			if (!emailFlag)
				return "redirect: " + request.getContextPath();
		}
		return "redirect: " + request.getContextPath() + "/member/signUp/" + url;
	}

	@RequestMapping("/signUp/confirmEmail.do")
	public String confirmEmail() {
		return "member/signUp/confirmEmailSent";
	}

	@RequestMapping("/signUp/additionalInfo.do")
	public String additionalInfo() {
		return "member/signUp/businessInfo";
	}

	@GetMapping("/signUp/accountVerify.do")
	public String accountVerify(HttpServletRequest request, String memberKey, String confirmationKey) {

		String url = "";
		int intMemberKey = 0;

		try {
			intMemberKey = Integer.parseInt(memberKey);
		} catch (Exception e) {
			return "redirect: " + request.getContextPath() + "/error.do";
		}

		int result = ms.accountVerify(intMemberKey, confirmationKey, request);

		switch (result) {
//		상황에 따른 result
		case 1:
			url = "emailConfirmed";
			break;
		case 2:
			url = "wrongConfirmationKey";
			break;
		case 3:
			url = "tooManyTryCount";
			break;
		case 4:
			url = "confirmationTimeOut";
			break;
		case 9:
		default:
			url = "somethingWentWrong";
		}

		return "redirect: " + request.getContextPath() + "/member/signUp/" + url + ".do";
	}

	@RequestMapping("/signUp/emailConfirmed.do")
	public String emailConfirmed() {
		return "member/signUp/emailConfirmed";
	}

	@RequestMapping("/signUp/wrongConfirmationKey.do")
	public String wrongConfirmationKey(Model model) {
		String titleMsg = "인증키 오류";
		String msgContent = "<h5>인증키가 잘못되었습니다.</h5><h5>다시 시도해 주세요.</h5>";
		model.addAttribute("titleMsg", titleMsg);
		model.addAttribute("msgContent", msgContent);
		return "member/signUp/emailError";
	}

	@RequestMapping("/signUp/tooManyTryCount.do")
	public String tooManyTryCount(Model model) {
		String titleMsg = "인증 시도 회수 초과";
		String msgContent = "<h5>새로운 인증 메일을 보냈습니다.</h5><h5>확인해 주세요.</h5>";
		model.addAttribute("titleMsg", titleMsg);
		model.addAttribute("msgContent", msgContent);
		return "member/signUp/emailError";
	}

	@RequestMapping("/signUp/confirmationTimeOut.do")
	public String confirmationTimeOut(Model model) {
		String titleMsg = "인증 기한 만료";
		String msgContent = "<h5>인증 기한인 24시간이 초과되어</h5><h5>새로운 인증 메일을 보냈습니다.</h5><h5>확인해 주세요.</h5>";
		model.addAttribute("titleMsg", titleMsg);
		model.addAttribute("msgContent", msgContent);
		return "member/signUp/emailError";
	}

	@RequestMapping("/signUp/somethingWentWrong.do")
	public String somethingWentWrong(Model model) {
		String titleMsg = "인증 과정 중 오류";
		String msgContent = "<h5>인증 과정 중에 에러가 발생했습니다.</h5><h5>관리자에게 문의하여주세요.</h5>";
		model.addAttribute("titleMsg", titleMsg);
		model.addAttribute("msgContent", msgContent);
		return "member/signUp/emailError";
	}

/////////////////////////////////////////////////////////
////////////회원가입 로직 끝 ////////////////////////////
/////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////
////////////Oauth 2.0 ///////////////////////////////////
/////////////////////////////////////////////////////////

	@RequestMapping("/oauth/emailFound.do")
	public String emailFound(HttpSession session, Model model) {
		Member m = (Member) session.getAttribute("emailFoundMember");
		String email = m.getEmail();
		String id = m.getId().substring(0, m.getId().length() - 3) + "**";
		model.addAttribute("email", email);
		model.addAttribute("id", id);
		return "member/oauth/emailFound";
	}

	@RequestMapping("/oauth/emailFoundEnd.do")
	public String emailFoundEnd(HttpSession session, HttpServletRequest request, String password, Model model) {
		String url = "";
		Member m = (Member) session.getAttribute("emailFoundMember");
//		비밀번호 확인
		boolean pwMatcher = pwEncoder.matches(password, m.getPassword());
		if (!pwMatcher) {
			model.addAttribute("pwFlag", true);
			String email = m.getEmail();
			String id = m.getId().substring(0, m.getId().length() - 3) + "**";
			model.addAttribute("email", email);
			model.addAttribute("id", id);
			return "member/oauth/emailFound";
		}
//		비밀번호 일치 시
		SnsInfo sns = (SnsInfo) session.getAttribute("snsForEmailFoundMember");
		boolean flag = ms.insertSnsInfoForEmailFoundMember(session, m, sns);
		if (!flag)
			return "redirect: " + request.getContextPath() + "/error.do";
		return "redirect: " + request.getContextPath() + "/" + url;
	}

	@RequestMapping("/oauth/newOauthMember.do")
	public String newOauthMember(HttpSession session, Model model) {
		Member m = (Member) session.getAttribute("newSnsMember");
		String email = m.getEmail();
		model.addAttribute("email", email);
		return "member/oauth/newOauthMember";
	}

	@RequestMapping("/oauth/newOauthMemberEnd.do")
	public String newOauthEnd(HttpSession session, HttpServletRequest request,
			@RequestParam(required = false) String email, @RequestParam(defaultValue = "0") String isSubscribed) {
		Member m = (Member) session.getAttribute("newSnsMember");
		SnsInfo sns = (SnsInfo) session.getAttribute("snsForNewSnsMember");
		if (email != null && email != "")
			m.setEmail(email);
		int intIsSub = Integer.parseInt(isSubscribed);
		m.setIsSubscribed(intIsSub);

		boolean flag = ms.insertNewOauthMember(session, m, sns);
		if (!flag)
			return "redirect: " + request.getContextPath() + "/error.do";
		return "redirect: " + request.getContextPath();
	}

/////////////////////////////////////////////////////////////////////
//	Kakao
	@RequestMapping("/oauth/kakao.do")
	public String kakaoSignIn(HttpSession session, HttpServletRequest request, String state, String code,
			@RequestParam(required = false) String error) {
		int signInResult = 0;
		String path = request.getContextPath();
		String url = "";

		if ((error != null && error.equals("access_denied")) || (state == null || code == null))
			return "redirect: " + request.getContextPath() + "/error.do";

		String kakaoState = (String) session.getAttribute("kakaoState");
//		상태 토큰 불일치 시!
		if (!kakaoState.equals(state)) {
			session.removeAttribute("kakaoState");
			return "redirect: " + request.getContextPath() + "/error.do";
		}

		OauthKey keys = new OauthKey(request);

		String clientId = keys.getKakaoClientId();
		String clientSecret = keys.getKakaoClientSecret();
		String redirectUri = keys.getKakaoCallbackUri();

		RestTemplate rest = new RestTemplate();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		parameters.add("grant_type", "authorization_code");
		parameters.add("client_id", clientId);
		parameters.add("redirect_uri", redirectUri);
		parameters.add("code", code);
		parameters.add("client_secret", clientSecret);

		HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<MultiValueMap<String, String>>(
				parameters, headers);
		KakaoToken token = rest.postForObject("https://kauth.kakao.com/oauth/token", tokenRequest, KakaoToken.class);

//		액세스 토큰으로 정보 받아오기
		rest = new RestTemplate();
		headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token.getAccess_token());
		HttpEntity<String> authEntity = new HttpEntity<String>("", headers);
		KakaoOauthResult result = rest.postForObject("https://kapi.kakao.com/v2/user/me", authEntity,
				KakaoOauthResult.class);

		signInResult = ms.kakaoSignIn(session, result);

		switch (signInResult) {
		case 1:
			url = "redirect: " + path;
			break;
		case 2:
			url = "redirect: " + path + "/member/oauth/emailFound.do";
			break;
		case 3:
			url = "redirect: " + path + "/member/oauth/newOauthMember.do";
			break;
		default:
			url = "redirect: " + path + "/error.do";
		}

		session.removeAttribute("kakaoState");

		return url;
	}

	@RequestMapping("/oauth/kakao/addition.do")
	public String addKakaoSignIn(HttpSession session, HttpServletRequest request, String state, String code,
			@RequestParam(required = false) String error) {
		Member m = (Member) session.getAttribute("signedInMember");

		String path = request.getContextPath();
		String url = "";

		if ((error != null && error.equals("access_denied")) || (state == null || code == null))
			return "redirect: " + request.getContextPath() + "/error.do";

		String kakaoState = (String) session.getAttribute("kakaoState");
//		상태 토큰 불일치 시!
		if (!kakaoState.equals(state)) {
			session.removeAttribute("kakaoState");
			return "redirect: " + request.getContextPath() + "/error.do";
		}

		OauthKey keys = new OauthKey(request);

		String clientId = keys.getKakaoClientId();
		String clientSecret = keys.getKakaoClientSecret();
		String redirectUri = keys.getKakaoMyPageCallbackUri();

		RestTemplate rest = new RestTemplate();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		parameters.add("grant_type", "authorization_code");
		parameters.add("client_id", clientId);
		parameters.add("redirect_uri", redirectUri);
		parameters.add("code", code);
		parameters.add("client_secret", clientSecret);

		HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<MultiValueMap<String, String>>(
				parameters, headers);
		KakaoToken token = rest.postForObject("https://kauth.kakao.com/oauth/token", tokenRequest, KakaoToken.class);

//		액세스 토큰으로 정보 받아오기
		rest = new RestTemplate();
		headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token.getAccess_token());
		HttpEntity<String> authEntity = new HttpEntity<String>("", headers);
		KakaoOauthResult result = rest.postForObject("https://kapi.kakao.com/v2/user/me", authEntity,
				KakaoOauthResult.class);

		int flag = ms.addKakaoSignIn(session, m.getMemberKey(), result);

		switch (flag) {
		case 5:
			url = "redirect: " + path + "/member/myPage/account/oauth.do";
			break;
		case 6:
			url = new ErrorUriMaker(request, "해당 간편 인증 아이디가 이미 다른 계정에 존재합니다!", "/member/myPage/account/oauth.do", null)
					.getRedirectErrorUri();
			break;
		default:
			url = new ErrorUriMaker(request, "무언가 잘못 되었네요..", "/member/myPage/account/oauth.do", null)
					.getRedirectErrorUri();
		}

		session.removeAttribute("kakaoState");

		return url;
	}

//	Naver
	@RequestMapping("/oauth/naver.do")
	public String naverSignIn(HttpSession session, HttpServletRequest request, String state, String code) {
		int signInResult = 0;
		String path = request.getContextPath();
		String url = "";
		if (state == null || code == null)
			return "redirect: " + request.getContextPath() + "/error.do";
		String naverState = (String) session.getAttribute("naverState");
//		상태 토큰 불일치 시!
		if (!naverState.equals(state)) {
			session.removeAttribute("naverState");
			return "redirect: " + request.getContextPath() + "/error.do";
		}

		OauthKey keys = new OauthKey(request);

		String clientId = keys.getNaverClientId();
		String clientSecret = keys.getNaverClientSecret();
		String requestUrl = "https://nid.naver.com/oauth2.0/token?client_id=" + clientId + "&client_secret="
				+ clientSecret + "&grant_type=authorization_code&state=" + naverState + "&code=" + code;

		RestTemplate rest = new RestTemplate();
//		토큰 받아옴
		NaverAccessTokenRequest token = rest.getForObject(requestUrl, NaverAccessTokenRequest.class);

//		프로필 받아오기
		rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token.getAccess_token());
		HttpEntity<String> profileRequest = new HttpEntity<String>("", headers);
		NaverOauthResult result = rest.postForObject("https://openapi.naver.com/v1/nid/me", profileRequest,
				NaverOauthResult.class);
		if (result.getMessage().equals("success")) {
			NaverProfile profile = result.getResponse();

			signInResult = ms.naverSignIn(session, profile);
			switch (signInResult) {
			case 1:
				url = "redirect: " + path;
				break;
			case 2:
				url = "redirect: " + path + "/member/oauth/emailFound.do";
				break;
			case 3:
				url = "redirect: " + path + "/member/oauth/newOauthMember.do";
				break;
			default:
				url = "redirect: " + path + "/error.do";
			}
		} else {
			url = "redirect: " + path + "/error.do";
		}
		session.removeAttribute("naverState");
		return url;
	}

	@RequestMapping("/oauth/naver/addition.do")
	public String addNaverSignIn(HttpSession session, HttpServletRequest request, String state, String code) {
		Member m = (Member) session.getAttribute("signedInMember");
		String path = request.getContextPath();
		String url = "";

		if (state == null || code == null)
			return "redirect: " + request.getContextPath() + "/error.do";
		String naverState = (String) session.getAttribute("naverState");
//		상태 토큰 불일치 시!
		if (!naverState.equals(state)) {
			session.removeAttribute("naverState");
			return "redirect: " + request.getContextPath() + "/error.do";
		}

		OauthKey keys = new OauthKey(request);

		String clientId = keys.getNaverClientId();
		String clientSecret = keys.getNaverClientSecret();
		String requestUrl = "https://nid.naver.com/oauth2.0/token?client_id=" + clientId + "&client_secret="
				+ clientSecret + "&grant_type=authorization_code&state=" + naverState + "&code=" + code;

		RestTemplate rest = new RestTemplate();
//		토큰 받아옴
		NaverAccessTokenRequest token = rest.getForObject(requestUrl, NaverAccessTokenRequest.class);

//		프로필 받아오기
		rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token.getAccess_token());
		HttpEntity<String> profileRequest = new HttpEntity<String>("", headers);
		NaverOauthResult result = rest.postForObject("https://openapi.naver.com/v1/nid/me", profileRequest,
				NaverOauthResult.class);
		session.removeAttribute("naverState");
		if (result.getMessage().equals("success")) {
			NaverProfile profile = result.getResponse();
			int flag = ms.addNaverSignIn(session, m.getMemberKey(), profile);
			switch (flag) {
			case 5:
				url = "redirect: " + path + "/member/myPage/account/oauth.do";
				break;
			case 6:
				url = new ErrorUriMaker(request, "해당 간편 인증 아이디가 이미 다른 계정에 존재합니다!", "/member/myPage/account/oauth.do",
						null).getRedirectErrorUri();
				break;
			default:
				url = new ErrorUriMaker(request, "무언가 잘못 되었네요..", "/member/myPage/account/oauth.do", null)
						.getRedirectErrorUri();
			}

		} else {
			url = new ErrorUriMaker(request, "무언가 잘못 되었네요..", "/member/myPage/account/oauth.do", null)
					.getRedirectErrorUri();
		}
		return url;

	}

/////////////////////////////////////////////////////////
////////////Oauth 2.0 종료///////////////////////////////////
/////////////////////////////////////////////////////////	

//////////////////////////////////////////////////////
////////////일반 로그인 & 로그오프////////////////////
//////////////////////////////////////////////////////
	@RequestMapping("/loginVerify.do")
	public String loginVerify(HttpSession session, HttpServletRequest request, String id, String password) {

		Member m = ms.selectMemberById(id);
		if (m == null) {
			request.setAttribute("loginFlag", true);
			return "member/memberLogin";
		}
		boolean pwFlag = pwEncoder.matches(password, m.getPassword());
		if (!pwFlag) {
			request.setAttribute("loginFlag", true);
			return "member/memberLogin";
		}

		ms.signInSuccess(session, 0, m);
		return "redirect: " + request.getContextPath();
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		return "redirect: " + request.getContextPath();
	}
//////////////////////////////////////////////////////////////

	@RequestMapping("/myPage.do")
	public String myPageMain() {
		return "member/myPage/account/accountMenu";
	}

	@RequestMapping("/myPage/account.do")
	public String myPageAccount() {
		return "member/myPage/account/accountMenu";
	}

	@RequestMapping("/myPage/account/delete.do")
	public String deleteAccount() {
		return "member/myPage/account/deleteAccount";
	}

	@RequestMapping("/myPage/account/deleteEnd.do")
	public String deleteAccountEnd(HttpSession session, HttpServletRequest request) {
		Member m = (Member) session.getAttribute("signedInMember");
		boolean flag = ms.deleteMember(m);
		if (!flag)
			return "redirect: " + request.getContextPath() + "/error.do";

		session.invalidate();
		return "redirect: " + request.getContextPath() + "/member/accountDeleted.do";
	}

	@RequestMapping("/accountDeleted.do")
	public String accountDeleted() {
		return "member/accountDeleted";
	}

	@RequestMapping("/myPage/account/changePw.do")
	public String changePw() {
		return "member/myPage/account/changePw";
	}

	@RequestMapping("/myPage/account/changePwEnd.do")
	public String changePwEnd(HttpSession session, HttpServletRequest request, String oldPassword, String newPassword) {
		Member m = (Member) session.getAttribute("signedInMember");
		boolean result = pwEncoder.matches(oldPassword, m.getPassword());
		if (!result)
			return "redirect: " + request.getContextPath() + "/error.do";

		m.setPassword(pwEncoder.encode(newPassword));

		result = ms.updateMemberPassword(m);
		if (!result)
			return "redirect: " + request.getContextPath() + "/error.do";
		else
			session.setAttribute("signedInMember", m);

		return "redirect: " + request.getContextPath() + "/member/myPage.do";
	}

	@RequestMapping("/myPage/account/oauth.do")
	public String oauthAccount(HttpSession session, Model model) {
		Member m = (Member) session.getAttribute("signedInMember");
		List<SnsInfo> oauths = ms.selectSnsInfoByMemberKey(m.getMemberKey());

		boolean google = false;
		boolean kakao = false;
		boolean naver = false;
//		모든 정보를 보내는 것보다는, 소스의 번호만 보냄
		for (SnsInfo s : oauths) {
			int sourceNo = s.getLoginSourceNo();
			if (sourceNo == 1)
				google = true;
			if (sourceNo == 2)
				kakao = true;
			if (sourceNo == 3)
				naver = true;
		}

		model.addAttribute("google", google);
		model.addAttribute("kakao", kakao);
		model.addAttribute("naver", naver);

		return "member/myPage/account/oauth";
	}

	@RequestMapping("/myPage/account/oauth/delete.do")
	public String deleteOauth(HttpSession session, HttpServletRequest request, String loginSource) {
		Member m = (Member) session.getAttribute("signedInMember");
		int loginSourceNo = Integer.parseInt(loginSource);
		SnsInfo sns = new SnsInfo();
		sns.setMemberKey(m.getMemberKey());
		sns.setLoginSourceNo(loginSourceNo);

		boolean result = ms.deleteSelectedOauthFromMember(sns);

		if (!result)
			return "redirect: " + request.getContextPath() + "/error.do";

		return "redirect: " + request.getContextPath() + "/member/myPage/account/oauth.do";
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
//	계정 비지니스 관리

	@RequestMapping("/myPage/account/business/manageBusiness.do")
	public String manageBusiness(HttpSession session, HttpServletRequest request) {
		return "member/myPage/account/business/manageBusiness";
	}

//	비지니스 추가 페이지
	@RequestMapping("/myPage/account/business/addBusiness.do")
	public String addBusiness() {
		return "member/myPage/account/business/addBusiness";
	}

//	비지니스 추가 후 페이지
	@PostMapping("/myPage/account/business/addBusinessEnd.do")
	public String addBusinessEnd(HttpSession session, HttpServletRequest request, Business b,
			@RequestParam(defaultValue = "99", required = false) String[] categories) {

		Member m = (Member) session.getAttribute("signedInMember");

		if (b.getBusinessNickname() == null || b.getBusinessNickname() == "") {
			b.setBusinessNickname(b.getBusinessName());
		}

		if (categories != null) {
			TreeSet<BusinessCategory> businessCategories = new TreeSet<BusinessCategory>();
			for (String c : categories) {
				BusinessCategory bc = new BusinessCategory(Integer.parseInt(c), null);
				businessCategories.add(bc);
			}
			b.setBusinessCategories(businessCategories);
		}
		b.setMemberKey(m.getMemberKey());

		boolean result = bs.insertBusiness(b);

		if (!result)
			return new ErrorUriMaker(request, "판매자 삽입 중 에러 발생!", "/member/myPage/account/business/manageBusiness.do",
					"판매자 관리로...").getErrorUri();

		loadMemberAgain(session);

		return "redirect: " + request.getContextPath() + "/member/myPage/account/business/manageBusiness.do";
	}

//	비지니스 삭제 버튼 클릭시
	@RequestMapping("/myPage/account/business/deleteBusiness.do")
	public String deleteBusiness(HttpSession session, HttpServletRequest request, String businessKey) {
		Member m = (Member) session.getAttribute("signedInMember");
		int bKey = Integer.parseInt(businessKey);
		boolean containFlag = false;
		for (Business b : m.getBusinesses()) {
			if (b.getBusinessKey() == bKey)
				containFlag = true;
		}
		if (!containFlag)
			return new ErrorUriMaker(request, "잘못된 접근입니다!", "/member/myPage/account/business/manageBusiness.do",
					"판매자 관리로...").getErrorUri();

		bs.updateBusinessToStoppedByBusinessKey(bKey);

		loadMemberAgain(session);

		return "redirect: " + request.getContextPath() + "/member/myPage/account/business/manageBusiness.do";
	}

//	비지니스 수정 클릭시
	@RequestMapping("/myPage/account/business/modifyBusiness.do")
	public String modifyBusiness(HttpSession session, HttpServletRequest request, String businessKey, Model model) {
		Member m = (Member) session.getAttribute("signedInMember");
		int bKey = Integer.parseInt(businessKey);
		Business business = null;

		for (Business b : m.getBusinesses()) {
			if (b.getBusinessKey() == bKey)
				business = b;
		}
		if (business == null)
			return new ErrorUriMaker(request, "잘못된 접근입니다!", "/member/myPage/account/business/manageBusiness.do",
					"판매자 관리로...").getErrorUri();

		model.addAttribute("memberBusiness", business);

		boolean[] categoryFlag = { false, false, false, false, false, false, false, false };

		for (BusinessCategory bc : business.getBusinessCategories()) {
			int categoryNo = bc.getBusinessCategoryNo();
			if (categoryNo != 99) {
				categoryFlag[categoryNo - 1] = true;
			} else {
				categoryFlag[7] = true;
			}
		}

		model.addAttribute("categoryFlag", categoryFlag);

		return "member/myPage/account/business/modifyBusiness";
	}

//	비지니스 수정 완료
	@RequestMapping("/myPage/account/business/modifyBusinessEnd.do")
	public String modifyBusinessEnd(HttpSession session, HttpServletRequest request, Business b,
			@RequestParam(defaultValue = "99", required = false) String[] categories) {
		
		Member m = (Member) session.getAttribute("signedInMember");

		boolean flag = false;
		for(Business bu : m.getBusinesses()) {
			if(bu.getBusinessKey() == b.getBusinessKey()) flag = true;
		}
		
		if(!flag) return new ErrorUriMaker(request, "잘못된 접근입니다!", "/member/myPage/account/business/manageBusiness.do",
				"판매자 관리로...").getErrorUri();
		
		if (b.getBusinessNickname() == null || b.getBusinessNickname() == "") {
			b.setBusinessNickname(b.getBusinessName());
		}

		if (categories != null) {
			TreeSet<BusinessCategory> businessCategories = new TreeSet<BusinessCategory>();
			for (String c : categories) {
				BusinessCategory bc = new BusinessCategory(Integer.parseInt(c), null);
				businessCategories.add(bc);
			}
			b.setBusinessCategories(businessCategories);
		}
		
		b.setMemberKey(m.getMemberKey());
		
		bs.updateBusinessInfo(b);
		
		loadMemberAgain(session);
		
		return "redirect: " + request.getContextPath() + "/member/myPage/account/business/manageBusiness.do";
	}
	
	@RequestMapping("/myPage/account/accountInfo.do")
	public String accountInfo(HttpSession session, HttpServletRequest request) {
		return "member/myPage/account/accountInfo";
	}
	
	@RequestMapping("/myPage/account/accountInfoEnd.do")
	public String accountInfoEnd(HttpSession session, HttpServletRequest request, Member updatedMember, String isSubscribed) {
		Member m = (Member) session.getAttribute("signedInMember");
		
		if (isSubscribed != null && isSubscribed.equals("1"))
			updatedMember.setIsSubscribed(1);
		else updatedMember.setIsSubscribed(0);
		updatedMember.setMemberKey(m.getMemberKey());
		
		boolean flag = ms.updateMemberFromAccountInfo(updatedMember);
		if(!flag) return new ErrorUriMaker(request, "", "", "").getErrorUri();
		
		loadMemberAgain(session);
		return "redirect: " + request.getContextPath() + "/member/myPage/account.do";
	}
	
	@RequestMapping("/myPage/account/changeProfilePic.do")
	public String changeProfilePic() {
		return "member/myPage/account/changeProfilePic";
	}
	
	
/////////////////////////////////////////////////////////
//	아이디 비밀번호 찾기
	@RequestMapping("/idPwFind.do")
	public String idPwFind() {
		return "member/idFind";
	}
	@RequestMapping("/pwFind.do")
	public String pwFind() {
		return "member/pwFind";
	}
	
	@RequestMapping("/pwFindEnd.do")
	public String pwFindEnd(Model model, HttpServletRequest request, String memberKey, String confirmationKey) {
		
		model.addAttribute("memberKey",memberKey);
		model.addAttribute("confirmationKey", confirmationKey);
		
		return "member/emailPwChange";
	}
	
	@RequestMapping("/emailPwChangeEnd.do")
	public String emailPwChangeEnd(HttpServletRequest request, String memberKey, String confirmationKey, String password) {
		int mKey = -1;
		try {
			mKey = Integer.parseInt(memberKey);
		} catch (Exception e) {
			return new ErrorUriMaker(request, "", "", "").getErrorUri();
		}
		int result = ms.pwFindVerify(mKey, confirmationKey, request);
		
		if(result != 1) return new ErrorUriMaker(request, "", "", "").getErrorUri();
		
		Member m = new Member();
		m.setMemberKey(mKey);
		m.setPassword(pwEncoder.encode(password));
		
		boolean flag = ms.updateMemberPassword(m);
		if(!flag) return new ErrorUriMaker(request, "", "", "").getErrorUri();
		
		return "redirect: "+request.getContextPath()+"/member/successfullyChanged.do";
	}
	
	@RequestMapping("/successfullyChanged.do")
	public String successfullyChanged() {
		return "member/emailPwChangeEnd";
	}
	
}
