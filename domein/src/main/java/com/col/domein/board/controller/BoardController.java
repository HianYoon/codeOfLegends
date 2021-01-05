package com.col.domein.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
//github.com/HianYoon/codeOfLegends.git
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//github.com/HianYoon/codeOfLegends.git
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
	
	/*
	 * @RequestMapping("/community/write.do") public ModelAndView write(Board b,
	 * ModelAndView mv, Attachment a,
	 * 
	 * @RequestParam(value="upFile")MultipartFile upFile, HttpSession session) {
	 * 
	 * String
	 * path=session.getServletContext().getRealPath("/resources/upload/bannerAds");
	 * 
	 * //파일 디렉토리가 없으면 mkdirs로 폴더를 생성! File dir=new File(path); if(!dir.exists())
	 * dir.mkdirs();
	 * 
	 * //rename처리시작 if(!upFile.isEmpty()) { String
	 * originalFileName.getOriginalFileName(); String
	 * extension=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
	 * 
	 * SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS"); int
	 * rnd=(int)(Math.random()*10000); String
	 * renamedFileName=sdf.format(System.currentTimeMillis())+"_"+rnd+"."+extension;
	 * 
	 * try { upFile.transferTo(new File(path+"/"+renamedFileName));
	 * }catch(IOException e) { e.printStackTrace(); }
	 * 
	 * a.setOriginalFileName(originalFileName);
	 * a.setRenamedFileName(renamedFileName); }
	 * 
	 * int result=service.write(b); System.out.println("이게 1이되야하는데: "+result);
	 * mv.addObject("msg",result>0?"입력성공":"입력실패");
	 * mv.addObject("loc","/ads/adsMainApply.do"); mv.setViewName("/common/msg");
	 * return mv; }
	 */
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
	
	
	  @RequestMapping("/community/communityList.do") public String communityList()
	  { return "community/communityList"; }

	
	
	@RequestMapping("/community/bkbDetail.do")
	public String bkbDetail(Model m,int threadKey) {
		
		List<Map> list = service.selectBkbArticles(threadKey);
		m.addAttribute("list",list);
		return "community/bkbDetail";
	}
}