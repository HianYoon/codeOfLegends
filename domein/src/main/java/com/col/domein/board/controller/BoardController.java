package com.col.domein.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
//github.com/HianYoon/codeOfLegends.git
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.board.model.service.BoardService;
import com.col.domein.board.model.vo.Board;
import com.col.domein.common.pageBar.PageBarFactory;
import com.col.domein.member.model.vo.Member;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	@Autowired
	private Member m;
	
	@RequestMapping("/community/community.do")
	public ModelAndView selectboardList(ModelAndView mv,
			@RequestParam(value="cPage", defaultValue="1") int cPage, 
			@RequestParam(value="numPerpage", defaultValue="10") int numPerpage) {
			
		mv.addObject("list",service.selectBoardList(cPage,numPerpage));
        System.out.println(service.selectBoardList(cPage,numPerpage));
		
		int totalData=service.selectCount();
		mv.addObject("pageBar",PageBarFactory.getPageBar(totalData, cPage, numPerpage, "community.do"));
		mv.addObject("totalData",totalData);
		mv.setViewName("community/communityList");
		
		return mv;
	}
	@RequestMapping("/community/write.do")
	public String write() {
		return "community/write";
	}
	@RequestMapping("/community/insertBoard.do")
	public ModelAndView insertBoard(HttpSession session,Board board, ModelAndView mv,@RequestParam(value="image", required=false)MultipartFile image,String nickname, String threadTitle,int memberKey,String content) {
		String path = session.getServletContext().getRealPath("/resources/upload/boardKnowBattle");
		File dir = new File(path);
		if(!dir.exists()) dir.mkdirs();
		String originalName = "";
		String reName = "";
		
		//등록 눌렀을때 해야할 것: 파일업로드->쓰레드 등록->아티클 등록
		if(!image.isEmpty()) {
			originalName = image.getOriginalFilename();
			String ext = originalName.substring(originalName.lastIndexOf(",")+1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rndValue = (int)Math.random()*10000;
			reName = sdf.format(System.currentTimeMillis())+"_"+rndValue+"."+ext;
			try {
				image.transferTo(new File(path+"/"+reName));
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		Map map = new HashMap();
		//아티클
		map.put("originalName",originalName);
		map.put("reName",reName);
		map.put("content",content);
		//---
		//쓰레드
		map.put("threadTitle",threadTitle);
		//---
		map.put("memberKey",memberKey);
		map.put("nickname",nickname);
		
		int result=service.insertBoard(map);
		mv.addObject("msg", result>0?"입력성공":"입력실패");
		mv.addObject("loc", "/community/community.do");
		mv.setViewName("common/msg");
		return mv;
	}
	@RequestMapping("/community/imageUpload.do")
	public void imageUpload(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam MultipartFile upload) throws Exception {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
	
		String fileName = upload.getOriginalFilename(); //첨부 파일 이름
		byte[] bytes = upload.getBytes(); 
		String path=session.getServletContext().getRealPath("/resources/upload/community");
		OutputStream out = new FileOutputStream(new File(path + fileName));
		out.write(bytes);
		String callback = request.getParameter("CKEditorFuncNum");
	
		PrintWriter printWriter = response.getWriter();
		String fileUrl = request.getContextPath() + "/images/" + fileName;
		printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + fileUrl
				+ "','이미지가 업로드되었습니다.')" + "</script>");
		printWriter.flush();
	}

	@RequestMapping("/community/profile.do")
	public String profile() {
		return "community/profile";
	}
	
	@RequestMapping("/community/bkbDetail.do")
	public String bkbDetail(Model m,int threadKey) {
		
		List<Map> list = service.selectBkbArticles(threadKey);
		m.addAttribute("list",list);
		return "community/bkbDetail";
	}
	
	@RequestMapping("/community/insertArticle.do")
	public String insertArticle(HttpSession session,Model m, int threadKey, String content, int memberKey,
			@RequestParam(value="image", required=false)MultipartFile image) {
		String path = session.getServletContext().getRealPath("/resources/upload/boardKnowBattle");
		File dir = new File(path);
		String originalName = "";
		String reName = "";
		if(!dir.exists()) dir.mkdirs();
		
		if(!image.isEmpty()) {
			originalName = image.getOriginalFilename();
			String ext = originalName.substring(originalName.lastIndexOf(",")+1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rndValue = (int)Math.random()*10000;
			reName = sdf.format(System.currentTimeMillis())+"_"+rndValue+"."+ext;
			try {
				image.transferTo(new File(path+"/"+reName));
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		Map map = new HashMap();
		map.put("threadKey",threadKey);
		map.put("content",content);
		map.put("memberKey",memberKey);
		map.put("originalName",originalName);
		map.put("reName",reName);
		int result = service.insertArticle(map);
//		List<Map> list = service.selectBkbArticles(threadKey);
//		m.addAttribute("list",list);
		m.addAttribute("msg", result>0?"댓글이 등록되었습니다.":"댓글등록에 실패하였습니다.");
		m.addAttribute("loc","/community/bkbDetail.do?threadKey="+threadKey);
		return "common/msg";
	}

}