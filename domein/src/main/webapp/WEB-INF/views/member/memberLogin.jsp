<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" " />
</jsp:include>
<link rel="stylesheet" href="${path }/resources/css/member/login.css" />
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="1048798785374-akhqjnf6p4g1fdo3mkf2pudg9ffh5ger.apps.googleusercontent.com">
<section id="context">

	<div class="login-logo-container">
		<img class="login-logo"
			src="${path }/resources/images/logo/signature.png" alt="" />
	</div>

	<div class="login-fields-container">
		<h4 class="login-error-msg">아이디나 비밀번호가 틀렸습니다</h4>
		<h3>아이디</h3>
		<input type="text" class="input--text" id="login-id" />
		<h3>비밀번호</h3>
		<input type="password" class="input--text" id="login-pw" />
	</div>
	<div class="login-sub-menu-container">
		<h5 class="id-pw-finder">ID/PW 찾기</h5>
		<h5>|</h5>
		<h5 class="sign-up">회원가입</h5>
	</div>
	<div class="login-button-container">
		<button class="btn btn--primary">로그인</button>
	</div>
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
		console.log("클릭됨");
	})

</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />