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
<style>
.choice-conpany-container ul {
    display: flex;
    width: 100%;
    height: 130px;
    justify-content: space-around;
   background:url('/domein/resources/images/auction/auction.jpg')no-repeat 0 0;;
    border-radius: 5px;
    margin: 20px;
    background-position: center;
    background-color: red;
}
.choice-conpany-container ul:hover{
	filter: grayscale(1);
}
</style>
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
                
	                                <div class="">
	                              <!--       <div class="numbertext">1 / 5</div> -->
	                                    	<img src="${path}/resources/upload/boardauction/file/${list.RENAMED_FILE_NAME}" id="big-target"  style="width:300px;heigth:200px;">
	                                <!--     <div class="text">Caption Text</div> -->
	                                </div>
                                
                                
                            </div>
                            <br>
                            
                         <!--    <div style="text-align:center">
                                <span class="dot"></span> 
                                <span class="dot"></span> 
                                <span class="dot"></span> 
                                <span class="dot"></span> 
                                <span class="dot"></span> 
                            </div> -->
                            
                            <ul>
                                
                                <li><span>제목:<c:out value="${list.TITLE}"/></span></li>
                                <li><span>사업자:<c:out value="${list.BUSINESS_NAME}"/></span></li>
                                <li>시작일:<fmt:formatDate value="${list.START_DATE}" pattern="yyyy-MM-dd HH:mm"/>
                                <span class="Oction-date">마감일:<fmt:formatDate value="${list.END_DATE}" pattern="yyyy-MM-dd HH:mm"/></span>
                                </li>
                                <li><h4>요구사항</h4></li>
                                <li>
                                    
                                    <textarea name="content" id="textarea" cols="10" rows="4" readonly><c:out value="${list.CONTENT}"/></textarea></li>
                                </ul>
                                
                                
                            </div>
                        </div>
                                 <c:set value="${count}" var="count"/>
                        
                        <div class="choice-company-container">
                       <c:if  test="${count != 0 }">
                        <p class="joinComponyCount">< 참여한 업체  ></p>
                        <div class="choice----box">
                            <form name="forfor" >
                                    <c:forEach items="${business}" var="business">
		                                <div class="choice-conpany-container">
		                                    <ul id="choiceCompony">
		                                        <li>
		                                            <input type="radio" name="chocieCompany" value="${business.WRITER_KEY }" />
		                                            
		                                        </li>
		                                        <li><input type="text" name="writerKey" value="${business.WRITER_KEY }"/></li>
		                                      
		                                        
		                                    </ul>
		                                </div>
                                    </c:forEach>
							</form>	
                          </div>      
                       </c:if>
                       <c:if test="${count == 0 }">
                       
                       		<p class="joinComponyCount">< 참여한 업체가 없습니다. ></p>
                       </c:if>
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
                        <div class="OctionBuyerBar">
                             <ul>
                         
                             <c:if test="${signedInMember !=null && list.BUSINESS_KEY !=null}">
                      
                                 <li><a href="${path }/auction/joinEnllo.do?articleNo=${list.ARTICLE_NO}">Auction</a></li>
                    		</c:if>
                                 <li><a href="#review-container"  id="QnA">Q & A</a></li>
                                 <li>조회수:<c:out value="${list.READ_COUNT}"/></li>
                                 <li>참여수:<c:out value="${count}"/></li>
                             </ul>
                        </div>



                             <div id="review-container" class="review-container" style="/* display:none */;">
                                <div style="margin-top: 20px" >
                              
		                                   <button type="button" class="btn btn-primary" id="CommentUpdate">수정</button>
		                                   <button type="button" class="btn btn-primary" id="Commentdelete">삭제</button>
		                                   <button type="button" class="btn btn-primary" id="Commentlist">목록</button>
                                </div>
								<div class="my-3 p-3 bg-white rounded shadow-sm=" style="padding-top:10px">
		                           <form name="form" id="form" role="form" modelAttribute="replayVO" >
										
		                           
		                             <div class="row">
		                             	<div class="col-sm-10">
		                             		<textarea  id="content" name="commentContent" class="form-control" row="3" placeholder="댓글을 입력해주세요."></textarea>
		                             	</div>
		                             	<div class="col-sm-2">
		                             	
		                             		<input  class="form-control" name="writerKey" id="reg_id" value="${signedInMember.memberKey }" placeholder="댓글 작성자"/>
		                             		<input  type="hidden" class="articleStatusNo" value="1" name="articleStatusNo"/>
		                             			<input  type="text" id="refArticle" name="refArticle" value="${list.ARTICLE_NO}"/>
		                             		</c:forEach>	
		                             		<!-- <input  type="hidden"  value="1" name="refComment"/> -->
		                             		<input type="file" name="upFile" id="upFile"/>
		                             		<button type="button" class="btn btn-primary" id="btnReplaSave" >저장</button>
		                             		
		                             	</div>
		                             </div>
									</form >
								</div>
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
	$("#Commentlist").click(function(){
		commentList();//댓글 목록 불러오기 
	});
	//댓글 목록 불러오기 
	const refNo=$("#refArticle").val();
	let refArticle = Number(refNo);
	function commentList(){
		$.ajax({
			url:"${path}/auction/commentList",
			type:'get',
			data:{'refArticle':refArticle},
			success: function(result){
				var htmls='';
				for(let i=0;i < result.length;i++){
					htmls += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
					htmls += '<div class="commentInfo'+result[i].AUCTION_COMMENT_NO+'"><input type="hidden" id="cNo" value="'+result[i].AUCTION_COMMENT_NO+'"/>'+'댓글번호 : '+result[i].AUCTION_COMMENT_NO+' / 작성자 : '+result[i].WRITER_KEY;
					htmls += '<img src"${path}/resources/upload/auction/file/'+result[i].RENAMED_FILE_NAME+'" style="width:20px;heigth:20px"/>';
					htmls += '<input type="button" onclick="commentUpdate('+result[i].AUCTION_COMMENT_NO+',\''+result[i].WRITER_KEY+'\');"> 수정 </input>';
					htmls += '<input type="button" onclick="commentDelete('+result[i].AUCTION_COMMENT_NO+');"> 삭제 </input> </div>';
					htmls += '<div class="commentContent'+result[i].AUCTION_COMMENT_NO+'"> <p class="AcContent">'+result[i].COMMENT_CONTENT+'</p>';
					htmls += '</div></div>';
			}
			$("#replyList").html(htmls);
			}
			
		});
	}
	//댓글등록하기 
	 $(document).on("click","#btnReplaSave",function (){
	
		const url="${path}/restBoard/getReplyList";
		var form=$("#form")[0];
		var fileform=new FormData(form);
		$("#btnReplaSave").prop("disabled",true);
		console.log(form);
		commentList();
		$.ajax({
			type:"POST",
			enctype:"multipart/form-data",
			url: url,
			data:fileform,
			processData:false,
			contentType:false,
			success:function(result){
				let htmls="";
				if(result.length < 1){
					htmls.push("등록된 댓글이 없습니다.");
				}else{
					for(let i=0;i < result.length;i++){
						htmls += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
						htmls += '<div class="commentInfo'+result[i].AUCTION_COMMENT_NO+'"><input type="hidden" id="cNo" value="'+result[i].AUCTION_COMMENT_NO+'"/>'+'댓글번호 : '+result[i].AUCTION_COMMENT_NO+' / 작성자 : '+result[i].WRITER_KEY;
						htmls += '<img src"${path}/resources/upload/auction/file/'+result[i].RENAMED_FILE_NAME+'" style="width:20px;heigth:20px"/>';
						htmls += '<input type="button" onclick="commentUpdate('+result[i].AUCTION_COMMENT_NO+',\''+result[i].WRITER_KEY+'\' value="'+result[i].AUCTION_COMMENT_NO+'수정");"> </input>';
						htmls += '<input type="button" onclick="commentDelete('+result[i].AUCTION_COMMENT_NO+');" value="'+result[i].AUCTION_COMMENT_NO+'삭제"></input> </div>';
						htmls += '<div class="commentContent'+result[i].AUCTION_COMMENT_NO+'"> <p class="AcContent">'+result[i].COMMENT_CONTENT+'</p>';
						htmls += '</div></div>';
				}
				$("#replyList").html(htmls);
			}
		}
		});
	 });
	//댓글 수정 input폼으로 변경
	function commentUpdate(articleNo,content){
	console.log("내용:"+content);
	console.log("article"+articleNo);
	
		var b= "";
		b += '<div class="input-group">';
		b += '<input type="text" class="form-control" name="commentContent'+articleNo+'" value="'+content+'"/>';
		b += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+content+');">수정</button></span>';
		b += '</div>';
		$(".commentContent"+articleNo).html(b);
	} 
	
	//댓글 수정
	function commentUpdateProc(articleNo){
		console.log("수정"+articleNo);
		var updateContent=$('[name=commentContent'+articleNo+']').val();
		$.ajax({
			url:"${path}/auctionComment/update.do",
			data:{'commentContent': updateContent,'refArticle':articleNo},
			success: function(data){
				if(data == 1 ) commentList(articleNo);// 댓글 수정후 목록
			}
		})
	}
	function commentDelete(articleNo){
		const auctionCommentNo="auctionCommentNo="+articleNo;
		console.log(articleNo);
		$.ajax({
			url:'${path}/auctionComment/delete.do',
			data:auctionCommentNo,
			type:'post',
			success: function(data){
				if(data == 1) commentList(articleNo);//댓글 삭제후 목록 출력
			}
		});
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
