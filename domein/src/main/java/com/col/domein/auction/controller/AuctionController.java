package com.col.domein.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuctionController {
	
	//옥션등록
	@RequestMapping("/auction/auctionEnllo.do")
	public String auctionEnllo() {
		
		return "auction/auctionEnllo";
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
