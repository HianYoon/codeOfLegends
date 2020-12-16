package com.col.domein.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("admin/searchUser.do")
	public String searchUser() {
		return "admin/searchUser";
	}
	
}
