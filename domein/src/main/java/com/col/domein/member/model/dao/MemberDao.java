package com.col.domein.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	public boolean isEmptyIdName(SqlSession session, String idName) {
		return (int)(session.selectOne("signup.isEmptyIdName", idName))==0;
	}
}
