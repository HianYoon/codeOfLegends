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
                                <label for="category-select">ī�װ�ǰ��</label>
                                <select name="category" id="category-select">
                                    <option value="1">����</option>
                                    <option value="2">����</option>
                                    <option value="3">��ä</option>
                                    <option value="4">����</option>
                                    <option value="5">Ŀ��</option>
                                    <option value="6">�ְ�</option>
                                    <option value="7">����</option>
                                    <option value="8">��Ÿ</option>
                                </select>
                               
                                <input type="hidden" class="input--text" value="${update.ARTICLE_NO }" name="articleNo" placeholder="����ڹ�ȣ"  required>
                                <input type="hidden" class="input--text" value="${update.BUSINESS_KEY }" name="businessKey" placeholder="����ڹ�ȣ"  required>
                                <input type="text" class="input--text" value="${update.TITLE }" name="title" placeholder="����"  required>
								 <textarea name="saleContent" id=""  value="${update.SALE_CONTENT }" cols="30" rows="10" class="input-text"placeholder="���뼳��">���뼳��:
                       			 </textarea>
                       	 <div class="direct-btn-group">
		                            <button type="submit" class="btn btn--primary">����ϱ�</button>
		                            <button type="reset" class="btn btn--primary">����ϱ�</button>
                        </div>
                		</form>

                		
                		
                        <form action="${path }/product/updatePDS.do?productNo=${update.PRODUCT_NO}" method="post" enctype="multipart/form-data" id="oction--form" >
                        
                            <div class="direct--product--img">
                                <h1>��ǰ ���</h1>
                            </div>
                             <select name="productStatusNo" id="productStatusNo">
                                	<option value="1" >�ǸŽ���</option>
                                	<option value="0">�Ǹ��ߴ�</option>
                                	
                                </select>
                            <div class="product-textgroup">

                                <input type="hidden" class="input--text" value="${update.ARTICLE_NO}" name="articleNo" placeholder="�۹�ȣ" required>
                                <input type="text" class="input--text" value="${update.PRODUCT_NO}" name="productNo" placeholder="��ǰ��ȣ" required>
                                <input type="text" class="input--text" value="${update.product_Status_No}" name="productStatusNo" placeholder="ī�װ�" required>
                                <input type="text" class="input--text" value="${update.product_Name}" name="productName" placeholder="��ǰ��" required>
                                <input type="text" class="input--text" value="${update.origin}" name="origin" placeholder="������" required>
                                <input type="text" class="input--text" value="${update.productQuality}" name="productQuality" placeholder="���" required>
                                <input type="text" class="input--text" value="${update.productQuantity}" name="productQuantity" placeholder="����" required>
                                <input type="text" class="input--text" value="${update.measureUnit}" name="measureUnit" placeholder="����:box/20kg-box/set/��/kg"required>
                                <input type="text" class="input--text" value="${update.price}" name="price" placeholder="����"  required>
                                <input type="text" class="input--text" value="${update.remaningQuantity}" name="remaningQuantity" placeholder="����"  readonly>
                               
                            </div>
                                
                                <div class="direct-img-container">
                                    <div class="direct-img-file1">
                                                
                                    </div>
                                    <div class="direct-img-file">
                                        <input type="file" class="input--text upFile" id="upFile" name="upFile" value="${up.P_RENAMED_FILE_NAME}" required />
                                  
        
                                    </div>
        
                                </div>
                          
                        <div class="direct-btn-group">
                            <button type="submit" class="btn btn--primary">����ϱ�</button>
                            <button type="reset" class="btn btn--primary">����ϱ�</button>
                        </div>
                    </form>
                 </div>           
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
