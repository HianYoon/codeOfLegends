package com.col.domein.auction.model.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.auction.model.dao.AuctionDao;
import com.col.domein.auction.model.vo.AuctionBid;
import com.col.domein.auction.model.vo.BidContent;
import com.col.domein.auction.model.vo.BoardAttachementFile;
import com.col.domein.auction.model.vo.BoardAttachementImage;
import com.col.domein.auction.model.vo.BoardAuction;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	private AuctionDao dao;
	@Autowired
	private SqlSession session;
	//등록페이지 사업자정보불러오기
	@Override
	public List<Map> selectBusinessKey(int memberKey) {
		// TODO Auto-generated method stub
		return dao.selectBusinessKey(session,memberKey);
	}
	// 입찰 등록
	@Override
	public int inertEnllo(BoardAuction auc, List<BoardAttachementImage> imgs, List<BoardAttachementFile> files) {
		// TODO Auto-generated method stub
		int result=dao.inertEnllo(session,auc);
		if(result>0) {
			if(files != null ) {
				for(BoardAttachementFile bFile: files) {
					bFile.setArticleNo(auc.getArticleNo());
					int fs=files.size();
					for(int i=1;i<fs;i++) {
						int no=i++;
						bFile.setArticleNo(no);
					}
					int fileresult=dao.insertUpFile(session,bFile);
				}
			}
		}
		if(result>0) {
			if(imgs != null ) {
				for(BoardAttachementImage i:imgs ) {
					i.setArticleNo(auc.getArticleNo());
					int at=imgs.size();
					for(int j =1 ; j < at; j++) {
						int no = j++;
						i.setArticleNo(no);
					}
					result=dao.insertImgFile(session, i);
				}
			}
		}
		return result;
	}

	//auction view
	@Override
	public List<Map> selectAuctionView(int articleNo) {
		// TODO Auto-generated method stub
		return dao.selectAuctionView(session,articleNo);
	}
	//옥션 list
	@Override
	public List<Map> selectAuctionList(int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return dao.selectAuctionList(session,cPage,numPerpage);
	}//페이지바
	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount(session);
	}
	@Override
	public List<BoardAuction> getReplyList(int bid) {
		// TODO Auto-generated method stub
		return dao.getReplyList(session,bid);
	}
	//조회수 증
	@Override
	public void plusReadCount(int articleNo) {
		// TODO Auto-generated method stub
		dao.plusReadCount(session,articleNo);
	}
	//bid 업데이트 
	@Override
	public int updateAuctionBid(int articleNo, int writerKey,int bidStatusNo) {
		
		return dao.updateAuctionBid(session,articleNo,writerKey);
	}
	//insert Bid
	@Override
	public int insertAuctionBid(int articleNo, int writerKey, int bidStatusNo) {
		// TODO Auto-generated method stub
		return dao.insertAuctionBid(session,articleNo,writerKey,bidStatusNo);
	}
	//좋아요 체크
	@Override
	public List<Map> checkLike(int articleNo, int writerKey) {
		// TODO Auto-generated method stub
		return dao.checkLike(session,articleNo,writerKey);
	}
	//옥션 정보 불러오기 
	@Override
	public List<Map> selectAuctionOne(int articleNo) {
		// TODO Auto-generated method stub
		return dao.selectAuctionOne(session,articleNo);
	}
	
	//옥션  join Enllo list
	@Override
	public int insertJoinAuctionList(AuctionBid bid, BidContent bc) {
		// TODO Auto-generated method stub
	
		int result=dao.insertJoinAuctionList(session,bid);
		if(result > 0) {
				int bidKey=bid.getBidKey();
				bc.setBidKey(bidKey);
			int resul=	dao.insertJoinEnlloBidContent(session,bc);
		}
		return result;
	}
	//join목록
	@Override
	public List<Map> selectBidContent(int articleNo, int writerKey) {
		// TODO Auto-generated method stub
		return dao.selectselectBidContent(session,articleNo,writerKey);
	}
	//join목록 list삭제
	@Override
	public int auctionJoinListdelete(int bidKey) {
		// TODO Auto-generated method stub
		return dao.auctionJoinListdelete(session,bidKey);
	}
	//join업체 수 및 정보가져오기 
	@Override
	public int selectAuctionJoinCount(int articleNo) {
		// TODO Auto-generated method stub
		return dao.selectAuctionJoinCount(session,articleNo);
	}
	//참여업체 정보가져오기 
	@Override
	public List<Map> selectJoinCompany(int writerKey) {
		// TODO Auto-generated method stub
		return dao.selectJoinCompany(session,writerKey);
	}
	
	//join목록List수정
	@Override
	public int auctionJoinUpdate(AuctionBid bid) {
		// TODO Auto-generated method stub
		return dao.auctionJoinUpdate(session,bid);
	}
	//수정할 joinlist불러오기
	@Override
	public BidContent selectJoinList(int bidKey) {
		// TODO Auto-generated method stub
		return dao.selectJoinList(session,bidKey);
	}


	
}
