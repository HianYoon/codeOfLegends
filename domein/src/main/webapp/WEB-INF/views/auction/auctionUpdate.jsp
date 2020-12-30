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
                
         

            <!--입찰등록 update form -->
                <div id="tab2" class="tab_content">
                   <!--Content-->
                 <form action="" method="post" enctype="multipart/form-data" id="oction--form" >
                  
                       <div class="oction--register--img">
                           <h1>입찰 등록</h1>
                         
                               <input type="text" class="input--text inputMax" name="" placeholder="제목" required>
                               <input type="text" class="input--text inputMax" name="" placeholder="아이디" readonly>
                            <input type="text" class="input--text inputMax" name="" placeholder="상호명" readonly required>

                       
                        <div class="register-date-group">
                            <h4>입찰날짜</h4>
                            시작일:  <input type="date" class="input--text" name="" placeholder="시작일" id="startDate" required>
                            마감일:  <input type="date" class="input--text" name="" placeholder="마감일" id="endDate" required>
                        </div>
                        
                        <div class="register-date-group">
                            <h4>거래일자</h4>
                            시작일:  <input type="date" class="input--text" name="" placeholder="시작일" id="deleveryDate" required>
                            종료일:  <input type="date" class="input--text" name="" placeholder="마감일" id="deleveryEndDate" required>
                        </div>
                        
                        <div class="oction-img-container">
                            <div class="oction-img-file1">
                                
                            </div>
                            <div class="oction-img-file">
                                <input type="file" class="input--text upFile" id="upFile" name="imgFile"  multiple  readonly required />
                            
                            
                        </div>
                        
                    </div>
                    
                    
                    
                    
                    <textarea name="" id="" cols="30" rows="10" class="input-text"placeholder="요구사항">요구사항:
                    </textarea>
                    <div class="register-btn-group">
                        <button type="submit" class="btn btn--primary">등록하기</button>
                        <button type="reset" class="btn btn--primary">취소하기</button>
                    </div>
                </div>
                
                 </form>
                </div>
        
                <div id="tab3" class="tab_content">
      
	</div>
</div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
