package com.col.domein.order.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	@RequestMapping(value="/cartToorder.do")
	public ModelAndView cartToOrder(ModelAndView mv,int memberKey,
			@RequestParam(value="chk[]") List<String> chArr)throws Exception {
		
		System.out.println("memberKey"+memberKey);
		List<Map> list=new ArrayList<Map>();
		System.out.println("chArr:"+chArr);
		int productNo= 0;

		System.out.println();
		for(String i : chArr) {

				
				productNo=Integer.parseInt(i);
				
				System.out.println("int:"+productNo);
				list=os.selectCartProduct(memberKey,productNo);
			//map.put("productNo",productNo);
			//map.put("memberKey",memberKey);
		}
		System.out.println("List"+list);
		mv.addObject("list",list);
		mv.setViewName("order/orderCart");
		return mv;
		
	}
}
