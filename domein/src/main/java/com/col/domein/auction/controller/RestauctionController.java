package com.col.domein.auction.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.col.domein.auction.model.service.AuctionService;
import com.col.domein.auction.model.vo.AuctionBid;

@RestController
@RequestMapping(value="/restBoard")
public class RestauctionController {
	
	@Inject
	private AuctionService service;
	
	//bid
	@RequestMapping("/auction/bid.do")
	public ModelAndView stringify(@RequestBody AuctionBid bid,ModelAndView mv) {
		int articleNo=bid.getArticleNo();
		int writerKey=bid.getWriterKey();
		int bidStatusNo=bid.getBidStatusNo();
		//되잇는지 체크
		List<Map> check=service.checkLike(articleNo,writerKey);
		
		if(check != null ) {
			bidStatusNo=1;
			int result=service.updateAuctionBid(articleNo,writerKey,bidStatusNo);
			mv.addObject("result",result);
			mv.addObject("auction/auctionList");
			
		}else {
			bidStatusNo=1;
			int result=service.insertAuctionBid(articleNo,writerKey,bidStatusNo);
			mv.addObject("result",result);
			mv.addObject("auction/auctionList");
		}
	
		return mv;
	}
}
