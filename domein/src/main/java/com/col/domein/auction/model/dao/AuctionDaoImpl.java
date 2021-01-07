package com.col.domein.auction.model.dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.auction.model.vo.AuctionBid;
import com.col.domein.auction.model.vo.BidContent;
import com.col.domein.auction.model.vo.BoardAttachementFile;
import com.col.domein.auction.model.vo.BoardAttachementImage;
import com.col.domein.auction.model.vo.BoardAuction;
@Repository
public class AuctionDaoImpl implements AuctionDao {

	//사업자정보 불러오기
	@Override
	public List<Map> selectBusinessKey(SqlSession session, int memberKey) {
		// TODO Auto-generated method stub
		return session.selectList("boardAuction.selectBusinessKey",memberKey);
	}
	//auction등록
	@Override
	public int inertEnllo(SqlSession session, BoardAuction auc) {
		// TODO Auto-generated method stub
		return session.insert("boardAuction.inertEnllo",auc);
	}
	//파일
	@Override
	public int insertUpFile(SqlSession session, BoardAttachementFile bFile) {
		// TODO Auto-generated method stub
		return session.insert("boardAuction.insertUpFile",bFile);
	}
	//이미지
	@Override
	public int insertImgFile(SqlSession session, BoardAttachementImage bImg) {
		// TODO Auto-generated method stub
		return session.insert("boardAuction.insertImgFile",bImg);
	}
	//옥션 리스트
	@Override
	public List<Map> selectAuctionList(SqlSession session, int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return session.selectList("boardAuction.selectAuctionList",null,new RowBounds((cPage-1)*numPerpage,numPerpage));
	}
	@Override
	public int selectCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("boardAuction.selectCount");
	}


	//옥션 view
	@Override
	public List<Map> selectAuctionView(SqlSession session, int articleNo) {
		// TODO Auto-generated method stub
		return session.selectList("boardAuction.selectAuctionView",articleNo);
	}
	@Override
	public List<BoardAuction> getReplyList(SqlSession session, int bid) {
		// TODO Auto-generated method stub
		return session.selectList("boardAuction.getReplyList",bid);
	}
	// 조회수 증가 
	@Override
	public void  plusReadCount(SqlSession session, int articleNo) {
		// TODO Auto-generated method stub
		session.update("boardAuction.plusReadCount",articleNo);
	}
	//bid
	@Override
	public int updateAuctionBid(SqlSession session, int articleNo, int writerKey) {
		// TODO Auto-generated method stub
		TreeMap<String,Integer> map=new TreeMap<String,Integer>();
		map.put("articleNo", articleNo);
		map.put("writerKey",writerKey);
		return session.update("boardAuction.updateAuctionBid",map);
	}
	//insert Bid
	@Override
	public int insertAuctionBid(SqlSession session, int articleNo, int writerKey, int bidStatusNo) {
		TreeMap<String,Integer> map=new TreeMap<String,Integer>();
		map.put("articleNo", articleNo);
		map.put("writerKey",writerKey);
		map.put("bidStatusNo", bidStatusNo);
		return session.insert("boardAuction.insertAuctionBid",map);
	}
	@Override
	public List<Map> checkLike(SqlSession session, int articleNo, int writerKey) {
		// TODO Auto-generated method stub
		TreeMap<String,Integer> map=new TreeMap<String,Integer>();
		map.put("articleNo", articleNo);
		map.put("writerKey",writerKey);
		return session.selectList("boardAuction.checkLike",map);
	}
	//auction one
	@Override
	public List<Map> selectAuctionOne(SqlSession session, int articleNo) {
		// TODO Auto-generated method stub
		return session.selectList("boardAuction.selectAuctionOne",articleNo);
	}
	//auction join enllo
	@Override
	public int insertJoinAuctionList(SqlSession session,AuctionBid bid  ) {
		// TODO Auto-generated method stub
		return session.insert("boardAuction.insertJoinAuctionList",bid);
	}
	//BidContent 등록
	@Override
	public int insertJoinEnlloBidContent(SqlSession session,BidContent bc) {
		// TODO Auto-generated method stub
		return session.insert("boardAuction.insertJoinEnlloBidContent",bc);
	}
	//join목록
	@Override
	public List<Map> selectselectBidContent(SqlSession session, int articleNo, int writerKey) {
		// TODO Auto-generated method stub
		TreeMap<String,Integer> map=new TreeMap<String,Integer>();
		map.put("articleNo", articleNo);
		map.put("writerKey",writerKey);
		return session.selectList("boardAuction.selectselectBidContent",map);
	}
	//joinList목록 삭제 
	@Override
	public int auctionJoinListdelete(SqlSession session, int bidKey) {
		// TODO Auto-generated method stub
		return session.delete("boardAuction.auctionJoinListdelete",bidKey);
	}
	//joinList업체 가져오기 
	@Override
	public int selectAuctionJoinCount(SqlSession session, int articleNo) {
		// TODO Auto-generated method stub
		return session.selectOne("boardAuction.selectAuctionJoinCount",articleNo);
	}
	//참여업체 정보가져오기 
	@Override
	public List<Map> selectJoinCompany(SqlSession session,int writerKey) {
		// TODO Auto-generated method stub
		return session.selectList("boardAuction.selectJoinCompany",writerKey);
	}
	

	
	
	

}
