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
                
 
			<c:set value="${business}" var="business"/>
            <!-- 입찰 등록 form -->
                <div id="tab2" class="tab_content">
                   <!--Content-->
                 <form action="${path }/auction/insertEnllo.do" method="post" enctype="multipart/form-data" id="oction--form" >
                  
                       <div class="oction--register--img">
                           <h1>입찰 등록</h1>
                         <div>
                             <c:forEach items="${business}" var="business">
                               <input type="text" class="input--text inputMax" name="title" placeholder="제목" required>
                               <input type="text" class="input--text inputMax" name="id" value="${signedInMember.nickname }" placeholder="아이디" readonly>
                               <input type="text" class="input--text inputMax" name="writerKey" value="${business.BUSINESS_KEY }"/>
                               <input type="hidden" class="inputMax" name="ReadCount" value="0"/>
                               <input type="hidden" class="inputMax" name="auctionStatusNo" value="1"/>
                           			 <input type="text" class="input--text inputMax" name="businessName" value="${business.BUSINESS_NAME }" readonly required>
                         	</c:forEach>
                         </div>

                       
                        <div class="register-date-group">
                            <h4>입찰날짜</h4>
                            시작일:  <input type="date" class="input--text" name="startDate" placeholder="시작일" id="startDate" required>
                            마감일:  <input type="date" class="input--text" name="endDate" placeholder="마감일" id="endDate" required>
                        </div>
                        
                  
                        <div class="oction-img-container">
                            <div class="oction-img-file1">
                                
                            </div>
                            <div class="oction-img-file">
                                <input type="file" class="input--text upFile" id="upFile" name="upFile"  multiple    />
                                <input type="file" class="input--text upFile" id="img" name="imgFile"  multiple    />
                            
                            
                        </div>
                        
                    </div>
                    
                    <textarea name="content" id="AuctionContent" cols="10" rows="10" class="input-text"placeholder="요구사항">요구사항:
                    </textarea>
                    <div class="register-btn-group">
                        <button type="submit" id="EnlloBtn" class="btn btn--primary">등록하기</button>
                        <button type="reset" id="cancleBtn" class="btn btn--primary">취소하기</button>
                    </div>
                </div>
                
                 </form>
                </div>
        
  

</section>
<script type="text/javascript">
$(document).ready(function(){
	$("#EnlloBtn").click(function(){
		alert("등록되었습니다.");
	});
});
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
