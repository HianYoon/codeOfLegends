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
<html lang='en'>
  <head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <script src='http://code.jquery.com/jquery-3.5.1.min.js'></script>
      <title>Document</title>
      <link
			rel="stylesheet"
			href="../../../../../../src\main\webapp\resources\css\sharedStyle.css"
		/>
		<link
			rel="stylesheet"
			href="../../../../../../src\main\webapp\resources\css\signUp\confirmEmailSent.css"
		/>
		<link
			rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
		/>
  </head>
  <body>
    <section>

      <div class="animate__animated animate__flip animate__infinite animate__slow img-cont">
        <img src="../../../resources/images/signUp/free-icon-mail-1334869.png" alt="">
      
      </div>
      <br>
      <h2>ì¸ì¦ ë©ì¼ì´ ë°ì¡ëììµëë¤</h2>
      <br>
      <h5>ì´ë¦ íìë __________@ .comì¼ë¡</h5>
      <h5>ì¸ì¦ ë©ì¼ì´ ë°ì¡ëììµëë¤.</h5>
      <h5>ì´ë©ì¼ ì¸ì¦ì ìë£íìë©´ ê³ì  ìì±ì´ ìë£ë©ëë¤.</h5>
      <br>
      <div>
        <button class="btn btn--primary">ë©ì¸ íë©´ì¼ë¡</button>
      </div>
    </section>
  </body>
</html>