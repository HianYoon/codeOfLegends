package com.col.domein.auctionComment.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.auctionComment.model.service.AuctionCommentService;
import com.col.domein.auctionComment.model.vo.AuctionComment;
import com.col.domein.auctionComment.model.vo.AuctionCommentLike;

@Controller
public class AuctionCommentController {
	
	@Autowired
	AuctionCommentService service;
	@RequestMapping("/restBoard/getReplyList")
	@ResponseBody
	public List<Map> commentEnllo(ModelAndView mv,AuctionComment ac,
			MultipartHttpServletRequest upFile,HttpSession session) {
		int refAticle=ac.getRefArticle();
		System.out.println("ac"+ac);
		String path=session.getServletContext().getRealPath("/resources/upload/aucton/file");
		File dir=new File(path);
		MultipartFile mf=upFile.getFile("upFile");
		List<AuctionComment> files=new ArrayList();
		if(!dir.exists()) dir.mkdirs();
		if(!mf.isEmpty()) {
			String originalFileName=mf.getOriginalFilename();
			String extension=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rnd=(int)(Math.random()*10000);
			String rename=sdf.format(System.currentTimeMillis())+"_"+rnd+"."+extension;
			try{
				mf.transferTo(new File(path+"/"+rename));
			}catch(IOException e) {
				e.printStackTrace();
			}
		ac.setOriginalFileName(originalFileName);
		ac.setRenamedFileName(rename);
		System.out.println(""+ac);
		}
		int result=service.acComment(ac);
		
		//service.select
		List<Map>list=service.selectAuctionComment(refAticle);
		return list;
	}
	//댓글리스트
	@RequestMapping("/auction/commentList")
	@ResponseBody
	public List<Map> CommentList(@RequestParam int refArticle){
		List<Map>list=service.selectAuctionComment(refArticle);
		return list;
	}
	//수정 업데이트 
	@RequestMapping("/auctionComment/update.do")
	@ResponseBody 
	public int commentUpdate(int refArticle) {
		int result=service.commentUpdate(refArticle);
		return result;
	}
	//댓글 삭제
	@RequestMapping("/auctionComment/delete.do")
	@ResponseBody
	public int commentDelete(@RequestParam int auctionCommentNo ){
		
		int result=service.commentDelete(auctionCommentNo);
		return result;
	}
	//좋아요
	@RequestMapping("/auctionComment/like.do")
	@ResponseBody
	public int insertLike(AuctionCommentLike like){
		System.out.println(""+like);
	
		int result=service.insertLike(like);
	
		return result;
	}
}
