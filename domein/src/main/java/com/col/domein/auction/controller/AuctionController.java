package com.col.domein.auction.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.auction.model.service.AuctionService;

@Controller
public class AuctionController {
	@Autowired
	private AuctionService service;
	//옥션등록
	@RequestMapping("/auction/auctionEnllo.do")
	public ModelAndView auctionEnllo(ModelAndView mv, int memberKey) {
		System.out.println(memberKey);
		List<Map> map=service.selectBusinessKey(memberKey);
		System.out.println(""+map);
		mv.addObject("business",map);
		mv.setViewName("auction/auctionEnllo");
		return mv;
	}
	//옥션등록 수정
	@RequestMapping("/auction/auctionEnlloUpdate.do")
	public String auctionEnlloUpdate() {
		return "auction/auctionUpdate";
	}
	//옥션 참여
	@RequestMapping("/auction/auctionJoin.do")
	public String auctionJoin() {
		return "auction/auctionJoinEnllo";
	}
	//옥션 참여수정
	@RequestMapping("/auction/auctionJoinUpdate.do")
	public String auctionJoinUpdate() {
		return "auction/auctionJoinUpdate";
	}
	//옥션 my페이지
	@RequestMapping("/auction/auction.do")
	public String myAuction() {
		return "auction/myAuction";
	}
	//옥션 view페이지
	@RequestMapping("/auction/auctionView.do")
	public String auctionView() {
		return "auction/auctionView";
	}

}
