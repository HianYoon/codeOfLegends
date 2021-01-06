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
                            
                            <div class="slideshow-container">
                
	                                <div class="mySlides fade">
	                                    <div class="numbertext">1 / 5</div>
	                                    <img src="${path}/resources/upload/boardauction/file/${list.RENAMED_FILE_NAME}" class="slideImg"  style="width:100%;heigth:200px;">
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
                        </div>
					</c:forEach>
                        <div class="OctionBuyerBar">
                             <ul>
                                 <li><a href="">Auction</a></li>
                                 <li><a href="#review-container"  id="QnA">Q & A</a></li>
                                 <li><a href="">조회수</a></li>
                                 <li><a href="">참여수</a></li>
                             </ul>
                        </div>

                        <div class="choice-company-container">
                            <form action="">
                                <div class="choice-conpany-container" style="display:none;">
                                    
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
                             <div id="review-container" class="review-container" style="display:none;">
                                <div style="margin-top: 20px" >
                              
		                                   <button type="button" class="btn btn-primary" id="CommentUpdate">수정</button>
		                                   <button type="button" class="btn btn-primary" id="Commentdelete">삭제</button>
		                                   <button type="button" class="btn btn-primary" id="Commentlist">목록</button>
                                </div>
								<div class="my-3 p-3 bg-white rounded shadow-sm=" style="padding-top:10px">
		                             <form:form name="form" id="form" role="form" modelAttribute="replayVO" action="" method="post" >
										
		                             <form:hidden path="bid" id="bid"/>
		                             <div class="row">
		                             	<div class="col-sm-10">
		                             		<textarea path="content" id="content" class="form-control" row="3" placeholder="댓글을 입력해주세요."></textarea>
		                             	</div>
		                             	<div class="col-sm-2">
		                             		<form:input path="reg_id" class="form-control" id="reg_id" placeholder="댓글 작성자"></form:input>
		                             		<button type="button" class="btn btn-primary" id="btnReplaSave">저장</button>
		                             		
		                             	</div>
		                             </div>
									</form:form>
								</div>
									<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
										<h6 class="border-bottom pb-2 mb-0">Reply list</h6>
										<div id="replyList"></div>
									</div> 
							</div>

            </div>
        </div>
       </div> 
	</div>
</div>
</section>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js" defer></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#QnA").click(function(){
			
			$("#review-container").slideDown();
			$("#review-container").show();
		},function(){
			$("#review-container").slideUp();
			$("#review-container").css("display","block");
		});
	})
	
	$(function(){
		showReplayList(){
	
		const url="${path}/restBoard/getReplyList",
		const paramData={"bid":"${boardContent.bid}"};
		$.ajax({
			type:"POST",
			url: url,
			data:paramData,
			dataType:'json',
			success:function(result){
				let htmls="";
				if(result.length < 1){
					htmls.push("등록된 댓글이 없습니다.");
				}else{
					$(result).each(function(){
						htmls +='<div class="media text-muted pt-3" id="rid'+this.rid+'">';
						htmls +='<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice"
						focusable="false" role="img" aria-label="Placeholder:32x32">';
						htmls +='<title>Placeholder</title>';
						htmls +='<rect width="100%" height="100%" fill="#007bff"></rect>';
						htmls +='<text x="50%" fill="#007bff" dy = ".3em">32x32</text>';
						htmls +='</svg>';
						htmls +='<p class="media-body pb-3 mb-0 small Ih-125 border-bottom horder-gray">';
						htmls +='<span class="d-block">';
						htmls +='<strong class="text-gray-dark">'+this.reg_id+'</strong>';
						htmls +='<span style="padding-left: 7px; font-size:9pt">';
						htmls +='<a href="javascript:void(0)" onclick="fn-editReply('+this.rid+',\''+this.reg_id+'\',\''+this.content+'\')" style="padding-right:5px">수정</a>';
						htmls +='<a href="javascript:void(0)" onclick="fn_deleteReplay('+this.rid+')">삭제</a>';
						htmls +='</span>';
						htmls +='</span>';
						htmls +='</p>';
						htmls +='</div>';
						
					});
				
				}
				$("#replayList").html(htmls);
			};
		});
		});
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
