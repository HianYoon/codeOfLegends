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
		<div class="search-result">
			<div class="area-top">
				<div class="wrap-inner">
					<div class="wrap-user-profile">
						<div class="box-img">
							<c:choose>
								<c:when test="${m.profileUrl != null }">
									<img src="${m.profileUrl }" alt="">
								</c:when>
								<c:otherwise>
									<img src="https://secure.gravatar.com/avatar/91524e06c4642938f6dff01039a4b2a3?s=96&r=g&d=https://drsuleymantas.com/wp-content/plugins/userswp/assets/images/no_profile.png" width="120">
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${businessKey == -1 }">
									<span class="labeling red">
										미등록
									</span>
								</c:when>
								<c:otherwise>
									<span class="labeling green">
										사업자
									</span>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="box-text">
							<dl class="list-user-profile">
								<div>
									<dt>회원번호</dt>
									<dd><c:out value="${m.memberKey }"/></dd>
								</div>
								<div>
									<dt>이름</dt>
									<dd><c:out value="${m.userName }"/></dd>
								</div>
								<div>
									<dt>닉네임</dt>
									<dd><c:out value="${m.nickname}"/></dd>
								</div>
							</dl>
						</div>
						<!-- <form action="">
							<div class="box-form">
								<div class="wrap-data">
									<select name="" id="">
										<option value="게시글 조회">게시글 조회</option>
										<option value="입찰내역 조회">입찰내역 조회</option>
										<option value="판매내역 조회">판매내역 조회</option>
										<option value="판매내역 조회">판매내역 조회</option>
									</select>						
									<label for="banDays">
										<input type="number" id="banDays" class="input-short" placeholder="1" min="1" />
										<span class="text-label">일</span>
									</label>
								</div>
								<input type="submit" class="button-type-1"  value="제재">
							</div>
						</form> -->
					</div>
				</div>
			</div>
			<div class="wrap-result">
				<div class="wrap-inner">
					<div class="area-tab">
						<ul class="list-tab">
							<li class="active">
								<button>게시글</button>
							</li>
							<li>
								<button>입찰내역</button>
							</li>
							<li>
								<button>판매내역</button>
							</li>
							<li>
								<button>구매내역</button>
							</li>
						</ul>
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
											<c:if test="${proList.PRODUCT_STATUS_NO==0 }">
												<p class="labeling gray">중지</p>
											</c:if>
											<p class="list-title">
												<a href="${path }/product/productDetail.do?articleNo=${proList.ARTICLE_NO}" ><c:out value="${proList.TITLE }"/></a>
											</p>
											<p class="date"><c:out value="${proList.WRITTEN_DATE }"/></p>	
										</div>
										<div class="box-button">
											<c:if test="${proList.PRODUCT_STATUS_NO != 8 }">
												<button class="button-type-1" onclick="location.replace('${path}/admin/blindArticle.do?productNo=${proList.PRODUCT_NO }&memberKey=${m.memberKey }&businessKey=${businessKey }&status=8')">블라인드</button>
											</c:if>
											<c:if test="${proList.PRODUCT_STATUS_NO == 8 }">
												<button class="button-type-1" onclick="location.replace('${path}/admin/blindArticle.do?productNo=${proList.PRODUCT_NO }&memberKey=${m.memberKey }&businessKey=${businessKey }&status=1')">블라인드 해제</button>
											</c:if>
											<button class="button-type-1" >삭제</button>
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