<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" " />
</jsp:include>
<link rel="stylesheet"
	href="${path}/resources\css\signUp\emailConfirmed.css" />
<section id="context">
	<div
		class="animate__animated animate__bounce animate__infinite animate__slower img-cont">
		<img src="${path }/resources/images/signUp/free-icon-mail-1334855.png"
			alt="">

	</div>
	<br>
	<h2>어라, ${email}이 이미 가입되어 있네요!</h2>
	<br>
	<form action="${path }/member/oauth/emailFoundEnd.do" method="post">
		<h3>도매인에서는 이메일 한 개당 하나의 아이디만 만들 수 있어요.</h3>
		<br>
		<h3>발견된 아이디는 ${id }입니다.</h3>
		<h3>비밀번호를 입력하여 새로운 간편 인증을 연결하세요!</h3>
		<br>
		<div class="flex-center">
			<input type="password" required name="password" class="input--text">
		</div>
		<c:if test="${pwFlag == true}">
			<div class="flex-center">
				<h5>비밀번호가 틀렸어요 ㅠ 다시 입력하세요!</h5>
			</div>
		</c:if>

		<br> <br>
		<div class="flex-center">

			<button type="submit" id="submit" class="btn btn--primary">연결
				완료</button>

		</div>

	</form>
</section>


<jsp:include page="/WEB-INF/views/common/footer.jsp" />