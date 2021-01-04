package com.col.domein.auction.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class AuctionDaoImpl implements AuctionDao {

	//사업자정보 불러오기
	@Override
	public List<Map> selectBusinessKey(SqlSession session, int memberKey) {
		// TODO Auto-generated method stub
		return session.selectList("boardAuction.selectBusinessKey",memberKey);
	}

}
