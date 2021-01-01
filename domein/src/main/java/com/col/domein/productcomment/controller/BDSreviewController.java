package com.col.domein.productcomment.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.productcomment.model.service.BDSService;
import com.col.domein.productcomment.model.vo.BDSreview;

@Controller
public class BDSreviewController {
	@Autowired
	BDSService service;
	
	
	//product 댓글 저장 요청 처리 
	@RequestMapping("/product/reviews")
	public ModelAndView reviewInsert(HttpServletRequest request,ModelAndView mv,BDSreview bds) {
		System.out.println(""+bds);
		//댓글 작성자
		int writerKey=(int)request.getSession().getAttribute("writerKey");
		
		//댓글의 그룹 번호 
		int ref_productNo= Integer.parseInt(request.getParameter("refReview"));
		//댓글이 달릴상품 번호
		Integer refArtecle=Integer.parseInt(request.getParameter("refArtecle"));
		//댓굴의 내용
		String reviewContent=request.getParameter("reviewContent");
		//댓글 내에서의 그룹 번호 (null 이면 상품의 댓글이다.)
		String reviewStatusNo=request.getParameter("");
		int result=service.insertComment(bds);
		
		mv.setViewName("redirect:/product/getComment");
		return mv;
	}
	@RequestMapping("/product/getComment")
	public ModelAndView getComment(ModelAndView mv,BDSreview bds,HttpServletRequest request) {
		List<Map>list=service.selectBDScomment(bds.getReviewNo());
		mv.addObject("list",list);
		mv.setViewName("product/productDetail");
		return mv;
	}

}
