package com.col.domein.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.ads.model.service.AdsService;
import com.col.domein.member.model.vo.Member;

import net.sf.json.JSONArray;

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
//			String acceptJSON=new Gson().toJson(accept); 			
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
	
	
}
