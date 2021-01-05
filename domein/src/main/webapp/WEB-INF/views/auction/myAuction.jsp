<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet"
	href="${path}/resources/css/member/myPage/common/myPageHeader.css">
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
