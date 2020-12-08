package com.col.domein.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.product.model.service.ProductService;

@Controller
public class ProductController {
	
	private ProductService service;
	@RequestMapping("/product.insert.do")
	public ModelAndView insertProduct(ModelAndView mv) {
		
		return mv;
	}

}
