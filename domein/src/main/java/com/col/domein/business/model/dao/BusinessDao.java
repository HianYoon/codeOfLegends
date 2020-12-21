package com.col.domein.business.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.business.model.vo.Business;

@Repository
public class BusinessDao {

	public boolean isEmptyBusinessNo(SqlSession session, String businessNo) {
		return (int)(session.selectOne("business.isEmptyBusinessNo",businessNo))==0;
	}
	
	public int getSeqBusinessKeyNextVal(SqlSession session) {
		return session.selectOne("business.getSeqBusinessKeyNextVal");
	}
	
	public boolean insertBusiness(SqlSession session, Business b) {
		return session.insert("business.insertBusiness",b)==1;
	}
	
	public boolean insertBusinessCategory(SqlSession session, Map<String,Integer> keys) {
		return session.insert("category.insertBusinessCategory",keys)==1;
	}
}
