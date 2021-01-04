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
	                 <input type="hidden" id="" name="" value=""/>
	                  
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
            <form action="${path}/product/reviews" method="POST"  enctype="multipart/form-data" >
                <div class="review-container" style="display:none">
                         <!-- //점 이미지 -->
                    <div class="top-comment"><span><input type="text" id="userNickName" name="userNickName" value="${member.nickname}"/></span>
	                    <span class="hamburger" style="padding: 15px;">
	                    	<div class="singo" style="display:none;">
	                    	
	                    	</div>
	                    </span>
	                    <input type="hidden" name="writerKey" value="${member.memberKey }"/>
	                    <input type="hidden" name="reviewStatusNo" value="1"/>
	                    <c:forEach items="${product }" var="productARTICLENO">
	                  	 <input type="hidden" name="refArticle" id="refArticle" value="${productARTICLENO.ARTICLE_NO}"/>
	                    </c:forEach>
	                    <input type="hidden" name="BDSreviewLevel" value="1"/>
	                    
                    </div>
                    <textarea name="reviewContent" id="reviewComment" cols="30" rows="10" placeholder="댓글을 남겨보세요!"><c:if test="${empty member.memberKey }">로그인이 필요합니다.!</c:if></textarea>
                    <div class="comment-group">
                        <div >
                            <span id="like">like</span>
                            <span><input type="file" name="file" id="reFile" required/></span>
                        </div>
                        <div>
                           <button type="submit" id="PcommentGo" class="btn btn-primary">등록</button>
                        </div>
                    </div>
                </div>

             </form>
        </div>
        	 <c:forEach items="${comment }" var="comment">
        		<c:set var="writer" value="${signedInMember}"/> 
        	 	<c:if test="${comment.REVIEW_LEVEL == 1 }">
        	 	<div class="re-comment">
        	 		<ul id="product-re-comment-box">
        	 			<li>
        	 			<input type="hidden" id="reviewNo" value="${comment.REVIEW_NO}"/>
        	 			<input type="hidden" id="actorKey" name="actorKey" value="${writer.memberKey}"/>
        	 			
        	 		
        	 				<span class="membernick"><c:out value="${writer.nickname}"/></span>
        	 			<c:if test="${comment.WRITER_KEY == writer.memberKey} ">
        	 				<span class="re-comment-span-update">수정</span><span class="re-comment-span-delete">삭제</span>
        	 			</c:if>
        	 			</li>
        	 			<li><c:out value="${comment.REVIEW_CONTENT }"/></li>
        	 			<li><span><img id="product-re-comment" src="${path }/resources//upload/product/comment/${comment.R_RENAMED_FILE_NAME}"/></span><span id="pro-comment-like">like</span><span><button type="button" id="product-recomment-btn">답글쓰기</button></span>  </li>
        	 				<span><fmt:formatDate value="${comment.WRITTEN_DATE }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
        	 		</ul>
        	 	</div>
         
        	</c:if>
        	<c:if test="${comment.REVIEW_LEVEL == 2 }">
        		<div class="re-comment">
        	 		<ul id="product-re-comment-box">
        	 			<li>
        	 			<input type="hidden" id="reviewNo" value="${comment.REVIEW_NO}"/>
        	 			<input type="hidden" id="actorKey" name="actorKey" value="${writer.memberKey}"/>
        	 				<span><c:out value="${writer.nickname}"/><input type="hidden" id="actorKey" name="actorKey" value="${writer.memberKey}"></span>
        	 			<c:if test="${comment.WRITER_KEY == member.memberKey} ">
        	 			<span class="re-comment-span-update">수정</span><span class="re-comment-span-delete">삭제</span><span><fmt:formatDate value="${comment.WRITTEN_DATE }" pattern="yyyy.MM.dd HH:mm:ss"/></span>
        	 			</c:if>
        	 			
        	 			</li>
        	 			<li><c:out value="${comment.REVIEW_CONTENT }"/></li>
        	 			<li><span id="pro-comment-like">like</span><span><img id="product-re-comment" src="${path }/resources//upload/product/comment/${comment.R_RENAMED_FILE_NAME}"/></span><span id="pro-comment-like">like</span>
        	 			<span><button type="button" id="product-recomment-btn">답글쓰기</button></span> 
        	 			</li>
        	 		</ul>
        	 	</div>
         
        	
        	
        	</c:if>
        </c:forEach>
	</div>
								<div class="singoForm" style="display:none;">
	                    			<form id="modal" action="${path }" method="post"  enctype="multipart/form-data">
	                    			<div class="modal-title">
	                    			
	                    				<input type="hidden"  name="writerKey" value="${member.memberKey }" readonly/>
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
		 <c:if test="${member != null}">
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
		 </c:if>
		 //멤버가 없을때 
		 <c:if test="${member == null}">
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
		 </c:if>

	 });
	//like 기능 클릭하면
$(document.body).on("click","#pro-comment-like",function(){
	
	const review=$(".re-comment");
	const commentLike=review.find("#pro-comment-like");
	const actorNum1=review.find("#actorKey");
	const actorKey=Number(actorNum1.val());
	console.log("actorNum:"+actorKey);
	 const reviewNum1=review.find("#reviewNo");
	 const reviewNo=Number(reviewNum1.val());
	 
	 console.log("reviewNum:"+reviewNo);
				console.log("like");
				commentLike.css("color","red");
				$.ajax({
					url:"${path}/BDSreview/like.do",
					type:"POST",
					data:{
						"reviewNo":reviewNo,
						"actorKey":actorKey
					},
					dataType:"html",
					success:function(data){
					console.log("입력성공");
					alert("좋아요!");
					}
				});
});

	$("#product-recomment-btn").click(e =>{
		alert("클릭햇다!!");
	<c:if test="${member != null}">
		let reviews=$("div#reviews");
		let form=$("div#reviews>form").clone();
		console.log(form);
		form.find("div.top-comment");
		form.find("div.top-comment>span");
		form.find("[name=userNickName]").val();
		form.append("</span>");
		form.find("[name=reviewStatusNo]").val("1");//status상태 1 
		form.find("[name=refArticle]").val(e.target.value);//상품 번호 
		form.find("[name=BDSreviewLevel]").val(2);// 레벨 2
		form.find("textarea[name=reviewContent]").attr("rows","1");
		form.append("</div>");
		form.find("div.comment-group");
		form.find("div.comment-group>div");
		form.find("div.comment-group>div>span#like");
		form.append("</span>");
		form.find("div.comment-group>div>last-child>[name=file]");
		form.append("</span>");
		form.append("</div>");
		form.append("<div>");
		form.find("[type=submit]").addClass("btn btn-primary");
		form.append("</div>");
		form.append("</div>");
		form.append("</div>");
		reviews.find(form).css("display","none");
		$(e.target).parents("reviews").after(reviews.children(form).slideDown(800));
		$(e.target).off("click");//클릭 이벤트 제거하기
		
		
	</c:if>
		
	});		
	
		
		
	
 </script>
 
 <script src="${path }/resources/js/productDetail/productDetail.js" defer></script>
 
 </c:if>
 <c:if test="${product.get(0).PRODUCT_STATUS_NO == 8}">
 	해당 글은 블라인드 처리 되었습니다.
 	<button onclick="window.history.back()">뒤로가기</button>
 	
 </c:if>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
