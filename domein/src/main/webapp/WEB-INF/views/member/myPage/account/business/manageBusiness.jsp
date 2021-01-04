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
	href="${path}/resources/css/member/myPage/account/business/manageBusiness.css">

<section id="context">
	<script src="https://kit.fontawesome.com/8f9d453cdc.js"
		crossorigin="anonymous"></script>

	<jsp:include
		page="/WEB-INF/views/member/myPage/common/myPageHeader.jsp" />

	<!-- section-content 안에 내용을 기술해 주세요! -->

	<div class="section-content">

		<table class="existing-businesses">
			<thead>
				<tr>
					<th>판매자 명</th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${signedInMember.businesses }" var="b">
				<tr>
					<td class="modify-btn-cont">
						<button class="btn btn--primary"
							onclick="modifyBusiness('${b.businessKey }');">${b.businessName }</button>
					</td>
					<td>
						<button class="btn btn--primary2"
							onclick="removeBusiness('${b.businessKey }');">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div class="add-btn-cont">
			<button class="btn btn--primary" id="addBusinessBtn">판매자 추가</button>
		</div>


	</div>


	<!-- 아래 div는 비워두세요!  space-between을 위한 빈 아이임-->
	<div></div>

</section>
<script src="${path }/resources/js/member/myPage/business/manageBusiness.js">
	
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />