package com.col.domein.chatting.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.chatting.model.dao.ChatDao;
import com.col.domein.chatting.model.vo.Chat;

@Service
public class ChatService {
	
	@Autowired
	private ChatDao dao;
	
	@Autowired
	private SqlSession session;
	
	public int insertChat(Chat chat) {
		return dao.insertChat(session,chat);
	}
	
	public List selectChatroom(int memberKey) {
		return dao.selectChatroom(session,memberKey);
	}
	
	public List searchUser(String key) {
		return dao.searchUser(session,key);
	}

}
