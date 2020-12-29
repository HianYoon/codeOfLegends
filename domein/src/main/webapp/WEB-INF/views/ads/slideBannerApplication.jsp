<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>

<link rel="stylesheet" href="${path }/resources/css/sharedStyle.css" />
<link rel="stylesheet" href="${path }/resources/css/ads/bannerApplication.css" />

<section id="content">
    <div id="wholeback">
        <div class="tab_menu">
            <ul><h2>광고신청 페이지</h2>
                <li><a href=""><h5>슬라이드 배너 신청</h5></a></li>
                <li><a href=""><h5>(판매)추천 게시글 신청</h5></a></li>
            </ul>
        </div>
        <div id="container">
            <form action="${path }/ads/slideBannerApplication.do" enctype="multipart/form-data" method="post">
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
                    <div id="div_preImage">
                        <p>미리보기가 표시됩니다.</p>
                        <!-- <img src="C:\Users\Sungbin\Desktop\images\img_preview.png" alt="미리보기가 표시됩니다." id="preImage" width="100%" height="100%"><br> -->
                    </div>
                    <input type="file" class=".btn.btn--primary" name="upload" accept="image/*" onchange="fn_readImage(event);" required>
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
                    개시일&nbsp;&nbsp;<input type="date" name="startDate" min="" required>&nbsp;&nbsp;                        
                    종료일&nbsp;&nbsp;<input type="date" name="endDate" min="" required><br>
                    <!-- 기타 선택 시, return false로 체크 -->
                    결제금액&nbsp;&nbsp;<input type="text" value="0" name="adsPrice" readonly>&nbsp;원
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
        $("#urlLink").focus(e=>{
            $("#msg_url").html("[이미지 클릭 시, 이동할 주소를 입력해주세요. 요청주소가 없을 시, -입력]").css("color","green");
        });
        $("#urlLink").blur(e=>{
            $("#msg_url").html("");
        });
    })
    function fn_readImage(e){
        var reader=new FileReader();
        // if(!e.target.files[0].match("image.*")){
        //     alert("이미지 파일만 업로드 가능합니다.");
        //     return;
        // }            
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
    function fn_deleteFile(){            
        $("#div_preImage").empty();
        let p=document.createElement("p");            
        $("#div_preImage").append(p).children().html("미리보기가 표시됩니다.");
        $("#upload").val("");            
        // $("#preImage").attr("src","");
    }
    
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>


