<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <link rel="stylesheet" href="${path }/resources/css/community/forum.css"/>
 <script src="https://kit.fontawesome.com/0185489875.js" crossorigin="anonymous"></script>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section class="container">
        <div class="forum-logo">
            <img src="${path }/resources/images/profile/logo.png" alt="">
        </div>
        <div class="forum-title">
            <p>밥은 국밥이지 밥은 국밥인가 국밥은 밥이지 국밥은 밥인가 국밥은 밥이다 국밥 한끼 7천원</p>
        </div>
        <div class="forum-writer">
            <div class="forum-profile">
                <img src="gookbab.jpg" alt="" width="100px">
            </div>
            <div class="forum-content">
                <div class="forum-content-name">
                    <h2>국밥원정대</h2>
                    <p>글 1개</p>
                    <h5>2020-12-16</h5>
                </div>
                <div class="forum-content-content">
                    <p>뜨근~하고 든든~한 국밥<br>
                        뜨근~하고 든든~한 국밥<br>
                        뜨근~하고 든든~한 국밥<br>
                        뜨근~하고 든든~한 국밥<br></p>
                </div>
                <div class="forum-content-button">
                    <input type="button" value="수정">
                    <input type="button" value="삭제">
                    <input type="button" value="추천">
                </div>
            </div>
        </div>
        <div class="forum-writer">
            <div class="forum-profile">
                <img src="frog.jpg" alt="" width="100px">
            </div>
            <div class="forum-content">
                <div class="forum-content-name">
                    <h2>개구리</h2>
                    <p>글 1개</p>
                    <h5>2020-12-16</h5>
                </div>
                <div class="forum-content-content">
                    <p>뜨근~하고 든든~한 국밥<br>
                        뜨근~하고 든든~한 국밥<br></p>
                </div>
                <div class="forum-content-button">
                    <input type="button" value="수정">
                    <input type="button" value="삭제">
                    <input type="button" value="추천">
                </div>
            </div>
        </div>
        <div class="forum-writer">
            <div class="forum-profile">
                <img src="toy.png" alt="" width="100px">
            </div>
            <div class="forum-content">
                <div class="forum-content-name">
                    <h2>외계인</h2>
                    <p>글 1개</p>
                    <h5>2020-12-16</h5>
                </div>
                <div class="forum-content-content">
                    <p>뜨근~하고 든든~한 국밥<br>
                        뜨근~하고 든든~한 국밥<br></p>
                </div>
                <div class="forum-content-button">
                    <input type="button" value="수정">
                    <input type="button" value="삭제">
                    <input type="button" value="삭제">
                </div>
            </div>
        </div>
        <div class="community-bottom-right">
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
                <tbody>
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
                </tbody>
            </table>
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
