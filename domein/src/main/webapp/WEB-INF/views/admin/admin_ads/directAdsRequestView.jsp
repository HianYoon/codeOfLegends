<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="추천게시글 요청 검토"/>
</jsp:include>

<link rel="stylesheet" href="${path }/resources/css/admin/ads/directAdsRequestView.css?after"/>

<section id="content">
	<div id="wholeback">
        <div class="tab_menu">
            <ul><h2>[관리자] 광고관리</h2>
                <li><a href="${path }/admin/admin_ads/adminBannerManage.do"><h5>슬라이드 배너 관리</h5></a></li>
                <li><a href="${path }/admin/admin_ads/adminBannerBoard.do"><h5>슬라이드 배너 요청 검토</h5></a></li>
                <li><a href="${path }/admin/admin_ads/adminDirectBoard.do"><h5>추천 게시글 요청 검토</h5></a></li>
            </ul>
        </div>
        <div id="container">
            <form action="" enctype="multipart/form-data" method="post">
                <h2>추천 게시글 요청 검토</h2>
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
                <div class="div_preview">
                    {summon게시글}
                </div>
                <br>
                <div class="div_url">                        
                    <label for="ads_url"><span><u>url:</u></span></label>&nbsp;&nbsp;<input type="text" name="ads_url" id="ads_url" value="" readonly>&nbsp;
                    <input type="button" class="" value="게시글로 이동" onclick="fn_goto();">                      
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

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

