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
	href="${path }/resources\css\signUp\registrationForm.css" />
<link rel="stylesheet"
	href="${path }/resources/css/member/myPage/account/changePw.css" />

<section id="context">

	<jsp:include
		page="/WEB-INF/views/member/myPage/common/myPageHeader.jsp" />

	<!-- section-content 안에 내용을 기술해 주세요! -->

	<div class="section-content">
		<form action="${path }/member/myPage/account/changePwEnd.do" method="post">
			<table>
				<tr class="form-row">
					<td>
						<div class="icons">
							<img src="${path }/resources/images/signUp/padlock (3).png"
								alt="" />
						</div>
					</td>
					<td><input type="password" class="input--text reg-form"
						placeholder="기존 비밀번호" name="oldPassword" id="old-password"/></td>
				</tr>
				<tr class="message-row">
					<td></td>
					<td class="message-cont" id="old-pw-message">예전 비밀번호를 적어주세요</td>
				</tr>
				<tr class="form-row">
					<td>
						<div class="icons">
							<img src="${path }/resources/images/signUp/padlock (3).png"
								alt="" />
						</div>
					</td>
					<td><input type="password" class="input--text reg-form"
						placeholder="새로운 비밀번호" name="newPassword" /></td>
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
			<div>
				<button type="submit" class="btn btn-primary2" id="submit-btn"
					disabled>제출</button>
				<button type="reset" class="btn btn-primary2" id="cancel-btn">취소</button>
			</div>
		</form>
	</div>


	<!-- 아래 div는 비워두세요!  space-between을 위한 빈 아이임-->
	<div></div>

</section>
<script src="${path }/resources/js/member/myPage/changePw.js"></script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />