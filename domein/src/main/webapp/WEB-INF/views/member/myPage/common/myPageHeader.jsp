<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet"
	href="${path}/resources/css/member/myPage/common/myPageHeader.css?after">
<script>
	<%
	if(session.getAttribute("signedInMember") == null){ %>
		location.href = path;
	<%
	}
	%>
</script>
<div class="myPageHeader">
	<a href="#">입찰/구매내역</a> <a href="${path }/member/myPage/account.do">계정</a>
	<a href="#">고객센터</a> <a href="${path }/ads/adsMainApply.do">광고 신청</a>
	<a href="${path }/auction/auction.do">옥션</a>
	<c:if test="${signedInMember.levelNo == 99 }"> <a href="${path }/admin/admin_ads/adminAdsMain.do">관리자</a></c:if>
</div>
