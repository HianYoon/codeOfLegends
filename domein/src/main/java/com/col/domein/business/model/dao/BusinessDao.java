package com.col.domein.business.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BusinessDao {

	public boolean isEmptyBusinessNo(SqlSession session, String businessNo) {
		return (int)(session.selectOne("business.isEmptyBusinessNo",businessNo))==0;
	}
	
}
