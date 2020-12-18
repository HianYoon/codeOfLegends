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
      <script>
                            window.addEventListener("load",function(){
                                var minus=document.querySelector(".minus");
                                var plus=document.querySelector(".plus");
                                var number=document.querySelector(".number");

                                minus.onclick=function(){
                                    const ss=parseInt(number.value);
                                    if(ss>0)
                                    number.value= ss-1;
                                    else(ss<0) 
                                    return;
                                    
                                }
                                plus.onclick=function(){
                                    const ss=parseInt(number.value);
                                    if(ss>=0)
                                    number.value=ss+1;
                                
                                   
                                }
                             var orderCount=document.querySelector(".order-product");//클릭햇을때 복사
                             var productSelect=document.querySelector("#product-select-List option:checked");//클릭대상
                             
                             var currentBox=orderCount.firstElementChild;
                             
                             productSelect.onclick=function(){
                            //자식노드를 함께 복사하기 위해 true를 입력
                                var tds=orderCount.cloneNode(true);
                                orderCount.append(tds);
                             };
                            });
                        </script>
<section id="content">
	 <div class="productDetailPage">
        <div class="product-text-group">
            <div class="product-small-group">
                <ul>
                    <li><img src="" alt="이미지1"></li>
                </ul>

            </div>
            
                
            <div class="product-img">
                <img src="${path}/resources/upload/product/${product.prenamedfilename}" alt="빅이미지">
            </div>
                
            <div class="product-textgroup">
                <form action="${path}/product/productOrder.do" method="post" >
                    <h2>카테고리명</h2>
                    <ul class="star">
                        <li><span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>조회수</span></li>
                        <li><img src="${path}/resources/images/profile/jjim.png" style="width:20px;height:20px"alt="찜" id="jjim"></li>
                        <li><img src="" alt="공유하기"></li>
                    </ul>
                    
                    
                    <div class="product-origin">
                        <h3>${product.TITLE }</h3>
                        <div class="product-price">
                            <p>${product.PRICE}</p>
                            <p>포인트적립 0.5%</p>
                        </div>
                        <p><span class="text-left">원산지:</span> <span class="text-right">${product.ORIGIN}</span></p>
                        <p><span class="text-left">배송비:</span> <span class="text-right">10만원이하 3000원</span></p>
                        <p><span class="text-left">배송방법:</span> <span class="text-right">업체배송</span></p>
                        <p>조건에 따라 추가비용이 발생할수있습니다.</p>
                        
                    </div>
                   		<div class="select-container">
                   		
	                   	<div>
	                        <select name="productNames" id="product-select-List">
		                        <c:forEach var="pName" items="${product.productName}" varStatus="status">
		                            <option value="">옵션</option>
		                            <option value="<c:out value="${pName}"/>"><c:out value="${pName}"/></option>
		                            
		                        </c:forEach>
	                        </select>
	                   	</div>
	                   	<div>
	                        <select name="addProductname" id="product-select-List">
		                         <c:forEach var="pName" items="${product.productName}" varStatus="status">
		                            <option value="옵션">옵션</option>
		                            <option value="<c:out value="${pName}"/>"><c:out value="${pName}"/></option>
		                            
		                        </c:forEach>
	                        </select>
	                   	</div>
                        </div>
                    
                    <div class="order-product">
	                   	 <div class="order-container">
	                        <h4><c:out value="${product.ProductName}"/></h4>
	                        <div class="product-price">
	                            <input type="button" class="minus" value="-"/>
	                            <input type="number" name="count" class="number" value="0" readonly>
	                            <input type="button" class="plus" value="+"/>
	                       </div>
	                      <div class="price-text">
	                            <p><span class="text-left">가격</span> <span class="text-right">${product.PRICE}</span></p>
	                            
	                      </div>
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
