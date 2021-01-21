package com.col.domein.auction.model.dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.auction.model.vo.AuctionBid;
import com.col.domein.auction.model.vo.BidContent;
import com.col.domein.auction.model.vo.BoardAttachementFile;
import com.col.domein.auction.model.vo.BoardAttachementImage;
import com.col.domein.auction.model.vo.BoardAuction;
import com.col.domein.business.model.vo.Business;
import com.col.domein.member.model.vo.Member;

public interface AuctionDao {
	//businessname불러오기 
	List<Map> selectBusinessKey(SqlSession session, int memberKey);
	//auction 등록
	int inertEnllo(SqlSession session, BoardAuction auc);
	//auction 파일 등록
	int insertUpFile(SqlSession session, BoardAttachementFile bFile);
	//auction 이미지 등록
	int insertImgFile(SqlSession session, BoardAttachementImage bImg);
	//auction List
	List<Map> selectAuctionList(SqlSession session, int cPage, int numPerpage);
	//카운트
	int selectCount(SqlSession session);


	//auction view
	List<Map> selectAuctionView(SqlSession session, int articleNo);
	//댓글 구현
	List<BoardAuction> getReplyList(SqlSession session, int bid);
	//조회수 증가 
	int plusReadCount(SqlSession session, int articleNo);
	//bid
	int updateAuctionBid(SqlSession session, int articleNo, int writerKey);
	//insertBid
	int insertAuctionBid(SqlSession session, int articleNo, int writerKey, int bidStatusNo);
	
	//checkLike
	List<Map> checkLike(SqlSession session, int articleNo, int writerKey);
	//AuctionOne
	List<Map> selectAuctionOne(SqlSession session, int articleNo);
	//auction join Enllo
	int insertJoinAuctionList(SqlSession session, AuctionBid bid );
	//auction bidContent 등록
	int insertJoinEnlloBidContent(SqlSession session,BidContent bc);
	//join목록 
	List<Map> selectselectBidContent(SqlSession session, int articleNo, int writerKey);
	//joinList 삭제
	int auctionJoinListdelete(SqlSession session, int bidKey);
	//joinList목록
	int selectAuctionJoinCount(SqlSession session, int articleNo);
	//참여업체 정보가져오기 
	List<Map> selectJoinCompany(SqlSession session, int writerKey);
	
	//join목록List 수정
	int auctionJoinUpdate(SqlSession session, BidContent bid);
	//join수정할 list불러오기 
	List<Map> selectJoinList(SqlSession session, int bidKey);
	//옥션취소시 데이터 삭제 
	int listAlldelete(SqlSession session, int articleNo, int writerKey);
	//auctionjoinlist 체크
	int checkAuctionBid(SqlSession session, int articleNo, int writerKey);
	//메인페이지 auctionList
	List<Map> selectAuctionListAll(SqlSession session);
	List<String> checkPeaple(SqlSession session, int articleNo);

}
