package com.col.domein.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.col.domein.member.model.service.MemberService;
import com.col.domein.member.model.vo.Member;

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
			boolean emailFlag = ms.sendEmailVerification(m);

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
		
		String url ="";
		int intMemberKey=0;
		
		try {
			intMemberKey = Integer.parseInt(memberKey);
		} catch (Exception e) {
			return "redirect: /error.do";
		}
		
		int result = ms.accountVerify(intMemberKey, confirmationKey);
		
		switch(result) {
//		상황에 따른 result
		case 1: url = "emailConfirmed"; break;
		case 2: url = "wrongConfirmationKey"; break;
		case 3: url = "tooManyTryCount"; break;
		case 4: url = "confirmationTimeOut"; break;
		case 9:
		default: url = "somethingWentWrong";
		}
		
		return "redirect: "+request.getContextPath()+"/member/signUp/"+url+".do";
	}
	
	@RequestMapping("/signUp/emailConfirmed.do")
	public String emailConfirmed() {
		return "member/signUp/emailConfirmed";
	}
	
	@RequestMapping("/signUp/wrongConfirmationKey.do")
	public String wrongConfirmationKey() {
		return "member/signUp/wrongConfirmationKey";
	}
	@RequestMapping("/signUp/tooManyTryCount.do")
	public String tooManyTryCount() {
		return "member/signUp/tooManyTryCount";
	}
	@RequestMapping("/signUp/confirmationTimeOut.do")
	public String confirmationTimeOut() {
		return "member/signUp/confirmationTimeOut";
	}
	@RequestMapping("/signUp/somethingWentWrong.do")
	public String somethingWentWrong() {
		return "member/signUp/somethingWentWrong";
	}
	
}
