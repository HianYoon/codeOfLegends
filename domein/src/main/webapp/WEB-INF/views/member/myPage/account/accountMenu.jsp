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
<script src="https://kit.fontawesome.com/8f9d453cdc.js" crossorigin="anonymous"></script>
<jsp:include page="/WEB-INF/views/member/myPage/common/myPageHeader.jsp"/>

	<div class="section-content">
		
		<div class="account-nav-list">
			<a href="#">
			<i class="fas fa-user-circle"></i>
			회원정보 수정
			</a>
		</div>
		<div class="account-nav-list">
			<a href="#">
			<i class="fas fa-users"></i>
			간편인증 관리
			</a>
		</div>
		<div class="account-nav-list">
			<a href="#">
			<i class="fas fa-briefcase"></i>
			판매자 인증
			</a>
		</div>
		<div class="account-nav-list">
			<a href="#">
			<i class="fas fa-key"></i>
			비밀번호 변경
			</a>
		</div>
		<div class="account-nav-list">
			<a href="#">
			<i class="fas fa-user-times"></i>
			탈퇴
			</a>
		</div>


	
	</div>





</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>