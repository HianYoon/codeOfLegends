package com.col.domein.auctionComment.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.auctionComment.model.dao.AuctionCommentDao;
import com.col.domein.auctionComment.model.vo.AuctionComment;
import com.col.domein.auctionComment.model.vo.AuctionCommentLike;

@Service
public class AuctionCommentServiceImpl implements AuctionCommentService {

	
	@Autowired
	private SqlSession session;
	@Autowired
	private AuctionCommentDao dao;
	
	//댓글 등록
	@Override
	public int acComment(AuctionComment ac) {
		// TODO Auto-generated method stub
		return dao.acComment(session,ac);
	}

	@Override
	public List<Map> selectAuctionComment(int refAticle) {
		// TODO Auto-generated method stub
		return dao.selectAuctionComment(session, refAticle);
	}
	//댓글 수정
	@Override
	public int commentUpdate(int refArticle) {
		// TODO Auto-generated method stub
		return dao.commentUpdate(session,refArticle);
	}

	@Override
	public int commentDelete(int auctionCommentNo) {
		// TODO Auto-generated method stub
		return dao.commentDelete(session,auctionCommentNo);
	}

	@Override
	public int selectCommentCount(int articleNo) {
		// TODO Auto-generated method stub
		return dao.selectCommentCount(session,articleNo);
	}



	@Override
	public int insertLike(AuctionCommentLike like) {
		// TODO Auto-generated method stub
		return dao.insertLike(session, like);
	}
}
