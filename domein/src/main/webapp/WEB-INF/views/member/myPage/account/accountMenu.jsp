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

		<div class="account-nav-list">
			<a href="#"> <i class="fas fa-user-circle" id="account-user-icon"></i>
				회원정보 수정
			</a>
		</div>
		<div class="account-nav-list">
			<a href="#"> <i class="fas fa-users" id="account-sns-icon"></i>
				간편인증 관리
			</a>
		</div>
		<div class="account-nav-list">
			<a href="#"> <i class="fas fa-briefcase"
				id="account-business-icon"></i> 판매자 인증
			</a>
		</div>
		<div class="account-nav-list">
			<a href="#"> <i class="fas fa-key" id="account-password-icon"></i>
				비밀번호 변경
			</a>
		</div>
		<div class="account-nav-list">
			<a href="#" class="account-logout-icon"> <i
				class="fas fa-sign-out-alt" id=account-logout-icon"></i> 로그아웃
			</a>
		</div>
		<div class="account-nav-list">
			<a href="${path }/member/myPage/account/delete.do"> <i
				class="fas fa-user-times" id="account-delete-icon"></i> 탈퇴
			</a>
		</div>



	</div>


	<!-- 아래 div는 비워두세요!  space-between을 위한 빈 아이임-->
	<div></div>

</section>
<script src="${path }/resources/js/member/myPage/accountMenu.js">
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />