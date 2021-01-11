package com.col.domein.auctionComment.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.auctionComment.model.vo.AuctionComment;

@Repository
public class AuctionCommentDaoImpl implements AuctionCommentDao {

	
	//댓글등록
	@Override
	public int acComment(SqlSession session, AuctionComment ac) {
		// TODO Auto-generated method stub
		return session.insert("auctionComment.acComment",ac);
	}

}
