<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="처음"/>
</jsp:include>

<!-- ////////////////////////////////////////slick api 필요 script /////////////////////////////////////////////////////-->

<!-- Add the slick-theme.css if you want default styling -->
<link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<!-- Add the slick-theme.css if you want default styling -->
<link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>

<script type="text/javascript" src="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

<!-- ////////////////////////////////////////slick api 필요 script /////////////////////////////////////////////////////-->
<style>
.div_slickContainer{
	display:relative;
	border:1px #ddd solid;	
}
.div_slickImage{
	display:absolute;
	margin-left:29%;
	width:580px;	
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
	
	asdf
	sdf
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	d
	dfdfsf
	</pre>
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
