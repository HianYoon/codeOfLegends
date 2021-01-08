package com.col.domein.auction.model.service;

import java.util.List;
import java.util.Map;

import com.col.domein.auction.model.vo.AuctionBid;
import com.col.domein.auction.model.vo.BidContent;
import com.col.domein.auction.model.vo.BoardAttachementFile;
import com.col.domein.auction.model.vo.BoardAttachementImage;
import com.col.domein.auction.model.vo.BoardAuction;
import com.col.domein.business.model.vo.Business;

public interface AuctionService {
	//등록페이지사업자 정보불러오기
	List<Map> selectBusinessKey(int memberKey);
	//등록
	int inertEnllo(BoardAuction auc, List<BoardAttachementImage> imgs, List<BoardAttachementFile> files);
	//auction List
	List<Map> selectAuctionList(int cPage, int numPerpage);
	//옥션 수 
	int selectCount();
	//auction view페이지
	List<Map> selectAuctionView(int articleNo);
	//비동기식 댓글
	List<BoardAuction> getReplyList(int bid);
	//조회수 증가 
	void plusReadCount(int articleNo);
	//bid 증가 
	int updateAuctionBid(int articleNo, int writerKey, int bidStatusNo);
	//insert bid
	int insertAuctionBid(int articleNo, int writerKey, int bidStatusNo);
	//checklike
	List<Map> checkLike(int articleNo, int writerKey);
	//옥션 정보 불러오기 
	List<Map> selectAuctionOne(int articleNo);
	//옥션 joinEnlloList
	int insertJoinAuctionList(AuctionBid bid, BidContent bc);
	//join 목록 불러오기 
	List<Map> selectBidContent(int articleNo, int writerKey);
	//joinList목록  지우기
	int auctionJoinListdelete(int bidKey);
	//업체 갯수 정보 불러오기 
	int selectAuctionJoinCount(int articleNo);
	//참여업체 정보
	List<Map> selectJoinCompany(int writerKey);
	//joinList수정
	int auctionJoinUpdate(BidContent bid);
	//joinlist수정된 목록가져오기
	List<Map> selectJoinList(int bidKey);


}
