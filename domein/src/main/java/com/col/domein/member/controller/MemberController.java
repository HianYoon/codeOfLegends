package com.col.domein.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.col.domein.member.model.service.MemberService;
import com.col.domein.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	@RequestMapping("/member/memberLogin.do")
	public String memberLogin() {
		return "member/memberLogin";
	}

	@RequestMapping("/member/signUp/signUp.do")
	public String signUp() {
		return "member/signUp/signUpConsent";
	}

	@RequestMapping("/member/signUp/register-form.do")
	public String registerForm() {
		return "member/signUp/registrationForm";
	}

	@RequestMapping("/member/signUp/signUpEnd.do")
	public String confirmEmail(HttpSession session, Member m, String isSubscribed,
			String additionalInfo) {
		
		String url="confirmEmail.do";
		
		if(isSubscribed!=null) m.setIsSubscribed(1);
		
		if(additionalInfo!=null) {
			url="additionalInfo.do";
		}
		session.setAttribute("newMember", m);
		return "redirect: /member/signUp/"+url;
	}
	
	@RequestMapping("/member/signUp/confirmEmail.do")
	public String confirmEmail() {
		return "member/signUp/confirmEmail";
	}
	
	@RequestMapping("/member/signUp/additionalInfo.do")
	public String additionalInfo() {
		return "member/signUp/businessInfo";
	}
}
