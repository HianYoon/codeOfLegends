<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <link rel="stylesheet" href="${path }/resources/css/community/review.css"/>
 
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
    <section>
        <div class="profile">
            <div class="profile-logo">
                <img src="frog.jpg" alt="">
            </div>
            <div class="profile-name">
                <p>★ 3.5</p>
                <h4>개구리</h4>
                <input type="text" placeholder="내용">
            </div>
        </div>
        <div class="profile">
            <div class="profile-logo">
                <img src="toy.png" alt="">
            </div>
            <div class="profile-name">
                <form>
                    <p>★ 5.0</p>
                    <h4>외계인</h4>
                    <input type="text" placeholder="내용">
                </form>
            </div>
        </div>
        <div class="profile">
            <div class="profile-logo">
                <img src="jonsnow.png" alt="">
            </div>
            <div class="profile-name">
                <p>★ 4.8</p>
                <h4>존스노우</h4>
                <input type="text" placeholder="내용">
            </div>
        </div>
        <div class="profile">
            <div class="profile-logo">
                <img src="3.png" alt="">
            </div>
            <div class="profile-name">
                <p>★ 4.5</p>
                <h4>사람</h4>
                <input type="text" placeholder="내용">
            </div>
        </div>
        <div class="profile">
            <div class="profile-logo">
                <img src="4.png" alt="">
            </div>
            <div class="profile-name">
                <p>★ 4.2</p>
                <h4>사라암</h4>
                <input type="text" placeholder="내용">
            </div>
        </div>
    </section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
