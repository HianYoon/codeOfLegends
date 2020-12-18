<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="${path }/resources/css/product/product.css"/>
 <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
 <link rel="stylesheet" href="${path }/resources/css/sharedStyle.css"/>
 
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section id="content">
	 <div class="productDetailPage">
        <div class="product-text-group">
            <div class="product-small-group">
                <ul>
                    <li><img src="" alt="이미지1"></li>
                    <li><img src="" alt="이미지2"></li>
                    <li><img src="" alt="이미지3"></li>
                    <li><img src="" alt="이미지4"></li>
                    <li><img src="" alt="이미지5"></li>
                </ul>

            </div>
            
                
            <div class="product-img">
                <img src="" alt="빅이미지">
            </div>

            <!-- 700px슬라이드용 이미지 -->
            <!--  -->
            <div class="slideshow-container" style="display: none;">

                <div class="mySlides fade">
                  <div class="numbertext">1 / 5</div>
                  <img src="" style="width:100%">
                  <div class="text">Caption Text</div>
                </div>
                
                <div class="mySlides fade">
                  <div class="numbertext">2 / 5</div>
                  <img src="" style="width:100%">
                  <div class="text">Caption Two</div>
                </div>
                
                <div class="mySlides fade">
                  <div class="numbertext">3 / 5</div>
                  <img src="" style="width:100%">
                  <div class="text">Caption Three</div>
                </div>
                
                <div class="mySlides fade">
                  <div class="numbertext">4 / 5</div>
                  <img src="" style="width:100%">
                  <div class="text">Caption Three</div>
                </div>
                
                <div class="mySlides fade">
                  <div class="numbertext">5 / 5</div>
                  <img src="" style="width:100%">
                  <div class="text">Caption Three</div>
                </div>
                
                </div>
                <br>
                <div style="text-align:center">
                    <span class="dot"></span> 
                    <span class="dot"></span> 
                    <span class="dot"></span> 
                    <span class="dot"></span> 
                    <span class="dot"></span> 
                </div>
                <!-- 700px슬라이드용 이미지 -->

                
            <div class="product-textgroup">
                <form action="" method="post" >
                    <h2>카테고리명</h2>
                    <ul>
                        <li><span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>조회수</span></li>
                        <li><img src="" alt="찜"></li>
                        <li><img src="" alt="공유하기"></li>
                    </ul>
                    
                    <div class="product-origin">
                        <h3>상품명</h3>
                        <div class="product-price">
                            <p>원가격</p>
                            <p>할인가격</p>
                        </div>
                        <p><span class="text-left">원산지</span> <span class="text-right">국내산</span></p>
                        <p><span class="text-left">배송비:</span> <span class="text-right">3000원</span></p>
                        <p><span class="text-left">배송방법:</span> <span class="text-right">업체배송</span></p>
                        <p>조건에 따라 추가비용이 발생할수있습니다.</p>
                        
                    </div>
                   
                        <select name="" id="product-select-List">
                            <option value="1">1</option>
                        </select>
                    
                    <div class="order-container">
                        <h4>상품명</h4>
                        <div class="product-price">
                            <input type="button" class="minus" value="-"/>
                            <input type="number" value="0" readonly>
                            <input type="button" class="plus" value="+"/>
                        </div>
                        <div class="price-text">
                            <p><span class="text-left">가격</span> <span class="text-right">3000원</span></p>
                            
                        </div>
                        
                        

                    </div>

                </form>

            </div>
        </div>
        <hr/>
        <div class="link-text-container">
            <ul>
                <li><a href="#product-Explanation">상품설명</a></li>
                <li><a href="#reviews">리뷰</a></li>
                <li><a href="#">문의</a></li>
                <li><a href="#">좋아요<img src="" alt="따봉"></a></li>
            </ul>
        </div>
        <hr/>
        <div id="product-Explanation">
            <img src="" alt="상품이미지">
            <p>상품설명</p>
            <p>좋아요!! 무조건사요</p>
        </div>
        <div id="reviews">
            <form action="" method="POST" >
                <div class="review-container">
                         <!-- //점 이미지 -->
                    <div class="top-comment"><span>닉네임/아이디</span><span><img src="" alt=""></span></div>
                    <textarea name="" id="reviewComment" cols="30" rows="10" placeholder="문의사항을 남겨보세요!"></textarea>
                    <div class="comment-group">
                        <div >
                            <span><img src="" alt="" class="comment-img"></span>
                            <span><img src="" alt=""class="comment-img"></span>
                        </div>
                        <div>
                           <p>등록</p>
                        </div>
                    </div>
                </div>

             </form>
        </div>
    </div>

</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
