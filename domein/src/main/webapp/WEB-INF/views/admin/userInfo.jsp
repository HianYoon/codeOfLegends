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
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<div class="container">
		<div class="search-result">
			<div class="area-top">
				<div class="wrap-inner">
					<div class="wrap-user-profile">
						<div class="box-img">
							<img src="/domein/resources/images/profile/profile.png" alt="">
							<span class="labeling red">
								비인증
							</span>
						</div>
						<div class="box-text">
							<dl class="list-user-profile">
								<div>
									<dt>회원번호</dt>
									<dd>8282</dd>
								</div>
								<div>
									<dt>이름</dt>
									<dd>김대욱</dd>
								</div>
							</dl>
						</div>
						<form action="">
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
						</form>
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
								<li class="item-user-activity">
									<div class="box-text">
										<p class="labeling blue">거래중</p>
										<p class="list-title">
											<a href="" >수입 삼겹살 유통 판매합니다.</a>
										</p>
										<p class="date">2020.11.15</p>	
									</div>
									<div class="box-button">
										<button class="button-type-1" >블라인드</button>
										<button class="button-type-1" >삭제</button>
									</div>
								</li>
								<li class="item-user-activity">
									<div class="box-text">
										<p class="labeling blue">거래중</p>
										<p class="list-title">
											<a href="" >수입 삼겹살 유통 판매합니다.수입 삼겹살 유통 판매합니다.</a>
										</p>
										<p class="date">2020.11.15</p>	
									</div>
									<div class="box-button">
										<button class="button-type-1" >블라인드</button>
										<button class="button-type-1" >삭제</button>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<style>

	
</style>
<%-- <jsp:include page="/WEB-INF/views/common/footer.jsp"/> --%>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>