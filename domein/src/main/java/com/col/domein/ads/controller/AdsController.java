package com.col.domein.ads.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.ads.model.service.AdsService;
import com.col.domein.ads.model.vo.BannerAds;
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
	}
	
	
	@RequestMapping("ads/slideBannerApplication.do")
	public String viewBannerApply() {
		return "ads/slideBannerApplication";
	}
	
	
	//slideBanner광고 신청 Form 작성(파일업로드 포함)
	@RequestMapping("/ads/slideBannerApplicationEnd.do")
	public ModelAndView bannerApply(BannerAds bannerAds, Date startDate, Date endDate, ModelAndView mv, 
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
		
		int result=service.bannerApply(bannerAds);
		mv.addObject("msg",result>0?"입력성공":"입력실패");
		mv.addObject("loc","/board/board.do");
		mv.setViewName("/common/msg");
		return mv;
	}
	
	
	@RequestMapping("/ads/directAdsApplication.do")
	public String viewDirectAdsApply() {
		return "ads/directAdsApplication";
	}
	
	
}
