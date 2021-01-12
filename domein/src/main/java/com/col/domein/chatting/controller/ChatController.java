package com.col.domein.chatting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.chatting.model.service.ChatService;
import com.col.domein.member.model.vo.Member;

@Controller
public class ChatController {

	@Autowired
	private ChatService service;
	
	//채팅페이지 화면전환
	@RequestMapping("/chat/chatroom.do")
	public ModelAndView enterChatroom(HttpSession session, ModelAndView mv) {
		Member m=(Member) session.getAttribute("signedInMember");
		mv.addObject("list",service.selectChatroom(m.getMemberKey()));
		mv.setViewName("/chatting/chatView");
		return mv;
	}
	
	//이름검색 자동완성 기능(ajax통신) 
	@RequestMapping("/chat/searchUser")
	public void searchUser(HttpServletResponse response, String key) throws IOException {
		List list=service.searchUser(key);
		String csv="";
		for(int i=0;i<list.size();i++) {
			if(i!=0) csv+=",";
			csv+=list.get(i);
		}
		response.setContentType("text/csv;charset=utf-8");
		response.getWriter().print(csv);
	}
	
}
