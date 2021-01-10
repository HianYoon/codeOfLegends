package com.col.domein.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.col.domein.order.model.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService os;
	
	@RequestMapping("/order.do")
	public String orderTest() {
		return "order/orderTemplate";
	}
}
