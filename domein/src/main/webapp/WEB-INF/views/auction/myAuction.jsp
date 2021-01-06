<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet"
	href="${path}/resources/css/member/myPage/common/myPageHeader.css">
	<style>
	.myPageHeader {
	background-color: #ddd;
	display: flex;
	flex-direction: column;
	justify-content: space-around;
	align-items: baseline;
	width: 200px;
	height: 100%;
}

.myPageHeader>a {
	margin: 10px;
	font-size: 27px;
}

#context {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	align-content: center;
}


.section-content {
	width: calc(100% - 200px);
	display: flex;
	justify-content: center;
	flex-direction: column;
	align-content: center;
	padding-top: 30px;
	padding-bottom: 30px;
}
.myPageHeader a{
    text-decoration: none;
}
.myPageHeader a:hover{
	background: white;
	
}
@media screen and (max-width: 768px) {
	.myPageHeader {
		flex-direction: row;
		width: 100%;
		flex-wrap: wrap;
		height: 75px;
	}
	#context {
		flex-direction: column;
	}
	.section-content {
		width: 100%;
		height: calc(100% - 75px);
		padding-top: 30px;
		padding-bottom: 30px;
	}
	.myPageHeader>a {
	
		font-size: 1em;
		width: fit-content;
	}

}
	</style>
<script>
	<%
	if(session.getAttribute("signedInMember") == null){ %>
		location.href = path;
	<%
	}
	%>
</script>
<div class="myPageHeader">
	<a href="${path }/auction/auctionEnllo.do?memberKey=${signedInMember.memberKey}">옥션등록</a>
	<a href="${path }/auction/auctionJoin.do">옥션참여Joinlist</a>
	<a href="${path }/auction/auctionUpdate.do">옥션List/수정/삭제</a>
	<a href="${path }/product/intoEnllo.do?memberKey=${signedInMember.memberKey}">판매등록</a>
	<a href="${path }/product/intoproductList.do?memberKey=${signedInMember.memberKey}">my판매list</a>
	
	<c:if test="${signedInMember.levelNo == 99 }"> <a href="#">관리자</a></c:if>
</div>
