package com.col.domein.member.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	public boolean isEmptyData(SqlSession session, Map<String, String> map) {
		return (int)(session.selectOne("signup.isEmptyData", map))==0;
	}
}
