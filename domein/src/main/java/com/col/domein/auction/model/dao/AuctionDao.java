package com.col.domein.auction.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.auction.model.vo.BoardAttachementFile;
import com.col.domein.auction.model.vo.BoardAttachementImage;
import com.col.domein.auction.model.vo.BoardAuction;
import com.col.domein.business.model.vo.Business;

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

}
