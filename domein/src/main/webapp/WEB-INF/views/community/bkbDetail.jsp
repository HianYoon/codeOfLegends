<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<link rel="stylesheet" href="${path }/resources/css/community/forum-dw.css"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section id="content" class="page-forum">
		<div class="container">
			<div class="wrap-inner">
			<c:forEach items="${list }" var="l" varStatus="status">
				<div class="article">
					<div class="wrap-title">
						<c:if test="${status.first }">
							<h2 class="page-title"><c:out value="${l.THREAD_TITLE }"/></h2>
						</c:if>
					</div>
					<div class="wrap-contents">
						<div class="box-img">
							<img src="./images/profile/profile.png" alt="">
						</div>
						<div class="box-text">
							<div class="box-text-top">
								<div class="wrap-left">
									<p class="nickname"><c:out value="${l.NICKNAME }"/></p>
									<p class="date"><c:out value="${l.WRITTEN_DATE }"/></p>
								</div>
								<div class="box-button">
									<button class="btn-type-1 edit">수정</button>
									<button class="btn-type-1 delete">삭제</button>
								</div>		
							</div>
							<div class="box-text-main">
								<p class="box-text-main-text">
									<c:out value="${l.ARTICLE_CONTENT }"/>
									<img src="./images/profile/toy.png" alt="">
								</p>
								<div class="box-button">
									<button class="btn-like">
										<span class="number-like">3</span>
										<img src="${path }/resources/images/profile/jjim.png" alt="">
									</button>
								</div>
							</div>
							<c:if test="${status.first }">
								<div class="box-text-bottom">
									<dl class="info-article">
										<div><dt>등록일</dt><dd>19일 전</dd></div>
										<div><dt>마지막 댓글</dt><dd>오늘</dd></div>
										<div><dt>댓글</dt><dd>4</dd></div>
										<div><dt>조회수</dt><dd>19</dd></div>
										<div><dt>좋아요</dt><dd>6</dd></div>
									</dl>				
								</div>
							</c:if>
						</div>
					</div>
				</div>
				</c:forEach>
				<%-- <div class="article">
					<div class="wrap-contents">
						<div class="box-img">
							<img src="./images/profile/jonsnow.png" alt="">
						</div>
						<div class="box-text">
							<div class="box-text-top">
								<div class="wrap-left">
									<p class="nickname">개구리</p>
									<p class="date">2021.01.02 <span class="time">10:11</span></p>
								</div>
								<div class="box-button">
									<button class="btn-type-1 edit">수정</button>
									<button class="btn-type-1 delete">삭제</button>
								</div>
							</div>
							<div class="box-text-main">
								<p class="box-text-main-text">
									뜨끈~하고 든든한 국밥~<br>
									뜨끈~하고 든든한 국밥~
								</p>
								<div class="box-button">
									<button class="btn-like">
										<span class="number-like">1</span>
										<img src="${path }/resources/images/profile/jjim.png" alt="">
									</button>
								</div>
							</div>
						</div>
					</div>
				</div> --%>
			</div>
		</div>
	</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>