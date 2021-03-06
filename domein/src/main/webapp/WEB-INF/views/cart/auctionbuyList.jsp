<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
	<c:set var="signedInMember" value="${signedInMember}"/>
  <link rel="stylesheet"
	href="${path }/resources/css/cart/cart.css" />
  <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
    
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>

<section id="content">
 <div id="octionPage">

        <div id="wrapper">    
            <!--탭 메뉴 영역 -->
            <ul class="tabs">
                <li><a href="#tab3">구매품목</a></li>

                         <!-- 구매한 품목 -->
                        <div id="tab3" class="tab_content">
                            <!--Content-->
                            <div class="date-search-group">
                                <form action="" method="POST">
                                    <input type="date" class="input--text">
                                    <input type="date" class="input--text">
                                    <button type="submit" class="btn btn--primary2">검색</button>
    
                                </form>

                            </div>
                            <h2>회사명</h2> 
                            <h3>주문날짜:20.11.20</h3>

                           
                            <div class="oction-orderList">
                                
                                <div class="end-list" style="">
                                    <div class="end-list-group .content">
                                        <ul>
                                            <li>번호</li>
                                            <li>상품명</li>
                                            <li>원산지</li>
                                            <li>등급</li>
                                            <li>갯수</li>
                                            <li>단위</li>
                                            <li>가격</li>
                                        </ul>
                                        <ul >
                                            <li>1</li>
                                            <li>등심</li>
                                            <li>수입:말레이시안</li>
                                            <li>등급</li>
                                            <li>2</li>
                                            <li>채</li>
                                            <li>500000원</li>
                                        </ul>

                                    </div>
                                    <div class="total-cart">
                                        <p>총 갯수:</p>
                                        <p>총 가격:</p>

                                    </div>
                                </div>
                            </div>
                            
                        </div>
                        
    </div>
  </div>     
</section>

<script>
 
$(document).ready(function(){
    //로드될때
    $(".tab_content").hide();//모든탭을 숨겨~~
    $('ul.tabs li:first').addClass("active").show();//액티브된 처음탭보여줘
    $('.tab_content:first').show();//show first tab content

    //On Click Event
    $("ul.tabs li").click(function(){
        $('ul.tabs li').removeClass('active');//Remove any 'active' class
        $(this).addClass('active').attr('color','blue');//셀렉트된탭을 active해라
        $('.tab_content').hide();//Hide all tab content

        var activeTab=$(this).find('a').attr('href');
        $(activeTab).fadeIn();//Fade in the active ID content
        return false;
    });
});

</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
