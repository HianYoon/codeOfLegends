<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt"%> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" " />
</jsp:include>
<link
	rel="stylesheet"
	href="${path }/resources\css\signUp\registrationForm.css"
/>

<section id="context">
	<form action="${path}/member/signUp/confirmEmail.do" method="post" id="the-form">
		<div class="form-logo-cont">
			<img src="${path }/resources\images\logo\signature.png" alt="" />
		</div>
		<div class="form-container">
			<table>
				<tr class="form-row">
					<td>
						<div class="icons">
							<img
								src="${path }/resources/images/signUp/student-card.png"
								alt=""
							/>
						</div>
					</td>
					<td>
						<input
							type="text"
							class="input--text reg-form"
							placeholder="아이디"
							name="id"
						/>
					</td>
				</tr>
				<tr class="message-row">
					<td></td>
					<td class="message-cont">
						영소문자/숫자로 이루어진 5~15 길이의 아이디
					</td>
				</tr>
				<tr class="form-row">
					<td>
						<div class="icons">
							<img
								src="${path }/resources/images/signUp/padlock (3).png"
								alt=""
							/>
						</div>
					</td>
					<td>
						<input
							type="password"
							class="input--text reg-form"
							placeholder="비밀번호"
						/>
					</td>
				</tr>
				<tr class="message-row">
					<td></td>
					<td class="message-cont">숫자,특문 각 1회 이상, 영문 2+ 사용, 8자리 이상</td>
				</tr>
				<tr class="form-row">
					<td>
						<div class="icons">
							<img
								src="${path }/resources/images/signUp/padlock (2).png"
								alt=""
							/>
						</div>
					</td>
					<td>
						<input
							type="password"
							class="input--text reg-form"
							placeholder="비밀번호 확인"
						/>
					</td>
					<td></td>
				</tr>

				<tr class="message-row">
					<td></td>
					<td class="message-cont">일치하지 않습니다</td>
				</tr>
				<tr class="form-row">
					<td>
						<div class="icons">
							<img src="${path }/resources/images/signUp/user (2).png" alt="" />
						</div>
					</td>
					<td>
						<input
							type="text"
							class="input--text reg-form"
							placeholder="이름"
						/>
					</td>
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
					<td>
						<input
							type="text"
							class="input--text reg-form"
							placeholder="닉네임:한영숫자 2~10 자리"
						/>
					</td>
				</tr>
				<tr class="message-row">
					<td></td>
					<td class="message-cont">잘못되었거나 중복된 닉네임</td>
				</tr>
				<tr class="form-row">
					<td>
						<div class="icons">
							<img
								src="${path }/resources/images/signUp/telephone.png"
								alt=""
							/>
						</div>
					</td>
					<td>
						<input
							type="tel"
							class="input--text reg-form"
							placeholder="휴대전화 010-1234-5678"
						/>
					</td>
					
				</tr>
				<tr class="message-row">
					<td></td>
					<td class="message-cont">잘못된 번호입니다</td>
				</tr>
				<tr class="form-row">
					<td>
						<div class="icons">
							<img src="${path }/resources/images/signUp/mail.png" alt="" />
						</div>
					</td>
					<td>
						<input
							type="email"
							class="input--text reg-form"
							placeholder="이메일"
						/>
					</td>
				</tr>
				<tr class="message-row">
					<td></td>
					<td class="message-cont">사용할 수 없는 이메일입니다</td>
				</tr>
			</table>
		</div>
		<div class="check-container">
			<table>
				<tr>
					<td>
						<label for="email-ad-check">이메일로 정보를 받으시겠습니까?</label>
					</td>
					<td>
						<label for="email-ad-check"
							><img
								src="${path }/resources/images/signUp/unchecked.png"
								alt=""
								id="email-ad-check-img"
								class="small-check"
						/></label>
					</td>
				</tr>
				<tr>
					<td>
						<label for="additional-info-check"
							>사업자 정보를 입력하시겠습니까?</label
						>
					</td>
					<td>
						<label for="additional-info-check">
							<img
								src="${path }/resources/images/signUp/unchecked.png"
								alt=""
								id="additional-info-check-img"
								class="small-check"
							/>
						</label>
					</td>
				</tr>
			</table>
			<input type="checkbox" name="email-ad-check" id="email-ad-check" />
			<input
				type="checkbox"
				name="additional-info-check"
				id="additional-info-check"
			/>
		</div>
		<div class="button-container">
			<!-- 가입조건 체크 후 후에 가입하기의 클래스를 btn--primary로 바꾸어줌! -->
			<button type="submit" id="submit-btn" class="btn btn--primary2" disabled>가입하기</button>
		</div>
	</form>
	
	<script src="${path }/resources/js/signUp/registrationForm.js"></script>

</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />
