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
	href="${path}/resources/css/member/myPage/account/oauth.css">

<section id="context">

	<jsp:include
		page="/WEB-INF/views/member/myPage/common/myPageHeader.jsp" />

	<!-- section-content 안에 내용을 기술해 주세요! -->
	<div class="section-content">
		<h2>간편 인증 관리</h2>
		<table>
			<tr>
				<td>
					<div class="oauth-icon">
						<img src="${path }/resources/images/sns/google.svg" alt="" />
					</div>
				</td>
				<td><c:if test="${google == false }">
						<button class="btn btn--primary" id="btn-google-connect">연결하기</button>
					</c:if> <c:if test="${google == true }">
						<button class="btn btn--primary2" id="btn-google-disconnect"
							onclick="deleteOauth(1);">연결끊기</button>
					</c:if></td>
			</tr>
			<tr>
				<td>
					<div class="oauth-icon">
						<img src="${path }/resources/images/sns/kakao.png" alt="" />
					</div>
				</td>
				<td><c:if test="${kakao == false }">
						<button class="btn btn--primary" id="btn-kakao-connect">연결하기</button>
					</c:if> <c:if test="${kakao == true }">
						<button class="btn btn--primary2" id="btn-kakao-disconnect"
							onclick="deleteOauth(2);">연결끊기</button>
					</c:if></td>
			</tr>
			<tr>
				<td>
					<div class="oauth-icon">
						<img src="${path }/resources/images/sns/naver.png" alt="" />
					</div>
				</td>
				<td><c:if test="${naver == false }">
						<button class="btn btn--primary" id="btn-naver-connect">연결하기</button>
					</c:if> <c:if test="${naver == true }">
						<button class="btn btn--primary2" id="btn-naver-disconnect"
							onclick="deleteOauth(3);">연결끊기</button>
					</c:if></td>
			</tr>

		</table>
		<c:if test="${google == false}">
			<div class="oauth-hidden-btn-cont">
				<div class="g-signin2" id="googleSignIn" data-onsuccess="onSignIn"></div>
			</div>
		</c:if>
	</div>


	<!-- 아래 div는 비워두세요!  space-between을 위한 빈 아이임-->
	<div></div>


</section>
<script src="${path }/resources/js/member/myPage/oauth.js"></script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />