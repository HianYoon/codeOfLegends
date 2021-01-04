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
	href="${path}/resources/css/member/myPage/account/business/addBusiness.css" />
<section id="context">

	<jsp:include
		page="/WEB-INF/views/member/myPage/common/myPageHeader.jsp" />

	<!-- section-content 안에 내용을 기술해 주세요! -->
	<div class="section-content">


		<form
			action="${path }/member/myPage/account/business/addBusinessEnd.do"
			method="post">
			<div class="form-wrapper">
				<input class="displayNone" value="${memberBusiness.businessNo }"
					name="businessNo">
				<table>
					<th class="form-titles">사업자 등록번호 - 변경불가</th>
					<tr>
						<td class="first-column"><input type="text"
							class="input--text input-validator" placeholder="'-'제외 숫자만"
							id="businessNo" name="businessNo" readonly="readonly"
							value="${memberBusiness.businessNo }" /></td>
						<td><img src="${path}/resources/images/signUp/checked.png"
							class="opacity0 checker" id="businessNoCheck" alt="" /></td>
					</tr>
					<th class="form-titles">사업자명 - 변경불가</th>
					<tr>
						<td class="first-column"><input type="text"
							class="input--text" id="businessName" name="businessName"
							placeholder="사업자 등록번호 입력 시 자동 입력" readonly
							value="${memberBusiness.businessName }"></td>
					</tr>
					<th class="form-titles">사업자 별칭</th>
					<tr>
						<td class="first-column"><input type="text"
							class="input--text" maxlength="20" id="businessNickname"
							name="businessNickname" placeholder="미입력 시 상호명 자동 입력/ 20자 제한"
							value="${memberBusiness.businessNickname }"></td>

					</tr>
					<th class="form-titles">사업자 전화번호</th>
					<tr>
						<td class="first-column "><input type="tel"
							class="input--text input-validator" id="businessTel"
							name="businessTel" placeholder="자동 입력 / 수정 가능"
							value="${memberBusiness.businessTel }"></td>
						<td><img src="${path}/resources/images/signUp/checked.png"
							class="opacity0 checker" id="businessTelCheck" alt="" /></td>
					</tr>

					<th class="form-titles">주소 - 변경불가</th>
					<tr>
						<td class="first-column"><input type="text"
							class="input--text input-validator" readonly
							name="businessAddress" id="businessAddress"
							value="${memberBusiness.businessAddress }" /></td>
						<td><img src="${path}/resources/images/signUp/checked.png"
							class="opacity0 checker" id="addressCheck" alt="" /></td>
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
									<img src="${path}/resources/images/signUp/vegetables.png"
										alt="" />
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
						<c:if test="${categoryFlag[0] == true }">
							<input type="checkbox" value="1" id="beef" name="categories"
								class="catCheck" checked="checked" />
						</c:if>
						<c:if test="${categoryFlag[0] == false }">
							<input type="checkbox" value="1" id="beef" name="categories"
								class="catCheck" />
						</c:if>
						<c:if test="${categoryFlag[1] == true }">
							<input type="checkbox" value="2" id="seafood" name="categories"
								class="catCheck" checked />
						</c:if>
						<c:if test="${categoryFlag[1] == false }">
							<input type="checkbox" value="2" id="seafood" name="categories"
								class="catCheck" />
						</c:if>


						<c:if test="${categoryFlag[2] == true }">
							<input type="checkbox" value="3" id="vegetable" name="categories"
								class="catCheck" checked />
						</c:if>
						<c:if test="${categoryFlag[2] == false }">
							<input type="checkbox" value="3" id="vegetable" name="categories"
								class="catCheck" />
						</c:if>

						<c:if test="${categoryFlag[3] == true }">
							<input type="checkbox" value="4" id="steel" name="categories"
								class="catCheck" checked />
						</c:if>
						<c:if test="${categoryFlag[3] == false }">
							<input type="checkbox" value="4" id="steel" name="categories"
								class="catCheck" />
						</c:if>

						<c:if test="${categoryFlag[4] == true }">
							<input type="checkbox" value="5" id="pet" name="categories"
								class="catCheck" checked />
						</c:if>
						<c:if test="${categoryFlag[4] == false }">
							<input type="checkbox" value="5" id="pet" name="categories"
								class="catCheck" />
						</c:if>

						<c:if test="${categoryFlag[5] == true }">
							<input type="checkbox" value="6" id="bakery" name="categories"
								class="catCheck" checked />
						</c:if>
						<c:if test="${categoryFlag[5] == false }">
							<input type="checkbox" value="6" id="bakery" name="categories"
								class="catCheck" />
						</c:if>

						<c:if test="${categoryFlag[6] == true }">
							<input type="checkbox" value="7" id="electronics"
								class="catCheck" name="categories" checked />
						</c:if>
						<c:if test="${categoryFlag[6] == false }">
							<input type="checkbox" value="7" id="electronics"
								class="catCheck" name="categories" />
						</c:if>
						<c:if test="${categoryFlag[7] == true }">
							<input type="checkbox" value="99" id="etc" name="categories"
								class="catCheck" checked />
						</c:if>
						<c:if test="${categoryFlag[7] == false }">
							<input type="checkbox" value="99" id="etc" name="categories"
								class="catCheck" />
						</c:if>

					</div>
				</table>
				<div class="btn-cont">
					<button class="btn btn--primary2" disabled id="submit-btn">수정</button>
					<button class="btn btn--primary2">취소</button>
				</div>
			</div>
		</form>



	</div>


	<!-- 아래 div는 비워두세요!  space-between을 위한 빈 아이임-->
	<div></div>


</section>
<script src="${path }/resources/js/member/myPage/business/modifyBusiness.js"></script>

<script>
	console.log(${categoryFlag[7]});
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />