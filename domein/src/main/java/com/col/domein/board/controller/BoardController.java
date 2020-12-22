package com.col.domein.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BoardController {

	@RequestMapping("/community/community.do")
	public String community() {
		return "community/community";
	}
	
	@RequestMapping("/community/write.do")
	public String write() {
		return "community/write";
	}
	
	@RequestMapping("/community/forum.do")
	public String forum() {
		return "community/forum";
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
