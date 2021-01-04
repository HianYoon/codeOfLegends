package com.col.domein.auction.model.service;

import java.util.List;
import java.util.Map;

import com.col.domein.business.model.vo.Business;

public interface AuctionService {
	//등록페이지사업자 정보불러오기
	List<Map> selectBusinessKey(int memberKey);

}
