package com.col.domein.chatting.util;

import javax.websocket.EncodeException;
import javax.websocket.Encoder.Text;
import javax.websocket.EndpointConfig;

import com.col.domein.chatting.model.vo.Chat;
import com.google.gson.Gson;

public class MessageEncoder implements Text<Chat> {

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(Chat object) throws EncodeException {
		// TODO Auto-generated method stub
		return new Gson().toJson(object);
	}

	
	
}
