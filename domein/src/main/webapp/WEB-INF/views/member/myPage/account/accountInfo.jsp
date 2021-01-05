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
	href="${path }/resources\css\member/myPage/account/accountInfo.css" />
<section id="context">
	<script src="https://kit.fontawesome.com/8f9d453cdc.js"
		crossorigin="anonymous"></script>

	<jsp:include
		page="/WEB-INF/views/member/myPage/common/myPageHeader.jsp" />

	<!-- section-content 안에 내용을 기술해 주세요! -->

	<div class="section-content">

		<form action="${path}/member/myPage/account/accountInfoEnd.do" method="post"
			id="the-form">
			
			<div class="form-container">
				<table>
					<tr class="form-row">
						<td>
							<div class="icons">
								<img src="${path }/resources/images/signUp/student-card.png"
									alt="" />
							</div>
						</td>
						<td><input type="text" class="input--text reg-form"
							placeholder="아이디" name="id" value="${signedInMember.id }"/></td>
					</tr>
					<tr class="message-row">
						<td></td>
						<td class="message-cont">영소문자/숫자로 이루어진 5~15 길이의 아이디</td>
					</tr>
					
					<tr class="form-row">
						<td>
							<div class="icons">
								<img src="${path }/resources/images/signUp/user (2).png" alt="" />
							</div>
						</td>
						<td><input type="text" class="input--text reg-form"
							placeholder="이름" name="userName" value="${signedInMember.userName }"/></td>
					</tr>
					<tr class="message-row">
						<td></td>
						<td class="message-cont">실명을 적어주세요</td>
					</tr>
					<tr class="form-row">
						<td>
							<div class="icons">
								<img src="${path }/resources/images/signUp/user (2).png" alt="" />
							</div>
						</td>
						<td><input type="text" class="input--text reg-form"
							placeholder="닉네임:한영숫자 2~10 자리" name="nickname" value="${signedInMember.nickname }"/></td>
					</tr>
					<tr class="message-row">
						<td></td>
						<td class="message-cont">잘못되었거나 중복된 닉네임</td>
					</tr>
					<tr class="form-row">
						<td>
							<div class="icons">
								<img src="${path }/resources/images/signUp/telephone.png" alt="" />
							</div>
						</td>
						<td><input type="tel" class="input--text reg-form"
							placeholder="휴대전화 010-1234-5678" name="phone" value="${signedInMember.phone }"/></td>

					</tr>
					<tr class="message-row">
						<td></td>
						<td class="message-cont">이미 존재하거나 잘못된 번호입니다</td>
					</tr>
					<tr class="form-row">
						<td>
							<div class="icons">
								<img src="${path }/resources/images/signUp/mail.png" alt="" />
							</div>
						</td>
						<td><input type="email" class="input--text"
							placeholder="이메일" name="email" disabled="disabled" value="${signedInMember.email }"/></td>
					</tr>
					<tr class="message-row">
						<td></td>
						<td class="message-cont">이메일은 변경할 수 없습니다</td>
					</tr>
				</table>
			</div>
			<div class="check-container">
				<table>
					<tr>
						<td><label for="email-ad-check">이메일로 정보를 받으시겠습니까?</label></td>
						<td><label for="email-ad-check"><img
								src="${path }/resources/images/signUp/unchecked.png" alt=""
								id="email-ad-check-img" class="small-check" /></label></td>
					</tr>

				</table>
				<input type="checkbox" name="isSubscribed" id="email-ad-check"
					value="1" />
			</div>
			<div class="button-container">
				<!-- 가입조건 체크 후 후에 가입하기의 클래스를 btn--primary로 바꾸어줌! -->
				<button type="submit" id="submit-btn" class="btn btn--primary2"
					disabled>수정하기</button>
			</div>
		</form>

	</div>


	<!-- 아래 div는 비워두세요!  space-between을 위한 빈 아이임-->
	<div></div>
</section>
<script src="${path }/resources/js/member/myPage/accountInfo.js"></script>

<script>
<c:if test="${signedInMember.isSubscribed == 1 }">
	$("#email-ad-check-img").trigger("click");
</c:if>

</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />