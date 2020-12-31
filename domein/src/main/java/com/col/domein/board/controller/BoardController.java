package com.col.domein.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.board.model.service.BoardService;
import com.col.domein.common.pageBar.PageBarFactory;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("/community/communityList.do")
	public ModelAndView boardList(ModelAndView mv,
			@RequestParam(value="cPage", defaultValue="1") int cPage, 
			@RequestParam(value="numPerpage", defaultValue="10") int numPerpage) {
			
		mv.addObject("list",service.selectBoardList(cPage,numPerpage));
		int totalData=service.selectCount();
			
		
		mv.addObject("pageBar",PageBarFactory.getPageBar(totalData, cPage, numPerpage, "communityList.do"));
		mv.addObject("totalData",totalData);
		mv.setViewName("community/communityList");
		
		return mv;
	}
	  
	/*
	 * @RequestMapping("/community/list.do") public ModelAndView list(Map<String,
	 * Object> commandMap) throws Exception{ ModelAndView mv = new
	 * ModelAndView("community/community");
	 * 
	 * 
	 * List<Map<String,Object>> list = BoardService.selectBoardList(commandMap);
	 * mv.addAllObjects("list", list);
	 * 
	 * 
	 * return mv; }
	 */
	/*
	 * @Autowired private BoardService boardService;
	 * 
	 * @RequestMapping("/community/community.do") public ModelAndView
	 * BoardList(Map<String, Object> commandMap) {
	 * 
	 * ModelAndView mv = new ModelAndView("/community/list"); List<Map<String,
	 * Object>> list = boardService.selectBoardList(commandMap);
	 * mv.addObject("list", list); return mv; }
	 */
	/*
	 * @RequestMapping("community/community.do") public ModelAndView community() {
	 * List result = boardService.getBoardList(); ModelAndView mv = new
	 * ModelAndView();
	 * 
	 * mv.addObject("result", result);
	 * 
	 * return mv; }
	 */
	/*
	 * @RequestMapping("/community/list.do.") public String list(Model model, int
	 * no) { model.addAttribute("list",boardService.service()); return "list"; }
	 */
	@RequestMapping("/imageUpload.do")
	public void imageUpload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam MultipartFile upload) throws Exception {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String fileName = upload.getOriginalFilename(); //첨부 파일 이름
		byte[] bytes = upload.getBytes(); 
		String uploadPath = "";
		OutputStream out = new FileOutputStream(new File(uploadPath + fileName));
		out.write(bytes);
		String callback = request.getParameter("CKEditorFuncNum");

		PrintWriter printWriter = response.getWriter();
		String fileUrl = request.getContextPath() + "/images/" + fileName;
		printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + fileUrl
				+ "','이미지가 업로드되었습니다.')" + "</script>");
		printWriter.flush();
	}

	@RequestMapping("/community/forum.do")
	public String forum() {
		return "community/forum";
	}

	@RequestMapping("/community/profile.do")
	public String profile() {
		return "community/profile";
	}
	@RequestMapping("/community/community.do")
	public String community() {
		return "community/community";
	}
	
	@RequestMapping("/community/write.do")
	public String write() {
		return "community/write";
	}
	/*
	 * @RequestMapping("/board/write.do") public ModelAndView insertBoard(Board
	 * board, ModelAndView mv,
	 * 
	 * @RequestParam(value="upFile", required=false) MultipartFile[] upFile,
	 * HttpSession session) { }
	 */

	/*
	 * @RequestMapping("") public String () { return ""; }
	 * 
	 * @RequestMapping("") public String () { return ""; }
	 * 
	 * @RequestMapping("") public String () { return ""; }
	 */
}
