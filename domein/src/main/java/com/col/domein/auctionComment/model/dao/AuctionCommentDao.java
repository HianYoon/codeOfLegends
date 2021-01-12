package com.col.domein.auctionComment.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.auctionComment.model.vo.AuctionComment;

public interface AuctionCommentDao {
	
	//댓글 등록
	int acComment(SqlSession session, AuctionComment ac);
	//댓글 불러오기 
	List<Map> selectAuctionComment(SqlSession session, int refAticle);
	//댓글 수정
	int commentUpdate(SqlSession session, int refArticle);
	//댓글 삭제
	int commentDelete(SqlSession session, int auctionCommentNo);

}
