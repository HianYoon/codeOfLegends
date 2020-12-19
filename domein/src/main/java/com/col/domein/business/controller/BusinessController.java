package com.col.domein.business.controller;

import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.col.domein.business.model.service.BusinessService;
import com.col.domein.business.model.vo.Business;
import com.col.domein.business.model.vo.BusinessCategory;
import com.col.domein.member.model.service.MemberService;
import com.col.domein.member.model.vo.Member;

@Controller
@RequestMapping("/business")
public class BusinessController {

	@Autowired
	private BusinessService bs;
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping("/businessInfoEnd.do")
	public String businessInfoEnd(HttpSession session,HttpServletRequest request, Business b,
			@RequestParam(defaultValue = "99", required = false) String[] categories) {

		if (b.getBusinessNickname() == null || b.getBusinessNickname() == "") {
			b.setBusinessNickname(b.getBusinessName());
		}
		if (categories != null) {
			TreeSet<BusinessCategory> businessCategories = new TreeSet<BusinessCategory>();
			for (String c : categories) {
				BusinessCategory bc = new BusinessCategory(Integer.parseInt(c));
				businessCategories.add(bc);
			}
			b.setBusinessCategories(businessCategories);
		}
		Member m = (Member)session.getAttribute("newMember");
		int memberKey = ms.insertMember(m);
		
		if(memberKey == -1) {
//			에러시 기본 화면으로 이동/ 추후 에러페이지로 이동!
			return "redirect: "+request.getContextPath();
		}
		/////////////////////////////
		b.setMemberKey(memberKey);
		boolean businessFlag = bs.insertBusiness(b);
		
//		에러 상황시
		if(!businessFlag) return "redirect: "+request.getContextPath();
		
		///////////////////////////////////////////
		boolean emailFlag = ms.sendEmailVerification(m);
		
//		에러 상황시
		if(!emailFlag) return "redirect: "+request.getContextPath();
		
		
		return "redirect: "+request.getContextPath()+"/member/signUp/confirmEmail.do";
	}

}
