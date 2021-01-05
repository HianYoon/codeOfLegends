<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" " />
</jsp:include>
<link
	rel="stylesheet"
	href="${path }/resources\css\signUp\registrationForm.css"
/>
<section id="context">

	<form action="${path}/member/emailPwChangeEnd.do" method="post"
		id="the-form">


		<input type="hidden" class="displayNone" value="${memberKey }"
			name="memberKey"> <input type="hidden" class="displayNone"
			value="${confirmationKey }" name="confirmationKey">

		<div class="form-container">
			<table>
				<tr class="form-row">
					<td>
						<div class="icons">
							<img src="${path }/resources/images/signUp/padlock (3).png"
								alt="" />
						</div>
					</td>
					<td><input type="password" class="input--text reg-form"
						placeholder="비밀번호" name="password" /></td>
				</tr>
				<tr class="message-row">
					<td></td>
					<td class="message-cont">숫자,특문 각 1회 이상, 영문 2+ 사용, 8자리 이상</td>
				</tr>
				<tr class="form-row">
					<td>
						<div class="icons">
							<img src="${path }/resources/images/signUp/padlock (2).png"
								alt="" />
						</div>
					</td>
					<td><input type="password" class="input--text reg-form"
						placeholder="비밀번호 확인" /></td>
					<td></td>
				</tr>

				<tr class="message-row">
					<td></td>
					<td class="message-cont">일치하지 않습니다</td>
				</tr>
			</table>
		</div>
		<div class="button-container">
			<!-- 가입조건 체크 후 후에 가입하기의 클래스를 btn--primary로 바꾸어줌! -->
			<button type="submit" id="submit-btn" class="btn btn--primary2"
				disabled>비밀번호 수정</button>
		</div>
	</form>
</section>

<script src="${path }/resources/js/member/emailPwChange.js"></script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />