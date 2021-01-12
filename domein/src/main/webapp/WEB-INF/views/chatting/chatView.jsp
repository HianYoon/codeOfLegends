<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>

<link rel="stylesheet" href="${path }/resources/css/chat/chatView.css"/>

<section id="content">
    <div id="wholeback">
        <div class="tab_menu">
            <ul><h2>[도매인] 채팅</h2>
            	<li>
                	<input type="text" id="searchUser" list="data" name="searchUser"><datalist id="data"></datalist>
                </li>
                <c:if test="${!list.isEmpty() }">
                <!-- div id값을 chatroomKey로 주고 e.target의 id값으로 보내면 db검색가능! -->
                <forEach items="${list }" var="list">
                <li>
                    <div class="div_user" id="${list.CHATROOM_KEY }">
                        <img src="" alt="">
                        <div>
                            <h5><c:out value="${list.NICKNAME }"/></h5>                        
                            <h6><c:out value=""/></h6>
                        </div>
                    </div>
                </li>                    
                </forEach>
                </c:if>
            </ul>
        </div>
        <div id="container">
            <h2><c:out value="${signedInMember.nickname }"/></h2>
            <hr>
            <div class="div_chatBody">
                <div class="div_content">
                <!-- 불러온 대화내용이 있으면 날짜 출력 -->
                    <c:if test="">
                    <div class="div_date"></div>
                    </c:if>
                    <!-- 메시지 출력되는 곳 (.append(?)) -->
                    <div class="div_msg">
                    	
                   	</div>
                   	<input type="text" id="msg"/><input type="button" id="sendMsg" value="전송"/>
                </div>
                <div class="div_Info"></div>
            </div>
        </div>
	</div>        
</section>		
<script>
	$(function(){
		$("#msg").keypress(e=>{
			if(e.keyCode==13){
				$("#sendMsg").click();
			}
		});
	});
	$("#searchUser").keyup(e=>{
		$.ajax({
			url:"${path}/chat/searchUser",
			data:{"key":$(e.target).val()},
			success:data=>{
				let keys=data.split(",");
				$("#data").html("");
				for(let i=0;i<keys.length;i++){
					$("#data").append($("<option>").html(keys[i]));
				}
			}
		});
	});
	
</script>

<script>
	
	let socket=new WebSocket("ws://localhost:9090${path }/directChat");
	console.log("ws://localhost:9090${path }/directChat")
		
	socket.onopen= (e=>{
		console.log(e);
	});
	
	socket.onmessage=(e=>{		
		console.log(JSON.parse(e.data));
		//객체로 변환한 내용을 변수에 저장
		let msg=JSON.parse(e.data);
		
		let announcement=$("<h4>");
		let right=$("<h4>").css({
			"clear":"both",
			"float":"right",
			"backgroundColor":"#FFCA28",
			"padding":"10px",
			"border-radius":"14px",			
		});
		let left=$("<h4>").css({
			"clear":"both",
			"float":"left",
			"backgroundColor":"#E2E2D3",
			"padding":"10px",
			"border-radius":"12px"
		});
		
		if(msg["writerKey"]==0){
			$(".div_msg").append(announcement.html(msg["msgContent"]));
		}else if(msg["writerKey"]=="${signedInMember.memberKey}"){
			$(".div_msg").append(right.html(msg["msgContent"]));
		}else{
			$(".div_msg").append(left.html(msg["msgContent"]));
		}		
	});
	
	//메시지를 구분할 수 있게 메시지를 구성해보자
	//보내는 id, 받는 아이디, 메시지 => 받는 아이디가 없으면 전체로 해보자!
	
	//서버에 메시지 보내기(socket.send())
	$("#sendMsg").click(e=>{				
		let writerKey="${signedInMember.memberKey}";
		let receiverKey=48;
		let chatroomKey=0;
	/* 	if(${chatMsg.chatroomKey}>0){
			chatroomKey=${chatMsg.chatroomKey};
		} */	
		socket.send(JSON.stringify(new Message(chatroomKey,writerKey,$("#msg").val(),receiverKey)));
		$("#msg").val("");
		
		/* alert("메세지 전송합니다잉?"); */	
	});
	
	//객체로 메시지 핸들링하기
	//javascript 객체를 websocket 서버에 전송하고 
	//websocket서버는 javascript와 대응되는 vo를 만들어서 통신하기 
	
	function Message(chatroomKey,writerKey,msgContent,receiverKey){
		this.chatroomKey=chatroomKey;
		this.writerKey=writerKey;
		this.msgContent=msgContent;
		this.receiverKey=receiverKey;
	}
		
	
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

