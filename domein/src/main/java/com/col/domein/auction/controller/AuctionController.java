package com.col.domein.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuctionController {
	@RequestMapping("/auction/auction.do")
	public String auction() {
		return "auction/auction";
	}
}
