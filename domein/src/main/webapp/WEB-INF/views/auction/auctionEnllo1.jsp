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
                <li><a href="#tab2">Action등록</li>
         
            
            </ul>
        </div>
        <div class="tab-container-group">

       
            <!--탭 콘텐츠 영역 -->
            <div class="tab_container">
                
                    
         
		<!--모달 박스  -->	
		
	 <div class="modal-wrapper" style="display: none;">
        <div class="modal">
            <div class="modal-title"><c:out value="${signedInMember.nickname }"/>님,진심입니까?</div>
            <p>당신의 선택은~~~~두구두구둥</p>
            <div class="close-wrapper1">
                <button id="modalSend" class="btn btn-primary2">구매하기</button>
                <button id="modalClose" class="btn btn-primary2">취소</button>
            </div>
        </div>
    </div>		
		<!--모달 박스  -->			

            <!-- 입찰 등록 form -->
                <div id="tab2" class="tab_content">
                    <h2>Action 거래중 COMPANY LIST</h2>

                    <form action="" method="POST">
                        <div class="cart-container">
                
                                <div class="product-cart">
                                     <input type="radio" name="cart-Oction" value="">
                                    <img src="" alt="이미지">
                                    
                                    <div class="cartContent">

                                        <p>제목:</p>
                                        <P>회사명</P>
                                        <P>거래일</P>
                                        <P>ORDER품목수:</P>
                                        
                                        <p>가격:</p>
        
                                    </div>
                                 </div>

                                </div>
                         
                                <div class="cart-total-price">
                                    <p>총가격:&nbsp;&nbsp;&nbsp;2000원</p>

                                </div>
                                <div class="cart-btn-group">
                                    <button type="button" id="" class="btn btn-primary2">주문하기</button>
                                </div>
                            </div>
                           
                      </form>
               
       
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
