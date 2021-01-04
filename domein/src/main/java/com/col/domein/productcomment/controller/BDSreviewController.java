package com.col.domein.productcomment.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.productcomment.model.service.BDSService;
import com.col.domein.productcomment.model.vo.BDSreview;
import com.col.domein.productcomment.model.vo.BDSreviewLike;

@Controller
public class BDSreviewController {
	@Autowired
	BDSService service;
	
	
	//product 댓글 저장 요청 처리 
	@RequestMapping("/product/reviews")
	public ModelAndView reviewInsert(HttpServletRequest request,ModelAndView mv,BDSreview bds,
			MultipartHttpServletRequest fileRequest,
			HttpSession session) {
		System.out.println(""+bds);
		//댓글 작성자
		/*
		 * int writerKey=(int)request.getSession().getAttribute("writerKey");
		 * 
		 * //댓글의 그룹 번호 int ref_productNo=
		 * Integer.parseInt(request.getParameter("refReview")); //댓글이 달릴상품 번호 Integer
		 * refArtecle=Integer.parseInt(request.getParameter("refArtecle")); //댓굴의 내용
		 * String reviewContent=request.getParameter("reviewContent"); //댓글 내에서의 그룹 번호
		 * (null 이면 상품의 댓글이다.) String reviewStatusNo=request.getParameter("");
		 */
		String path=session.getServletContext().getRealPath("/resources/upload/product/comment");
		File dir=new File(path);
		MultipartFile mf= fileRequest.getFile("file");
		long fileSize=mf.getSize();//파일사이즈
		if(!dir.exists()) dir.mkdirs();
	
			if(!mf.isEmpty()) {
				String rOriginalFileName=mf.getOriginalFilename();
				String ext=rOriginalFileName.substring(rOriginalFileName.lastIndexOf(".")+1);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
				int rndValue=(int)(Math.random()*10000);
				String reName=sdf.format(System.currentTimeMillis())+"_"+rndValue+"."+ext;
				try {
					mf.transferTo(new File(path+"/"+reName));
				}catch(IOException e) {
					e.printStackTrace();
				}
				//1파일 attachment 빌더 어노테이션을 설정해주고 has a 관계
				/*
				 * Integer refArticle=Integer.parseInt((String)
				 * request.getAttribute("refArticle")); bds.setRefArticle(refArticle);
				 */
				bds.setrRenamedFileName(reName);
				bds.setrOriginalFileName(rOriginalFileName);
				System.out.println(""+bds);
				}
			
		
		
		int result=service.insertComment(bds);
		mv.addObject("msg",result>0?"입력성공":"등록실패");
		mv.setViewName("redirect:/product/getComment");
		return mv;
	}
	
	@RequestMapping("/BDSreview/like.do")
	public  ModelAndView insertLike(BDSreviewLike bds,ModelAndView mv) {
		int result=service.insertLike(bds);
		
		mv.addObject("msg",result>0?"좋아요":"별로입니다");
		mv.addObject("data",result);
		mv.setViewName("product/productDetail.do");
		return mv;
	}


}
