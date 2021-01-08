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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.auction.model.service.AuctionService;
import com.col.domein.auction.model.vo.AuctionBid;
import com.col.domein.auction.model.vo.BidContent;
import com.col.domein.auction.model.vo.BoardAttachementFile;
import com.col.domein.auction.model.vo.BoardAttachementImage;
import com.col.domein.auction.model.vo.BoardAuction;
import com.col.domein.common.pageBar.PageBarFactory;

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
		mv.setViewName("/auction/auctionList.do");
		return mv;
	}
	
	//옥션 join 등록 ajax
	@RequestMapping("/auction/joinWriter.do")
	@ResponseBody
	public List<Map> auctionEnlloUpdate(AuctionBid bid,BidContent bc) {
		System.out.println(""+bid+""+bc);
		int articleNo=bid.getArticleNo();
		int writerKey=bid.getWriterKey(); 
		int result=service.insertJoinAuctionList(bid,bc);
		List<Map> list=service.selectBidContent(articleNo,writerKey);//목록 불러오기 
	System.out.println(""+list);
		return list;
	}
	//옥션join목록 삭제 
	@RequestMapping("/auction/joinEnllo")
	@ResponseBody
	public int auctionJoinListdelete(AuctionBid bid) {
		int bidKey=bid.getBidKey();
		int data=service.auctionJoinListdelete(bidKey);
		return data;
	}
//옥션 joinList불러오기
	@RequestMapping("/auction/Selectlist")
	@ResponseBody
	public List<Map> auctionEnlloUpdate(int articleNo,int writerKey ){
		
		List<Map> joinList=service.selectBidContent(articleNo,writerKey);
		return joinList;
	}
	//옥션 참여수정
	@RequestMapping("/auction/auctionJoinUpdate.do")
	@ResponseBody
	public List<Map> auctionJoinUpdate(BidContent bid) {
			int bidKey=bid.getBidKey();
			System.out.println("bid:"+bid);
			System.out.println(bidKey);
		
			List<Map> list=service.selectJoinList(bidKey);
			System.out.println("list:"+list);
			
		return list;
	}
	//옥션 join list 수정 등록
	@RequestMapping("/auction/auctionJoinUpdateEnllo.do")
	@ResponseBody
	public int JoinListUpdate (BidContent bid) {
		System.out.println("수정from bid:"+bid);
		int result=service.auctionJoinUpdate(bid);
		return result;
	}
	//옥션 my페이지
	@RequestMapping("/auction/auction.do")
	public String myAuction() {
		return "auction/myAuction";
	}
	//옥션 view페이지
	@RequestMapping("/auction/auctionView.do")
	public ModelAndView auctionView(ModelAndView mv, int articleNo,int writerKey) {
		System.out.println("writerKey"+writerKey);
		List<Map> list=service.selectAuctionView(articleNo);
		List<Map> company=service.selectJoinCompany(articleNo);//
		int count=service.selectAuctionJoinCount(articleNo);//참여업체수 
		//조회수 +1
		service.plusReadCount(articleNo);
		mv.addObject("list",list);
		mv.addObject("count",count);
		mv.addObject("company",company);
		mv.setViewName("auction/auctionView");
		
		return mv;
	}
	//list
	@RequestMapping("/auction/auctionList.do")
	public ModelAndView selectAuctionList(ModelAndView mv,
			@RequestParam(value="cPage",defaultValue="1") int cPage,
			@RequestParam(value="numPerpage",defaultValue="10")int numPerpage) {
		
		List<Map> list=service.selectAuctionList(cPage,numPerpage);
		int totalData=service.selectCount();
		
	System.out.println(""+list);
	mv.addObject("pageBar",PageBarFactory.getPageBar(totalData, cPage, numPerpage, "auctionList.do"));
	mv.addObject("auction",list);
	mv.setViewName("auction/auctionList");
	return mv;
	
	}
	// 참여자 == 등록 /상품 불러오기 
	@RequestMapping("/auction/joinEnllo.do")
	public ModelAndView gotoJoinEnllo(ModelAndView mv,int articleNo) {
		
		List<Map> map=service.selectAuctionOne(articleNo);
		mv.addObject("auction",map);
		mv.setViewName("auction/auctionJoinEnllo");
		
		return mv;
	}

}
