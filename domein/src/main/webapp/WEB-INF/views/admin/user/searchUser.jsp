<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>

<link rel="stylesheet" href="${path }/resources/css/admin/admin.css" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<section id="content" class="page-admin">	
	<div class="container">
		<div class="menu-side">
			<ul>
				<li><a href="${path }/admin/userList.do">사용자 관리</a></li>
				<li><a href="${path }/admin/articleList.do">게시글 조회</a></li>
			</ul>
		</div>
		<div class="search-result">
			<div class="area-top">
				<form action="${path }/admin/searchUser.do">
					<div class="search-option">
						<%-- <select name="searchOption">
							<option value="allSearch" <c:out value="${option=='all'?'selected':'' }"/>>통합검색</option>
							<option value="nickname" <c:out value="${option=='nickname'?'selected':'' }"/>>닉네임으로 검색</option>
							<option value="email" <c:out value="${option=='email'?'selected':'' }"/>>이메일로 검색</option>
						</select> --%>
						<label><input type="radio" name="searchOption" value="allSearch" checked <c:out value="${option=='allSearch'?'checked':'' }"/>>통합검색</label>
						<label><input type="radio" name="searchOption" value="nickname" <c:out value="${option=='nickname'?'checked':'' }"/>>닉네임으로 검색</label>
						<label><input type="radio" name="searchOption" value="email" <c:out value="${option=='email'?'checked':'' }"/>>이메일로 검색</label>
					</div>
					<div class="box-form">
						<div class="wrap-data">
							<label for="userInfo">
								<span class="text-label">사용자 검색</span>
								<input type="text" id="userInfo" name="keyword">
							</label>
						</div>
						<input type="submit" class="button-type-1" value="검색">
					</div>
				</form>
			</div>
			<div class="wrap-result">
				<div class="wrap-title">
					<h2 class="page-title">총 회원수: ${totalData }명</h2>
				</div>
				<div class="wrap-contents">
					<div class="wrap-inner">
						<ul class="lists-result">
							<c:forEach items="${list }" var="l">
							<li>
								<c:if test="${l.BUSINESS_KEY != null }">
									<a class="wrap-user-profile" href="${path}/admin/userInfo.do?memberKey=${l.MEMBER_KEY}&businessKey=${l.BUSINESS_KEY}&businessNo=${l.BUSINESS_NO}">
								</c:if>
								<c:if test="${l.BUSINESS_KEY == null }">
									<a class="wrap-user-profile" href="${path}/admin/userInfo.do?memberKey=${l.MEMBER_KEY}&businessKey=-1">
								</c:if>
									<div class="box-img">								
										<c:choose>
											<c:when test="${l.PROFILE_URL eq null }">
											<img src="https://secure.gravatar.com/avatar/91524e06c4642938f6dff01039a4b2a3?s=96&r=g&d=https://drsuleymantas.com/wp-content/plugins/userswp/assets/images/no_profile.png" width="120">
											</c:when>
											<c:otherwise>
											<img src="${l.PROFILE_URL}" width="120">
											</c:otherwise>
										</c:choose>
										<c:if test="${l.ACCOUNT_STATUS_NO == 9 }">
										<span class="labeling gray">탈퇴</span>
										</c:if>
										<c:if test="${l.BUSINESS_KEY == NULL && l.ACCOUNT_STATUS_NO != 9 }">
										<span class="labeling red">미등록</span>
										</c:if>
										<c:if test="${l.BUSINESS_KEY != NULL && l.ACCOUNT_STATUS_NO != 9 }">
										<span class="labeling green">사업자</span>
										</c:if>
										
									</div>
									<div class="box-text">
										<dl class="list-user-profile">
											<div>
												<dt>회원번호</dt>
												<dd><c:out value="${l.MEMBER_KEY }"/></dd>
											</div>
											<div>
												<dt>닉네임</dt>
												<dd><c:out value="${l.NICKNAME }"/></dd>
											</div>
											<div>
												<dt>전화번호</dt>
												<dd><c:out value="${l.PHONE }"/></dd>
											</div>
											<div>
												<dt>이메일</dt>
												<dd><c:out value="${l.EMAIL }"/></dd>
											</div>
										</dl>
									</div>
								</a>
							</li>
							</c:forEach>
						</ul>
					</div>
					${pageBar }
				</div>
			</div>
		</div>
	</div>
</section>
<style>
	
</style>
<%-- <jsp:include page="/WEB-INF/views/common/footer.jsp"/> --%>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>