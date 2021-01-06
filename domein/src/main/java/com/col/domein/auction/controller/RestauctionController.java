package com.col.domein.auction.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.col.domein.auction.model.service.AuctionService;
import com.col.domein.auction.model.vo.BoardAuction;

@RestController
@RequestMapping(value="/restBoard")
public class RestauctionController {
	
	@Inject
	private AuctionService service;
	
	@RequestMapping(value="/getReqlyList", method=RequestMethod.POST)
	public List<BoardAuction> getReplyList(@RequestParam("bid") int bid)throws Exception{
		return service.getReplyList(bid);
	}

}
