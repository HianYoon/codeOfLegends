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
                            <td><c:out value="${picked.adsTitle }"/></td>
                            <td><c:out value="${picked.nickName }"/></td>
                            <td><c:out value="${picked.applyDate }"/></td>
                        </tr>
                    </table>
                </div>
                <br>
                <div class="div_preview">
                	<p><u>Preview(미리보기)</u></p>
                    <textarea name="saleContent" rows="10" cols="150" style="resize:none" placeholder="미리보기가 표시됩니다." readonly required><c:out value="${picked.saleContent }"/></textarea>
                </div>
                <br>
                
                <!--////////////////////////////////////////////////////////////붙여온 곳///////////////////////////////////////////////////////  -->
               <div class="div_description">
                    <span><u>요청메시지</u></span><br>
                    <textarea name="adsDescription" rows="12" cols="150" style="resize:none" placeholder="내용을 입력해주세요" readonly required><c:out value="${picked.adsDescription }"/></textarea>
                </div>
                <!-- /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->                
                
                <br>
                <div class="div_period">
                    <p><u>기간 및 가격: </u></p>
                    <input type="text" name="startDate" value="${picked.startDate }" readonly> ~ <input type="text" name="endDate" value="${picked.endDate}" readonly>
                    <br>
                    결제금액:&nbsp;&nbsp;<input type="text" value="${picked.adsPrice }" name="ads_price" readonly>&nbsp;원
                </div>
                <br><br>
                <div class="div_submit">
                    <input type="submit" class="btn btn--primary" value="승인" onclick="fn_confirm();">&nbsp;
                    <input type="button" class="btn btn--primary2" value="반려" onclick="fn_deny();">
                    <br><br><br><br>
                </div>
            </form>
        </div>
	</div>    
</section>
<script>
	/* ajax로 승인 처리한 후에, alert남기고 page전환 */
	function fn_confirm(){		
		$.ajax({
			url:"${path}/admin/admin_ads/adminDirectDecision.do",
			data:{"decision":1,"adsKey":"${picked.adsKey}"},
			success:data=>{
				alert(data);
				location.replace("${path}/admin/admin_ads/adminDirectBoard.do");
			}
		});
	};
	function fn_deny(){
		$.ajax({
			url:"${path}/admin/admin_ads/adminDirectDecision.do",
			data:{"decision":0,"adsKey":"${picked.adsKey}"},
			success:data=>{
				alert(data);
				location.replace("${path}/admin/admin_ads/adminDirectBoard.do");
			}
		});
	};
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

