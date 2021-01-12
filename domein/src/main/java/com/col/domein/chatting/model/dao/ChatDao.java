package com.col.domein.chatting.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.chatting.model.vo.Chat;

@Repository
public class ChatDao {
	
	public int insertChat(SqlSession session,Chat chat) {
		return session.insert("chat.insertChat",chat);
	}
	
	public List selectChatroom(SqlSession session,int memberKey) {
		return session.selectList("chat.selectChatroom",memberKey);
	}
	
	public List searchUser(SqlSession session, String key) {
		return session.selectList("chat.searchUser",key);
	}
	
}
