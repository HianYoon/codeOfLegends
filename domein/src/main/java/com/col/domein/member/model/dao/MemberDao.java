package com.col.domein.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.member.model.vo.EmailCheck;
import com.col.domein.member.model.vo.Member;

@Repository
public class MemberDao {
	
	public boolean isEmptyData(SqlSession session, Map<String, String> map) {
		return (int)(session.selectOne("signup.isEmptyData", map))==0;
	}
	
	public int getSeqMemberKeyNextVal(SqlSession session) {
		return (int)(session.selectOne("signup.getSeqMemberKeyNextVal"));
	}
	
	public boolean insertMember(SqlSession session, Member m) {
		return session.insert("signup.insertMember", m)==1;
	}
	
	public boolean insertConfirmationKey(SqlSession session, Map<String, String> keys) {
		return session.insert("signup.sendEmailVerification", keys) == 1;
	}
	
	public EmailCheck selectEmailCheck(SqlSession session, int memberKey) {
		return session.selectOne("signup.selectEmailCheck", memberKey);
	}

	public int updateTryCount(SqlSession session, int memberKey) {
		return session.update("signup.updateTryCount", memberKey);
	}
	
	public boolean deleteEmailCheck(SqlSession session, int memberKey) {
		return session.delete("signup.deleteEmailCheck", memberKey)==1;
	}
	
	public Member selectMemberByMemberKey(SqlSession session, int memberKey) {
		return session.selectOne("member.selectMemberByMemberKey", memberKey);
	}
	
	public List<Map> selectMemberList(SqlSession session, int cPage, int numperPage){
		return session.selectList("member.selectMemberList",null,new RowBounds(((cPage-1)*numperPage),numperPage));
	}
	
	public boolean updateMemberToConfirmed(SqlSession session, int memberKey) {
		return session.update("signup.updateMemberToConfirmed", memberKey)==1;
	}
	


}
