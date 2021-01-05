package com.col.domein.auction.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

}
