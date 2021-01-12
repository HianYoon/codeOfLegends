package com.col.domein.ads.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.ads.model.service.AdsService;
import com.col.domein.ads.model.vo.BannerAds;
import com.col.domein.ads.model.vo.DirectAds;
import com.col.domein.business.model.vo.Business;
import com.col.domein.member.model.vo.Member;

@Controller
public class AdsController {

	@Autowired
	AdsService service;
	
	
	//회원 광고 신청 메인페이지 화면 전환(광고현황 가져오기)
	@RequestMapping("/ads/adsMainApply.do")
	public ModelAndView viewAdsMainApply(HttpServletRequest request,ModelAndView mv) {	
		HttpSession session=request.getSession(false);	
		Member m=(Member) session.getAttribute("signedInMember");
		if(m!=null) {
			System.out.println("광고페이지 applicantKey: "+m.getMemberKey());
			int applicantKey=m.getMemberKey();
			mv.addObject("bannerHoldCount",service.bannerHoldCount(applicantKey));
			mv.addObject("bannerAcceptCount",service.bannerAcceptCount(applicantKey));
			mv.addObject("bannerRejectCount",service.bannerRejectCount(applicantKey));
			mv.addObject("directHoldCount",service.directHoldCount(applicantKey));
			mv.addObject("directAcceptCount",service.directAcceptCount(applicantKey));
			mv.addObject("directRejectCount",service.directRejectCount(applicantKey));
			mv.setViewName("ads/adsMainApply");
			return mv;		
		}else {			
			mv.setViewName("redirect:/");
			return mv;
		}
	}
	
	
	//slideBanner로 화면전환(adsRate 또한 배달)
	@RequestMapping("/ads/slideBannerApplication.do")
	public ModelAndView viewBannerApply(ModelAndView mv) {
		mv.addObject("adsRate",service.showMeRate());
		mv.setViewName("ads/slideBannerApplication");
		return mv;
	}
	
	
	//slideBanner광고 신청 Form 작성(파일업로드 포함)
	@RequestMapping("/ads/slideBannerApplicationEnd.do")
	public ModelAndView bannerApplyEnd(BannerAds bannerAds, Date startDate, Date endDate, ModelAndView mv, 
			@RequestParam(value="upFile")MultipartFile upFile, HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/resources/upload/bannerAds");
		
		//파일 디렉토리가 없으면 mkdirs로 폴더를 생성!
		File dir=new File(path);
		if(!dir.exists()) dir.mkdirs();
		
		//rename처리시작
		if(!upFile.isEmpty()) {
			String adsOriginalFileName=upFile.getOriginalFilename();
			String extension=adsOriginalFileName.substring(adsOriginalFileName.lastIndexOf(".")+1);
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rnd=(int)(Math.random()*10000);
			String adsRenamedFileName=sdf.format(System.currentTimeMillis())+"_"+rnd+"."+extension;
			
			//transferTo(File path)메소드를 이용하여 파일을 디렉토리에 저장!
			try {
				upFile.transferTo(new File(path+"/"+adsRenamedFileName));
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			bannerAds.setAdsOriginalFileName(adsOriginalFileName);
			bannerAds.setAdsRenamedFileName(adsRenamedFileName);
		}
		
		bannerAds.setStartDate(startDate);
		bannerAds.setEndDate(endDate);		
		
		int targetNo=3;
		String msg="[도매인]슬라이드 배너 광고";
		
		mv.addObject("targetNo", targetNo);
		mv.addObject("msg", msg);
		mv.addObject("adsRequest",bannerAds);
		mv.setViewName("/ads/adsPayment");
		return mv;
		
//		int result=service.bannerApply(bannerAds);
//		System.out.println("bannerAds성공여부: "+result);
//		mv.addObject("msg",result>0?"입력성공":"입력실패");
//		mv.addObject("loc","/ads/adsMainApply.do");
//		mv.setViewName("/common/msg");
//		return mv;
	}
	
	
	//슬라이드 배너 결제
	@RequestMapping("/ads/paymentEnd.do")
	public ModelAndView bannerPaymentEnd(ModelAndView mv, BannerAds bannerAds, int orderNo) {
		int result=service.bannerApply(bannerAds);
		int result2=service.insertOrderNo(orderNo);
		System.out.println("bannerAds성공여부: "+result);
		System.out.println("orderNo성공여부: "+result2);
		if(result>0 && result2>0) {
			mv.addObject("msg","결제가 완료되었습니다.");					
		}else {
			mv.addObject("msg","진행중 오류가 발생했습니다. \\n 다시 시도해주세요.");
		}
		mv.addObject("loc","/ads/adsMainApply.do");
		mv.setViewName("/common/msg");
		return mv;
	}
	
	
	//directAdsApplication으로 화면 전환
	@RequestMapping("/ads/directAdsApplication.do")
	public ModelAndView viewDirectAdsApply(HttpServletRequest request,ModelAndView mv) {
		HttpSession session=request.getSession(false);	
		Member m=(Member) session.getAttribute("signedInMember");
		if(m!=null) {
			TreeSet<Business> businesses=m.getBusinesses();
			System.out.println("멤버의 사업: "+businesses);
			if(businesses.isEmpty()) {
				mv.addObject("msg","아직 사업자 등록을 하지 않았습니다. \\n 사업자 등록 후에 서비스를 이용해주세요.");
				mv.addObject("loc","/member/myPage.do");
				mv.setViewName("/common/msg");
			}else {
				List<Integer> keys = new ArrayList<Integer>();
				for(Business b : businesses){
				   keys.add(b.getBusinessKey());
				}		
				System.out.println("사업키: "+keys.get(0));
				mv.addObject("adsRate",service.showMeDirectAdsRate());
				mv.addObject("boardDirectSale",service.selectBoardDirectSale(keys));
				mv.setViewName("ads/directAdsApplication");
			}
			return mv;
		}else {
			mv.setViewName("redirect:/");
			return mv;
		}
	}
	
	//다이렉트 광고 등록완료
	@RequestMapping("/ads/directAdsApplicationEnd.do")
	public ModelAndView directAdsApplyEnd(DirectAds directAds, Date startDate, Date endDate, ModelAndView mv) {
		directAds.setStartDate(startDate);
		directAds.setEndDate(endDate);
		int result=service.directAdsApply(directAds);
		System.out.println("directAds성공여부: "+result);
		mv.addObject("msg",result>0?"입력성공":"입력실패");
		mv.addObject("loc","/ads/adsMainApply.do");
		mv.setViewName("/common/msg");
		return mv;
	}
	
	//다이렉트 광고 내용(saleContent) ajax통신
	@RequestMapping("/ads/directAdsAjaxView.do")
	public void directAdsAjaxView(HttpServletResponse response,
			@RequestParam(value="articleNo",defaultValue="0") String articleNo) throws IOException {
		String msg=service.selectDirectSaleContent(articleNo);
		if(msg!=null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(msg);			
		}else {
			msg="내용을 불러오던 도중 에러가 발생했습니다.";
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("msg");
		}
	}
	
	
	
	
}
