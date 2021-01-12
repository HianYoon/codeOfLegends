package com.col.domein.auctionComment.model.dao;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<Map> selectAuctionComment(SqlSession session,int refAticle) {
		// TODO Auto-generated method stub
		return session.selectList("auctionComment.selectAuctionComment",refAticle);
	}
	//댓글 수정

	@Override
	public int commentUpdate(SqlSession session, int refArticle) {
		// TODO Auto-generated method stub
		return session.update("auctionComment.commentUpdate",refArticle);
	}
	//댓글 삭제
	@Override
	public int commentDelete(SqlSession session, int auctionCommentNo) {
		// TODO Auto-generated method stub
		return session.delete("auctionComment.commentDelete",auctionCommentNo);
	}



	

}
