<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="${path }/resources/css/sharedStyle.css" />
<link rel="stylesheet"
	href="${path }/resources/css/common/headerStyle.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<title><%=request.getParameter("title")%></title>
<script>
	const path = "${path}";
</script>
</head>
<body>
<body>
	<header class="container">
		<div class="group">
			<div id="mainNav">
				<div class="logo">
					<a href="#"> <img
						src="${path }/resources/images/logo/signature.png" alt="" />
					</a>
				</div>
				<div class="search-box">
					<input type="text" class="search-txt" placeholder="검색"> <a
						class="search-btn" href="#"> <i class="fas fa-search"></i>
					</a>
				</div>
				<ul>
					<li><a href="#"> <img class="top-buttons"
							src="${path }/resources/images/profile/notification.png" alt="" />
					</a></li>
					<li><a href="#"> <img class="top-buttons"
							src="${path }/resources/images/profile/comment.png" alt="" />
					</a></li>
					<li><a href="#"> <img class="top-buttons"
							src="${path }/resources/images/profile/add-to-basket.png"
							alt="장바구니" />
					</a></li>
					<li><a href="${path }/member/memberLogin.do">로그인</a></li>
					<li><a href="${path }/member/signUp/signUp.do">회원가입</a></li>
				</ul>
			</div>
			<div class="mainNav-bottom">
				<ul class="mainNav-bottom-inner">
					<li><a href="#">
							<div>
								<div>
									<img src="${path }/resources/images/profile/blind.png" alt="" />
								</div>
								<p>블라인드 입찰</p>
							</div>
					</a></li>
					<li><a href="${path }/product/productList.do">
							<div id="categoryTap">
								<div>
									<img src="${path }/resources/images/profile/blind.png" alt="" />
								</div>
								<p>카테고리</p>
							</div>
					</a></li>
					<li><a href="#">
							<div>
								<div>
									<img src="${path }/resources/images/profile/talk.png" alt="" />
								</div>
								<p>지식인</p>
							</div>
					</a></li>
					<li><a href="#">
							<div>
								<div>
									<img src="${path }/resources/images/profile/review.png" alt="" />
								</div>
								<p>불만 마법사</p>
							</div>

					</a></li>
					<li><a href="#">
							<div>
								<div>
									<img src="${path }/resources/images/profile/home.png" alt="" />
								</div>
								<p>마이 페이지</p>
							</div>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="mobile-title">
			<a href="#">
				<div class="mobile-logo-cont">
					<img src="${path }/resources/images/logo/signature.png" alt="" />

				</div>
			</a>
		</div>
		<div class="mobile">
			<div class="mobile-in">
				<div>
					<a href="#">
						<div>
							<img src="${path }/resources/images/profile/search.png" alt="" />
						</div>
					</a>
				</div>
				<div>
					<a href="#">
						<div>
							<img src="${path }/resources/images/profile/blind.png" alt="" />
						</div>
					</a>
				</div>
				<div>
					<a href="#">
						<div>
							<img src="${path }/resources/images/profile/talk.png" alt="" />
						</div>
					</a>
				</div>
				<div>
					<a href="#">
						<div>
							<img src="${path }/resources/images/profile/review.png" alt="" />
						</div>
					</a>
				</div>
				<div>
					<a href="${path }/member/signUp/memberLogin.do">
						<div>
							<img src="${path }/resources/images/profile/user.png" alt="" />
						</div>
					</a>
				</div>
			</div>
		</div>
		
		   <div class="categorytap">
		        <ul class="one2"style="" >
		            <li><a href="${path}/product/productDetail.do"><img src="${path }/resources/images/signUp/beef.png" alt=""/>test중 product</a></li>
		            <li><a href="#"><img src="${path }/resources/images/signUp/fish.png" alt="" />수산</a></li>
		            <li><a href="#"><img src="${path }/resources/images/signUp/vegetables.png" alt="" />야채</a></li>
		            <li><a href="#"><img src="${path }/resources/images/signUp/beam.png" alt="" />철강</a></li>
		            <li><a href="#"><img src="${path }/resources/images/signUp/bone.png" alt="" />애견</a></li>
		            <li><a href="#"><img src="${path }/resources/images/signUp/bread.png" alt="" />베이커리</a></li>
		            <li><a href="#"><img src="${path }/resources/images/signUp/free-icon-lightning-616494.png" alt=""/>전자기기</a></li>
		            <li><a href="#"><img src="${path }/resources/images/signUp/free-icon-question-mark-in-dark-circle-71768.png" alt=""/>기타</a></li>
		        </ul>

    		</div>
    	<script>
    	let width = $(window).width();
    	if (width<=768) $(".one2").hide();
    			$('#categoryTap').mouseenter(function(){
    				let width = $(window).width();
    				if(width>768) $(".one2").show();
    			});
    			$(".one2").mouseleave(function(){
    				if(width>768) $(".one2").hide();
    			});
    		
    	</script>
	</header>



	<script src="${path }/resources/js/common/headerScript.js"></script>
</body>
</html>