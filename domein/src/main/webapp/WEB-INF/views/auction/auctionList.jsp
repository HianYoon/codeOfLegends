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
                
                    
                    <div id="tab1" class="tab_content">
                        <!--Content-->
                            <div class="oction--header">
                                <div class="oction-searchbox">
                                    <input type="search" class="input--text oction--input"/>
                                </div>
                                <ul>
                                    <li>인기순</li>
                                    <li>등록순</li>
                                    <li>마감순</li>
                                    <li>조회순</li>
                                </ul>
                                <ul class="grid">
                                    <li>
                                        <a href="#grid1">
                                            <img src="" alt="List">

                                        </a>
                                    </li>
                                    <li>
                                        <a href="#grid2">
                                            <img src="" alt="Grid">

                                          </a>
                                     </li>
                                </ul>
                            </div>
                        
                        <div id="grid1" class="oction-list-container">

                            <div class="oction_img">
                                <img src="#" alt="이미지" id="oction-img">
                                
                            </div> 
                            <div class="oction_textlist">
                                <a href="">
                                    
                                    <ul class="oction-list">
                                        <li><span>제목:</span>  
                                        </li>
                                        <li><span>상호명:</span></li>
                                        <li class="oction-dateBox"><span class="Oction-date">등록일:</span><span class="Oction-date">마감일:</span></li>
                                        
                                    </ul>
                                </a>
                            </div>
                            <div class="btn-oction-box">
                                        <p>조회수</p>
                                     <button class="btn">수정</button>    
                                     <button class="btn btn--primary">삭제</button>    
                                     <button class="btn btn--primary">참여</button>    
                                                
                            </div>
                              
                        </div>
                        
                        <!-- grid정렬 -->
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
</div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
