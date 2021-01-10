package com.col.domein.admin.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.ads.model.service.AdsService;
import com.col.domein.ads.model.vo.BannerAds;
import com.col.domein.ads.model.vo.DirectAds;
import com.col.domein.common.pageBar.PageBarFactory;
import com.col.domein.member.model.vo.Member;

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
	
	//슬라이드 배너 요청 게시판 보기 (slideBannerRequestBoard로 화면 전환)
	@RequestMapping("/admin/admin_ads/adminBannerBoard.do")
	public ModelAndView viewAdminBannerBoard(ModelAndView mv,
			@RequestParam(value="cPage",defaultValue="1") int cPage,
			@RequestParam(value="numPerPage",defaultValue="10") int numPerpage) {		
		
		int totalCount=service.selectBannerCountAll();
		
		//게시판 모두 불러오기
		List<BannerAds> board=service.selectBannerBoardAll(cPage,numPerpage);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
		JSONArray boardContent=new JSONArray();
		for(BannerAds b:board) {
			JSONObject jo=new JSONObject();
			jo.put("adsKey",b.getAdsKey());
			jo.put("statusDesc",b.getStatusDesc());
			jo.put("adsTitle",b.getAdsTitle());
			String applyDate=sdf.format(b.getApplyDate());
			jo.put("applyDate",applyDate);
			jo.put("nickName",b.getNickName());
			boardContent.add(jo);
		}
		//JSONArray boardContent=JSONArray.fromObject(board);
		//String boardContent=new Gson().toJson(board);//Date객체가 포함됨!
		mv.addObject("boardContent",boardContent);
		
		mv.addObject("pageBar",PageBarFactory.getPageBar(totalCount, cPage, numPerpage, "adminBannerBoard.do"));
		
		//검토대기 중인 요청수
		mv.addObject("pending", service.selectBannerPending());
		mv.setViewName("/admin/admin_ads/slideBannerRequestBoard");
		return mv;
	}
	
	
	//배너광고 요청게시판에서 -> 글 상세보기(slideBannerRequestView 화면)
	@RequestMapping("/admin/admin_ads/adminBannerView.do")
	public ModelAndView viewBannerRequest(ModelAndView mv, int adsKey) {		
		mv.addObject("picked",service.selectBannerWhole(adsKey));
		mv.setViewName("/admin/admin_ads/slideBannerRequestView");
		return mv;
	}
	
	//배너광고 요청글 상세보기 후 승인/반려 처리(slideBannerRequestView 화면)
	@RequestMapping("/admin/admin_ads/adminBannerDecision.do")
	public void adminBannerDeciseion(HttpServletResponse response,
			@RequestParam(value="decision",defaultValue="0") int decision,
			@RequestParam(value="adsKey",defaultValue="0") int adsKey) throws IOException {
		String msg="";
		if(decision==1) {
			int result=service.updateAccept(adsKey);
			if(result>0) {
				msg="승인처리 되었습니다.";
			}else {
				msg="처리도중 오류가 발생했습니다! \\n 다시 시도해주세요.";
			}			
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(msg);
		}else {
			int result=service.updateDeny(adsKey);
			if(result>0) {
				msg="반려처리 되었습니다.";				
			}else {
				msg="처리도중 오류가 발생했습니다! \\n 다시 시도해주세요.";
			}
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(msg);
		}
	}
	
	
	//directAdsRequestBoard로 화면 전환(추천게시글 요청 검토)
	@RequestMapping("/admin/admin_ads/adminDirectBoard.do")
	public ModelAndView viewAdminDirectBoard(ModelAndView mv,
			@RequestParam(value="cPage",defaultValue="1") int cPage,
			@RequestParam(value="numPerPage",defaultValue="10") int numPerpage) {		
		
		int totalCount=service.selectDirectCountAll();
		
		//게시판 모두 불러오기
		List<DirectAds> board=service.selectDirectBoardAll(cPage,numPerpage);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
		JSONArray boardContent=new JSONArray();
		for(DirectAds b:board) {
			JSONObject jo=new JSONObject();
			jo.put("adsKey",b.getAdsKey());
			jo.put("statusDesc",b.getStatusDesc());
			jo.put("adsTitle",b.getAdsTitle());
			String applyDate=sdf.format(b.getApplyDate());
			jo.put("applyDate",applyDate);
			jo.put("nickName",b.getNickName());
			boardContent.add(jo);
		}		
		mv.addObject("boardContent",boardContent);
		
		mv.addObject("pageBar",PageBarFactory.getPageBar(totalCount, cPage, numPerpage, "adminDirectBoard.do"));
		
		//검토대기 중인 요청수
		mv.addObject("pending", service.selectDirectPending());
		mv.setViewName("/admin/admin_ads/directAdsRequestBoard");
		return mv;
	}
	
	//추천게시글 요청게시판에서 -> 글 상세보기(directAdsRequestView 화면)
	@RequestMapping("/admin/admin_ads/adminDirectView.do")
	public ModelAndView viewDirectRequest(ModelAndView mv, int adsKey) {		
		mv.addObject("picked",service.selectDirectWhole(adsKey));
		mv.setViewName("/admin/admin_ads/directAdsRequestView");
		return mv;
	}
	
	
	@RequestMapping("/admin/admin_ads/adminDirectDecision.do")
	public void adminDirectDeciseion(HttpServletResponse response,
			@RequestParam(value="decision",defaultValue="0") int decision,
			@RequestParam(value="adsKey",defaultValue="0") int adsKey) throws IOException {
		String msg="";
		if(decision==1) {
			int result=service.updateDirectAccept(adsKey);
			if(result>0) {
				msg="승인처리 되었습니다.";
			}else {
				msg="처리도중 오류가 발생했습니다! \\n 다시 시도해주세요.";
			}			
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(msg);
		}else {
			int result=service.updateDirectDeny(adsKey);
			if(result>0) {
				msg="반려처리 되었습니다.";				
			}else {
				msg="처리도중 오류가 발생했습니다! \\n 다시 시도해주세요.";
			}
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(msg);
		}
	}
	
	
}
