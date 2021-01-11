<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" "/>
</jsp:include>
<link
	rel="stylesheet"
	href="${path }/resources\css\member/emailPwChangeEnd.css"
/>
<section id="context">
	<h2>비밀번호가 성공적으로 변경되었습니다</h2>
	
	<button class="btn btn--primary" onclick="location.href = ${path}">홈으로 </button>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>