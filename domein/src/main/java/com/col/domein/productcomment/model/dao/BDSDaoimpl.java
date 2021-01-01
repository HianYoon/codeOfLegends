package com.col.domein.productcomment.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.productcomment.model.vo.BDSreview;

@Repository
public class BDSDaoimpl implements BDSDao {

	//댓글 등록
	@Override
	public int insertComment(SqlSession session, BDSreview bds) {
		// TODO Auto-generated method stub
		return session.insert("bdsReview.insertComment",bds);
	}
	//댓글 불러오기 
	@Override
	public List<Map> selectBDScomment(SqlSession session, int reviewNo) {
		// TODO Auto-generated method stub
		return session.selectList("bdsReview.selectBDScomment",reviewNo);
	}

}
