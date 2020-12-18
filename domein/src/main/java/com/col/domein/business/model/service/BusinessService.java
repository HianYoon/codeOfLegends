package com.col.domein.business.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.business.model.dao.BusinessDao;

@Service
public class BusinessService {
	
	@Autowired
	private BusinessDao bd;
	@Autowired
	SqlSession session;
	
	public boolean isEmptyBusinessNo(String businessNo) {
		return bd.isEmptyBusinessNo(session, businessNo);
	}
}
