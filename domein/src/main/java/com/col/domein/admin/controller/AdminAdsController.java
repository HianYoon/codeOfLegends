package com.col.domein.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.ads.model.service.AdsService;
import com.col.domein.member.model.vo.Member;

@Controller
public class AdminAdsController {

	@Autowired
	AdsService service;
	
	
	//adminAdsMain 페이지로 화면 전환
	@RequestMapping("/admin/admin_ads/adminAdsMain.do")
	public ModelAndView viewAdminAdsMain(HttpSession session, ModelAndView mv) {
		Member m=(Member) session.getAttribute("signedInMember");	
		
		if(m!=null) {
			int bannerAccept=service.selectBannerAccept();
			int directAccept=service.selectDirectAccept();
			mv.addObject("accept",bannerAccept+directAccept);
			
			int bannerDeny=service.selectBannerDeny();
			int directDeny=service.selectDirectDeny();
			mv.addObject("deny",bannerDeny+directDeny);
			
			int bannerPending=service.selectBannerPending();
			int directPending=service.selectDirectPending();
			mv.addObject("pending",bannerPending+directPending);
							
			mv.setViewName("/admin/admin_ads/adminAdsMain");
			return mv;
		}else {
			mv.setViewName("/");
			return mv;
		}
	}
	
	
}
