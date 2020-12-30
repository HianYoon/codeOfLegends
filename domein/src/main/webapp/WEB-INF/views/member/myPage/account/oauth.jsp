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

	<c:if test="${sources }"></c:if>
	<!-- 아래 div는 비워두세요!  space-between을 위한 빈 아이임-->
	<div></div>

	<script>
	
	function deleteOauth(loginSourceNo){
		if(loginSourceNo == 1) signOut();
		location.href = path+"/member/myPage/account/oauth/delete.do?loginSource="+loginSourceNo;
	}
	
	
	$("#btn-google-connect").click(e=>{
		$("#googleSignIn *").trigger("click");
	})
	
	function onSignIn(googleUser){
		const id_token = googleUser.getAuthResponse().id_token;
		$.ajax({
			url: path + "/rest/member/oauth/google/addition",
			method: "POST",
			data : {"idToken": id_token},
			success: result =>{
				let uri="";
				switch(result){
				case 1: return;
				case 5: uri = "member/myPage/account/oauth.do"; break;
				case 6: uri ="error.do?msg=해당 간편 인증 아이디가 이미 다른 계정에 존재합니다!&loc=/member/myPage/account/oauth.do"; break;
				case 9:
					default: uri = "error.do?msg=무언가 잘못되었네요...&loc=/member/myPage/account/oauth.do";
				}
				location.href = path+"/"+uri;
			}
		})
		
	}
	
	$("#btn-kakao-connect").click(e=>{
		$.ajax({
			url: path+"/rest/member/oauth/kakao/addition",
			method: "POST",
			success: result =>{
				location.href = result;
			}
		})
	})
	
	$("#btn-naver-connect").click(e=>{
		$.ajax({
			url: path+"/rest/member/oauth/naver/addition",
			method: "POST",
			success: result =>{
				location.href = result;
			}
		})
	})
</script>

</section>

<script src="${path }/resources/js/member/myPage/deleteAccount.js"></script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />