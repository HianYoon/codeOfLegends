<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="처음"/>
</jsp:include>
<link rel="stylesheet"
	href="${path }/resources/css/auction/auction.css" />
  <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
<!-- ////////////////////////////////////////slick api 필요 script /////////////////////////////////////////////////////-->

<!-- Add the slick-theme.css if you want default styling -->
<link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<!-- Add the slick-theme.css if you want default styling -->
<link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>

<script type="text/javascript" src="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

<!-- ////////////////////////////////////////slick api 필요 script /////////////////////////////////////////////////////-->
<style>
.div_slickContainer{
	position:relative;
	border:1px #ddd solid;
	height:40vh;
}
.div_slickImage{
	position:absolute;
	display:inline-block;
	margin-top:-20px;	
	left:30%;
	width:580px;	
	height:100%;
	border:1px #ddd solid;	
}
.slick-dots{
    top:220px;
}
.slick-dots li button:before {
    color: orange;
}
.slick-dots li.slick-active button:before {
    color:red !important;
}
</style>


<section id="content">
<div>
	<pre>
	<a href="${path }/admin/userList.do">ss</a>
	
	<!-- ////////////////////////////////////////slick 광고 /////////////////////////////////////////////////////-->
	<div class="div_slickContainer">        
        <div class="div_slickImage">
        <c:forEach items="${accept }" var="banner" > 
            <div><img src="${path }/resources/upload/bannerAds/${banner.adsRenamedFileName }" alt="image" href="${banner.urlLink }"></div>		                   
        </c:forEach>
        </div>                                                
    </div>
    
    <!-- ////////////////////////////////////////slick 광고 /////////////////////////////////////////////////////-->

	</pre>
</div>
<h2 class="auction--h2">A U C T I O N</h2>
		<div id="grid2" class="oction-list-container">
			 <div class="addview">
			            <a href="${path }/auction/auctionList.do"><h3 class="auctionAdd">더보기 </h3></a>
		            </div>
			 <div class="grid2-container">
                       <c:forEach items="${auction}" var="auction">
	      		<div class="oction--grid--container">
                                        <a href="${path }/auction/auctionView.do?articleNo=${auction.ARTICLE_NO}&writerKey=${auction.WRITER_KEY}"class="oction-img-group">
                                            <img id="big-target" src="${path }/resources/upload/boardauction/file/${auction.RENAMED_FILE_NAME}" alt="이미지" data-zoom="3"/>
                                            <input type="hidden" id="articleNo" name="articleNo" value="${auction.ARTICLE_NO}"/>
                                            <input type="hidden" id="memberKey" name="memberKey" value="${signedInMember.memberKey}"/>
                                        </a>
                                        <div>
            
                                            <ul class="grid-text-group" style="padding:0">
                                                <li>제목:<c:out value="${auction.TITLE }"/></li>
                                                <li><span>상호명:<c:out value="${auction.BUSINESS_NAME }"/></li>
                                                 <li class="oction-dateBox"><span class="Oction-date">시작일:<fmt:formatDate value="${auction.START_DATE}" pattern="yyyy-MM-dd HH:mm"/></span><span class="Oction-date">마감일:<fmt:formatDate value="${auction.END_DATE}" pattern="yyyy-MM-dd HH:mm"/></span></li>
                                                <li>조회수: <c:out value="${auction.READ_COUNT}"/>
                                                </li>
                                                  <li>
                                                    <span><div><img  src="${path }/resources/images/profile/jjim.png" alt="찜" style="width: 15px;height:15px;"></div></span>
                                               </li>
                                                
                                            </ul>
                                        </div>
                			  </div>
                          </c:forEach>
                          </div>
                 </div> 
 <h2 class="auction--h2">개  별  상  품</h2>                
            <div id="grid2" class="oction-list-container">   
	            <div class="addview">
		            <a href="${path }/product/productList.do"><h3 class="auctionAdd">더보기 </h3></a>
	            </div>
              <div class="grid2-container">  
                    <c:forEach items="${list}" var="l">
                    <div class="oction--grid--container">
                       		
                            <a class="oction-img-group" href="${path}/product/productDetail.do?articleNo=${l.ARTICLE_NO}&memberKey=${member.memberKey}">
                                <img id="big-target" src="${path}/resources/upload/product/${l.P_RENAMED_FILE_NAME}" alt="이미지" data-zoom="3"/>
                                
                            </a>
                            <div>

                                <ul class="grid-text-group" style="padding:0">
                                    <li><c:out value="${l.TITLE }"/></li>
                                    <li><fmt:formatNumber value="${l.PRICE}" pattern="###,###,###"/>원</li>
                                    <li>리뷰수<c:out value="${l.ATTAC }"/>
                                    <c:out value="${l.ARTICLE_NO}"/>

                                    </li>
                                      <li>
                                             <span><a href="${path}"><img src="${path }/resources/images/profile/jjim.png" alt="찜" style="width: 15px;height:15px;"></a></span>
                                             <span><a href="${path}"><img src="${path }/resources/images/profile/add-to-basket.png" alt="like" style="width: 15px;height:15px;"></a></span>
                
                                   </li>
                                    
                                </ul>
                            </div>
                     </div>
                     </c:forEach>  
                    </div>    
                </div>  
</section>
<script>
    $(function(){
	/*/////////////////////////////////////////////////slick onload 구현 ////////////////////////////////////////////////////// */
        $('.div_slickImage').slick({
            slidesToShow: 1,
            slidesToScroll: 1,
            infinite: true,
            autoplay: true,                
            autoplaySpeed: 5000,
            fade:true,
            dots: true,
            pauseOnDotsHover:true,
            pauseOnHover:false,
            responsive:[
                {
                    breakpoint:960, //화면 사이즈 960px
                    settings:{
                        slidesToShow:1,
                        slidesToScroll:1
                    }
                },
                {
                    breakpoint:768,
                    settings:{
                        slidesToShow:1,
                        slidesToScroll:1
                    }
                },
                {
                    breakpoint:400,
                    settings:"unslick"                 
                }
            ]                               
        });
        /*/////////////////////////////////////////////////slick onload 구현 ////////////////////////////////////////////////////// */
    })
</script>


<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
