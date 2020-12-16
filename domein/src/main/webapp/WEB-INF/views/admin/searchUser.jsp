<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section id="content">
<c:set var="path" value="${pageContext.request.contextPath }"/>

<%-- <jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include> --%>
<section id="content">

	
	<div class="container">
		<div class="topMenu">
			<ul>
				<li><a href="#">사용자 관리</a></li>
				<li><a href="#">게시글 제재</a></li>
			</ul>
		</div>
		<div class="sideMenu">
			<ul>
				<li><a href="#">사용자 관리</a></li>
				<li><a href="#">게시글 제재</a></li>
			</ul>
		</div>
		<div class="search-result">
			<div class="wrap-search">
				<form action="">
					<label for="userInfo">
						사용자 검색
						<input type="text" id="userInfo" name="keyword">
					</label>
					<input type="submit" value="검색">
				</form>
			</div>
			<div class="wrap-result">
				<div class="wrap-title">
					<h2>검색결과: 2명</h2>
				</div>
				<div class="wrap-contents">
					<ul class="list-result">
						<li>
							<div class="box-img">
								<img src="프사.png" alt="">
								<span class="text-red">비인증</span>
							</div>
							<div class="box-text">
								<dl>
									<div>
										<dt>회원번호</dt>
										<dd>신태일</dd>
									</div>
									<div>
										<dt>이름</dt>
										<dd>신태일</dd>
									</div>
								</dl>
							</div>
						</li>
						<li>
							<div class="box-img">
								<img src="프사.png" alt="">
								<span class="text-red">비인증</span>
							<div class="box-text">
								<dl>
									<div>
										<dt>회원번호</dt>
										<dd>신태일</dd>
									</div>
									<div>
										<dt>이름</dt>
										<dd>신태일</dd>
									</div>
								</dl>
							</div>
						</li>
						<li>
							<div class="box-img">
								<img src="프사.png" alt="">
								<span class="text-red">비인증</span>
							<div class="box-text">
								<dl>
									<div>
										<dt>회원번호</dt>
										<dd>신태일</dd>
									</div>
									<div>
										<dt>이름</dt>
										<dd>신태일</dd>
									</div>
								</dl>
							</div>
						</li>
						<li>
							<div class="box-img">
								<img src="프사.png" alt="">
								<span class="text-red">비인증</span>
							<div class="box-text">
								<dl>
									<div>
										<dt>회원번호</dt>
										<dd>신태일</dd>
									</div>
									<div>
										<dt>이름</dt>
										<dd>신태일</dd>
									</div>
								</dl>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

