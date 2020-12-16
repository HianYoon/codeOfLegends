package com.col.domein.member.model.service;

import java.util.Map;

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
	
	public boolean isEmptyData(Map<String, String> map) {
		
		return md.isEmptyData(session,map);
	}
}
