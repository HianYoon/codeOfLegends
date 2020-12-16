package com.col.domein.member.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.member.model.dao.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao md;
	@Autowired
	SqlSession session;
	
	public boolean isEmptyIdName(String idName) {
		
		return md.isEmptyIdName(session,idName);
	}
}
