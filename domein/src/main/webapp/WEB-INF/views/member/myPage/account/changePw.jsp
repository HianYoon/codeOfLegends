<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" "/>
</jsp:include>
<section id="context">
<script src="https://kit.fontawesome.com/8f9d453cdc.js"
		crossorigin="anonymous"></script>

	<jsp:include
		page="/WEB-INF/views/member/myPage/common/myPageHeader.jsp" />

	<!-- section-content 안에 내용을 기술해 주세요! -->

	<div class="section-content">
<form action="" method="post">
		<table>
			<tr>
				<td> <h4>현재 비밀번호</h4></td>
				<td> <input type="password" name="currentPassword" class="input--text"> </td>
			</tr>
			
			<tr>
				<td> <h4>새로운 비밀번호</h4></td>
				<td> <input type="password" name="newPassword" id="newPassword" class="input--text"> </td>
			</tr>
			
			<tr>
				<td> <h4>비밀번호 확인</h4></td>
				<td> <input type="password" name="newPasswordConfirm" id="newPasswordConfirm" class="input--text"> </td>
			</tr>
		
		</table>
		button
</form>
	</div>


	<!-- 아래 div는 비워두세요!  space-between을 위한 빈 아이임-->
	<div></div>

</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>