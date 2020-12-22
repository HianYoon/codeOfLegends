package com.col.domein.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.col.domein.member.model.service.MemberService;
import com.col.domein.member.model.vo.Member;
import com.col.domein.member.model.vo.SnsInfo;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService ms;
	@Autowired
	private BCryptPasswordEncoder pwEncoder;

	@RequestMapping("/memberLogin.do")
	public String memberLogin() {
		return "member/memberLogin";
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
				return "redirect: " + request.getContextPath();
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
/////////////////////////////////////////////////////////
////////////Oauth 2.0 종료///////////////////////////////////
/////////////////////////////////////////////////////////	

//////////////////////////////////////////////////////
////////////일반 로그인 ///////////////////////////////////
//////////////////////////////////////////////////////
	@RequestMapping("/loginVerify.do")
	public String loginVerify(HttpSession session, HttpServletRequest request, String id, String password,
			Model model) {

		Member m = ms.selectMemberById(id);
		if (m == null) {
			model.addAttribute("loginFlag", true);
			return "member/memberLogin";
		}
		boolean pwFlag = pwEncoder.matches(password, m.getPassword());
		if (!pwFlag) {
			model.addAttribute("loginFlag", true);
			return "member/memberLogin";
		}
		ms.signInSuccess(session, 0, m);
		return "redirect: " + request.getContextPath();
	}
}
