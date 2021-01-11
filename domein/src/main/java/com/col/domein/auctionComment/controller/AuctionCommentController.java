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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.auctionComment.model.service.AuctionCommentService;
import com.col.domein.auctionComment.model.vo.AuctionComment;

@Controller
public class AuctionCommentController {
	
	@Autowired
	AuctionCommentService service;
	@RequestMapping("/restBoard/getReplyList")
	@ResponseBody
	public int commentEnllo(ModelAndView mv,AuctionComment ac,
			MultipartHttpServletRequest upFile,HttpSession session) {
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
		return result;
	}
	

}
