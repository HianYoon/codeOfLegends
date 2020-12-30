<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ page import="com.col.domein.member.model.vo.Member,java.util.List" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
 <c:set var="member" value="${signedInMember}"/> 
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
        </div>
     </div>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>