package com.col.domein.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
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
	
	@RequestMapping("/member/signUp/additionalInfo.do")
	public String additionalInfo() {
		return "member/signUp/additionalInfo";
	}
	
	@RequestMapping("/member/signUp/confirmEmail.do")
	public String confirmEmail() {
		return "member/signUp/confirmEmail";
	}
}
