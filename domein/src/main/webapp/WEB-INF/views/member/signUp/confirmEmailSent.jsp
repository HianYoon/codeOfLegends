<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" "/>
</jsp:include>

<link
			rel="stylesheet"
			href="${path}/resources\css\signUp\confirmEmailSent.css"
		/>
<section id="context">

      <div class="animate__animated animate__flip animate__infinite animate__slow img-cont">
        <img src="${path}/resources/images/signUp/free-icon-mail-1334869.png" alt="">
      
      </div>
      <br>
      <h2>인증 메일이 발송되었습니다</h2>
      <br>
      <h5>${newMember.userName } 회원님 ${newMember.email } 으로</h5>
      <h5>인증 메일이 발송되었습니다.</h5>
      <h5>24시간 이내에 이메일 인증을 완료하시면 계정 생성이 완료됩니다.</h5>
      <br>
      <div>
        <button class="btn btn--primary">로그인 페이지로</button>
      </div>
      <%session.removeAttribute("newMember"); %>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
