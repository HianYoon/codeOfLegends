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
	href="${path}/resources/css/member/myPage/account/accountMenu.css">

<section id="context">
	<script src="https://kit.fontawesome.com/8f9d453cdc.js"
		crossorigin="anonymous"></script>

	<jsp:include
		page="/WEB-INF/views/member/myPage/common/myPageHeader.jsp" />

	<!-- section-content 안에 내용을 기술해 주세요! -->

	<div class="section-content">

		<form action="/member/myPage/account/changeProfilePicEnd.do" method="post" enctype="multipart/form-data">
		
		
		</form>

	</div>


	<!-- 아래 div는 비워두세요!  space-between을 위한 빈 아이임-->
	<div></div>

</section>
<script src="${path }/resources/js/member/myPage/accountMenu.js">
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />