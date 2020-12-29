<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
     <c:set var="member" value="${signedInMember}"/> 
<link rel="stylesheet" href="${path}/resources/css/product/productDetail.css"/>
 <link rel="stylesheet" href="${path}/resources/css/sharedStyle.css"/>
 <link rel="stylesheet"
	href="${path}/resources/css/jihunTab/TabMedia.css" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>

<section id="content">
	<c:if test="${product.get(0).PRODUCT_STATUS_NO != 8}">
	 <div class="productDetailPage">
        <div class="product-text-group">
        <c:forEach items="${product }" var="p">
        	<div class="product-container">
       
	            <div class="product-img">
	                <img src="${path}/resources/upload/product/${p.P_RENAMED_FILE_NAME}" alt="빅이미지">
	            </div>
	                
	            <div class="product-textgroup">
	                <form name="form" action="${path}/cart/cart.do" method="post" >
	                    <h2>카테고리명<input type="hidden" id="pNo" name="productNo" value="${p.PRODUCT_NO}"></h2>
	                 <input type="hidden" id="mNo" name="memberKey" value="${member.memberKey}">
	                  
	                    <ul class="star">
	                        <li><span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>리뷰수:</li>
	                        <!--  <li><img src="${path}/resources/images/profile/jjim.png" style="width:20px;height:20px"alt="찜" id="jjim"></li>
	                        <li><img src="" alt="공유하기"></li> -->
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
		                        <select name="productNames"  class="productNames" id="product-select-List" >
			                        <c:forEach var="pName" items="${product}" varStatus="status">
			                            <option value="">선택하세요</option>
			                            <option value="${pName.PRODUCT_NAME}"><c:out value="${pName.PRODUCT_NAME}"/><c:out value="${pName.MEASURE_UNIT}"/></option>
			                            
			                        </c:forEach>
		                        </select>
		                   	</div>
		                   	<div>
		                        <select name="addProductname" class="addProductname" id="product-select-List" style="display:none;">
			                         <c:forEach var="p1" items="${product}" varStatus="status">
			                            <option value="옵션">선택하세요</option>
			                            <option value="${p1.PRODUCT_NAME}"><c:out value="${p1.PRODUCT_NAME}"/></option>
			                            
			                        </c:forEach>
		                        </select>
		                   	</div>
	                        </div>
	                    
	                    <div class="order-product">
		                   	 <div class="order-container">
		                        <h4 class="orderText"></h4>
		                        <div class="product-price">
		                            <input type="button" class="minus" value="-"/>
		                            <input type="number" id="amount" name="amount" class="number" value="1" readonly>
		                            <input type="button" class="plus" value="+"/>
		                       </div>
		                      <div class="price-text">
		                            <p><span class="text-left">가격</span><input type="hidden" id="pprice1" value="${p.PRICE}" class="text-right"readonly/> <input id="pprice" name="price" value="${p.PRICE}" class="text-right" type="text" readonly/>원</p>
		                            
		                      </div>
		                    </div>   
	                  
	
	                    </div>
	                    <div class="button-order">
	                   <c:if test="${signedInMember !=null }">
	                        <button type="button" id="cartBtn"  class="btn btn--primary1">장바구니</button>
	                
	                   </c:if>
	                  
	                    <c:if test="${signedInMember ==null }">
	                        <button type="button" id="nonCartBtn" class="btn btn--primary1">장바구니</button>
	              		</c:if>
	                      
	                  <c:if test="">
	                        <button type="submit" id="orderPay" class="btn btn--primary1">구매하기</button>
	                  
	                  </c:if>
							<button type="submit" id="orderPay" class="btn btn--primary1">구매하기</button>
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
                <li id="productLike">좋아요</li>
                
               		 <li class="ProductComment">댓글쓰기</li>
                
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
            <form action="" method="POST"  enctype="multipart/form-data" >
                <div class="review-container" style="display:none">
                         <!-- //점 이미지 -->
                    <div class="top-comment"><span><input type="text" id="userNickName" name="userNickName" value="${member.nickname}"/>닉네임</span>
	                    <span class="hamburger" style="padding: 15px;">
	                    	<div id="Declaration" href="${path}/resources/images/profile/12.jpg">♡
	                    	</div>											
	                    	<div class="singo" style="display:none;">
	                    	
	                    	</div>
	                    </span>
	                    <input type="hidden" name="writerKey" value="${member.memberKey }"/>
	                    <input type="hidden" name="reviewStatus" value="${ARTICLE_NO }"/>
	                    <input type="hidden" name="articleStatus" value="${articlestatus.article_status_no }"/>
	                    
                    </div>
                    <textarea name="" id="reviewComment" cols="30" rows="10" placeholder="문의사항을 남겨보세요!"></textarea>
                    <div class="comment-group">
                        <div >
                            <span><img src="" alt="" class="comment-img"></span>
                            <span><input type="file" name="reviewFile" id="reFile"/></span>
                        </div>
                        <div>
                           <button type="submit" id="PcommentGo" class="btn btn-primary">등록</button>
                        </div>
                    </div>
                </div>

             </form>
        </div>
	</div>
								<div class="singoForm" style="display:none;">
	                    			<form id="modal" action="${path }" method="post"  enctype="multipart/form-data">
	                    			<div class="modal-title">
	                    			
	                    				<input type="hidden" name="writerKey" value="${member.memberKey }" readonly/>
	                    				<input type="text" name="nickName" value="${member.nickname }" readonly/>
	                    				<input type="text" name="reviewContent" value="${bds_review.REVIEW_CONTENT }" readonly/>
	                    			</div>
	                    			<div class="modal-title">
	                    			<div>
	                    				<input type="radio" name="reportTarget" value="1" /><span>부적절한홍보게시글</span>
	                    			</div>
	                    			<div>
	                    				<input type="radio" name="reportTarget" value="2" /><span>음란성또는 청소년에게부적한내용</span>
	                    			</div>
	                    			<div>
	                    				<input type="radio" name="reportTarget" value="3" /><span>명예훼손/사생활침해및저작권침해등</span>
	                    			</div>
	                    			<div>
	                    				<input type="radio" name="reportTarget" value="4" /><span>기타</span>
	                    			</div>
	                    			
	                    			</div>
	                    				
	                    				<div class="close-wrapper">
	                    					<button type="submit" class="btn btn-primary2">신고하기</button>
	                    					<button type="reset" id="modalClose" class="btn btn-primary2">취소</button>
	                    				</div>
	                    			</form>
	                    		</div>
		<script>
	
		</script>

  <script type="text/javascript">
	 const pNo=$("#pNo");
	 const mNo=$("#mNo");
	 const amo=$("#amount");
	//멤버가존재하면
	 $(function (){
		 $("#cartBtn").click(function(){
			const productNo= pNo.val();
			const memberKey= mNo.val();
			const amount= amo.val();
			$.ajax({
				url:"${path}/cart/cart.do",
				type:"POST",
				data:{
					"productNo":productNo,
					"memberKey":memberKey,
					"amount":amount
				},
				dataType:"html",
				success:function(data){
					alert("장바구니에 담겼습니다.");
				}
			});
		 });
		 //멤버가 없을때 
		 $("#nonCartBtn").click(function(){
			 const productNo= pNo.val();
			 console.log(productNo);
				const amount= amo.val();
			$.ajax({
				url:"${path}/cart/cart.do",
				type:"POST",
				data:{
					"productNo":productNo,
					"amount":amount
				},
				dataType:"html",
				success:function(data){
					alert("장바구니에 담겼습니다.");
				}
			});
		 });

	 });
	 const likeNumber=0;
	 const likeNo=0;
	$(".productLike").click(function(){
		likeNo= likeNumber+1;
	 		console.log(likeNo);
	})
	
 </script>
 
 <script src="${path }/resources/js/productDetail/productDetail.js" defer></script>
 
 </c:if>
 <c:if test="${product.get(0).PRODUCT_STATUS_NO == 8}">
 	해당 글은 블라인드 처리 되었습니다.
 	<button onclick="window.history.back()">뒤로가기</button>
 	
 </c:if>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
