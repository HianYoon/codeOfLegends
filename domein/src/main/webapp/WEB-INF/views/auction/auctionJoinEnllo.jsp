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
                
                    
                 
        
                <div id="tab3" class="tab_content">
                   <!--Content-->
                   <h1>참여form</h1>
                   
                   <c:forEach items="${auction}" var="auction">
                            <div class="joinform-container">
                                <div class="User-container">
                                    <div class="oction--img-joinform">
                                        <div class="joinImg">
                                            <img src="${path}/resources/boardauction/file/${auction.RENAMED_FILE_NAME}" alt="이미지" style="width:400px;height:250px; border: 1px solid red;">
                                            
                                            <p>
                                             <span class="small-img">
                                            	<img src="${path}/resources/boardauction/file/${auction.RENAMED_FILE_NAME}" alt="">
                                            </span>
                                            </p>
                                            

                                        </div>
                                    </div>
                                    <div class="buyerList">
                                        <ul class="usercontent">
                                            <li >${auction.TITLE}</li>
                                            <li >${auction.BUSINESS_NAME}</li>
                                            <li><span >시작일:<fmt:formatDate value="${auction.START_DATE}" pattern="yyyy-MM-dd"/></span>
                                            <span >마감일:<fmt:formatDate value="${auction.END_DATE}" pattern="yyyy-MM-dd"/></span></li>
                                           
                                            <li >내용:${auction.CONTENT}</li>
                                        </ul>

                                    </div>
                                </div>
                                <h3>목록작성</h3>
                                <form action="${path }/auction/joinEnlloEnd.do?=articleNo=${auction.ARTICLE_NO}"  method="POST" enctype="multipart/form-data" class="joinform">
                                   <div class="join-container">

                                       <div class="input-container">
                                           <div class="input-joingroup">
                                           
                                           		<input type="hidden" id="articleNo" name="articleNo" value="${auction.ARTICLE_NO}"/>
                                           		<input type="hidden" id="writerKey" name="writerKey" value="${auction.BUSINESS_KEY}"/>
                                           		<input type="hidden" id="bidStatusNo" name="bidStatusNo" value="1"/>
                                           
						</c:forEach>
                                               <input type="text" id="productName" name="products" class="input--text" placeholder="품명" required>
                                               <input type="text" id="productQuality" name="products" class="input--text" placeholder="등급" required>
                                               <input type="text" id="productOrigin" name="products" class="input--text" placeholder="원산지"  required>
                                               <input type="text" id="Quantity" name="products"class="input--text" placeholder="양"  required>
                                               
                                            </div>
                                            <div class="input-joingroup">
                                                <input type="text" id="measureUnit" name="products" class="input--text" placeholder="예)5kg또는20kgbox,box/set/개/kg/벌"  required>
                                                <input type="text" id="price" name="products" class="input--text" placeholder="가격"  required>
                                            </div>
                                            
                                        </div>
                                        <div>
                                            
                                            <button type="button" id="addList" class="btn btn--primary2">추가</button>
                                            <button type="button" id="resetInput" class="btn btn--primary2">초기화</button>
                                        </div>
                                    </div>
                                    <div>
                                        <h3>품목명</h3>
                                        <div id="log"></div>
                                    </div>
                                    <div class="joinformBtn">
                                         <button type="submit" class="btn btn--primary">등록</button>
                                         <button type="reset" class="btn btn--primary">취소</button>
                                    </div>
                      
                                </form>
                            </div>      
                 
                </div>



       
	</div>
</div>
</section>
<script type="text/javascript">
//
$(document).ready(function(){
	listReply2();//json리턴방식
	$("#addList").click(function(){
		let articleNo=$("#articleNo").val();
		console.log(articleNo);
		let writerKey=$("#writerKey").val();
		let bidStatusNo=$("#bidStatusNo").val();
		let productName=$("#productName").val();
		let productQuality=$("#productQuality").val();
		let productOrigin=$("#productOrigin").val();
		let Quantity=$("#Quantity").val();
		let measureUnit=$("#measureUnit").val();
		let price=$("#price").val();
		const bid="articleNo="+articleNo+"&writerKey="+writerKey+"&bidStatusNo="+bidStatusNo+
		"&productName="+productName+"&productQuality="+productQuality+"&productOrigin="+productOrigin+"&Quantity="+Quantity+
		"&measureUnit="+measureUnit+"&price="+price;
		$.ajax({
			type:"post",
			url:"${path}/auction/joinWriter.do",
			data:bid,
			success: function(){
				alert("추가되었습니다.");
				listReply2();
			}
		});
		
	});
	//Controller방식
	function listReply(){
		$.ajax({
			type:"get",
			url:"${path}/auction/joinList.do",
			success: function(data){
				//responseText가 result에 저장됨.
				$("#log").html(data);
			}
		});
	}
	function listReply2(){
		$.ajax({
			type:"get",
			contentType:"application/json",//RestController이면 생략가능
			url:"${path}/auction/joinList.do",
			success: function(result){
				console.log(result);
				let output="<table id='joinCheck'>";
				for(let i in result){
					output += "<tr>";
					
					output +="<td><input type='checkbox' name='checkList' id='checkList' value=''/></td>";
					output +="<td>"+result[i].bidKey+"</td>";
					output +="<td>"+result[i].productName+"</td>";
					output +="<td>"+result[i].productQuality+"</td>";
					output +="<td>"+result[i].productOrigin+"</td>";
					output +="<td>"+result[i].Quantity+"</td>";
					output +="<td>"+result[i].measureUnit+"</td>";
					output +="<td>"+result[i].price+"</td>";
					output +="</tr>";	
				}
				output += "</table>";
				$("#log").html(output);
			}
		});
	}
});

</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
