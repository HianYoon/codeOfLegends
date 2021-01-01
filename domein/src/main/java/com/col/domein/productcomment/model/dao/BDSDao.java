package com.col.domein.productcomment.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.productcomment.model.vo.BDSreview;



public interface BDSDao {
	//댓글 등록
	int insertComment(SqlSession session, BDSreview bds);
	//댓글 불러오기
	List<Map> selectBDScomment(SqlSession session, int reviewNo);

}
