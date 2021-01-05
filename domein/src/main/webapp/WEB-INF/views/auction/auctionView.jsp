<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
    
<link rel="stylesheet" href="${path }/resources/css/auction/auction.css" />
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
                <!-- myOction(판매자페이지) -->
              <div id="tab5" class="tab_content">
                  <div class="OctionBuyer-text-container" >
                    <div class="action-container">
					<c:forEach items="${list }" var="list">
                        <div class="Oction-text-items">
                            
                            <ul>
                                <li><img src=""  class="big--img" alt="큰이미지" style="width:200px;height:200px; box-sizing: border-box; padding: 5px 3px 5px;"></li>
                                <li class="buyer-img"><span><img src="" alt=""></span>
                                    <span class="buyer-small-img"><img src="#" alt="img1"></span>
                                    <span><img src="#" alt="img2"></span>
                                </li>
                            </ul>
                            <ul>
                                
                                <li><span>제목:<c:out value="${list.TITLE}"/></span></li>
                                <li><span>사업자:<c:out value="${list.BUSINESS_NAME}"/></span></li>
                                <li>시작일:<fmt:formatDate value="${list.START_DATE}" pattern="yyyy-MM-dd HH:mm"/>
                                <span class="Oction-date">마감일:<fmt:formatDate value="${list.END_DATE}" pattern="yyyy-MM-dd HH:mm"/></span>
                                </li>
                                <li><h4>요구사항</h4></li>
                                <li>
                                    
                                    <textarea name="content" id="textarea" cols="20" rows="7" readonly><c:out value="${list.CONTENT}"/></textarea></li>
                                </ul>
                                
                                
                            </div>
                            <div class="slideshow-container">
                                
                                <div class="mySlides fade">
                                    <div class="numbertext">1 / 5</div>
                                    <img src="img_nature_wide.jpg" class="slideImg"  style="width:100%">
                                    <div class="text">Caption Text</div>
                                </div>
                                
                                
                                
                            </div>
                            <br>
                            
                            <div style="text-align:center">
                                <span class="dot"></span> 
                                <span class="dot"></span> 
                                <span class="dot"></span> 
                                <span class="dot"></span> 
                                <span class="dot"></span> 
                            </div>
                        </div>
					</c:forEach>
                        <div class="OctionBuyerBar">
                             <ul>
                                 <li><a href="">Auction</a></li>
                                 <li><a href="">Q & A</a></li>
                                 <li><a href="">조회수</a></li>
                                 <li><a href="">참여수</a></li>
                             </ul>
                        </div>

                        <div class="choice-company-container">
                            <form action="">
                                <div class="choice-conpany-container">
                                    
                                    <ul>
                                        <li>
                                            <input type="radio" name="chocieCompany" value="" />
                                            
                                        </li>
                                        <li>A업체</li>
                                        <li>품목갯수:10개</li>
                                        <li>총가격: 2000원</li>
                                        <li>등록일자:</li>
                                        
                                    </ul>
                                </div>

                                
                                <!-- 모달스크립트 -->
                                <div class="modal-btn">
                                    
                                    <button id="modalOpen" class="btn btn--primary2">선택</button>
                                </div>
                                <div class="modal-wrapper1" style="display: none;">
                                    <div class="modal1">
                                        <div class="modal-title1">안녕하세요</div>
                                        <p>모달내용은 어쩌고 이러고..</p>
                                        <div class="close-wrapper1">
                                            <button id="modalSend" class="btn btn-primary2">최종선택</button>
                                            <button id="modalClose" class="btn btn-primary2">닫기</button>
                                        </div>
                                    </div>
                                </div>
                               
                               
                              
                            </form>
                              
                             <form action="" method="post" >
                                <div class="review-container">
                                         <!-- //점 이미지 -->
                                    <div class="top-comment"><span>업체</span><span><img src="" alt=""></span></div>
                                    <textarea name="" id="reviewComment" cols="30" rows="10" placeholder="문의사항을 남겨보세요!"></textarea>
                                    <div class="comment-group">
                                        <div >
                                            <span><img src="" alt="" class="comment-img"></span>
                                            <span><img src="" alt=""class="comment-img"></span>
                                        </div>
                                        <div>
                                           <p>등록</p>
                                        </div>
                                    </div>
                                </div>

                             </form>

            </div>
        </div>
       </div> 
	</div>
</div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
