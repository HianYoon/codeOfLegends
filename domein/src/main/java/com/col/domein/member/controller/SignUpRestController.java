package com.col.domein.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.col.domein.member.model.service.MemberService;

@RestController
public class SignUpRestController {
	
	@Autowired
	private MemberService ms;
	
	@PostMapping("/member/signup/id")
	public boolean idChecker(@RequestParam String data) {
		
		return ms.isEmptyIdName(data); 
	}
	
}
