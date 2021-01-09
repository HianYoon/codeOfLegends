<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="[관리자]슬라이드 배너 관리"/>
</jsp:include>

<script>
	/* "롼리자가 아니면"으로 수정 필요 */
	<%
	if(session.getAttribute("signedInMember") == null){ %>
		location.href = path;
	<%
	}
	%>		
	if(${signedInMember.levelNo}!=99){
		alert("관리자만 이용가능한 서비스입니다.");
		location.href=path;
	}

</script>

<!-- Add the slick-theme.css if you want default styling -->
<link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<!-- Add the slick-theme.css if you want default styling -->
<link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>

<script type="text/javascript" src="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

<link rel="stylesheet" type="text/css" href="${path }/resources/css/admin/ads/slideBannerManager.css?after"/>

<section id="content">
	<div id="wholeback">
	    <div class="tab_menu">
	        <ul><h2>[관리자] 광고관리</h2>
	            <li><a href="${path }/admin/admin_ads/adminBannerManage.do"><h5>슬라이드 배너 관리</h5></a></li>
	            <li><a href="${path }/admin/admin_ads/adminBannerBoard.do"><h5>슬라이드 배너 요청 검토</h5></a></li>
	            <li><a href="${path }/admin/admin_ads/adminDirectBoard.do"><h5>추천 게시글 요청 검토</h5></a></li>
	        </ul>
	    </div>
	    <div id="container">
	        <h2>슬라이드 배너 관리</h2>
	        <hr>
	        <form action="${path }/admin/admin_ads/slideBannerManageEnd.do" method="post">
		        <div class="div_application">
		            <div class="div_dailyInfo">오늘의 광고: <span style="color:red"><c:out value="${todayAds }"/></span> 건 / 내일의 광고: <span><c:out value="${tmrwAds }"/></span> 건</div>
		            <div class="div_slickContainer">
		                <h4>Preview(미리보기)</h4><br>
		                <div class="div_slickImage">
		                <c:forEach items="${accept }" var="banner" > 
		                	<!-- name이나, class 를 ${banner.urlLink }로 줘서 onclick=function()으로 주소 이동할 수 있게 업그레이드 해도됨 -->
		                    <div><img src="${path }/resources/upload/bannerAds/${banner.adsRenamedFileName }" alt="image" onclick="location.assign('${banner.urlLink }')"></div>		                   
		                </c:forEach>
		                </div>                                                
		            </div>
		        </div>
		        <div class="div_parent">	            
		            <br>
		            <input type="button" class="btn btn--primary" id="ads_Add" value="추가" onclick="fn_addAds();">&nbsp;&nbsp;
		            <%-- <input type="button" value="   <   " onclick="fn_toleft(event);"/>&nbsp;&nbsp;&nbsp; --%>
		            <div>
		            <c:forEach items="${accept }" var="banner" varStatus="vs">
		            	<img src="${path }/resources/upload/bannerAds/${banner.adsRenamedFileName }" class="notSelected" width=50 height=30 style="border-radius:3px;" onclick="fn_selected(event);"/>            			            	
		            </c:forEach>
		            </div>	            
		            <!-- &nbsp;&nbsp;&nbsp;<input type="button" value="   >   " onclick="fn_toright(event);"/>&nbsp; -->
		            &nbsp;&nbsp;<input type="button" class="btn btn--primary2" value="삭제" onclick="fn_deleteAds();">
		        </div>
		        <br>
		        <div class="div_submit">
		            <input type="submit" class="btn btn--primary" value="등록완료">
		        </div>
		        <div class="div_msg">
		        	<span id="msg"></span>	            	
	            </div>
	        </form>
	        <hr>
	        <h4><u>현재 승인된 광고</u></h4>
	        <br>
	        <!-- 이미지 호버 시 크게 확대되서 div_preview에 출력 -->	      
            <div class="div_preview">            	
                <img src="${path }/resources/upload/bannerAds/${totalAccept[0].adsRenamedFileName }" alt="" id="image_preview" width="100%" height="100%">
                <br><br>
                <div>
		            <c:forEach items="${totalAccept }" var="total" varStatus="vs">
		            	<img src="${path }/resources/upload/bannerAds/${total.adsRenamedFileName }" class="totalImage" width=50 height=30 style="border-radius:3px;" />&nbsp;            			            	
		            </c:forEach>
	            </div>
            </div>
            <br><br><br>
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
        $(".totalImage").on("mouseenter",e=>{
        	e.target.style.border="5px lime solid";        	
        	$("#image_preview").attr("src",$(e.target).attr("src"));
        });
        $(".totalImage").on("mouseleave",e=>{
        	e.target.style.border="none";
        });
    })
    
    /* function fn_toleft(e){
    	$(e.target).next().append($(e.target).next().children().first());
    	$('.div_slickImage').append($('.div_slickImage').children().first());
    }
    function fn_toright(e){
    	$(e.target).prev().prepend($(e.target).prev().children().last());
    } */
    function fn_selected(e){
    	if(e.target.className!="imgSelected"){
	    	e.target.className="imgSelected";
	    	e.target.style.border="5px orange solid";
	    	/* $(.div_submit).prepend($("<input>").attr({"type":"hidden","value":${param.accept.adsKey}})); */
    	}else{
    		e.target.className="notSelected";
    		e.target.style.border="none";
    	}
    }
    function fn_deleteAds(){
    	let confirm_test=confirm("선택하신 광고가 삭제됩니다."); 
		if(confirm_test==true){
	    	$(".imgSelected").remove();	
	    	$("#msg").html("[등록완료]를 확인하셔야 수정이 완료됩니다.").css("color","green");
		}else if(confirm_test==false){
			alert("취소되었습니다.");
			console.log($(".imgSelected"));
			$(".imgSelected").css("border","none");
			$(".imgSelected").toggleClass();
			console.log($(".imgSelected"));			
		}
    }
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

