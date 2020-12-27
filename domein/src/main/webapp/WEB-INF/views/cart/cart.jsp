<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>

  <link rel="stylesheet"
	href="${path }/resources/css/cart/cart.css" />
  <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
    
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
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
<section id="content">
 <div id="octionPage">

        <div id="wrapper">    
            <!--탭 메뉴 영역 -->
            <ul class="tabs">
                <li><a href="#tab1">장바구니</a></li>
                <li><a href="#tab2">Action<br/>장바구니</a></li>
                <li><a href="#tab3">구매품목</a></li>
                <li><a href="#tab4">주문품목</a></li>
            
            </ul>
        </div>
        <div class="tab-container-group">

       
            <!--탭 콘텐츠 영역 -->
            <div class="tab_container">
                
                    
                    <div id="tab1" class="tab_content">
                        <!--Content-->
                        <h2>장바구니</h2>
                      <form action="${path }" method="POST">
                        
                        <div class="cart-container">
                            <hr/>
                         <c:forEach items="${list}" var="list">
                            <c:set value="${cart}" var="cart"/>
                                <div class="product-cart">
                                
                                    <input type="radio" name="cart" value="">
                                  

                                        <img src="${path }/resources/upload/product/${list.P_RENAMED_FILE_NAME}" alt="이미지">
                                        <div class="cartContent">

                                            <p>상품명:<c:out value="${list.TITLE }"/></p>
                                            
                                            <input type="button" id="minus" name="minus" value="-" maxlength=""/>
                                            <input type="text" id="amount" name="amount" value="${cart.amount}" maxlength="" readonly/>
                                            <input type="button" id="plus" name="plus" value="+" maxlength=""/>
                                              
                                            <p>가격:<c:out value="${list.PRICE }"/>원</p>
            
                                        </div>
                                 
                   
                                 </div>
						</c:forEach>
                                </div>
                                <hr/>
                                <div class="cart-total-price">
                                    <p>총가격:&nbsp;&nbsp;&nbsp;2000원</p>

                                </div>
                                <div class="cart-btn-group">
                                    <button type="button" id="" class="btn btn-primary2">전체선택</button>
                                    <button type="button" id=""  class="btn btn-primary2">삭제</button>
                                    <button type="button" id=""  class="btn btn-primary2">쇼핑계속하기</button>
                                    <button type="submit" id=""  class="btn btn-primary2">결제하기</button>
                                </div>
                            </div>
                        </form>
                        
                 </div>


            <!-- 입찰 등록 form -->
                <div id="tab2" class="tab_content">
                    <h2>Action 거래중 COMPANY LIST</h2>

                    <form action="" method="POST">
                        <div class="cart-container">
                            <hr/>
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
                                <hr/>
                                <div class="cart-total-price">
                                    <p>총가격:&nbsp;&nbsp;&nbsp;2000원</p>

                                </div>
                                <div class="cart-btn-group">
                                    <button type="button" id="" class="btn btn-primary2">주문하기</button>
                                </div>
                            </div>
                           
                      </form>
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
                        
                        
                        
                        <!-- cart(주문 확인) -->
                        <div id="tab4" class="tab_content">
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

                           <form action="" method="POST">

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
                                               <li>선택</li>
                                           </ul>
                                           <ul >
                                               <li>1</li>
                                               <li>등심</li>
                                               <li>수입:말레이시안</li>
                                               <li>등급</li>
                                               <li>2</li>
                                               <li>채</li>
                                               <li>500000원</li>
                                               <li><input type="checkbox" name="orderEndUpdate" class="cart-checkbox"></li>
                                           </ul>
   
                                       </div>
                                        <div class="total-cart">
                                            <p>총 갯수:</p>
                                            <p>총 가격:</p>

                                        </div>
                                   </div>
                                   <button type="submit" id="" class="btn btn-primary2">수정하기</button>
                               </div>
                           </form>
                            
                        </div>
                          
                </div>
                
                
    </div>
       
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
