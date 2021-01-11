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
	public ModelAndView insertBoard(HttpSession session,Board board, ModelAndView mv,@RequestParam(value="image", required=false)MultipartFile image,String threadTitle,int memberKey,String content) {
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
		
		int result=service.insertBoard(map);
		mv.addObject("msg", result>0?"입력성공":"입력실패");
		mv.addObject("loc", "/community/community.do");
		mv.setViewName("common/msg");
		return mv;
	}
//	@RequestMapping("/community/insertBoard.do")
//	public ModelAndView insertBoard(Board board,ModelAndView mv) {
//		
//		System.out.println(""+board);
//		
//		int result=service.insertBoard(board);
//		mv.addObject("articleContent",board);
//		mv.addObject("loc","/community/communityList.do");
//		mv.setViewName("common/msg");
//		return mv;
//	}
//	
//	@RequestMapping("/community/insertBoard.do")
//	public ModelAndView insertBoard(Board board, ModelAndView mv) 
//			{
//			
//		int result=service.insertBoard(board);
//		mv.addObject("msg", result>0?"입력성공":"입력실패");
//		mv.addObject("loc", "/community/communityList.do");
//		mv.setViewName("common/msg");
//		
//	return mv;	
//	}
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
	
//	@RequestMapping("community/write.do")
//	public ModelAndView write(Board board, ModelAndView mv, 
//			@RequestParam(value="upFile", required=false) MultipartFile[] upFile,
//			HttpSession session) {
//		int result=service.insertBoard(board,files);
//		mv.addObject("msg", result>0?"입력성공":"입력실패");
//		mv.addObject("loc", "/board/board.do");
//		
//		mv.setViewName("common/msg");
//		return mv;
//	}
	
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
	
//    @RequestMapping(value = "/community/imageUpload", method = RequestMethod.POST)
//    public void communityImageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload, HttpSession session) {
// 
//        OutputStream out = null;
//        PrintWriter printWriter = null;
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
// 
//        try{
// 
//            String fileName = upload.getOriginalFilename();
//            byte[] bytes = upload.getBytes();
//            String uploadPath = session.getServletContext().getRealPath("/resources/upload/community") + fileName;//저장경로
// 
//            out = new FileOutputStream(new File(uploadPath));
//            out.write(bytes);
//            String callback = request.getParameter("CKEditorFuncNum");
// 
//            printWriter = response.getWriter();
//            String fileUrl = session.getServletContext().getRealPath("/resources/upload/community") + fileName;//url경로
// 
//            printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
//                    + callback
//                    + ",'"
//                    + fileUrl
//                    + "','이미지를 업로드 하였습니다.'"
//                    + ")</script>");
//            printWriter.flush();
// 
//        }catch(IOException e){
//            e.printStackTrace();
//        } finally {
//            try {
//                if (out != null) {
//                    out.close();
//                }
//                if (printWriter != null) {
//                    printWriter.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
// 
//        return;
//    }
//    @RequestMapping(value="/mine/imageUpload.do", method = RequestMethod.POST)
//    public void imageUpload(HttpServletRequest request,
//            HttpServletResponse response, MultipartHttpServletRequest multiFile
//            , @RequestParam MultipartFile upload) throws Exception{
//        // 랜덤 문자 생성
//        UUID uid = UUID.randomUUID();
//        
//        OutputStream out = null;
//        PrintWriter printWriter = null;
//        
//        //인코딩
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        
//        try{
//            
//            //파일 이름 가져오기
//            String fileName = upload.getOriginalFilename();
//            byte[] bytes = upload.getBytes();
//            
//            //이미지 경로 생성
//            String path = fileDir.getPath() + "ckImage/";// fileDir는 전역 변수라 그냥 이미지 경로 설정해주면 된다.
//            String ckUploadPath = path + uid + "_" + fileName;
//            File folder = new File(path);
//            
//            //해당 디렉토리 확인
//            if(!folder.exists()){
//                try{
//                    folder.mkdirs(); // 폴더 생성
//                }catch(Exception e){
//                    e.getStackTrace();
//                }
//            }
//            
//            out = new FileOutputStream(new File(ckUploadPath));
//            out.write(bytes);
//            out.flush(); // outputStram에 저장된 데이터를 전송하고 초기화
//            
//            String callback = request.getParameter("CKEditorFuncNum");
//            printWriter = response.getWriter();
//            String fileUrl = "/mine/ckImgSubmit.do?uid=" + uid + "&fileName=" + fileName;  // 작성화면
//            
//        // 업로드시 메시지 출력
//          printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
//          printWriter.flush();
//            
//        }catch(IOException e){
//            e.printStackTrace();
//        } finally {
//          try {
//           if(out != null) { out.close(); }
//           if(printWriter != null) { printWriter.close(); }
//          } catch(IOException e) { e.printStackTrace(); }
//         }
//        
//        return;
//    }
    
    
//    @RequestMapping(value="/community/imageUpload.do", method = RequestMethod.POST)
//    public void imageUpload(HttpServletRequest request, HttpSession session,
//            HttpServletResponse response, MultipartHttpServletRequest multiFile
//            , @RequestParam MultipartFile upload) throws Exception{
//        // 랜덤 문자 생성
//        UUID uid = UUID.randomUUID();
//        
//        OutputStream out = null;
//        PrintWriter printWriter = null;
//        
//        //인코딩
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        
//        try{
//            
//            //파일 이름 가져오기
//            String fileName = upload.getOriginalFilename();
//            byte[] bytes = upload.getBytes();
//            
//            //이미지 경로 생성
//            String path = session.getServletContext().getRealPath("/resources/upload/community");// fileDir는 전역 변수라 그냥 이미지 경로 설정해주면 된다.
//            System.out.println();
//            String ckUploadPath = fileName;
//            File folder = new File(path);
//            
//            //해당 디렉토리 확인
//            if(!folder.exists()){
//                try{
//                    folder.mkdirs(); // 폴더 생성
//                }catch(Exception e){
//                    e.getStackTrace();
//                }
//            }
//            
//            out = new FileOutputStream(new File(ckUploadPath));
//            out.write(bytes);
//            out.flush(); // outputStram에 저장된 데이터를 전송하고 초기화
//            
//            String callback = request.getParameter("CKEditorFuncNum");
//            printWriter = response.getWriter();
//            String fileUrl = "/community/insertBoard.do?uid=" + uid + "&fileName=" + fileName;  // 작성화면
//            
//        // 업로드시 메시지 출력
//          printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
//          printWriter.flush();
//            
//        }catch(IOException e){
//            e.printStackTrace();
//        } finally {
//          try {
//           if(out != null) { out.close(); }
//           if(printWriter != null) { printWriter.close(); }
//          } catch(IOException e) { e.printStackTrace(); }
//         }
//        
//        return;
//    }

	@RequestMapping("/community/bkbDetail.do")
	public String bkbDetail(Model m,int threadKey) {
		
		List<Map> list = service.selectBkbArticles(threadKey);
		m.addAttribute("list",list);
		return "community/bkbDetail";
	}
	
	@RequestMapping("/community/insertArticle.do")
	public String insertArticle(HttpSession session,Model m, int threadKey, String content, int memberKey,@RequestParam(value="image", required=false)MultipartFile image) {
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