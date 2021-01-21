package com.col.domein.auction.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import com.col.domein.auctionComment.model.service.AuctionCommentService;
import com.col.domein.common.pageBar.PageBarFactory;
import com.col.domein.member.model.vo.Member;

@Controller
public class AuctionController {
	@Autowired
	private AuctionService service;
	@Autowired
	private AuctionCommentService ACservice;
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
	public List<Map> JoinListUpdate (BidContent bid,int articleNo,int writerKey) {
		System.out.println("수정from bid:"+bid);
		int bidKey=bid.getBidKey();
		int result=service.auctionJoinUpdate(bid);
			List <Map> list=service.selectJoinList(bidKey);
			List<Map> map=service.selectBidContent(articleNo,writerKey);
		return map;
	}
	//옥션 my페이지
	@RequestMapping("/auction/auction.do")
	public String myAuction() {
		return "auction/myAuction";
	}
	//옥션 view페이지
	@RequestMapping("/auction/auctionView.do")
	public ModelAndView auctionView(HttpServletResponse response,HttpServletRequest request,ModelAndView mv, int articleNo,int writerKey) {
		System.out.println("writerKey"+writerKey);
		List<Map>  business=service.selectBusinessKey(writerKey);
		List<Map> list=service.selectAuctionView(articleNo);
		List<Map> company=service.selectJoinCompany(articleNo);//
		int ComentCount =ACservice.selectCommentCount(articleNo);//댓글 갯수확인
		System.out.println(" 댓글수:"+ComentCount);
		int count=service.selectAuctionJoinCount(articleNo);//참여업체수 
		
		
		Cookie[] cookies=request.getCookies();
		Cookie viewCookie=null;//비교하기위한 새로운 쿠키
		//쿠키가 잇을경우
		if(cookies != null && cookies.length > 0) {
			for(int i=0; i<cookies.length;i++) {
				//Cookie의 name이 cookie+ reviewNo와 일치하는 쿠키를 viewCookie에 넣어줌
				if(cookies[i].getName().equals("cookie"+articleNo)) {
					System.out.println("처음생성한 쿠키가 들어옴");
					viewCookie=cookies[i];
				}
			}
		}
		if(viewCookie == null) {
			System.out.println("cookie없음");
			Cookie newCookie=new Cookie("cookie"+articleNo,"|"+articleNo+"|");
			response.addCookie(newCookie);//쿠키추가
			//조회수 +1
			int result=service.plusReadCount(articleNo);
			if(result>0) {
				System.out.println("조회수증가");
			}else {
				System.out.println("조회수증가안함");
			}
		}else {
			String value=viewCookie.getValue();
			System.out.println("cookie값"+value);
		}
		
		
		mv.addObject("list",list);
		mv.addObject("count",count);//참여업체수 
		mv.addObject("ComentCount",ComentCount);//댓글수
		mv.addObject("company",company);
		mv.addObject("business",business);
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
	//취소시 데이터다지우고 옥션 뷰화면으로 
	@RequestMapping("/auction/listAlldelete.do")
	public ModelAndView listAlldelete(ModelAndView mv,int articleNo,int writerKey) {
		
		System.out.println(""+articleNo+""+writerKey);
		int check=service.checkAuctionBid(articleNo,writerKey);
		System.out.println(""+check);
		if(check == 1 ) {
			
			int result=service.listAlldelete(articleNo,writerKey);
			mv.setViewName("/auction/auctionView.do");
		}else {
			mv.setViewName("/auction/auctionView.do");
		}
		return mv;
	}
	@RequestMapping("/mail/mailsenderAll")
	public ModelAndView mailsenderAll(int articleNo,ModelAndView mv,HttpServletRequest request,ModelMap map) 
	throws AddressException,MessagingException{
		System.out.println(articleNo);
		
	boolean m=	service.checkPeaple(articleNo);
	mv.addObject("msg",m);
	mv.setViewName("/auction/auctionView.do");
	return mv;
	}
	
}
