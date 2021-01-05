package com.col.domein.auction.model.service;

import java.util.List;
import java.util.Map;

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



}
