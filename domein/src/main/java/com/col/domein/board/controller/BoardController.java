package com.col.domein.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.board.model.service.BoardService;
import com.col.domein.board.model.vo.Attachment;
import com.col.domein.board.model.vo.Board;
import com.col.domein.common.pageBar.PageBarFactory;
import com.col.domein.product.model.vo.Attachement;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	/*
	 * @RequestMapping("/community/communityList.do") public ModelAndView
	 * boardList(ModelAndView mv,
	 * 
	 * @RequestParam(value="cPage", defaultValue="1") int cPage,
	 * 
	 * @RequestParam(value="numPerpage", defaultValue="10") int numPerpage) {
	 * 
	 * mv.addObject("list",service.selectBoardList(cPage,numPerpage));
	 * 
	 * int totalData=service.selectCount();
	 * mv.addObject("pageBar",PageBarFactory.getPageBar(totalData, cPage,
	 * numPerpage, "communityList.do")); mv.addObject("totalData",totalData);
	 * mv.setViewName("community/communityList");
	 * 
	 * return mv; }
	 */
 	@RequestMapping("/community/insertBoard.do") 
	public ModelAndView insertBoard(ModelAndView mv,Board b,
			@RequestParam(value="upFile",required=false) MultipartFile[] upFile,
			HttpSession session) {
		System.out.println(""+b);
		//upload실제 경로를 가져와야하는데 없으니깐 만들어준다.
				String path=session.getServletContext().getRealPath("/resources/upload/community");
				File dir=new File(path);
				if(!dir.exists()) 
					dir.mkdirs();//mkdirs()<-폴더를 생성을해라
				//2.제너를 선언을해준다.
				List<Attachment> files=new ArrayList();
				//다중파일 업로드하기 MultipartFile객체의 transferTo()메소드 이용 파일을 저장
				//rename처리해줘야함 ->file명을 재정의 하는것
				for(MultipartFile f :upFile) {
					if(!f.isEmpty()) {
						//파일명 생성하기
						String originalName=f.getOriginalFilename();
						String ext=originalName.substring(originalName.lastIndexOf(".")+1);
						
						//리네임 규칙
						SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
						int rndValue=(int)(Math.random()*10000);
						String reName=sdf.format(System.currentTimeMillis())+"_"+rndValue+"."+ext;
						try {
							f.transferTo(new File(path+"/"+reName));
						}catch(IOException e) {
							e.printStackTrace();
						}
						//1.파일 attachment 빌더어노테이션을 설정해주고   --has a관계.
					 Attachement a=Attachement.builder().originFileName(originalName)
							 .renamedFileName(reName).build();
						/* files.add(a); */
						}
					}
				int result=service.insertBoard(b,files);
				mv.addObject("msg",result>0?"수정성공":"수정실패");
				mv.setViewName("index");
				return mv;
			}
	@RequestMapping("/imageUpload.do")
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
}
