<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="시스템 메시지"/>
</jsp:include>
<section id="context">
	<script>
		alert("${msg}");
		location.replace("${pageContext.request.contextPath}${loc}");
	</script>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>