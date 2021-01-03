package com.col.domein.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
		mv.setViewName("community/community");
		
		return mv;
	}
	
//	@RequestMapping("/community/write.do")
//	public void fileDownload(String oriname, String rename,
//			@RequestHeader(value="user-agent") String header,
//			HttpServletRequest request,HttpServletResponse response) {
//		
//		//파일 디렉토리 가져오기
//		String path=request.getServletContext().getRealPath("/resources/upload/community");
//		File saveFile=new File(path+"/"+rename);
//		
//		//입출력스트림
//		BufferedInputStream bis=null;
//		ServletOutputStream sos=null;
//		
//		try {
//			bis=new BufferedInputStream(new FileInputStream(saveFile));
//			sos=response.getOutputStream();
//			boolean isMS=header.indexOf("Trident")!=-1||header.indexOf("MSIE")!=-1;
//			String encodeStr="";
//			if(isMS) {
//				encodeStr=URLEncoder.encode(oriname,"UTF-8");
//				encodeStr=encodeStr.replaceAll("\\+","%20");
//			}else {
//				encodeStr=new String(oriname.getBytes("UTF-8"),"ISO-8859-1");
//			}
//			response.setContentType("application/octet-stream;charset=utf-8");
//			response.setHeader("Content-Disposition","attachment;filename=\""+encodeStr+"\"");
//			
//			int read=-1;
//			while((read=bis.read())!=-1) {
//				sos.write(read);
//			}
//			
//		}catch(IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				sos.close();
//				bis.close();
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	@RequestMapping("community/write.do")
	public String wirte(Model m) {
		return "community/write";
	}
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
	
	/*
	 * @RequestMapping("/community/write.do") public String write() { return
	 * "community/write"; }
	 */
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
	
	@RequestMapping("/community/bkbDetail.do")
	public String bkbDetail(Model m,int threadKey) {
		
		List<Map> list = service.selectBkbArticles(threadKey);
		m.addAttribute("list",list);
		return "community/bkbDetail";
	}
}
