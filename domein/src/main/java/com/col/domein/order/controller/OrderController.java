package com.col.domein.order.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value="/order/cartToorder.do", method=RequestMethod.POST)
	public ModelAndView cartToOrder(ModelAndView mv,HttpSession session,int memberKey,
			@RequestParam(value="chk[]") List<String> chArr)throws Exception {
		
		TreeMap<String,Integer> map=new TreeMap<String,Integer>();
		System.out.println("memberKey"+memberKey);
		int product= 0;
		for(String i : chArr) {
			int productNo=Integer.parseInt(i);
			map.put("productNo",productNo);
			map.put("memberKey",memberKey);
			System.out.println("map:"+map);
			List<Map>list=os.selectCartProduct(map);
			System.out.println(""+list);
			mv.addObject("list",list);
			mv.setViewName("order/orderCart");
		}
		return mv;
		
	}
}
