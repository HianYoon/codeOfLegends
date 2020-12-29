<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" " />
</jsp:include>
<!-- 로그인 된 상태로 이곳으로 오려고 하면 인덱스로 내쫓기 -->
<c:if test="${signedInMember !=null}">
	<script>
			location.href = path;
		</script>
</c:if>

<link rel="stylesheet" href="${path }/resources/css/member/login.css" />
<section id="context">
	<div class="login-logo-container">
		<img class="login-logo"
			src="${path }/resources/images/logo/signature.png" alt="" />
	</div>
	<form action="${path }/member/loginVerify.do" method="post"
		class="login-form">
		<div class="login-fields-container">
			<c:if test="${loginFlag == true}">
				<h5>아이디나 비밀번호가 틀렸습니다</h5>
			</c:if>
			<h3>아이디</h3>
			<input type="text" class="input--text" id="login-id" name="id"
				required />
			<h3>비밀번호</h3>
			<input type="password" class="input--text" id="login-pw"
				name="password" required />
		</div>
		<div class="login-sub-menu-cont">
			<div class="login-sub-menu-container">
				<h5 class="id-pw-finder">ID/PW 찾기</h5>
				<h5>|</h5>
				<h5 class="sign-up">회원가입</h5>
			</div>
		</div>
		<div class="login-button-container flex-center">
			<button class="btn btn--primary">로그인</button>
		</div>
	</form>
	<div class="oauth-button-container">
		<h4>간편 로그인 / 회원가입</h4>
		<div class="buttons">
			<img src="${path }/resources/images/sns/google.svg" alt=""
				id="btn-google" /> <img
				src="${path }/resources/images/sns/kakao.png" alt="" id="btn-kakao" />
			<img src="${path }/resources/images/sns/naver.png" alt=""
				id="btn-naver" />
		</div>
	</div>

	<div class="oauth-hidden-btn-cont">
		<div class="g-signin2" id="googleSignIn" data-onsuccess="onSignIn"></div>
	</div>

</section>

<script>
	$(".sign-up").click(e => {
		location.href = "${path}/member/signUp/signUp.do";
	})
	$("#btn-google").click(e=>{
		$("#googleSignIn *").trigger("click");
	})
	
	function onSignIn(googleUser){
		const id_token = googleUser.getAuthResponse().id_token;
		$.ajax({
			url: path + "/rest/member/oauth/google",
			method: "POST",
			data : {"idToken": id_token},
			success: result =>{
				let uri="";
				switch(result){
				case 1: uri = ""; break;
				case 2: uri = "member/oauth/emailFound.do"; break;
				case 3: uri = "member/oauth/newOauthMember.do"; break;
				case 9:
					default: "error.do";
				}
				location.href = path+"/"+uri;
			}
		})
		
	}
	
	$("#btn-kakao").click(e=>{
		$.ajax({
			url: path+"/rest/member/oauth/kakao",
			method: "POST",
			success: result =>{
				location.href = result;
			}
		})
	})
	
	$("#btn-naver").click(e=>{
		$.ajax({
			url: path+"/rest/member/oauth/naver",
			method: "POST",
			success: result =>{
				location.href = result;
			}
		})
	})
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />