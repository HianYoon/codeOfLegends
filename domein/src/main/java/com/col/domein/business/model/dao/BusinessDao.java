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
	
	public int updateBusinessToStoppedByMemberKey(SqlSession session, int memberKey) {
		return session.update("business.updateBusinessToStoppedByMemberKey", memberKey);
	}
	
	public boolean updateBusinessToStoppedByBusinessKey(SqlSession session, int businessKey) {
		return session.update("business.updateBusinessToStoppedByBusinessKey", businessKey) == 1;
	}
	
	public boolean updateBusinessNicknameAndTel(SqlSession session, Business b) {
		return session.update("business.updateBusinessNicknameAndTel", b) == 1;
	}
	
	public boolean deleteCategories(SqlSession session, int businessKey) {
		return session.delete("category.deleteCategories", businessKey) >= 1;
	}
}
