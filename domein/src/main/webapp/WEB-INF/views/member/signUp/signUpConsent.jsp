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

</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
		<link
			rel="stylesheet"
			href="../../../../../../src\main\webapp\resources\css\sharedStyle.css"
		/>
		<link
			rel="stylesheet"
			href="../../../../../../src\main\webapp\resources\css\signUp\signUpConsent.css"
		/>
		<title>Document</title>
	</head>
	<body>
		<section>
			<div class="consent-container">
				<h3 class="consent-title">ê°ì¸ì ë³´ ìì§ ì´ì© ì ê³µ ëì</h3>
				<div class="consent-wrapper">
					<div class="consent-content">
	<pre>sdfasdf
	sdfsdf
	asdf
	asdf
	adsfadfdf
	asfasfsfsfsfsfsfadfadfds
	asdfasdfd
	asfasdf
	asdfasdf
	asdf
	asdf
	asdf
	asdfa
	sdfas
	dfasd
	fasdf
	</pre>
					</div>
				</div>
      </div>
      <div class="button-container">
        <button id="agree-btn" class="btn btn--primary">ëì</button>
        <button id="cancel-btn" class="btn btn--primary2">ì·¨ì</button>
      </div>
		</section>
	</body>
</html>
