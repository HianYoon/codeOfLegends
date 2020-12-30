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
	href="${path}/resources/css/member/myPage/account/deleteAccount.css">

<section id="context">

	<jsp:include
		page="/WEB-INF/views/member/myPage/common/myPageHeader.jsp" />

	<!-- section-content 안에 내용을 기술해 주세요! -->
	<div class="section-content">

		<table>
			<tr> 
				<td>
					<div>
						<img class="oauth-icon" alt="" src="">
					</div>
				</td>
				<td>
					<button class="btn btn-primary">연결하기</button>
				</td>
			</tr>
			<tr> 
				<td>
					<div>
						<img class="oauth-icon" alt="" src="">
					</div>
				</td>
				<td>
					<button class="btn btn-primary">연결하기</button>
				</td>
			</tr>
			<tr> 
				<td>
					<div>
						<img class="oauth-icon" alt="" src="">
					</div>
				</td>
				<td>
					<button class="btn btn-primary">연결하기</button>
				</td>
			</tr>
			
		</table>

	</div>


	<!-- 아래 div는 비워두세요!  space-between을 위한 빈 아이임-->
	<div></div>



</section>

<script src="${path }/resources/js/member/myPage/deleteAccount.js"></script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />