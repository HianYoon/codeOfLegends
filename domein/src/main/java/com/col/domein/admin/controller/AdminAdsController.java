package com.col.domein.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.ads.model.service.AdsService;
import com.col.domein.ads.model.vo.BannerAds;
import com.col.domein.member.model.vo.Member;
import com.google.gson.Gson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class AdminAdsController {

	@Autowired
	AdsService service;
	
	
	//adminAdsMain 페이지로 화면 전환
	@RequestMapping("/admin/admin_ads/adminAdsMain.do")
	public ModelAndView viewAdminAdsMain(HttpSession session, ModelAndView mv) {
		Member m=(Member) session.getAttribute("signedInMember");	
		
		if(m!=null) {
			List accept=service.selectAccept();
			JSONArray jAccept=JSONArray.fromObject(accept);
			//String acceptJSON=new Gson().toJson(accept); 			
			mv.addObject("accept",jAccept);
			
			List deny=service.selectDeny();	
			JSONArray jDeny=JSONArray.fromObject(deny);
			mv.addObject("deny",jDeny);
			
			List pending=service.selectPending();			
			JSONArray jPending=JSONArray.fromObject(pending);
			mv.addObject("pending",jPending);							
							
			mv.setViewName("/admin/admin_ads/adminAdsMain");
			return mv;
		}else {
			mv.setViewName("/");
			return mv;
		}
	}
	
	//승인된 광고들을 불러서 [관리자]배너관리페이지로 이동
	@RequestMapping("/admin/admin_ads/adminBannerManage.do")
	public ModelAndView adminBannerManage(ModelAndView mv) {
		Date day=new Date();
		System.out.println("오늘의 날짜는: "+day);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String today=sdf.format(day);		
		System.out.println("오늘의 날짜: "+today);
		
		//해당날짜에 맞는 승인된 광고 검색		
		List<BannerAds> accept=service.selectBannerAccept(today);
		JSONArray jAccept=JSONArray.fromObject(accept);		
//		for(BannerAds b:accept) {
//			JSONObject jo=new JSONObject();
//			jo.put("adsKey",b.getAdsKey());
//			jo.put("applicantKey",b.getApplicantKey());			
//			jo.put("adsRenamedFileName",b.getAdsRenamedFileName());			
//			jo.put("urlLink",b.getUrlLink());			
//			jo.put("adsTitle",b.getAdsTitle());			
//			jAccept.add(jo);
//		}
//		String jAccept=new Gson().toJson(accept);
		mv.addObject("accept", jAccept);		
		
		//날짜상관없이 승인된 광고 검색
		List<BannerAds> tAccept=service.selectBannerTotalAccept();
		JSONArray totalAccept=JSONArray.fromObject(tAccept);
		mv.addObject("totalAccept",totalAccept);
		
		//내일날짜 구하기
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, 1);
		Date tmday=cal.getTime();
		String tmrw=sdf.format(tmday);
		System.out.println("내일날짜: "+tmrw);
		//오늘, 내일 예정된 광고 수
		mv.addObject("tmrwAds", service.selectAdsCountByDay(tmrw));
		mv.addObject("todayAds", service.selectAdsCountByDay(today));
		
		mv.setViewName("/admin/admin_ads/slideBannerManager");
		return mv;
	}
	
	//slideBannerRequestBoard로 화면 전환(슬라이드 배너 요청 게시판)
	@RequestMapping("/admin/admin_ads/adminBannerView.do")
	public ModelAndView viewAdminBannerBoard(ModelAndView mv) {
		//게시판 모두 불러오기
		List<BannerAds> board=service.selectAll();
		//JSONArray boardContent=JSONArray.fromObject(board);
		String boardContent=new Gson().toJson(board);
		mv.addObject("boardContent",boardContent);
		
		//검토대기 중인 요청수
		mv.addObject("pending", service.selectBannerPending());
		mv.setViewName("/admin/admin_ads/slideBannerRequestBoard");
		return mv;
	}
	
	//directAdsRequestBoard로 화면 전환(추천게시글 요청 검토)
	@RequestMapping("/admin/admin_ads/adminDirectView.do")
	public ModelAndView viewAdminDirectBoard(ModelAndView mv) {
		mv.setViewName("/admin/admin_ads/directAdsRequestBoard");
		return mv;
	}
	
	
	
	
}
