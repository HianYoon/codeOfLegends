package com.col.domein.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("/member/memberLogin.do")
	public String memberLogin() {
		return "member/memberLogin";
	}
	
	@RequestMapping("/member/signUp.do")
	public String signUp() {
		return "member/signUp/signUpConsent";
	}
	
}
