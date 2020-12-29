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
	href="${path}/resources/css/member/myPage/account/deleteAccount.css">

<section id="context">

	<jsp:include
		page="/WEB-INF/views/member/myPage/common/myPageHeader.jsp" />

	<!-- section-content 안에 내용을 기술해 주세요! -->
	<div class="section-content">

		<div class="sadness-img-cont">
			<img alt="" src="${path }/resources/images/common/sadness.jpg">
		</div>
		<h3>저희를 정말 영원히 떠나시는건가요? ㅠㅠ</h3>
		<h5>아직 보여드리지 못한 것이 많은데 ㅠㅠㅠㅠ</h5>
		
		<br>
		<br>
		<div class="section-btn-cont">
			<button id="deleteAccount" class="btn btn--primary2"> 웅.. </button>
			<button id="remainAccount" class="btn btn--primary"> 아니! </button>
		</div>
		<br>
	</div>


	<!-- 아래 div는 비워두세요!  space-between을 위한 빈 아이임-->
	<div></div>



</section>

<script>
	$("#deleteAccount").click(e=>{
		signOut();
		location.href = path + "/member/myPage/account/deleteEnd.do";
	})
	
	$("#remainAccount").click(e=>{
		location.href = path + "/member/myPage/account";
	})
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />