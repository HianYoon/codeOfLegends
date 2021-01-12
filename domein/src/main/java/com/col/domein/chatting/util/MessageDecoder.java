package com.col.domein.chatting.util;

import javax.websocket.DecodeException;
import javax.websocket.Decoder.Text;
import javax.websocket.EndpointConfig;

import com.col.domein.chatting.model.vo.Chat;
import com.google.gson.Gson;

public class MessageDecoder implements Text<Chat>{

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Chat decode(String s) throws DecodeException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(s, Chat.class);
	}

	@Override
	public boolean willDecode(String s) {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
