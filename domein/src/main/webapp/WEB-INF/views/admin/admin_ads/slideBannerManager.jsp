<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="[관리자]슬라이드 배너 관리"/>
</jsp:include>

<!-- Add the slick-theme.css if you want default styling -->
<link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<!-- Add the slick-theme.css if you want default styling -->
<link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>

<script type="text/javascript" src="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

<link rel="stylesheet" type="text/css" href="${path }/resources/css/admin/ads/slideBannerManager.css"/>

<section id="content">
	<div id="wholeback">
	    <div class="tab_menu">
	        <ul><h2>[관리자] 광고관리</h2>
	            <li><a href="${path }/admin/admin_ads/adminBannerManage.do"><h5>슬라이드 배너 관리</h5></a></li>
	            <li><a href="${path }/admin/admin_ads/adminBannerView.do"><h5>슬라이드 배너 요청 검토</h5></a></li>
	            <li><a href="${path }/admin/admin_ads/adminDirectView.do"><h5>추천 게시글 요청 검토</h5></a></li>
	        </ul>
	    </div>
	    <div id="container">
	        <h2>슬라이드 배너 관리</h2>
	        <hr>
	        <div class="div_application">
	            <div class="div_dailyInfo">오늘의 광고: <span><></span> 건 / 내일의 광고: <span><></span> 건</div>
	            <div class="div_slickContainer">
	                <h4>Preview(미리보기)</h4><br>
	                <div class="div_slickImage">
	                <c:forEach items="${accept }" var="banner" > 
	                    <div><img src="${path }/resources/upload/bannerAds/${banner.adsRenamedFileName }" alt="image" href="${banner.urlLink }"></div>		                   
	                </c:forEach>
	                </div>                                                
	            </div>
	        </div>
	        <div class="div_parent">	            
	            <br>
	            <input type="button" class=".btn.btn--primary" id="ads_Add" value="추가" onclick="fn_addAds();">&nbsp;
	            <c:forEach items="${accept }" var="banner" >
	            	<div><img src="${path }/resources/upload/bannerAds/${banner.adsRenamedFileName }" width=50 height=30></div>
	            </c:forEach>	            
	            <input type="button" class=".btn.btn--primary2" value="삭제" onclick="fn_deleteAds();">
	        </div>
	        <div class="div_submit">
	            <input type="submit" value="등록완료">
	        </div>
	        <hr>
	        <h4><u>승인된 광고</u></h4>
	        <!-- 이미지 호버 시 크게 확대되서 div_preview에 출력 -->
	        <%-- <c:if>
	
	        </c:if> --%>
            <div class="div_preview">
                <img src="" alt="" id="image_preview" width="100%" height="100%">
            </div>
            <br><br>
        </div>
    </div>
</section>
<script>
    $(function(){
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
    })
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

