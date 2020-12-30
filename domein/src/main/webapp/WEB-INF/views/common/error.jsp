<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" "/>
</jsp:include>
<section id="context">
 <h1>버그다 버그!</h1>
 <br>
 <h5>${msg }</h5>
 <br>
 <c:if test="${loc !=null }">
 <button class="btn btn--primary" onclick="location.href='${path}${loc}';">${locDesc} </button>
 </c:if>
 <c:if test="${loc ==null }">
 <button class="btn btn--primary" onclick="location.href='${path}';">${locDesc}</button>
 </c:if>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>