package com.col.domein.auctionComment.model.service;

import java.util.List;
import java.util.Map;

import com.col.domein.auctionComment.model.vo.AuctionComment;

public interface AuctionCommentService {
	//댓글 등록 
	int acComment(AuctionComment ac);
	//댓글 리스트
	List<Map> selectAuctionComment(int refAticle);
	// 댓글 수정
	int commentUpdate(int refArticle);
	//댓글 삭제
	int commentDelete(int auctionCommentNo);

}
