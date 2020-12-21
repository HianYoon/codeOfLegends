package com.col.domein.cart.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.cart.model.service.CartService;
import com.col.domein.cart.model.vo.Cart;
import com.col.domein.member.model.vo.Member;
@Controller
public class CartController {
	
	@Autowired
	private CartService service;
	@Autowired
	private Member m;
	@RequestMapping("/cart/cart.do")
	public <MutipartFile> ModelAndView cart(ModelAndView mv,Cart c,int memberkey,int productNo
			){
		
		if(memberkey==m.getMemberKey()) {
			c.setMemberKey(memberkey);
			c.setProductNo(productNo);
			
			System.out.println("양:"+c.getAmount());
			System.out.println("멤버번호:"+c.getMemberKey());
			System.out.println("상품번호"+c.getProductNo());
			
			int result=service.insertProductCart(c);
			mv.addObject("cart");
			mv.setViewName("cart/cart");
			
		}else {
			//쿠키값으로 생성
			
		}
		return mv;
	}
}
