package com.col.domein.auction.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.auction.model.dao.AuctionDao;
import com.col.domein.auction.model.vo.BoardAttachementFile;
import com.col.domein.auction.model.vo.BoardAttachementImage;
import com.col.domein.auction.model.vo.BoardAuction;
import com.col.domein.business.model.vo.Business;

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


	
}
