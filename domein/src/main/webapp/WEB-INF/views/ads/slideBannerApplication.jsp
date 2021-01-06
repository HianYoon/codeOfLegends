<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="슬라이드 배너 신청"/>
</jsp:include>

<script>
	<%
	if(session.getAttribute("signedInMember") == null){ %>
		location.href = path;
	<%
	}
	%>
</script>

<!-- jQuery UI CSS파일  -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<!-- jQuery 기본 js파일 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<!-- jQuery UI 라이브러리 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> 

<link rel="stylesheet" href="${path }/resources/css/ads/bannerApplication.css?after" />

<section id="content">
    <div id="wholeback">
        <div class="tab_menu">
            <ul><h2><a href="${path }/ads/adsMainApply.do">광고신청</a></h2>
                <li><a href="${path }/admin/admin_ads/adminAdsMain.do"><h5>슬라이드 배너 신청</h5></a></li>
                <li><a href="${path }/ads/directAdsApplication.do"><h5>(판매)추천 게시글 신청</h5></a></li>
            </ul>
        </div>
        <div id="container">
            <form action="${path }/ads/slideBannerApplicationEnd.do" enctype="multipart/form-data" method="post">
                <h2>배너 광고 신청</h2>
                <hr>
                <div class="div_intro">
                    <ul><u>슬라이드 배너 광고란?</u>
                        <li>메인페이지 가장 상단에 게재되는 광고로써, 효율적인 유입경로 확보 및 노출 극대화 달성</li>
                        <li>기존 이미지 소재를 활용하려는 광고주를 위한 형태</li>
                        <li>정적, 동적 이미지 형태의 소재를 다양한 사이즈로 유저에게 노출 가능</li>
                    </ul>                        
                    <ul><u>광고 형식</u>
                        <li>GIF, JPG, PNG, HTML5</li>
                        <li>대표 사이즈 및 지원 사이즈 (980x320)</li>
                    </ul>
                </div>

                <div class="div_title">
                	<input type="hidden" name="applicantKey" value="${signedInMember.memberKey }"/>
                    <label for="adsTitle"><span><u>제목</u></span></label>&nbsp;&nbsp;<input type="text" name="adsTitle" id="adsTitle" required>
                </div>

                <div class="div_description">
                    <span><u>요청메시지</u></span><br>
                    <textarea name="adsDescription" rows="12" cols="150" style="resize:none" placeholder="내용을 입력해주세요" required></textarea>
                </div>
                <br>
                <div class="div_attached">
                    <p><u>첨부파일 (메인배너에 삽입될 이미지를 580x190 사이즈로 업로드)</u></p>
                    <span><u>Preview(미리보기)</u></span>
                    <div id="div_preImage" onclick="fn_activateUpload(event);">
                        <p>미리보기가 표시됩니다.</p>
                        <!-- <img src="C:\Users\Sungbin\Desktop\images\img_preview.png" alt="미리보기가 표시됩니다." id="preImage" width="100%" height="100%"><br> -->
                    </div>
                    <input type="file" class=".btn.btn--primary" name="upFile" accept="image/*" onchange="fn_readImage(event);" required>
                    <input type="button" class=".btn.btn--primary2" name="deleteFile" value="삭제" onclick="fn_deleteFile();">                
                </div>
                <br>
                <div class="div_url">
                    <span id="msg_url"></span><br>
                    <label for="urlLink"><span><u>url</u></span></label>&nbsp;&nbsp;<input type="text" name="urlLink" id="urlLink" placeholder="이미지 클릭 시, 이동할 주소입력" required>                      
                </div>
                <br>
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
		/* url위 안내메시지 출력 */
        $("#urlLink").focus(e=>{
            $("#msg_url").html("[이미지 클릭 시, 이동할 주소를 입력해주세요. 요청주소가 없을 시, -입력]").css("color","green");
        });
        $("#urlLink").blur(e=>{
            $("#msg_url").html("");
        });
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
            minDate:0                
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
    /* div눌러도 file Upload 실행 */
    function fn_activateUpload(e){
    	$(e.target).next().click();
    }
    /* image 확장자로만 업로드 파일 제한 */
    function fn_readImage(e){
        var reader=new FileReader();                
        let extensionName=e.target.value.substring(e.target.value.lastIndexOf('.')+1,e.target.value.length);
        console.log(extensionName);
        if(extensionName=='jpg'||extensionName=='jpeg'||extensionName=='png'||extensionName=='gif'){
                            
        }else{
            alert("이미지파일의 형식만 업로드 할 수 있습니다.\n(지원하는 확장자형식: jpg/jpeg/png/gif)");
            return fn_deleteFile();
        }
        reader.onload=function(e){     
            // let img=$("<img>").attr({src:"e.target.result",name:"preImage",width:"580",height:"200"});           
            let img=document.createElement("img");
            img.setAttribute("src",e.target.result);
            img.setAttribute("width","100%");
            img.setAttribute("height","100%"); 
            // img.setAttribute("object-fit","contain");                
            $("#div_preImage").children().css("display","none");
            $("#div_preImage").append(img);
            // $("#preImage").attr("src",e.target.result);                
            // // $("#div_preImage").append("#preImage");
        }
        reader.readAsDataURL(e.target.files[0]);
    }
    /* 삭제 버튼 클릭시, 업로드된 파일 및 이미지 삭제 */
    function fn_deleteFile(){            
        $("#div_preImage").empty();
        let p=document.createElement("p");            
        $("#div_preImage").append(p).children().html("미리보기가 표시됩니다.");
        $("#upload").val("");            
        // $("#preImage").attr("src","");
    }
    
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>


