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
	href="${path}/resources\css\signUp\emailConfirmed.css" />
<section id="context">
	<div
		class="animate__animated animate__bounce animate__infinite animate__slower img-cont">
		<img src="${path }/resources/images/signUp/free-icon-mail-1334855.png"
			alt="">

	</div>
	<br>
	<h2>자동으로 가입되었어요</h2>
	<br>
	<form action="${path }/member/oauth/newOauthMemberEnd.do" method="post">
		<c:if test="${email != null }">
			<h3>아이디와 이메일은 마이페이지에서 변경하실 수 있어요!</h3>
		</c:if>
		<c:if test="${email == null }">
			<h3>간편로그인에서 이메일이 자동 발견되지 않았네요 ㅠㅠ</h3>
			<h3>이메일을 입력해 주세요</h3>
			<input type="email" name="email" id="email" required class="input--text">
		</c:if>
		<br>
		<div class="flex-center">
			<label for="isSubscribed">이메일로 정보를 받아보실래요?</label> <input
				type="checkbox" id="isSubscribed" value="1">
		</div>
		
		<br>
		<br>
		<div class="flex-center">
		<c:if test="${email == null }">
			<button type="submit" id="submit" class="btn btn--primary2" disabled>가입 완료</button>
			</c:if>
			<c:if test="${email != null }">
			<button type="submit" id="submit" class="btn btn--primary">가입 완료</button>
			</c:if>
		</div>

	</form>
</section>
	<script>
	const email = $("#email");
	const submit = $("#submit");
		email.keyup(e=>{
			$.ajax({
				url: path+"/rest/member/signup/email",
				method: "POST",
				data: {data : email.val()},
				success: result =>{
					if(result) submit.removeClass("btn--primary2").addClass("btn--primary").removeAttr("disabled");
					else submit.removeClass("btn--primary").addClass("btn--primary2").attr({disabled:"disabled"});
				}
			})
		})
	</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />