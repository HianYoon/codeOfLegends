
  package com.col.domein.chatting.controller;
  
  import java.sql.Date;
import java.util.Set;

import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.col.domein.chatting.model.service.ChatService;
import com.col.domein.chatting.model.vo.Chat;
import com.col.domein.chatting.util.MessageDecoder;
import com.col.domein.chatting.util.MessageEncoder;
  
  @Controller
  
  @ServerEndpoint(value="/directChat", encoders= {MessageEncoder.class}, decoders= {MessageDecoder.class}) 
  public class ChatServer {
	  
	  @Autowired
	  private ChatService service;
	  
	  @OnOpen
	  public void onOpen(Session session, EndpointConfig config) {
		  System.out.println("WebSocket에 접속되었습니다.");
	  }
	  
	  
	  @OnMessage
	  public void message(Session session, Chat chat) {
		  //key:value 형식으로 클라이언트의 정보를 저장
		  session.getUserProperties().put("data", chat);
		  try {
//			  int result=service.insertChat(chat);
//			  if(result>0) {
				  //현재연결된 세션을 가져와서 Set에 보관
				  Set<Session> users=session.getOpenSessions();
				  for(Session all:users) {
					  //메세지를 클라이언트에게 전송
					  all.getBasicRemote().sendObject(chat);
				  }				  
//			  }else {
//				  session.getBasicRemote().sendObject(new Chat(0,0,"메시지 전송 실패",new Date(1051898405),"","",0,0,0,""));
//			  }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
  }
 