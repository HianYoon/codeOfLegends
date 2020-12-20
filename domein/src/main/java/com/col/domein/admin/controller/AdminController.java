package com.col.domein.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.col.domein.member.model.service.MemberService;
import com.col.domein.member.model.vo.Member;

@Controller
public class AdminController {

	@Autowired
	private MemberService ms;
	
	@RequestMapping("admin/searchUser.do")
	public String searchUser(Model m,@RequestParam(value="cPage",defaultValue="1")int cPage,
			@RequestParam(value="numPerpage",defaultValue="10")int numPerpage) {
		
		List<Map> list = ms.selectMemberList(cPage,numPerpage);
		m.addAttribute("list",list);
		return "admin/searchUser";
	}
	
	@RequestMapping("admin/userInfo.do")
	public String userInfo(Model m, int memberKey) {
		
		Member member = ms.selectOneMemberWithBusinessNo(memberKey);
		m.addAttribute("m",member);
		
		return "admin/userInfo";
	}
}