</section>
<style>

	.container ul,
	li,
	a {
		list-style: none;
		text-decoration: none;
		padding: 0px;
		color: black;
		margin: 0px;
	}
	.topMenu{
		display:none;
	}
	.sideMenu {
		justify-content: center;
		flex-direction: column;
		/* position: fixed; */
		width: 250px;
		text-align: center;
		background-color: #FFCA28;
		top: 0;
		left: 0
	}
	.sideMenu > ul > li {
		padding-top: 20px;
		padding-bottom: 20px;
		padding-bottom: 10px;
		font-size: 14px;
	}
	.sideMenu > ul > li a{
		display: block;
	}
	.container {
		/* margin-left: 250px; */
		display:flex;
		margin-top:-5px;
	}
	.container .search-result{
		flex:1;
	}
	.container .wrap-search {
		height: 40px;
		padding: 40px 0;
		margin-bottom: 50px;
		text-align: center;
		background-color: #f6f6f6;
	}
	.container .wrap-search form {		
		display: inline-block;
		position: relative;
	}
	.container .wrap-search label {
		font-size: 22px;
		font-weight: bold;
	}
	.container .wrap-search input[type=text] {
		width: 300px;
		height: 40px;
		padding: 10px;
		box-sizing: border-box;
		margin-left: 10px;
		font-size: 18px;
	}
	.container .wrap-search input[type=submit] {
		position: absolute;
		top: 0;
		right: 0;
		height: 40px;
		padding: 0 10px;
		background-color: transparent;
		border: none;
		appearance: none;
		cursor: pointer;
		transition: 0.3s;
	}
	.container .wrap-search input[type=submit]:hover {
		opacity: 0.5;
	}
	.wrap-result .wrap-title {
		text-align: center;
	}
	.wrap-result .wrap-title h2{
		font-size: 20px;
	}

	.wrap-result .wrap-contents {
		padding: 0 20px;
		margin-top: 30px;
	}
	.wrap-result .wrap-contents .list-result {
		max-width: 850px;
		margin: 0 auto;	
	}
	.wrap-result .wrap-contents .list-result li {
		display: flex;
	}
	.wrap-result .wrap-contents .list-result li + li {
		margin-top: 20px;
		padding-top: 20px;
		border-top: 1px solid #ccc;
	}
	.wrap-result .wrap-contents .list-result li .box-img{
		position: relative;
		width: 120px;
		height: 120px;
		background-color: salmon;
		text-align: center;
	}
	.wrap-result .wrap-contents .list-result li .box-img img{
		min-height: 100%;
	}
	.wrap-result .wrap-contents .list-result li .box-img .text-red{
		position: absolute;
		right: 0;
		bottom: 0;
		background-color: red;
		color: white;
		font-size: 9px;
	}
	.wrap-result .wrap-contents .list-result li .box-text {
		display: flex;
		align-items: center;
		flex: 1;
		padding: 0 30px;
		font-size: 14px;
	}
	.wrap-result .wrap-contents .list-result li .box-text dl {
		display: flex;
	}
	.wrap-result .wrap-contents .list-result li .box-text dl div {
		width: 150px;
	}
	.wrap-result .wrap-contents .list-result li .box-text dt:after{
		content: ': ';
	}
	.wrap-result .wrap-contents .list-result li dl div >* {
		display: inline;
	}

	@media screen and (max-width: 769px){
		.topMenu{
			display:block;
			background-color:#FFCA28;
			position:fixed;
			width:100%;
			height:30px;
		}
		.topMenu ul{
			display:flex;
			justify-content:center;
		}
		.topMenu ul li{
			padding-right:30px;
		}
		.toMenu ul:first-child{
			border: 1px solid gray;
		}
		.sideMenu{
			display:none;
		}
		.container {
		/* margin-left: 250px; */
		display:block;
		margin-top:-5px;
		}
		
	}

	@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dokdo&family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');

	* {
		margin: 0;
		padding: 0;
		font-family: 'Noto Sans KR', sans-serif;
	}

	a {
		text-decoration: none;
		color: black;
	}

	/* 폰트 클래스 */

	.sans {
		font-family: 'Noto Sans KR', sans-serif;
	}

	.dokdo {
		font-family: 'Dokdo', cursive;
	}

	.han {
		font-family: 'Black Han Sans', sans-serif;
	}

	/* 버튼 클래스 */
	.btn {
		height: 35px;
		background: #eee linear-gradient(to bottom, #fcfcfc, #eee);
		border: 1px solid #d5d5d5;
		border-radius: 4px;
		/* display:inline-flex로 하게되면 안에 글자에 맞게 좌우로 크기가 변경됨ㄴ */
		display: inline-flex;
		align-items: center;
		padding: 0 12px;
		font-size: 14px;
		font-weight: 1000;
		line-height: 1.5;
		/* 마우스가 올라갓을때 손가락모양으로 바뀌게 */
		cursor: pointer;
		/* 패딩이나 margin이 들어갓을때 커지는것을막아주는 css명령어 */
		box-sizing: border-box;
		position: relative;
	}

	.btn:hover::before {
		content: '';
		position: absolute;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background: rgba(0, 0, 0, 0.07);
	}

	.btn.btn--primary {
		border: 1px solid #ddd;
		color: black;
		background: #ffca28 linear-gradient(#ffca28, #fffd61);

	}

	.btn.btn--primary2 {
		border: 1px solid #ddd;
		color: black;
		background: #b0bec5 linear-gradient(#b0bec5, #e2f1f8);
	}


	/* input설정 */
	.input--text {
		height: 34px;
		padding: 0 10px;
		border: 1px solid #ddd;
		border-radius: 4px;
		box-sizing: border-box;
		/* a태그 포커스 없애는css outline */
		outline: none;
		/* input안에 쉐도우가 생기게하는 inset추가 */
		box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.075);
		font-size: 16px;

	}

	.input--text:focus {
		border-color: #51a7e8;
		box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.075),
			0 0 5px rgba(81, 167, 232, 0.5);
	}

	/* Vendor Prefix(브라우저 업체별 접두사) */
	.input--text::-webkit-input-placeholder {
		color: #cacaca;
	}

	.input--text::-ms-input-placeholder {
		color: #cacaca;
	}

	.input--text::-moz-input-placeholder {
		color: #cacaca;
	}
</style>
<%-- <jsp:include page="/WEB-INF/views/common/footer.jsp"/> --%>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>