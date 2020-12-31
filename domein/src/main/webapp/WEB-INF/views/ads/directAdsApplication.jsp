<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>

<script>
	<%
	if(session.getAttribute("signedInMember") == null){ %>
		location.href = path;
	<%
	}
	%>
</script>

<!-- css파일 소환 -->
<link rel="stylesheet" href="${path }/resources/css/ads/directAdsApplication.css" />

<section id="content">
    <div id="wholeback">
        <div class="tab_menu">
            <ul><h2>광고신청 페이지</h2>
                <li><a href="${path }/ads/slideBannerApplication.do"><h5>슬라이드 배너 신청</h5></a></li>
                <li><a href="${path }/ads/directAdsApplication.do"><h5>(판매)추천 게시글 신청</h5></a></li>
            </ul>
        </div>
        <div id="container">
            <form action="" method="post">
                <h2>도매인 추천 게시글 신청</h2>
                <hr>
                <div class="div_intro">
                    <ul><u>추천 게시글 광고란?</u>
                        <li>도매인 메인페이지 내 추천 게시글로 게재되는 광고로써, 게시글 조회를 유도하고자 하는 광고주들을 위한 유형</li>
                        <li>등록된 이미지 및 정보, 직접 등록한 텍스트/영상 소재를 이용하여 입찰홍보 및 판매 마케팅에 특화된 형태</li>
                    </ul>
                    <br>
                    <ul><u>광고 형식</u>
                        <li>일반적인 게시글 형태로 지원</li>
                    </ul>
                </div>

                <div class="div_myArticle">
                    <p><u>내가 쓴 게시글</u></p>
                    <!-- <c:if test=""> -->
                       <table class="table_myArticle">
                           <thead>
                               <tr>
                                   <th>게시판</th>
                                   <th class="colspan">제목</th>
                                   <th>날짜</th>
                               </tr>
                           </thead>                    
                           <tbody>                    
                           <%-- <c:forEach items="" var="">  --%>                       
                               <tr>
                                   <td><input type="radio" id="myArticle" name="myArticle" value="article_no">&nbsp;입찰게시판</td>
                                   <td>안녕하세요 울랄라에서 올라올라 오랑우탄 쌀람마리꿈</td>
                                   <td>2020.12.31</td>
                               </tr>
                           <%-- </c:forEach> --%>
                           </tbody>
                       </table>
                       <div class="div_pageBar">

                       </div>
                   <!-- </c:if> -->
               </div>

               <div class="div_preview">
                   <p><u>Preview(미리보기)</u></p>
                   <div class="div_ajax">

                   </div>
               </div>

               <div class="div_period">
                   <p><u>기간 및 가격</u></p>
                   개시일&nbsp;&nbsp;<input type="date" name="ads_start_date" min="" required>&nbsp;&nbsp;                        
                   종료일&nbsp;&nbsp;<input type="date" name="ads_end_date" min="" required><br>
                   <!-- 기타 선택 시, return false로 체크 -->
                    결제금액&nbsp;&nbsp;<input type="text" value="0" name="ads_price" readonly>&nbsp;원
                </div>
                <br><br>

                <div class="div_submit">
                    <input type="submit" value="결제화면으로 이동">&nbsp;
                    <input type="reset" value="취소">
                    <br><br><br><br>
                </div>

            </form>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>


