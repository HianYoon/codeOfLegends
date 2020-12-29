<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" "/>
</jsp:include>
<link rel="stylesheet"
	href="${path}/resources/css/member/accountDeleted.css">
<section id="context">

<div class="account-deleted-cont">

		<div class="sadness-img-cont">
			<img alt="" src="${path }/resources/images/common/accountDeleted.jpg">
		</div>
		<h3>저에게는 꿈이있어요</h3>
		<h5>당신이 언젠가 돌아오는 꿈!</h5>
		
		<br>
		<h2>언제라도 다시 돌아와 주세요</h2>
		<br>
		<div class="section-btn-cont">
			<button id="toIndex" class="btn btn--primary"> 웅.. </button>
		</div>
		<br>
	</div>

</section>
<script src="${path }/resources/js/member/accountDeleted.js"></script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>