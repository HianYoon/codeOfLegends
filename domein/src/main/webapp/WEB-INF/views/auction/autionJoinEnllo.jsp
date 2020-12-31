<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
    
<link rel="stylesheet"
	href="${path }/resources/css/auction/auction.css" />
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
                <li><a href="#tab1">입찰목록</a></li>
                <li><a href="#tab2">입찰등록</a></li>
                <li><a href="#tab3">입찰참여</a></li>
                <li><a href="#tab5">myOction<br>(판매자)</a></li>
               
            </ul>
        </div>
        <div class="tab-container-group">

       
            <!--탭 콘텐츠 영역 -->
            <div class="tab_container">
                
                    
                 
        
                <div id="tab3" class="tab_content">
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
                                            <li >title</li>
                                            <li >name</li>
                                            <li>입찰마감일:</li>
                                            <li><span >startDate</span><span >endDate</span></li>
                                            <li>납품예정일:</li>
                                            <li><span >deleveryDate</span><span >deleveryEndDate</span></li>
                                            <li >content</li>
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
                                        <div>
                                            
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



       
	</div>
</div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
