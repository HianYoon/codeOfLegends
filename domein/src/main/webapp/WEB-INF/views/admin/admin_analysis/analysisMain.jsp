<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="[관리자]통계 (Overview)"/>
</jsp:include>

<link rel="stylesheet" href="${path }/resources/css/admin/analysis/analysisMain.css"/>

<section id="content">
	<div id="wholeback">
        <div class="tab_menu">
            <ul><h2>[관리자] 통계</h2>
                <li>입찰 통계</li>                    
                <li>판매 통계(Direct Sales)</li>                    
                <li>회원관련 통계</li>                                    
            </ul>
        </div>
        <div id="container">
            <h2>통계 Overview</h2>
            <hr>
            <div class="div_graphs">
                <div class="div_desc">                	
                    <h3>입찰 통계(Auction)</h3>                        
                    <p>
                        2020년 현재까지의 누적된 입찰 수량을 월 별로 완료 건과 취소 건으로 나누어 쉽고 빠르게 볼 수 있습니다.<br>
                        그래프를 클릭하시면 더 자세한 정보를 얻으실 수 있습니다.
                    </p>
                    <br>
                    <div id="div_auction"></div>
                    <hr>
                </div>
                <div class="div_desc">
                    <h3>판매 통계(Direct sales)</h3>                        
                    <p>2020년 현재까지의 누적된 (auction이 아닌)일반 판매량을 판매완료와 환불 건으로 나누어 정리했습니다.</p><br>
                    <div id="div_directSales"></div>
                    <hr>
                </div>
                <div class="div_desc">
                    <h3>회원 통계(Member)</h3>                        
                    <p>2020년 현재까지의 회원 수 변동에 대한 추이를 한 눈에 볼 수 있도록 기록했습니다.</p><br>
                    <div id="div_member"></div>
                </div>
                <div id="div_ads"></div>
            </div>
        </div>
    </div>
</section>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	  google.charts.load('current', {'packages':['line']});
	  google.charts.setOnLoadCallback(drawChart);
	
	function drawChart() {
	
	  var data = new google.visualization.DataTable();
	  data.addColumn('string', '월 별');
	  data.addColumn('number', '총 누적 입찰');
	  data.addColumn('number', '완료');
	  data.addColumn('number', '취소');
	
	  data.addRows([
	    ['8월', 13, 10, 3],
	    ['9월', 25, 23, 2],
	    ['10월', 29, 22, 7],
	    ['11월',  48,  36,  12],
	    ['12월',  55,  39,  16]
	  ]);
	
	  var options = {    
	    title: '월 별 입찰 경과(단위: 건 당(n건)',    
	    width: 800,
	    height: 400,
	    animation:{
	        startup:true,
	        duration:3000,
	        easing:'out'
	    },    
	    axes: {
	      x: {
	        0: {side: 'bottom'}
	      }
	    },    
	  };
	
	  var chart = new google.visualization.LineChart(document.getElementById('div_auction'));
	
	  chart.draw(data, google.charts.Line.convertOptions(options));
	}
</script>

<script type="text/javascript">
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['월 별','총 판매량', '판매완료', '환불'],
        ['8월', 248,  236,      12],
        ['9월', 538, 481,      57],
        ['10월', 1388, 1297,       91],
        ['11월', 1154, 1026,      128],
        ['12월', 927, 882,      45]
      ]);

      var options = {
        title: '월 별 일반 판매량(건 당)',
        hAxis: {title: '월 별',  titleTextStyle: {color: '#333'}},
        vAxis: {minValue: 0},
        width: 800,
        height: 400,
        animation:{
            startup:true,
            duration:4000,
            easing:'out'
        }
      };

      var chart = new google.visualization.AreaChart(document.getElementById('div_directSales'));
      chart.draw(data, options);
    }
</script>

<script type="text/javascript">
    google.charts.load('current', {'packages':['bar']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['월 별', '전체회원수', '신규', '탈퇴'],
        ['8월', 356, 102, 12],
        ['9월', 1070, 714, 19],
        ['10월', 1519, 449, 36],
        ['11월', 2407, 888, 115],
        ['12월', 3011, 604, 42]
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
            duration:4000,
            easing:'out'
        }
      };

      var chart = new google.visualization.ColumnChart(document.getElementById('div_member'));

      chart.draw(data, options);
    }
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

