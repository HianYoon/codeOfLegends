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
                             
                            </div>
               
                        <!-- grid정렬 -->
                       
                            <div id="grid2" class="oction-list-container">
                                <!-- grid-content -->
                                <div class="grid2-container">
									<c:forEach items="${auction}" var="auction">
                                    <!-- 절제선 -->
                                    <div class="oction--grid--container">
                       
                                        <a href="${path }/auction/auctionView.do?articleNo=${auction.ARTICLE_NO}"class="oction-img-group">
                                            <img id="big-target" src="${path }/resources/upload/boardauction/file/${auction.RENAMED_FILE_NAME}" alt="이미지" data-zoom="3"/>
                                            
                                        </a>
                                        <div>
            
                                            <ul class="grid-text-group" style="padding:0">
                                                <li>제목:<c:out value="${auction.TITLE }"/></li>
                                                <li>상호명:<span>상호명:<c:out value="${auction.BUSINESS_NAME }"/></li>
                                                 <li class="oction-dateBox"><span class="Oction-date">시작일:<fmt:formatDate value="${auction.START_DATE}" pattern="yyyy-MM-dd HH:mm"/></span><span class="Oction-date">마감일:<fmt:formatDate value="${auction.END_DATE}" pattern="yyyy-MM-dd HH:mm"/></span></li>
                                                <li>조회수
                                                </li>
                                                  <li>
                                                    <span><a href="${path}"><img src="${path }/resources/images/profile/jjim.png" alt="찜" style="width: 15px;height:15px;"></a></span>
                                           			<span><a href="${path}"><img src="${path }/resources/images/profile/add-to-basket.png" alt="like" style="width: 15px;height:15px;"></a></span>
                            
                                               </li>
                                                
                                            </ul>
                                        </div>
                                           
                                            
                                    
                                 </div>
                               </c:forEach>
                                    <!-- 절제선 -->
                                </div>
                                <div id="pageBar">${pageBar }</div>
                            </div>
                    
                </div>
            </div>

	</div>
</div>
</section>
<script src="${path }/resources/js/auction/auctionList.js" defer></script>
<script>
/* $(document).ready(function(){
 	$(".oction-list-container").hide();
 	$("ul.grid li:first").addClass("active").show();
 	$(".oction-list-container").show();
 });
 $("ul.grid li").click(function(){
 	$("ul.grid li").removeClass("active");
 	$(this).addClass("active");
 	$(".oction-list-container").hide();
 	let activeList=$(this).find('a').attr('href');
 	$(activeList).fadeIn();
 	return false;
 
 }) */
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
