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
				<form action="${path }/admin/searchArticle.do">
					<div class="search-option">
						<%-- <select name="searchOption">
							<option value="allSearch" <c:out value="${option=='all'?'selected':'' }"/>>통합검색</option>
							<option value="nickname" <c:out value="${option=='nickname'?'selected':'' }"/>>닉네임으로 검색</option>
							<option value="email" <c:out value="${option=='email'?'selected':'' }"/>>이메일로 검색</option>
						</select> --%>
						<label><input type="radio" name="searchOption" value="allSearch" checked <c:out value="${option=='allSearch'?'checked':'' }"/>>통합검색</label>
						<label><input type="radio" name="searchOption" value="nickname" <c:out value="${option=='nickname'?'checked':'' }"/>>제목으로 검색</label>
						<label><input type="radio" name="searchOption" value="email" <c:out value="${option=='email'?'checked':'' }"/>>작성자로 검색</label>
					</div>
					<div class="box-form">
						<div class="wrap-data">
							<label for="userInfo">
								<span class="text-label">게시글 검색</span>
								<input type="text" id="userInfo" name="keyword">
							</label>
						</div>
						<input type="submit" class="button-type-1" value="검색">
					</div>
				</form>
			</div>
			<div class="wrap-result">
				<div class="wrap-inner">
					<div class="area-tab">
						<div class="contents-tab">
							<ul class="lists-result">
								<c:forEach items="${productList }" var="proList">
									<li class="item-user-activity">
										<div class="box-text">
											<c:if test="${proList.PRODUCT_STATUS_NO==1 }">
												<p class="labeling blue">거래중</p>
											</c:if>
											<c:if test="${proList.PRODUCT_STATUS_NO==8 }">
												<p class="labeling red">블라인드</p>
											</c:if>
											<c:if test="${proList.PRODUCT_STATUS_NO==9 }">
												<p class="labeling gray">삭제</p>
											</c:if>
											<p class="list-title">
												<a href="${path }/product/productDetail.do?articleNo=${proList.ARTICLE_NO}" ><c:out value="${proList.TITLE }"/></a>
											</p>
											<p class="date"><c:out value="${proList.WRITTEN_DATE }"/></p>
											<p class="writer"><c:out value="작성자 : ${proList.NICKNAME }"/></p>
										</div>
										<div class="box-button">
											<c:if test="${proList.PRODUCT_STATUS_NO != 8 }">
												<button class="button-type-1" onclick="location.replace('${path}/article/blindArticle.do?productNo=${proList.PRODUCT_NO }&status=8')">블라인드</button>
											</c:if>
											<c:if test="${proList.PRODUCT_STATUS_NO == 8 }">
												<button class="button-type-1" onclick="location.replace('${path}/article/blindArticle.do?productNo=${proList.PRODUCT_NO }&status=1')">블라인드 해제</button>
											</c:if>
											<c:if test="${proList.PRODUCT_STATUS_NO != 9 }">
											<button class="button-type-1" onclick="location.replace('${path}/admin/deleteArticle.do?productNo=${proList.PRODUCT_NO }&status=9')">삭제</button>
											</c:if>
											<c:if test="${proList.PRODUCT_STATUS_NO == 9 }">
											<button class="button-type-1" disabled onclick="location.replace('${path}/admin/deleteArticle.do?productNo=${proList.PRODUCT_NO }&status=9')">삭제됨</button>
											</c:if>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>