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
				<th class="form-titles">사업자 등록번호</th>
				<tr>

					<td class="first-column"><input type="text"
						class="input--text input-validator" placeholder="123-456-12345 형식" id="businessNo"
						name="businessNo" required /></td>
					<td><img src="${path}/resources/images/signUp/checked.png"
						class="opacity0 checker" id="businessNoCheck" alt="" /></td>
				</tr>
				<th class="form-titles">사업자명</th>
				<tr>
					<td class="first-column"><input type="text"
						class="input--text" id="businessName" name="businessName"
						placeholder="사업자 등록번호 입력 시 자동 입력" readonly></td>
				</tr>
				<th class="form-titles">사업자 별칭</th>
				<tr>
					<td class="first-column"><input type="text"
						class="input--text" id="businessNickname" name="businessNickname"
						placeholder="미입력 시 상호명 자동 입력"></td>
				</tr>
				<th class="form-titles">사업자 전화번호</th>
				<tr>
					<td class="first-column"><input type="tel" class="input--text input-validator"
						id="businessTel" name="businessTel"></td>
					<td><img src="${path}/resources/images/signUp/checked.png"
						class="opacity0 checker" id="businessNoCheck" alt="" /></td>
				</tr>

				<th class="form-titles">주소</th>
				<tr>

					<td class="first-column"><input type="text"
						class="input--text" id="narrow-field" readonly name="postcode" />
						<button class="btn btn--primary">우편번호 찾기</button></td>
				</tr>
				<tr>

					<td class="first-column"><input type="text"
						class="input--text input-validator" readonly name="businessAddress1" id="businessAddress1" /></td>
					<td><img src="${path}/resources/images/signUp/checked.png"
						class="opacity0 checker" id="addressCheck" alt="" /></td>
				</tr>
				<tr>

					<td class="first-column"><input type="text"
						class="input--text" name="businessAddress2" id="businessAddress2"
						placeholder="나머지 주소" /></td>
				</tr>
				<th class="form-titles">카테고리</th>
				<tr>

					<td colspan="1" class="categories"><label for="beef">
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

					<td colspan="1" class="categories"><label for="pet">
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
					<input type="checkbox" value="1" id="beef" name="categories" /> <input
						type="checkbox" value="2" id="seafood" name="categories" /> <input
						type="checkbox" value="3" id="vegetable" name="categories" /> <input
						type="checkbox" value="4" id="steel" name="categories" /> <input
						type="checkbox" value="5" id="pet" name="categories" /> <input
						type="checkbox" value="6" id="bakery" name="categories" /> <input
						type="checkbox" value="7" id="electronics" name="categories" /> <input
						type="checkbox" value="99" id="etc" name="categories" />
				</div>
			</table>
			<div class="btn-cont">
				<button class="btn btn--primary2" disabled>가입</button>
				<button class="btn btn--primary2">취소</button>
			</div>
		</div>
	</form>
	
	<script src="${path }/resources/js/signUp/businessInfo.js"></script>
	<script>
		
	</script>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />
