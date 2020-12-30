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
						<img src="${path }/resources/images/sns/google.svg" alt=""
							/>
					</div>
				</td>
				<td>
					<button class="btn btn--primary" id="btn-google" >연결하기</button>
				</td>
			</tr>
			<tr>
				<td>
					<div class="oauth-icon">
						<img src="${path }/resources/images/sns/kakao.png" alt=""
							/>
					</div>
				</td>
				<td>
					<button class="btn btn--primary" id="btn-kakao" >연결하기</button>
				</td>
			</tr>
			<tr>
				<td>
					<div class="oauth-icon">
						<img src="${path }/resources/images/sns/naver.png" alt=""
							/>
					</div>
				</td>
				<td>
					<button class="btn btn--primary" id="btn-naver" >연결하기</button>
				</td>
			</tr>

		</table>
			<div class="oauth-hidden-btn-cont">
		<div class="g-signin2" id="googleSignIn" data-onsuccess=""></div>
	</div>
	</div>


	<!-- 아래 div는 비워두세요!  space-between을 위한 빈 아이임-->
	<div></div>

<script>
	$("#btn-google").click(e=>{
		$("#googleSignIn *").trigger("click");
	})
	
	function onSignIn(googleUser){
		const id_token = googleUser.getAuthResponse().id_token;
		$.ajax({
			url: path + "/rest/member/oauth/google",
			method: "POST",
			data : {"idToken": id_token},
			success: result =>{
				let uri="";
				switch(result){
				case 1: uri = ""; break;
				case 2: uri = "member/oauth/emailFound.do"; break;
				case 3: uri = "member/oauth/newOauthMember.do"; break;
				case 9:
					default: "error.do";
				}
				location.href = path+"/"+uri;
			}
		})
		
	}
	
	$("#btn-kakao").click(e=>{
		$.ajax({
			url: path+"/rest/member/oauth/kakao",
			method: "POST",
			success: result =>{
				location.href = result;
			}
		})
	})
	
	$("#btn-naver").click(e=>{
		$.ajax({
			url: path+"/rest/member/oauth/naver",
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