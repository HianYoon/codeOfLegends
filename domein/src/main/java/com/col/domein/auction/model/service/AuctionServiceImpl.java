package com.col.domein.auction.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.auction.model.dao.AuctionDao;
import com.col.domein.business.model.vo.Business;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	private AuctionDao dao;
	@Autowired
	private SqlSession session;
	//등록페이지 사업자정보불러오기
	@Override
	public List<Map> selectBusinessKey(int memberKey) {
		// TODO Auto-generated method stub
		return dao.selectBusinessKey(session,memberKey);
	}
	
}
