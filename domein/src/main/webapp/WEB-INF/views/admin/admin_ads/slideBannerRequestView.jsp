<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="슬라이드 배너 요청 검토"/>
</jsp:include>

<script>
	/* "롼리자가 아니면"으로 수정 필요 */
	<%
	if(session.getAttribute("signedInMember") == null){ %>
		location.href = path;
	<%
	}
	%>		
	if(${signedInMember.levelNo}!=99){
		alert("관리자만 이용가능한 서비스입니다.");
		location.href=path;
	}

</script>

<link rel="stylesheet" href="${path }/resources/css/admin/ads/slideBannerRequestView.css?after"/>

<section id="content">
	<div id="wholeback">
        <div class="tab_menu">
            <ul><h2>[관리자] 광고관리</h2>
                <li><a href=""><h5>슬라이드 배너 관리</h5></a></li>
                <li><a href=""><h5>슬라이드 배너 요청 검토</h5></a></li>
                <li><a href=""><h5>추천 게시글 요청 검토</h5></a></li>
            </ul>
        </div>
        <div id="container">
            <form action="" enctype="multipart/form-data" method="post">
                <h2>슬라이드 배너 요청 검토</h2>
                <hr>
                <div class="div_requestTitle">
                    <table>
                        <tr>
                            <td>{title}</td>
                            <td>{writer}</td>
                            <td>{date}</td>
                        </tr>
                    </table>
                </div>
                <div class="div_view">
                    <div class="div_viewFile">
                        첨부파일: <span><></span>
                    </div>
                    <div class="div_preview">
                        <img src="" alt="" id="image_preview" width="100%" height="100%">
                    </div>
                </div>
                <div class="div_content">
                    <p><u>요청 메시지:</u></p>
                    <div class="div_message">
                        <textarea name="ads_description" rows="12" cols="150" style="resize:none" value="{content}" readonly></textarea>
                    </div>
                </div>
                <br>
                <div class="div_url">                        
                    <label for="ads_url"><span><u>url:</u></span></label>&nbsp;&nbsp;<input type="text" name="ads_url" id="ads_url" readonly>                      
                </div>
                <br>
                <div class="div_period">
                    <p><u>기간 및 가격: </u></p>
                    <input type="text" name="startDate" value="{startDate}" readonly> ~ <input type="text" name="endDate" value="{endDate}" readonly>
                    <br>
                    결제금액:&nbsp;&nbsp;<input type="text" value="0" name="ads_price" readonly>&nbsp;원
                </div>
                <br><br>
                <div class="div_submit">
                    <input type="submit" value="승인" onclick="fn_confirm();">&nbsp;
                    <input type="button" value="반려" onclick="fn_deny();">
                    <br><br><br><br>
                </div>
            </form>
        </div>
    </div>
</section>
	
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

