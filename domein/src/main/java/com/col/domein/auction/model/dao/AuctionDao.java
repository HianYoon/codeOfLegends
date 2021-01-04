package com.col.domein.auction.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.business.model.vo.Business;

public interface AuctionDao {

	List<Map> selectBusinessKey(SqlSession session, int memberKey);

}
