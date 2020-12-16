<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" " />
</jsp:include>
<link rel="stylesheet"
	href="${path }/resources\css\signUp\signUpConsent.css" />
<section id="context">
	<div class="consent-container">
		<h3 class="consent-title">개인정보동의</h3>
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
		<button id="agree-btn" class="btn btn--primary">동의</button>
		<button id="cancel-btn" class="btn btn--primary2">취소</button>
	</div>
</section>

<script>
	$("#agree-btn").click(e=>{
		location.href="${path}/member/register-form.do";
	})
	
	$("#cancel-btn").click(e=>{
		location.href="${path}/";
	})
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />