<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="사용자 결제화면" />
</jsp:include>
<section id="context">

<script>
	/* 로그인 안했으면 내쫓기 */
	<c:if test="${signedInMember == null}">
		location.href = '${path}/order/mustLogin.do';
	</c:if>	
</script>

	<!-- 아임포트 라이브러리 -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
		
	<!-- 주소 api 불러오기 goPopup() -->
	<button onclick="goPopup();" class="btn btn--primary">주소 찾기</button>
	
	<form action="${path }/ads/paymentEnd.do" method="post">
		<input type="tel" id="buyerTel" value="${signedInMember.phone }">구매자 전화번호
		<br> 
		<!-- 받는 사람 주소 -->
		<input class="addr" type="number" id="postcode" required="required" value="06234" readonly> 우편번호 <br> 
		<input type="text" class="addr" id="address1"  readonly> 주소1 <br>
		<input class="addr" type="text" id="address2"  readonly> 주소2 <br>
		<input class="addr" type="text" id="addrDetail" readonly> 자세한 주소 
		<input type="hidden" class="addr" id="fullAddr" value="서울특별시 강남구 테헤란로 14길 6 (역삼동) 남도빌딩 2F,3F,4F,5F,6F" readonly> <br>
		<input type="tel" id="receiverTel" value="01042191088" required> 전화번호 <br> 
		<input type="email" id="email" value="${signedInMember.email }" required> 이메일 <input type="text" id="name" value="${signedInMember.userName }" required> 이름 <br> 
		<<br><br>
		<input type="hidden" id="sumPrice" value="${adsRequest.adsPrice }" required>
		<br>
		<textarea rows="5" cols="60" id="receiverComment"></textarea>
		<br>
		<input type="hidden" id="discount" value="0">
		<br>
		<input type="number" id="totalPrice" value="${adsRequest.adsPrice }" readonly> 총 계
		<input type="hidden" name="bannerAds" value="${adsRequest }">

		<!-- requestPayButtonFunction()은 아임포트 모듈 불러옴 -->
		<button type="submit" onclick="requestPayButtonFunction(); return false;" class="btn btn--primary">결제</button>
	</form>
</section>

<script>
	
	const sumPrice = $("#sumPrice");
	const discount = $("#discount");
	const totalPrice = $("#totalPrice");
	sumPrice.change(e=>{

		totalPriceChanger();
	})
	discount.change(e=>{
		totalPriceChanger();
	})
	
	function totalPriceChanger(){
		totalPrice.val(sumPrice.val() - discount.val());
	}
	
	
	IMP.init("imp71956162");

	/* 이 함수를 결제 버튼에서 onclick으로 불러올것! */
	function requestPayButtonFunction() {
		requestPay();

		return false;
	}
	
		
	function requestPay(){
		
		IMP.request_pay({ // param
		    pg: "html5_inicis",
		    pay_method: "card",
		    merchant_uid: '${signedInMember.memberKey}_'+(new Date() - new Date(0)),
		    name: "${msg} (${adsRequest.startDate} ~ ${adsRequest.endDate})",
		    amount: sumPrice.val() - discount.val(),
		    buyer_email: $("#email").val(),
		    buyer_name: $("#name").val(),
		    buyer_tel: $("#buyerTel").val(),
		    buyer_addr: $("#fullAddr").val(),
		    buyer_postcode: $("#postcode").val()
		    
		  }, function (rsp) { // callback
		    if (rsp.success) {	  
		    	console.log("성공");
 		        $.ajax({
		        	url: '${path}/rest/order/authenticate',
		        	type: "POST",
		        	data:{
		        		"imp_uid" : rsp.imp_uid,
		        		"merchant_uid" : rsp.merchant_uid,
		        		"receiverTel" : $("#receiverTel").val(),
		        		"discount" : $("#discount").val(),
		        		"receiverComment" : $("#receiverComment").val(),
		        		"totalPrice" : sumPrice.val() - discount.val(),
		        		/* 1: auction, 2: direct_sale 3:banner_ads 4:auction_ads 5:direct_sale_ads*/
		        		"orderTargetNo" : "${targetNo}"
		        	},
		        	success: (data)=>{
		        		/* 데이터는 orderNo입니다. JSON 파싱 필요없이 바로 넘버로서 사용 가능 */
		        		/* orderNo를 이용해서, 각자 필요한 order_history로 집어넣으세요. location.href 추천 */		        		
		        		
		        		location.href="${path}/ads/paymentEnd.do?orderNo="+data;
		        		
		        		}
		        	})
		    } else {
		        /* 서버 연결 실패시 */
		        
		    }
		  })
	}
	
	$(".addr").click(e=>{
		goPopup();
	})
	
	/* 주소 api */
	function goPopup(){
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	    var pop = window.open("${path}/address/jusoPopup.do","pop","width=570,height=420, scrollbars=yes, resizable=yes");  
	    
		// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
	    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}
	/** API 서비스 제공항목 확대 (2017.02) **/
	function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
							, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		$("#address1").val(roadAddrPart1);
		$("#address2").val(roadAddrPart2);
		$("#addrDetail").val(addrDetail);
		$("#postcode").val(zipNo);
		$("#fullAddr").val(roadFullAddr);
	}
	

	
	
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />