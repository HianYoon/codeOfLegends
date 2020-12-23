<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ page import="com.col.domein.member.model.vo.Member,java.util.List" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>

 <link rel="stylesheet" href="${path }/resources/css/product/product.css"/>
  <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
  <link rel="stylesheet" href="${path }/resources/css/sharedStyle.css"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>


<section id="content">
	<script>
    $(document).ready(function(){
        //로드될때
        $(".tab_content").hide();//모든탭을 숨겨~~
        $('ul.tabs li:last').addClass("active").show();//액티브된 처음탭보여줘
        $('.tab_content:last').show();//show first tab content

        //On Click Event
        $("ul.tabs li").click(function(){
            $('ul.tabs li').removeClass('active');//Remove any 'active' class
            $(this).addClass('active').attr('color','blue');//셀렉트된탭을 active해라
            $('.tab_content').hide();//Hide all tab content
            //e.preventDefault();//a태그로 전환시 이벤트는 남게해주는..

            var activeTab=$(this).find('a').attr('href');
            $(activeTab).fadeIn();//Fade in the active ID content
            return false;
        });
        //상품등록
        $('#productQuantity').change(function(){
            test(this);
        });
        function test(){
            var val=$('#productQuantity').val();
            $('#remaningQuantity').val(val);
            alert($('#remaningQuantity').val());
        }
        //my상품조회
        var Mylist=document.querySelector(".myListSearch");
        Mylist.onclick=function(e){
      	  location.href="${path}/product/SelectMyList.do?businessKey=1";
        }
     
    });
 

