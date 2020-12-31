package com.col.domein.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuctionController {
	
	//옥션등록
	@RequestMapping("/auction/auctionjoin.do")
	public String auctionJoin() {
		return "auction/auction";
	}
	//옥션 참여
	@RequestMapping("/auction/auctionIn.do")
	public String auctionIn() {
		return "auction/auction";
	}
}
