package com.col.domein.auction.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.auction.model.service.AuctionService;
import com.col.domein.auction.model.vo.BoardAttachementFile;
import com.col.domein.auction.model.vo.BoardAttachementImage;
import com.col.domein.auction.model.vo.BoardAuction;
import com.col.domein.product.model.vo.Attachement;

@Controller
public class AuctionController {
	@Autowired
	private AuctionService service;
	//옥션등록
	@RequestMapping("/auction/auctionEnllo.do")
	public ModelAndView auctionEnllo(ModelAndView mv, int memberKey) {
		System.out.println(memberKey);
		List<Map> map=service.selectBusinessKey(memberKey);
		System.out.println(""+map);
		mv.addObject("business",map);
		mv.setViewName("auction/auctionEnllo");
		return mv;
	}
	//옥션등록 
	@RequestMapping("auction/insertEnllo.do")
	public ModelAndView inertEnllo(ModelAndView mv,Date startDate, Date endDate,BoardAuction auc,
			@RequestParam(value="upFile")MultipartFile upFile,
			@RequestParam(value="imgFile")MultipartFile imgFile,
			HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/resources/upload/boardauction/file");
		File dir=new File(path);
		String path1=session.getServletContext().getRealPath("/resources/upload/boardauction/img");
		File dir1=new File(path1);
		List<BoardAttachementFile> files=new ArrayList();
		List<BoardAttachementImage> imgs=new ArrayList();
		if(!dir.exists()) dir.mkdirs();
		
		if(!upFile.isEmpty()) {
			String originalFileName=upFile.getOriginalFilename();
			String extension=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rnd=(int)(Math.random()*10000);
			String rename=sdf.format(System.currentTimeMillis())+"_"+rnd+"."+extension;
			try {
				upFile.transferTo(new File(path+"/"+rename));
			}catch(IOException e) {
				e.printStackTrace();
			}
			BoardAttachementFile bFile =BoardAttachementFile.builder().originalFileName(originalFileName)
					.renamedFileName(rename).build();
			files.add(bFile);
		}else {
			
		}
		
		if(!dir1.exists()) dir1.mkdirs();
		
		if(!imgFile.isEmpty()) {
			String originalFileName=imgFile.getOriginalFilename();
			String extension=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rnd=(int)(Math.random()*10000);
			String rename=sdf.format(System.currentTimeMillis())+"_"+rnd+"."+extension;
			try {
				imgFile.transferTo(new File(path+"/"+rename));
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			BoardAttachementImage bImg =BoardAttachementImage.builder().imgOriginalFileName(originalFileName)
					.imgRenamedFileName(rename).build();
			imgs.add(bImg);
			
		}else {
			mv.setViewName("");
		}
		auc.setStartDate(startDate);
		auc.setEndDate(endDate);
		System.out.println(""+auc);
		int result=service.inertEnllo(auc,imgs,files);
		mv.addObject("msg",result>0?"입력성공":"입력실패");
		mv.setViewName("/auction/auction.do");
		return mv;
	}
	
	//옥션등록 수정
	@RequestMapping("/auction/auctionEnlloUpdate.do")
	public String auctionEnlloUpdate() {
		return "auction/auctionUpdate";
	}
	//옥션 참여
	@RequestMapping("/auction/auctionJoin.do")
	public String auctionJoin() {
		return "auction/auctionJoinEnllo";
	}
	//옥션 참여수정
	@RequestMapping("/auction/auctionJoinUpdate.do")
	public String auctionJoinUpdate() {
		return "auction/auctionJoinUpdate";
	}
	//옥션 my페이지
	@RequestMapping("/auction/auction.do")
	public String myAuction() {
		return "auction/myAuction";
	}
	//옥션 view페이지
	@RequestMapping("/auction/auctionView.do")
	public String auctionView() {
		return "auction/auctionView";
	}

}
