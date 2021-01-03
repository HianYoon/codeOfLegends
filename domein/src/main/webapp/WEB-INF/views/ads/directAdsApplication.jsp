<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>

<script>
	<%
	if(session.getAttribute("signedInMember") == null){ %>
		location.href = path;
	<%
	}
	%>
</script>

<!-- css파일 소환 -->
<link rel="stylesheet" href="${path }/resources/css/ads/directAdsApplication.css" />

<section id="content">
    <div id="wholeback">
        <div class="tab_menu">
            <ul><h2><a href="${path }/ads/adsMainApply.do">광고신청</a></h2>
                <li><a href="${path }/ads/slideBannerApplication.do"><h5>슬라이드 배너 신청</h5></a></li>
                <li><a href="${path }/ads/directAdsApplication.do"><h5>(판매)추천 게시글 신청</h5></a></li>
            </ul>
        </div>
        <div id="container">
            <form action="${path }/ads/directAdsApplicationEnd.do" method="post">
                <h2>도매인 추천 게시글 신청</h2>
                <hr>
                <div class="div_intro">
                    <ul><u>추천 게시글 광고란?</u>
                        <li>도매인 메인페이지 내 추천 게시글로 게재되는 광고로써, 게시글 조회를 유도하고자 하는 광고주들을 위한 유형</li>
                        <li>등록된 이미지 및 정보, 직접 등록한 텍스트/영상 소재를 이용하여 입찰홍보 및 판매 마케팅에 특화된 형태</li>
                    </ul>
                    <br>
                    <ul><u>광고 형식</u>
                        <li>일반적인 게시글 형태로 지원</li>
                    </ul>
                </div>

                <div class="div_myArticle">
                    <p><u>내가 쓴 게시글</u></p>                    
                       <table class="table_myArticle">
                           <thead>
                               <tr>
                                   <th>게시판</th>
                                   <th class="colspan">제목</th>
                                   <th>날짜</th>
                               </tr>
                           </thead>                              
                           <c:if test="${boardDirectSale not empty }">   
                           <tbody>                    
	                           <c:forEach items="${boardDirectSale }" var="bds" varStatus="vs">                       
	                               <tr>
	                                   <td><label for="${vs.count }"><input type="radio" id="${vs.count }" name="myArticle" value="${bds.articleNo }">&nbsp;다이렉트 판매</label></td>
	                                   <td><label for="${vs.count }"><c:out value="${bds.title }"/></label></td>
	                                   <td><label for="${vs.count }"><c:out value="${bds.writtenDate }"/></label></td>
	                               </tr>
	                           </c:forEach>
                           </tbody>
                           </c:if>
                           <c:if test="${boardDirectSale empty }">
                           <tbody>
                           		<tr>
                           			<td colspan="3"><h3>등록된 게시글이 없습니다.</h3></td>
                           		</tr>
                           </tbody>
                           </c:if>
                       </table>
                       <!-- 이 부분 수정해야함 pageBar도 파싱해야하고  -->
                       <div class="div_pageBar">
							<%-- ${pageBar } --%>
                       </div>                   
               </div>

               <div class="div_preview">
                   <p><u>Preview(미리보기)</u></p>
                   <div class="div_ajax">
	
                   </div>
               </div>

               <div class="div_period">
                   <p><u>기간 및 가격</u></p>
                   개시일&nbsp;&nbsp;<input type="text" id="startDate" name="startDate" placeholder="개시일 선택" onchange="fn_triggerEnd(event)" required>&nbsp;&nbsp;                        
                   종료일&nbsp;&nbsp;<input type="text" id="endDate" name="endDate" placeholder="종료일 선택" onchange="fn_triggerPrice(event)" disabled required><br>
                   <!-- 기타 선택 시, return false로 체크 -->
                    결제금액&nbsp;&nbsp;<input type="text" id="totalPrice" value="0" name="adsPrice" readonly>&nbsp;원
                </div>
                <br><br>

                <div class="div_submit">
                    <input type="submit" class=".btn.btn--primary" value="결제화면으로 이동">&nbsp;
                    <input type="reset" class=".btn.btn--primary2" value="취소">
                    <br><br><br><br>
                </div>

            </form>
        </div>
    </div>
</section>
<script>
	$(function(){
		$("input[name=myArticle]").click(e=>{
			$.ajax({
				url:"<%=request.getContextPath()%>/product/productDetail",
				data:{"articleNo":<%=request.getAttribute("boardDirectSale") %>},//서버에 전달할 데이터 자바스크립트 객체형식으로 보냄{key:value...}
				type:"get",
				dataType:"html",
				success:data=>{
					$(".div_ajax").html(data);                        					
				},
				error:(request,status,error)=>{
					console.log(request);
					console.log(status);
					console.log(error);
				}
			});
		});
	})
	/* DB에서 adsRate를 가져와 날짜 선택 시 계산하여 측정 */
	function fn_triggerPrice(e){    	
	    let ratePerDay=<%=request.getAttribute("adsRate") %>;
	    console.log("하루당 가격: "+ratePerDay);
	    
	    let dayGap=((new Date($("#endDate").val())-new Date($("#startDate").val()))/1000/60/60/24)+1;
	    console.log("몇일차이: "+dayGap);
	    
	    let totalPrice=dayGap*ratePerDay;
	    console.log("결제할 금액: "+totalPrice);
	    
	    $("#totalPrice").val(totalPrice);        
	}
	/* 개시일 값이 onchange될 시, destroy 후 종료일 datepicker 생성 */
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
	        minDate: new Date($("#startDate").val())
	    });
	}
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>


