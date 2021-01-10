package com.col.domein.auctionComment.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.auctionComment.model.vo.AuctionComment;

public interface AuctionCommentDao {
	
	//댓글 등록
	int acComment(SqlSession session, AuctionComment ac);

}
