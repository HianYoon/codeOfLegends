package com.col.domein.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CartController {
	
	@RequestMapping("/cart/cart.do")
	public String cart() {
		
		return "cart/cart";
	}
}
