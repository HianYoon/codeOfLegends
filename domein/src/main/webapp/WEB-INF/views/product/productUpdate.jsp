<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>

 <link rel="stylesheet" href="${path }/resources/css/product/product.css"/>
  <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
  <link rel="stylesheet" href="${path }/resources/css/sharedStyle.css"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section>
 <div class="direct-Product-container" style="display:block;">
              
                		<form action="${path}/boardSaleContent/updateBDS.do?articleNo=${update.ARTICLE_NO}" method="post">
                                <label for="category-select">카테고리품목</label>
                                <select name="category" id="category-select">
                                    <option value="1">정육</option>
                                    <option value="2">수산</option>
                                    <option value="3">야채</option>
                                    <option value="4">과일</option>
                                    <option value="5">커피</option>
                                    <option value="6">애견</option>
                                    <option value="7">제과</option>
                                    <option value="8">기타</option>
                                </select>
                               
                                <input type="hidden" class="input--text" value="${update.ARTICLE_NO }" name="articleNo" placeholder="사업자번호"  required>
                                <input type="hidden" class="input--text" value="${update.BUSINESS_KEY }" name="businessKey" placeholder="사업자번호"  required>
                                <input type="text" class="input--text" value="${update.TITLE }" name="title" placeholder="제목"  required>
								 <textarea name="saleContent" id=""  value="${update.SALE_CONTENT }" cols="30" rows="10" class="input-text"placeholder="내용설명">내용설명:
                       			 </textarea>
                       	 <div class="direct-btn-group">
		                            <button type="submit" class="btn btn--primary">등록하기</button>
		                            <button type="reset" class="btn btn--primary">취소하기</button>
                        </div>
                		</form>

                		
                		
                        <form action="${path }/product/updatePDS.do?productNo=${update.PRODUCT_NO}" method="post" enctype="multipart/form-data" id="oction--form" >
                        
                            <div class="direct--product--img">
                                <h1>상품 등록</h1>
                            </div>
                             <select name="productStatusNo" id="productStatusNo">
                                	<option value="1" >판매시작</option>
                                	<option value="0">판매중단</option>
                                	
                                </select>
                            <div class="product-textgroup">

                                <input type="hidden" class="input--text" value="${update.ARTICLE_NO}" name="articleNo" placeholder="글번호" required>
                                <input type="text" class="input--text" value="${update.PRODUCT_NO}" name="productNo" placeholder="상품번호" required>
                                <input type="text" class="input--text" value="${update.product_Status_No}" name="productStatusNo" placeholder="카테고리" required>
                                <input type="text" class="input--text" value="${update.product_Name}" name="productName" placeholder="상품명" required>
                                <input type="text" class="input--text" value="${update.origin}" name="origin" placeholder="원산지" required>
                                <input type="text" class="input--text" value="${update.productQuality}" name="productQuality" placeholder="등급" required>
                                <input type="text" class="input--text" value="${update.productQuantity}" name="productQuantity" placeholder="수량" required>
                                <input type="text" class="input--text" value="${update.measureUnit}" name="measureUnit" placeholder="단위:box/20kg-box/set/개/kg"required>
                                <input type="text" class="input--text" value="${update.price}" name="price" placeholder="가격"  required>
                                <input type="text" class="input--text" value="${update.remaningQuantity}" name="remaningQuantity" placeholder="갯수"  readonly>
                               
                            </div>
                                
                                <div class="direct-img-container">
                                    <div class="direct-img-file1">
                                                
                                    </div>
                                    <div class="direct-img-file">
                                        <input type="file" class="input--text upFile" id="upFile" name="upFile" value="${up.P_RENAMED_FILE_NAME}" required />
                                  
        
                                    </div>
        
                                </div>
                          
                        <div class="direct-btn-group">
                            <button type="submit" class="btn btn--primary">등록하기</button>
                            <button type="reset" class="btn btn--primary">취소하기</button>
                        </div>
                    </form>
                 </div>           
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
