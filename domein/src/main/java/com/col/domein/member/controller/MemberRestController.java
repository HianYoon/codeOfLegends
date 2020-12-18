package com.col.domein.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.col.domein.member.model.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberRestController {

	@Autowired
	private MemberService ms;

	@PostMapping("/signup/id")
	public boolean isEmptyIdName(@RequestParam String data) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("target", "ID");
		map.put("data",data);
		return ms.isEmptyData(map);
	}

	@PostMapping("/signup/nickname")
	public boolean isEmptyNickName(@RequestParam String data) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("target", "NICKNAME");
		map.put("data",data);
		return ms.isEmptyData(map);
	}
	
	@PostMapping("/signup/phone")
	public boolean isEmptyPhone(@RequestParam String data) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("target", "PHONE");
		map.put("data",data);
		return ms.isEmptyData(map);
	}
	@PostMapping("/signup/email")
	public boolean isEmptyEmail(@RequestParam String data) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("target", "EMAIL");
		map.put("data",data);
		return ms.isEmptyData(map);
	}
	
}
