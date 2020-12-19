<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<link rel="stylesheet" href="${path}/resources/css/product/productDetail.css"/>
 <link rel="stylesheet" href="${path}/resources/css/sharedStyle.css"/>
 <link rel="stylesheet"
	href="${path}/resources/css/jihunTab/TabMedia.css" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
 
   
<section id="content">
	 <div class="productDetailPage">
        <div class="product-text-group">
        <c:forEach items="${product }" var="p">
        	<div class="product-container">
       
	            <div class="product-small-group">
	                <ul>
	                    <li><img src="" alt="이미지1"></li>
	                </ul>
	
	            </div>
	            
	                
	            <div class="product-img">
	                <img src="${path}/resources/upload/product/${p.P_RENAMED_FILE_NAME}" alt="빅이미지">
	            </div>
	                
	            <div class="product-textgroup">
	                <form action="${path}/product/productOrder.do" method="post" >
	                    <h2>카테고리명<input type="hidden" id="pNo" name="pNo" value="${p.PRODUCT_NO}"></h2>
	                    <ul class="star">
	                        <li><span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>리뷰수:</li>
	                        <li><img src="${path}/resources/images/profile/jjim.png" style="width:20px;height:20px"alt="찜" id="jjim"></li>
	                        <li><img src="" alt="공유하기"></li>
	                    </ul>
	                    
	                    
	                    <div class="product-origin">
	                        <h3><c:out value="${p.TITLE }"/></h3>
	                        <div class="product-price">
	                            <p><span class="productPrice">
	                            <fmt:formatNumber pattern="###,###,###" value="${p.PRICE}"></fmt:formatNumber></span>원</p>
	                            <p>포인트적립 0.5%</p>
	                        </div>
	                        <p><span class="text-left">원산지:</span> <span class="text-right"><c:out value="${p.ORIGIN}"/></span></p>
	                        <p><span class="text-left">배송비:</span> <span class="text-right">10만원이하 3000원</span></p>
	                        <p><span class="text-left">배송방법:</span> <span class="text-right">업체배송</span></p>
	                        <p>조건에 따라 추가비용이 발생할수있습니다.</p>
	                        
	                    </div>
	                   		<div class="select-container">
	                   		
		                   	<div>
		                        <select name="productNames"  class="productNames" id="product-select-List">
			                        <c:forEach var="pName" items="${product}" varStatus="status">
			                            <option value="">옵션</option>
			                            <option value="${pName.PRODUCT_NAME}"><c:out value="${pName.PRODUCT_NAME}"/></option>
			                            
			                        </c:forEach>
		                        </select>
		                   	</div>
		                   	<div>
		                        <select name="addProductname" class="addProductname" id="product-select-List">
			                         <c:forEach var="p1" items="${product}" varStatus="status">
			                            <option value="옵션">옵션</option>
			                            <option value="${p1.PRODUCT_NAME}"><c:out value="${p1.PRODUCT_NAME}"/></option>
			                            
			                        </c:forEach>
		                        </select>
		                   	</div>
	                        </div>
	                    
	                    <div class="order-product">
		                   	 <div class="order-container">
		                        <h4><c:out value="${p.PRODUCT_NAME}"/></h4>
		                        <div class="product-price">
		                            <input type="button" class="minus" value="-"/>
		                            <input type="number" name="count" class="number" value="1" readonly>
		                            <input type="button" class="plus" value="+"/>
		                       </div>
		                      <div class="price-text">
		                            <p><span class="text-left">가격</span><input type="hidden" id="pprice1" value="${p.PRICE}" class="text-right" readonly/> <input id="pprice" name="price" value="" class="text-right" type="text" readonly/>원</p>
		                            
		                      </div>
		                    </div>   
	                  
	
	                    </div>
	                    <div class="button-order">
	                   
	                        <button type="button" id="cart" class="btn btn--primary1">장바구니</button>
	                        <button type="submit" id="" class="btn btn--primary1">구매하기</button>
	
	                    </div>
	
	                </form>
				</div>
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
            <img src="${path}/resources/upload/product/${p.P_RENAMED_FILE_NAME}" alt="상품이미지">
            <p>상품설명</p>
            <p><c:out value="${p.SALE_CONTENT }"/></p>
        </div>
         </c:forEach>
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
	<script>
		//좋아요
		
			var scart=$("#cart");
			var pNo=$("#pNo").val();
			cnosole.log(pNo);
			$("#cart").click(e=>{
				$.ajax({
					url:"s{path}/cart/cart.do",
					type:"POST",
					dataType:"json",
					data:"pNo:"+pNo,
					success: function(data){
						var msg= '';
						var
					}
				});
			});
		
	</script>
 <script src="${path }/resources/js/productDetail/productDetail.js" defer></script>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
