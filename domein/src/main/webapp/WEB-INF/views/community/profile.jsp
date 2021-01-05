<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <link rel="stylesheet" href="${path }/resources/css/community/profile.css"/>
 
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
    <section class="container">
    	<form action="${path }" method="post"></form>
        <div class="top">
            <div class="top-logo">
            	<img src="${path }/resources/images/profile/forg.png" alt="">
            </div>
            <div class="top-nickname">
                <h4>개구리</h4>
                <p>
                </p>
            </div>
            <div class="top-button">
                <button>레벨</button>
                <button>포인트</button>
            </div>
        </div>
        <div class="bottom">
            <input type="button" class="btn" id="di" value="다이렉트 입찰"/>
            <input type="button" class="btn" id="bl" value="블라인드 입찰"/>
            <input type="button" class="btn" id="com" value="커뮤니티"/>
            <input type="button" class="btn" id="re" value="평가"/>
        </div>
    </section>
    <script>
    $("#di").click(e => {
    	location.href = "";
    })
    $("#bl").click(e => {
    	location.href = "";
    })
    $("#com").click(e => {
    	location.href = "${path}/community/communityList.do";
    })
    $("#re").click(e => {
    	location.href = "";
    })
    </script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
