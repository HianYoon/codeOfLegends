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
<script src="https://apis.google.com/js/platform.js" async defer></script>
<%-- <link rel="stylesheet"
	href="${path }/resources/css/common/headerStyle.css" /> --%>
<link rel="stylesheet" href="${path }/resources/css/sharedStyle.css" />
<link rel="stylesheet" href="${path }/resources/css/common/headerStyle1.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link rel="apple-touch-icon" sizes="57x57" href="${path }/resources/favicon/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="${path }/resources/favicon/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72" href="${path }/resources/favicon/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76" href="${path }/resources/favicon/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114" href="${path }/resources/favicon/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120" href="${path }/resources/favicon/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144" href="${path }/resources/favicon/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152" href="${path }/resources/favicon/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180" href="${path }/resources/favicon/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"  href="${path }/resources/favicon/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32" href="${path }/resources/favicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="${path }/resources/favicon/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="${path }/resources/favicon/favicon-16x16.png">
<link rel="manifest" href="${path }/resources/favicon/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="${path }/resources/favicon/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
<meta name="google-signin-client_id"
	content="1048798785374-akhqjnf6p4g1fdo3mkf2pudg9ffh5ger.apps.googleusercontent.com">
<title>도매인 - 도소매 거래를 하는 사람들</title>
<script>
	const path = "${path}";
</script>
</head>
<body>
	<header>
		<div class="header-top pc-only">
			<div class="inner">
				<div class="logo">
					<a href="${path }"><img src="${path }/resources/images/logo/signature.png" alt="도매인"></a>
					<p class="sub-title-logo">도소매 거래를 하는 사람들</p>
				</div>
				<div class="box-search">
					<input type="text" placeholder="찾으시는 품목이 있으신가요?">
					<button><img src="${path }/resources/images/common/header/icon-search.png" alt="검색"></button>
				</div>
				<div class="box-button">
					<c:if test="${signedInMember == null }">
						<button class="btn-mypage" onclick="location.href='${path }/member/memberLogin.do'"><i class="icon-mypage"></i>로그인</button>
						<button class="btn-mypage" onclick="location.href='${path }/member/signUp/signUp.do'"><i class="icon-mypage"></i>회원가입</button>
					</c:if>
					<c:if test="${signedInMember != null }">
						<button class="btn-cart" onclick="location.href='${path }/cart/cart.do?memberKey=${signedInMember.memberKey}'"><i class="icon-cart"></i>CART</button>
						<button class="btn-mypage" onclick="location.href='${path }/member/myPage.do'"><i class="icon-mypage"></i>MY PAGE</button>
						<button class="btn-mypage" onclick="signOut(); location.replace('${path }/member/logout.do')"><i class="icon-mypage"></i>로그아웃</button>
					</c:if>
					<button class="btn-csCenter"><i class="icon-csCenter"></i>고객센터</button>
				</div>
			</div>
		</div>
		<div class="area-nav">
			<nav>
				<div class="inner">
					<ul class="list-depth-1">
						<li class="depth-1">
							<a href="${path}/auction/auctionList.do">도매 경매</a>
							<ul class="list-depth-2">
								<li><a href="#"><i class="icon-meat"></i>정육</a></li>
								<li><a href="#"><i class="icon-fish"></i>수산물</a></li>
								<li><a href="#"><i class="icon-vegetable"></i>과일·채소</a></li>
								<li><a href="#"><i class="icon-bread"></i>베이커리</a></li>
								<li><a href="#"><i class="icon-metal"></i>철강</a></li>
								<li><a href="#"><i class="icon-electronic"></i>전자기기</a></li>
								<li><a href="#"><i class="icon-pet"></i>애견</a></li>
								<li><a href="#"><i class="icon-etc"></i>ETC</a></li>
							</ul>
						</li>
						<li class="depth-1">
							<a href="${path }/product/productList.do">일반 구매</a>
							<ul class="list-depth-2">
								<li><a href="#"><i class="icon-meat"></i>정육</a></li>
								<li><a href="#"><i class="icon-fish"></i>수산물</a></li>
								<li><a href="#"><i class="icon-vegetable"></i>과일·채소</a></li>
								<li><a href="#"><i class="icon-bread"></i>베이커리</a></li>
								<li><a href="#"><i class="icon-metal"></i>철강</a></li>
								<li><a href="#"><i class="icon-electronic"></i>전자기기</a></li>
								<li><a href="#"><i class="icon-pet"></i>애견</a></li>
								<li><a href="#"><i class="icon-etc"></i>ETC</a></li>
							</ul>
						</li>
					</ul>
					<a href="${path }/community/communityList.do" class="link-forum"><i class="icon-forum"></i><span><small>도매인</small><br>지식포럼</span></a>
				</div>
			</nav>
			<button class="button-close">닫기</button>
		</div>
		<div class="mobile-title">
			<div class="mobile-logo-left">
				<input type="image" class="left"
					src="${path }/resources/images/profile/left.png" />
				<p></p>
			</div>
			<a href="${path }">
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
					<a href="${path }/community/communitylist.do">
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
					<c:if test="${signedInMember == null }">
						<a href="${path }/member/memberLogin.do">
							<div>
								<img src="${path }/resources/images/profile/user.png" alt="" />
							</div>
						</a>
					</c:if>
					<c:if
						test="${signedInMember != null and signedInMember.profileUrl == null}">
						<a href="${path }/member/myPage.do">
							<div>
								<img src="${path }/resources/images/profile/user.png" alt="" />
							</div>
						</a>
					</c:if>
					<c:if
						test="${signedInMember != null and signedInMember.profileUrl != null}">
						<a href="${path }/member/myPage.do">
							<div>
								<img src="${signedInMember.profileUrl }" alt=""
									class="circle-pic-frame" />
							</div>
						</a>
					</c:if>
				</div>
			</div>
		</div>
	</header>
	<div class="menu-floating">
		<ul>
			<li>
				<button class="btn-alarm">
					<img src="${path }/resources/images/common/header/icon-alarm.png" alt="알람">
				</button>
			</li>
			<li>
				<button class="btn-message">
					<img src="${path }/resources/images/common/header/icon-message.png" alt="메세지">
				</button>
			</li>
		</ul>
	</div>

	<div class="g-signin2 displayNone" data-onsuccess=""></div>
	<script src="${path }/resources/js/common/headerScript.js"></script>
<script src="${path }/resources/js/common/headerScript1.js"></script>
</body>