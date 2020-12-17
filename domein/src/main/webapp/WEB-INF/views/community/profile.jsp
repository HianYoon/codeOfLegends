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
    <section>
        <div class="top">
            <div class="top-logo">
                <img src="frog.jpg" alt="">
            </div>
            <div class="top-nickname">
                <h4>개구리</h4>
                <p>개구리는 양서류 중에서 가장 진화된 형질을 가지고 있으며,
                    다른 목()에 비하여 다양한 생활형을 나타내며 지리적 분포도 넓다.
                    지구상에 현존하는 개구리는 두꺼비아목에 7과와 개구리아목에 4과가 있으며,
                    모두 2,000여종이 살고 있다.
                </p>
            </div>
            <div class="top-button">
                <button>레벨</button>
                <button>포인트</button>
            </div>
        </div>
        <div class="bottom">
            <input type="button" class="btn" value="다이렉트 입찰"/>
            <input type="button" class="btn" value="블라인드 입찰"/>
            <input type="button" class="btn" value="커뮤니티"/>
            <input type="button" class="btn" value="평가"/>
        </div>
    </section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
