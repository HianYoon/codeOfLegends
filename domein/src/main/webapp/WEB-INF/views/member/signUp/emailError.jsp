<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" " />
</jsp:include>
<link
			rel="stylesheet"
			href="${path}/resources\css\signUp\emailConfirmed.css"
		/>
<section id="context">
	<div
		class="animate__animated animate__rubberBand animate__infinite animate__slower img-cont">
		<img src="${path }/resources/images/signUp/free-icon-mail-1334855.png"
			alt="">

	</div>
	<br>
	<h2>${titleMsg }</h2>
	<br>
	${msgContent }
	

	<br>
	<div>
		<button class="btn btn--primary" onclick="location.href = '${path}/member/memberLogin.do'">로그인 화면으로</button>
	</div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />