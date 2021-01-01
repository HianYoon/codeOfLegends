package com.col.domein.productcomment.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.productcomment.model.dao.BDSDao;
import com.col.domein.productcomment.model.service.BDSService;
import com.col.domein.productcomment.model.vo.BDSreview;
@Service
public class BDSServiceImpl implements BDSService {
	
	@Autowired
	private BDSDao dao;
	@Autowired
	private SqlSession session;
	//댓글 등록
	@Override
	public int insertComment(BDSreview bds) {
		// TODO Auto-generated method stub
		return dao.insertComment(session,bds);
	}
	@Override
	public List<Map> selectBDScomment(int reviewNo) {
		// TODO Auto-generated method stub
		return dao.selectBDScomment(session,reviewNo);
	}

}