</script>

   <div id="octionPage">

        <div id="wrapper">    
            <!--탭 메뉴 영역 -->
            <ul class="tabs">
                <li><a href="#tab1">판매등록</a></li>
                <li><a href="#tab2">Action 참여</a></li>
                <li><a href="#tab3">my상품List</a></li>
                <li><a href="#tab4">상품List</a></li>
            </ul>
        
        </div>

        <div class="tab-container-group">


            <!--탭 콘텐츠 영역 -->
            
               

                 <div id="tab1" class="tab_content">
                        <!--Content-->
                            <!--Content-->
                 <div class="direct-Product-container">
                 
                		<form action="${path}/boardSaleContent/insert.do" method="post">
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
                               
                                <input type="text" class="input--text" name="businessKey" placeholder="사업자번호"  required>
                                <input type="text" class="input--text" name="title" placeholder="제목"  required>
								 <textarea name="saleContent" id="" cols="30" rows="10" class="input-text"placeholder="내용설명">내용설명:
                       			 </textarea>
                       	 <div class="direct-btn-group">
		                            <button type="submit" class="btn btn--primary">등록하기</button>
		                            <button type="reset" class="btn btn--primary">취소하기</button>
                        </div>
                		</form>
                        <form action="${path }/product/insert.do?articleNo=${articleNo}" method="post" enctype="multipart/form-data" id="oction--form" >
                        
                            <div class="direct--product--img">
                                <h1>상품 등록</h1>
                            </div>
                             <select name="productStatusNo" id="productStatusNo">
                                	<option value="1" >판매시작</option>
                                	<option value="0">판매중단</option>
                                	
                                </select>
                            <div class="product-textgroup">

                                <input type="text" class="input--text" name="articleNo" placeholder="글번호" required>
                                <input type="text" class="input--text" name="productStatusNo" placeholder="카테고리" required>
                                <input type="text" class="input--text" name="productName" placeholder="상품명" required>
                                <input type="text" class="input--text" name="origin" placeholder="원산지" required>
                                <input type="text" class="input--text" name="productQuality" placeholder="등급" required>
                                <input type="text" class="input--text" id="productQuantity" name="productQuantity" placeholder="수량" required>
                                <input type="text" class="input--text" name="measureUnit" placeholder="단위:box/20kg-box/set/개/kg"required>
                                <input type="text" class="input--text" name="price" placeholder="가격"  required>
                                <input type="text" class="input--text" id="remaningQuantity" name="remaningQuantity" placeholder="갯수"  required>
                               
                            </div>
                                
                                <div class="direct-img-container">
                                    <div class="direct-img-file1">
                                                
                                    </div>
                                    <div class="direct-img-file">
                                        <input type="file" class="input--text upFile" id="upFile" name="upFile" multiple="multiple" required />
                                  
        
                                    </div>
        
                                </div>
                          
                        <div class="direct-btn-group">
                            <button type="submit" class="btn btn--primary">등록하기</button>
                            <button type="reset" class="btn btn--primary">취소하기</button>
                        </div>
                    </form>
                    
                 </div>           
             </div>
     
             <div id="tab2" class="tab_content">
                <!--Content-->
                <h1>참여form</h1>
                         <div class="joinform-container">
                             <div class="User-container">
                                 <div class="oction--img-joinform">
                                     <div>
                                         <img src="" alt="이미지" style="width:400px;height:400px; border: 1px solid red;">
                                         
                                         <p> <span class="small-img"><img src="" alt=""></span><span class="small-img"><img src="" alt=""></span><span class="small-img"><img src="" alt=""></span><span class="small-img"><img src="" alt=""></span><span class="small-img"><img src="" alt=""></span></p>
                                         

                                     </div>
                                 </div>
                                 <div class="buyerList">
                                     <ul class="usercontent">
                                         <li name="title">title</li>
                                         <li name="name">name</li>
                                         <li>입찰마감일:</li>
                                         <li><span name="">startDate</span><span name="">endDate</span></li>
                                         <li>납품예정일:</li>
                                         <li><span name="">deleveryDate</span><span name="">deleveryEndDate</span></li>
                                         <li name="content">content</li>
                                     </ul>

                                 </div>

                             </div>
                             <h3>목록작성</h3>
                             <form action=""  method="POST" enctype="multipart/form-data" class="joinform">
                                <div class="join-container">

                                    <div class="input-container">
                                        <div class="input-joingroup">
                                            <input type="text" id="productName" name="products" class="input--text" placeholder="품명" required>
                                            <input type="text" id="productQulity" name="products" class="input--text" placeholder="등급" required>
                                            <input type="text" id="productOrigin" name="products" class="input--text" placeholder="원산지"  required>
                                            <input type="text" id="productQuantity" name="products"class="input--text" placeholder="숫자"  required>
                                            
                                         </div>
                                         <div class="input-joingroup">
                                             <input type="text" id="measureUnit" name="products" class="input--text" placeholder="예)5kg또는20kgbox,box/set/개/kg/벌"  required>
                                             <input type="text" id="productPrice" name="products" class="input--text" placeholder="가격"  required>
                                             <input type="text" id="productDate" name="products" class="input--text" placeholder="생산일/요구사항이 있으면 기입" >
                                             <input type="text" id="productExpireDate" name="products" class="input--text" placeholder="유통기한" >
                                             		
                                         </div>
                                         
                                     </div>
                                   		  <textarea name="" id="" cols="30" rows="10" class="input-text"placeholder="내용설명">
                       					 </textarea>
                                     <div class="product-register-btn">
                                         
                                         <button type="button" id="addInput" class="btn btn--primary2">추가</button>
                                         <button type="button" id="resetInput" class="btn btn--primary2">초기화</button>
                                     </div>
                                 </div>
                                 <div>
                                     <h3>품목명</h3>
                                     <p id="log"></p>
                                 </div>
                                 <div class="joinformBtn">
                                      <button type="submit" class="btn btn--primary">등록</button>
                                      <button type="reset" class="btn btn--primary">취소</button>
                                 </div>
                             
                             </form>
                         </div>      
              
             </div>

                        
             
             
             <div id="tab3" class="tab_content">
                 <!--Content-->
                  <button type="button"class="myListSearch">내상품조회</button>
                
                 <table class="table">
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">상품이름</th>
                        <th scope="col">가격</th>
                        <th scope="col">등록일</th>
                        <th scope="col">수정</th>
                        <th scope="col">삭제</th>
                    </tr>
                    <c:forEach items="${product}" var="p">
					
                        <tr>
                            <td><c:out value="${p.ARTICLE_NO }"/></td>
 		                    <td><c:out value="${p.TITLE }"/></td>
           			       	<td><c:out value="${p.PRODUCT_NAME }"/></td>
          	             	 <td><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${p.PRICE}"/>원</td>
                	         <td><fmt:formatDate value="${p.WRITTEN_DATE}" pattern="yyyy-MM-dd"/></td>
                       
                            <td>
                                <button  type="button" onclick="location.href='${path }/product/productUpdate.do?articleNo=${p.ARTICLE_NO}';" class="btn btn-primary2">수정</button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-primary2"
                                 onclick="location.href='${path}/product/productDelete.do?articleNo=${p.ARTICLE_NO }';">삭제</button>
                            </td>
                        </tr>
                        
                        
                    </c:forEach>
                    </table>
             </div>
     
        
        <div id="tab4" class="tab_content">
            
            
            <!--Content--> 
            <div class="oction--header">
                <form action="" method="Post">
                    <div class="oction-searchbox">
                        <input type="search" class="input--text oction--input"/>
                        <button type="submit" class="btn btn-primary2">검색</button>
                       
                    </div>
                    </form>
                 <div class="product--search-list">
                     <ul>
                         <li>인기순</li>
                         <li>등록순</li>
                         <li>조회순</li>
                     </ul>
                     
                     
                 </div>   
            </div>
            
            
            
            
            <div id="grid2" class="oction-list-container">
                <!-- grid-content -->
                <div class="grid2-container">
                    
                    <!-- 절제선 -->
                    <c:forEach items="${board}" var="b">
                    <div class="oction--grid--container">
                       		
                            <a class="oction-img-group" href="${path}/product/productDetail.do?articleNo=${b.ARTICLE_NO}">
                                <img id="big-target" src="${path}/resources/upload/product/${b.P_RENAMED_FILE_NAME}" alt="이미지" data-zoom="3"/>
                                
                            </a>
                            <div>

                                <ul class="grid-text-group" style="padding:0">
                                    <li><c:out value="${b.TITLE }"/></li>
                                    <li><fmt:formatNumber value="${b.PRICE}" pattern="###,###,###"/>원</li>
                                    <li>리뷰수<c:out value="${b.ATTAC }"/>
                                    <c:out value="${b.ARTICLE_NO}"/>
                                    </li>
                                      <li>
                                             <span><a href="${path}"><img src="${path }/resources/images/profile/jjim.png" alt="찜" style="width: 15px;height:15px;"></a></span>
                                             <span><a href="${path}"><img src="${path }/resources/images/profile/add-to-basket.png" alt="like" style="width: 15px;height:15px;"></a></span>
                
                                   </li>
                                    
                                </ul>
                            </div>
                               
                              <!--   <script type="text/javascript">
                               	$("#big-target").Click(e=>{
                               		location.href="${path}/product/productView.do?productNo=${b.productNo}&article_No=${article_No}";
                               	});
                                </script>
                         -->
                     </div>
                  
                     </c:forEach>           
                              <!-- 절제선 -->
                      </div>
                              <div id="pageBar">${pageBar }</div>
                  </div>
               </div>
        </div>
     </div>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>