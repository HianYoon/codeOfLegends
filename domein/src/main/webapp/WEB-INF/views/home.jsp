<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section id="content">
<div>
	<ul>
		<li>a<a href="${path }/product/insert.do">product</a></li>
	</ul>
</div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<p>product<a href="${path }/product/insert.do"></a></p>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
