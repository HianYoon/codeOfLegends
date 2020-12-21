package com.col.domein.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.board.model.service.BoardService;

@Controller
public class BoardController {
	

		
	@RequestMapping("/board/community.do")
	public String community() {
		return "board/community";
	}
	
	@RequestMapping("/board/forum.do")
	public String forum() {
		return "board/forum";
	}
	@RequestMapping("/board/write.do")
	public String write() {
		return "board/write";
	}
/*	@RequestMapping("/board/write.do")
	public ModelAndView insertBoard(Board board, ModelAndView mv, 
			@RequestParam(value="upFile", required=false) MultipartFile[] upFile,
			HttpSession session) {
	}*/
	
/*
 * @RequestMapping("") public String () { return ""; }
 * 
 * @RequestMapping("") public String () { return ""; }
 * 
 * @RequestMapping("") public String () { return ""; }
 */
}
