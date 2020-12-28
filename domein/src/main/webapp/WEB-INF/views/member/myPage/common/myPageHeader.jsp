<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet"
	href="${path}/resources/css/member/myPage/common/myPageHeader.css">

<div class="myPageHeader">
	<a href="#">입찰/구매내역</a> <a href="${path }/member/myPage/account.do">계정</a>
	<a href="#">고객센터</a> <a href="#">광고 신청</a>
</div>
