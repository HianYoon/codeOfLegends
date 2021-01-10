package com.col.domein.auctionComment.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.auctionComment.model.dao.AuctionCommentDao;
import com.col.domein.auctionComment.model.vo.AuctionComment;

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
}
