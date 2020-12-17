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
	href="${path}/resources/css/signUp/businessInfo.css" />
<section id="context">

	<div class="form-logo-cont">
		<img src="${path}/resources\images\logo\signature.png" alt="" />
	</div>
	<form action="">
		<div class="form-wrapper">
			<table>
				<tr>
					<td>사업자 등록번호</td>
					<td><input type="text" class="input--text"
						placeholder="123-456-12345 형식" /></td>
					<td><img src="${path}/resources/images/signUp/checked.png"
						class="opacity0" id="businessNoCheck" alt="" /></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" class="input--text" id="narrow-field"
						readonly />
						<button class="input--text">우편번호 찾기</button></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="text" class="input--text" readonly /></td>
					<td><img src="${path}/resources/images/signUp/checked.png"
						class="opacity0" id="addressCheck" alt="" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="text" class="input--text"
						placeholder="나머지 주소" /></td>
				</tr>
				<tr>
					<td>카테고리</td>
					<td class="categories"><label for="beef">
							<div class="img-labels-container animate__animated">
								<h5>정육</h5>
								<img src="${path}/resources/images/signUp/beef.png" alt="" />
							</div>
					</label> <label for="seafood">
							<div class="img-labels-container animate__animated">
								<h5>수산</h5>
								<img src="${path}/resources/images/signUp/fish.png" alt="" />
							</div>
					</label> <label for="vegetable">
							<div class="img-labels-container animate__animated">
								<h5>야채</h5>
								<img src="${path}/resources/images/signUp/vegetables.png" alt="" />
							</div>
					</label> <label for="steel">
							<div class="img-labels-container animate__animated">
								<h5>철강</h5>
								<img src="${path}/resources/images/signUp/beam.png" alt="" />
							</div>
					</label></td>
				</tr>
				<tr>
					<td></td>
					<td class="categories"><label for="pet">
							<div class="img-labels-container animate__animated">
								<h5>애견</h5>
								<img src="${path}/resources/images/signUp/bone.png" alt="" />
							</div>
					</label> <label for="bakery">
							<div class="img-labels-container animate__animated">
								<h5>베이커리</h5>
								<img src="${path}/resources/images/signUp/bread.png" alt="" />
							</div>
					</label> <label for="electronics">
							<div class="img-labels-container animate__animated">
								<h5>전자기기</h5>
								<img
									src="${path}/resources/images/signUp/free-icon-lightning-616494.png"
									alt="" />
							</div>
					</label> <label for="etc">
							<div class="img-labels-container animate__animated">
								<h5>기타</h5>
								<img
									src="${path}/resources/images/signUp/free-icon-question-mark-in-dark-circle-71768.png"
									alt="" />
							</div>
					</label></td>
				</tr>
				<div class="input-fields">
					<input type="checkbox" value="1" id="beef" /> <input
						type="checkbox" value="2" id="seafood" /> <input type="checkbox"
						value="3" id="vegetable" /> <input type="checkbox" value="4"
						id="steel" /> <input type="checkbox" value="5" id="pet" /> <input
						type="checkbox" value="6" id="bakery" /> <input type="checkbox"
						value="7" id="electronics" /> <input type="checkbox" value="99"
						id="etc" />
				</div>
			</table>
			<div class="btn-cont">
				<button class="btn btn--primary">가입</button>
				<button class="btn btn--primary2">취소</button>
			</div>
		</div>
	</form>

	<script src="${path }/resources/js/signUp/businessInfo.js"></script>

</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />
