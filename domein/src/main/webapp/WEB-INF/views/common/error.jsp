<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" href="${path }/resources/css/common/error.css"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" "/>
</jsp:include>
<section id="context">
        <div class="logo">
        <img src="${path }/resources/images/common/sorry.jpg" width=800px height=700px alt="">
        </div>

        <div class="logo-mal">
            <h2>404</h2>
            <h4>죄송합니다. <br>
                현재 찾을 수 없는 페이지를 요청 하셨습니다.</h4>
            <p>존재하지 않는 주소를 입력하셨거나,<br>
            요청하신 페이지의 주소가 변경, 삭제되어 찾을 수 없습니다.<br>
            감사합니다.</p>
<!--              <input type="button" class="btn2" value="메인페이지">
            <input type="button" class="btn3" onclick="goBack()" value="이전페이지"> -->

 <h5>${msg }</h5>
 <br>
 <c:if test="${loc !=null }">
 <button class="btn2" onclick="location.href='${path}${loc}';">${locDesc}메인페이지 </button>
 </c:if>
 <c:if test="${loc ==null }">
 <button class="btn2" onclick="location.href='${path}';">${locDesc}메인페이지</button>
 </c:if>
 <input type="button" class="btn3" onclick="goBack()" value="이전페이지">
         </div>
</section>
<script src="${path }/resources/js/common/error.js"></script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>