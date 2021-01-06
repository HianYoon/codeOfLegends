<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>

<section id="content">

	<div class="div_msgContainer"></div>
	<input type="text" id="msg"/><button id="btn_send">전송</button>
	
	<script>
		let socket;
		//1. Websocket객체를 만들어서 소켓서버와 연결을 함
		//서버에 접속 요청을 함
		socket=new WebSocket("ws://'${path }'/chatting");
		
		//소켓서버에 접속되면 실행되는 함수
		socket.onopen= (e=>{
			console.log(e);
		});
		
		socket.onmessage=(e=>{
			console.log(e);
			console.log(e.data);
			//객체형식의 String으로 넘어온 것을 JSON.parse()함수를 이용해서 javascript객체로 만들어줌 
			console.log(JSON.parse(e.data));
			//객체로 변환한 내용을 변수에 저장
			let msg=JSON.parse(e.data);
			
			
			
			//$("#msgContainer").html(e.data);
			//출력시에 메시지 기준에 의해 메시지를 구분함
			//let messageHandler=e.data.split(",");
			//0:보낸사람, 1:받는사람, 2:메시지
			//console.log(messageHandler);
			
			//if(messageHandler[0]=='admin'){
			if(msg["sender"]=="admin") {
				//$("#msgContainer").append("<h4 style='color:green'>"+messageHandler[2]+"</h4>");
			
				//객체형식으로 출력하기
				$(".div_msgContainer").append("<h4 style='color:green'>"+msg["msg"]+"</h4>");
			//}else if(messageHandler[1]==" "&&messageHandler[0]==$("#nickname").val()){
			}else if(msg["receiver"]==" "&&msg["sender"]==$("#nickname").val()){
				let container=$("<p>").css({
					"clear":"both",
					"float":"right",
					"backgroundColor":"lime"
				//}).html(messageHandler[0]+" : "+messageHandler[2]); //문자형식으로보낼때
				}).html(msg["sender"]+" : "+msg["msg"]);//객체형식으로 보낼때!
				$(".div_msgContainer").append(container);
			}else{
				/* if(messageHandler[1]!=" "
						&&
						($("#nickname").val()==messageHandler[0]
						||messageHandler[1]==$("#nickname").val())
					){ */
					const sender=$("#nickname").val()
				if(msg["receiver"]!=" "&&(sender==msg["sender"]||sender==msg["receiver"])){
					let container=$("<p>").css({
						"clear":"both",
						"float":sender==msg["sender"]?"right":"left",
						"backgroundColor":"gray"
					//}).html("<귓속말>"+messageHandler[0]+" : "+messageHandler[2]);
					}).html("<귓속말>"+msg["sender"]+" : "+msg["msg"]);
					$(".div_msgContainer").append(container);
				}else{
					let container=$("<p>").css({
						"clear":"both",
						"float":"left",
						"backgroundColor":"hotpink"
					//}).html(messageHandler[0]+" : "+messageHandler[2]);
					}).html(msg["sender"]+" : "+msg["msg"]);
					$(".div_msgContainer").append(container);
				}
			}
		});
		
		//메시지를 구분할 수 있게 메시지를 구성해보자
		//보내는 id, 받는 아이디, 메시지 => 받는 아이디가 없으면 전체로 해보자!
		
		
		//서버에 메시지 보내기(socket.send())
		$("#btn_send").click(e=>{
			//socket.send("내가 접속함! 나야나!");
			if($("#nickname").val().length==0){
				alert("사용할 별명을 입력하세요!");
				return;
			}
			let id=$("#nickname").val();
			let receiver=$("#receiver").val().length==0?" ":$("#receiver").val();
			//socket.send(id+","+receiver+","+$("#msg").val());
			//객체로 전송(String 형식으로 JSON을 전송): JSON.stringify()
			socket.send(JSON.stringify(new Message(id,receiver,$("#msg").val())));
			
			
			/* alert("메세지 전송합니다잉?"); */	
		});
		
		//객체로 메시지 핸들링하기
		//javascript 객체를 websocket 서버에 전송하고 
		//websocket서버는 javascript와 대응되는 vo를 만들어서 통신하기 
		
		function Message(sender,receiver,msg){
			this.sender=sender;
			this.receiver=receiver;
			this.msg=msg;
		}
		
			
		
	</script>

</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

