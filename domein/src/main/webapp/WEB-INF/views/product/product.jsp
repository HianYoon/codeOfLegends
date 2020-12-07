<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
 <link rel="stylesheet" href="${path }/resources/css/product/product.css"/>
  <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section id="content">
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


    <div id="octionPage">

        <div id="wrapper">    
            <!--탭 메뉴 영역 -->
            <ul class="tabs">
                <li><a href="#tab1">판매등록</a></li>
                <li><a href="#tab2">Action 참여</a></li>
                <li><a href="#tab3">상품수정</a></li>
                <li><a href="#tab4">상품List</a></li>
            </ul>
        
        </div>

        <div class="tab-container-group">


            <!--탭 콘텐츠 영역 -->
            
               

                 <div id="tab1" class="tab_content">
                        <!--Content-->
                            <!--Content-->
                 <div class="direct-Product-container">

                        <form action="" method="POST" enctype="multipart/form-data" id="oction--form" >
                        
                            <div class="direct--product--img">
                                <h1>상품 등록</h1>
                            </div>
                            <div class="product-textgroup">

                                <input type="text" class="input--text" name="" placeholder="상품명" required>
                                <input type="text" class="input--text" name="" placeholder="원산지" required>
                                <input type="text" class="input--text" name="" placeholder="수량" readonly required>
                                <input type="text" class="input--text" name="" placeholder="단위:box/20kg-box/set/개/kg" readonly required>
                                <input type="text" class="input--text" name="" placeholder="가격" readonly required>
                            
                            </div>
                                
                                <div class="direct-img-container">
                                    <div class="direct-img-file1">
                                                
                                    </div>
                                    <div class="direct-img-file">
                                        <input type="file" class="input--text upFile" id="upFile" name="imgFile"  multiple  readonly required />
                                    
        
                                    </div>
        
                                </div>
        
                            
        
                        
                        <textarea name="" id="" cols="30" rows="10" class="input-text"placeholder="내용설명">내용설명:
                        </textarea>
                        <div class="direct-btn-group">
                            <button type="submit" class="btn btn--primary">등록하기</button>
                            <button type="reset" class="btn btn--primary">취소하기</button>
                        </div>
                    </form>
                    
                 </div>           
             </div>
     
   
                        
             
             
             <div id="tab3" class="tab_content">
                 <!--Content-->
                 <div class="direct-Product-container">
                     
                     <form action="" method="post" enctype="multipart/form-data" id="oction--form" >
                        
                        <div class="direct--product--img">
                            <h1>상품 수정</h1>
                        </div>
                        <div class="product-textgroup">
                            
                            <input type="text" class="input--text" name="" placeholder="상품명" required>
                            <input type="text" class="input--text" name="" placeholder="원산지" required>
                            <input type="text" class="input--text" name="" placeholder="수량" readonly required>
                            <input type="text" class="input--text" name="" placeholder="단위:box/20kg-box/set/개/kg" readonly required>
                            <input type="text" class="input--text" name="" placeholder="가격" readonly required>
                            
                        </div>
                        
                        <div class="direct-img-container">
                            <div class="direct-img-file1">
                                
                            </div>
                            <div class="direct-img-file">
                                <input type="file" class="input--text upFile" id="upFile" name="imgFile"  multiple  readonly required />
                      
                            
                        </div>
                        
                    </div>
                    
                    
                    
                    
                    <textarea name="" id="" cols="30" rows="10" class="input-text"placeholder="내용설명">내용설명:
                    </textarea>
                    <div class="direct-btn-group">
                        <button type="submit" class="btn btn--primary">등록하기</button>
                        <button type="reset" class="btn btn--primary">취소하기</button>
                    </div>
                </form>
            </div>           
        </div>
        
        <div id="tab4" class="tab_content">
            
            
            <!--Content-->
            <div class="oction--header">
                <form action="" method="POST">
                    <div class="oction-searchbox">
                        <input type="search" class="input--text oction--input"/>
                        <button type="submit" class="btn btn-primary2">검색</button>
                       
                    </div>
                    </form>
                <ul>
                    <li>인기순</li>
                    <li>등록순</li>
                    <li>마감순</li>
                    <li>조회순</li>
                </ul>
                
            </div>
            
            
            
            
            <div id="grid2" class="oction-list-container">
                <!-- grid-content -->
                <div class="grid2-container">
                    
                    <!-- 절제선 -->
                    <div class="oction--grid--container">
                       
                            <div class="oction-img-group">
                                <img id="big-target" src="" alt="이미지" data-zoom="3"/>
                                
                            </div>
                            <div>

                                <ul class="grid-text-group" style="padding:0">
                                    <li>제목</li>
                                    <li>상호명</li>
                                    <li><span>등록일</span><span>마감일</span></li>
                                    <li>조회수
                                    </li>
                                      <li>
                                             <span><a href=""><img src="" alt="찜" style="width: 15px;height:15px;"></a></span>
                                             <span><a href=""><img src="" alt="like"></a></span>
                
                                   </li>
                                    
                                </ul>
                            </div>
                               
                                
                        
                     </div>
                  
                                
                                <!-- 절제선 -->
                      </div>
                  </div>
               </div>
        </div>
     </div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
