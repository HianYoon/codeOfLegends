/*
 * package com.col.domein.chatting.controller;
 * 
 * import javax.websocket.EndpointConfig; import javax.websocket.OnMessage;
 * import javax.websocket.Session; import javax.websocket.server.ServerEndpoint;
 * 
 * import org.springframework.stereotype.Controller;
 * 
 * @Controller
 * 
 * @ServerEndpoint(value="/chatting", encoders= {MessageEncoder.class},
 * decoders= {MessageDecoder.class}) public class ChatServer {
 * 
 * @OnOpen public void onOpen(Session session, EndpointConfig config) { //클라이언트
 * 요청이 오면 실행되는 함수 //클라이언트에서 new WebSocket()를 실행하면 바로 실행되는 메소드
 * System.out.println("WebSocket서버 접속됨"); System.out.println(session.getId());
 * 
 * //접속 성공했다는 메시지를 클라이언트에게 전송하기 //session.getBasicRemote(): 데이터를 전송할 클라이언트 스트림을
 * 가져옴 //session.getBasicRemote().sendText(): 문자열을 전송하는 메소드 //반드시 예외처리를 해줘야함 try
 * { //session.getBasicRemote().sendText("admin, ,====채팅서버에 접속성공!===="); //위에 걸
 * 객체형식으로 보내려면 sendObject()메소드를 이용해서 처리함 session.getBasicRemote().sendObject(new
 * Message("admin"," ","====채팅서버에 접속성공!====")); }catch(Exception e) {
 * e.printStackTrace(); } }
 * 
 * 
 * //클라이언트가 보낸 메세지를 받아보자!
 * 
 * @OnMessage //public void message(Session session, String msg) { //decoder가
 * 등록되어 있다면!!!!!!!! public void message(Session session,Message msg) {
 * //session은 보낸사람의 session객체, msg는 클라이언트가 보낸 메시지가 들어있음
 * 
 * //접속한 세션에 특정 아이디값을 mapping하여 저장 //session.getUserProperties()메소드를 이용해서
 * key:value형식으로 클라이언트의 정보를 저장할 수 있음!
 * session.getUserProperties().put("data",msg);
 * 
 * //message를 parsing하기 //0:보낸이, 1:받는이, 2:메시지 //String[] message=msg.split(",");
 * 
 * 
 * 
 * //받은 메시지 전송하기 (전체 session에 전송) try { //특정사항만 전송하기 Set<Session>
 * clients=session.getOpenSessions(); //if(!message[1].equals(" ")) {
 * if(!msg.getReceiver().equals(" ")) { for(Session allclients: clients) {
 * Map<String,Object> clientData=allclients.getUserProperties();//접속된 클라이언트의 정보를
 * 가져옴 // String data=(String)clientData.get("data");//위의 "data"키 값으로 가져온거임 //
 * String[] mh=data.split(","); //
 * if(message[1].equals(mh[0])||message[0].equals(mh[0])) {//저장된 정보와 보낸사람의 msg를
 * 비교해서 보내는 처리 // allclients.getBasicRemote().sendText(msg); // } //객체로 데이터 전송하기
 * Message cm=(Message)clientData.get("data");
 * if(msg.getReceiver().equals(cm.getSender())||msg.getSender().equals(cm.
 * getSender())) { allclients.getBasicRemote().sendObject(msg); } } }else {
 * //본인한테만 보내지말고, 모든 접속한 session에 데이터보내기!(전체채팅) //현재 접속한 모든 client들의 session객체들을
 * 가져오기(session.getOpenSessions()) //Set객체로 반환함 // Set<Session>
 * clients=session.getOpenSessions(); for(Session all:clients) {
 * //session.getBasicRemote().sendText(msg);
 * //all.getBasicRemote().sendText(msg); all.getBasicRemote().sendObject(msg); }
 * } }catch(Exception e) { e.printStackTrace(); } }
 * 
 * 
 * }
 */