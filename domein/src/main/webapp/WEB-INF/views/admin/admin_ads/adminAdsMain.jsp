<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="[관리자]광고관리  메인페이지"/>
</jsp:include>

<script>
	/* "롼리자가 아니면"으로 수정 필요 */
	<%
	if(session.getAttribute("signedInMember") == null){ %>
		location.href = path;
	<%
	}
	%>
	let signedInMember= <%=session.getAttribute("signedInMember") %>;

</script>

<link rel="stylesheet" href="${path }/resources/css/admin/ads/adsMain.css" />

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
	        <h2>광고관리 페이지</h2>
	        <hr>
	        <div class="div_info">
	            <h3><u>알림메시지</u></h3>
	            <p>
	                관리자<>님, 돌아오셨군요!<br>
	                현재 검토 대기중인 광고 요청이 총 <> 건 있습니다.
	            </p>
	        </div>
	        <hr>
	        <div class="div_stat">
	            <h4><u>광고통계(총 광고 요청수 / 승인 / 반려 / 검토대기)</u></h4>
	            <p>지난 달에 대기 상태의 광고가 없다면 해당 월은 표시되지 않습니다.</p>
	            <br>
	            <div id="div_gChart"></div>                    
	        </div>
	    </div>
	</div>
</section>

<!-- Google Chart API 시작 -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

  // Load the Visualization API and the corechart package.
  google.charts.load('current', {'packages':['corechart']});

  // Set a callback to run when the Google Visualization API is loaded.
  google.charts.setOnLoadCallback(drawVisualization);

  // Callback that creates and populates a data table,
  // instantiates the pie chart, passes in the data and
  // draws it.
  function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
          ['월 별', '승인', '반려', '대기', '총 요청건'],
          ['8월',9,2,0,11],
          ['9월',5,1,0,6],
          ['10월',13,9,0,22],
          ['11월',18,13,0,31],
          ['12월',8,3,1,12]
        ]);

        var options = {
          title : '월 별 광고통계(2020년)',
          vAxis: {title: '광고 처리수'},
          hAxis: {title: '월(month)'},
          seriesType: 'bars',
          series: {3: {type: 'line'}},
          chartArea: {
              width:'68%'
            //   height:180
            },
          animation: {
              startup: true,
              duration: 3000,
              easing: 'out'
            }
        };

        var chart = new google.visualization.ComboChart(document.getElementById('div_gChart'));
        chart.draw(data, options);
    }
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

