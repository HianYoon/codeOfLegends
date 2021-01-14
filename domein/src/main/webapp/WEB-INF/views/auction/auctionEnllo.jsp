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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<!-- jQuery 기본 js파일 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<!-- jQuery UI 라이브러리 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> 
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
                            시작일:  <input type="text" class="input--text" name="startDate" placeholder="시작일" id="startDate" onchange="fn_triggerEnd(event)" autocomplete="off" required/>
                            마감일:  <input type="text" class="input--text" name="endDate" placeholder="마감일" id="endDate"  autocomplete="off" disabled required>
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
<script>
$(function(){		
		/* datepicker 개시일에 생성 */
        $("#startDate").datepicker({
            dateFormat: 'yy-mm-dd',
            prevText:'이전 달',
            nextText:'다음 달',
            currentText:'오늘',
            monthNames:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
            monthNamesShort:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
            dayNames:['일','월','화','수','목','금','토'],
            dayNamesShort:['일','월','화','수','목','금','토'],
            showMonthAfteryear:true,
            yearSuffix:'년',
            defaultDate: new Date(),
            minDate:0,
            beforeShow: function(){
            	setTimeout(function(){
            		$('.ui-datepicker').css('z-index', 9999999999);
            	}, 0);
            }
        }); 
	})
/* 게시일 값이 onchange될시 destroy후 종료일 datepicker생성 */
	function fn_triggerEnd(e){
	    $(e.target).next().attr('disabled',false);
	    $(e.target).next().datepicker("destroy");
	    $(e.target).next().datepicker({
	        dateFormat: 'yy-mm-dd',
	        prevText:'이전 달',
	        nextText:'다음 달',
	        currentText:'오늘',
	        monthNames:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	        monthNamesShort:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	        dayNames:['일','월','화','수','목','금','토'],
	        dayNamesShort:['일','월','화','수','목','금','토'],
	        showMonthAfteryear:true,
	        yearSuffix:'년',
	        // defaultDate: new Date($("#startDate").val()),
	        minDate: new Date($("#startDate").val()),
	        beforeShow: function(){
            	setTimeout(function(){
            		$('.ui-datepicker').css('z-index', 9999999999);
            	}, 0);
            }
	    });
	};

/* db에서 as */
$(document).ready(function(){
	$("#EnlloBtn").click(function(){
		alert("등록되었습니다.");
	});
});
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
