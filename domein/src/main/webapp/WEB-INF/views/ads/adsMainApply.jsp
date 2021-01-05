<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="광고신청 페이지"/>
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
<link rel="stylesheet" href="${path }/resources/css/ads/adsMainApply.css" />

<section id="content">
	<div id="wholeback">
	    <div class="tab_menu">
	        <ul><h2><a href="${path }/ads/adsMainApply.do">광고신청</a></h2>
	            <li><a href="${path }/ads/slideBannerApplication.do"><h5>슬라이드 배너 신청</h5></a></li>
	            <li><a href="${path }/ads/directAdsApplication.do"><h5>추천 판매게시글 신청</h5></a></li>	            
	        </ul>
	    </div>
	    <div id="container">
	        <h2>광고신청 페이지</h2>
	        <hr>
	        <div class="div_info">
	            <h3><u>알림메시지</u></h3>
	            <br>
	            <p>
	                <c:out value="<b>${signedInMember.nickname}</b>" escapeXml="false"/> 님, 안녕하세요!<br>
	                현재 검토 대기중인 광고 요청이 총 <b style="color:red"><c:out value="${bannerHoldCount }"/></b> 건 있습니다.
	            </p>
	        </div>
	        <hr>
	        <div class="div_stat">
	            <h3><c:out value="<${signedInMember.nickname}>" /> 님의 광고신청 진행현황(승인 / 반려 / 대기중 / 총 합계)</h3>	            
	            <br>
	            <div id="div_gChart"></div>                    
	        </div>
	    </div>
	</div>
</section>

<!-- Google ChartApi 시작 -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	let hold=${bannerHoldCount}+${directHoldCount};
	let accept=${bannerAcceptCount}+${directAcceptCount};
	let reject=${bannerRejectCount}+${directRejectCount};
	let total=hold+accept+reject;

	if(total==0){
		document.getElementById('div_gChart').innerHTML="<h2>현재 신청하신 광고가 없습니다.</h2>";
	}else{
	
	    google.charts.load('current', {'packages':['corechart']});
	    google.charts.setOnLoadCallback(drawChart);
	
	    function drawChart() {
	      var data = google.visualization.arrayToDataTable([
	        ['월 별', '승인', '반려', '대기중','총 합계'],
	        ['진행현황', accept, reject, hold, total]        
	      ]);
	
	      var options = {
	        chart: {
	          title: '월 별 회원수 추이',
	          subtitle: '단위: 명',
	        },        
	        width: 800,
	        height: 400,
	        animation:{
	            startup:true,
	            duration:3000,
	            easing:'out'
	        }
	      };
	
	      var chart = new google.visualization.BarChart(document.getElementById('div_gChart'));
	
	      chart.draw(data, options);
	    }
	}
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

