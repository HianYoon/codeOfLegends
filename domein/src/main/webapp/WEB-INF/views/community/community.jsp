<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <link rel="stylesheet" href="${path }/resources/css/community/community.css"/>
 <script src="https://kit.fontawesome.com/0185489875.js" crossorigin="anonymous"></script>
 
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section class="container">
        <div class="community-logo">
            <img src="${path }/resources/images/profile/logo.png" alt="">
        </div>
        <div class="community-title">
            <p>지식배틀</p>
        </div>
        <div class="community-bottom">
            <div class="community-bottom-left">
                <a href="">질문</a><br><br>
                <a href="">노하우</a>
            </div>
            <div class="community-bottom-right">
            	<form action="${path }/board/community.do" method="post">
	                <table class="board_list">
	                    <thead>
	                        <tr>
	                            <th>제목</th>
	                            <th>글쓴이</th>
	                            <th>추천수</th>
	                            <th>조회수</th>
	                            <th>날짜</th>
	                        </tr>
	                    </thead>
	                    <c:forEach items="${list }" var="b">
	                    	<tr>
	                    		<td class="tit">
	                    			<a href="#">
	                    				<c:out value="${b.BOARDTITLE }"/>
	                    			</a>
	                    		</td>
	                    		<td class="tit">
	                    			<a href="#">
	                    				<c:out value="${b.BOARDWRITER }"/>
	                    			</a>
	                    		</td>
	                    		<td class="tit">
	                    				<c:out value="${b.BOARDCOUNT }"/>
	                    		</td>
	                    		<td class="tit">
	                    				<c:out value="${b.BOARDREADCOUNT }"/>
	                    		</td>
	                    		<td class="tit">
	                    				<c:out value="${b.BOARDREADCOUNT }"/>
	                    		</td>
	                    		<td class="tit">
	                    				<c:out value="${b.BOARDWRITTENDATE }"/>
	                    		</td>
	                    	</tr>
	                    </c:forEach>
<!-- 	                    <tbody>
	                        <tr>
	                            <td class="tit">
	                                <a href='#'>밥은 국밥이지 밥은 국밥인가</a>
	                            </td>
	                            <td>국밥원정대</td>
	                            <td>1</td>
	                            <td>1</td>
	                            <td>11-18</td>
	                        </tr>
	                        <tr>
	                            <td class="tit">
	                                <a href='#'>국밥 7천원 8천원</a>
	                            </td>
	                            <td>외계인</td>
	                            <td>2</td>
	                            <td>3</td>
	                            <td>11-19</td>
	                        </tr>
	                        <tr>
	                            <td class="tit">
	                                <a href='#'>소고기 판매해요</a></td>
	                            <td>존스노우</td>
	                            <td>2</td>
	                            <td>3</td>
	                            <td>12-09</td>
	                        </tr>
	                        <tr>
	                            <td class="tit">
	                                <a href='#'>애완용품 판매합니다</a>
	                            </td>
	                            <td>사람</td>
	                            <td>2</td>
	                            <td>3</td>
	                            <td>12-09</td>
	                        </tr>
	                        <tr>
	                            <td class="tit">
	                                <a href='#'>국밥은 8500원 이상 먹지 마세요</a>
	                            </td>
	                            <td>국밥충</td>
	                            <td>5</td>
	                            <td>5</td>
	                            <td>12-10</td>
	                        </tr>
	                        <tr>
	                            <td class="tit">
	                                <a href='#'>국밥국밥국밥국밥국밥국밥</a>
	                            </td>
	                            <td>국밥부장관</td>
	                            <td>5</td>
	                            <td>5</td>
	                            <td>12-10</td>
	                        </tr>
	                        <tr>
	                            <td class="tit">
	                                <a href='#'>아직도 너의 국밥을 못잊어</a>
	                            </td>
	                            <td>gookbab</td>
	                            <td>5</td>
	                            <td>5</td>
	                            <td>12-10</td>
	                        </tr>
	                    </tbody> -->
	                </table>
                </form>
            </div>
        </div>
        <div class="paging">
            <a href='#'>
                <i class="fas fa-chevron-circle-left"></i>
            </a>
            <a href='#'>1</a>
            <a href='#'>2</a>
            <a href='#'>3</a>
            <a href='#'>4</a>
            <a href='#'>5</a>
            <a href='#'>6</a>
            <a href='#'>7</a>
            <a href='#'>
                <i class="fas fa-chevron-circle-right"></i>
            </a>
        </div>
    </section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
