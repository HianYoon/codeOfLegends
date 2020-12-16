<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>

<link
			rel="stylesheet"
			href="${path }/resources/css/common/footerStyle.css"
		/>
<!-- footer -->
<footer id="footer">
	
	<div class="footer-container">
		<div class="footer-group">
			<ul class="footer-text-items displayNone">
				<li><a href="#"><img src="${path }/resources/images/sns/facebook.png" alt="페이스북" id="footer-sns-img"></a></li>
				<li><a href="#"><img src="${path }/resources/images/sns/google.png" alt="구글" id="footer-sns-img"></a></li>
				<li><a href="#"><img src="${path }/resources/images/sns/kakao.png" alt="카카오" id="footer-sns-img"></a></li>
				<li><a href="#"><img src="${path }/resources/images/sns/naver.png" alt="네이버" id="footer-sns-img"></a></li>
			</ul>
		</div>
		<div class="footer-text-group">
			<div class="footer-group">
				<ul class="footer-text-items displayNone">
					<li><a href="#">회사소개</a></li>
					<li><a href="#">전자금융약관</a></li>
					<li><a href="#">개인정보처리방침</a></li>
					<li><a href="#">판매자등록</a></li>
					<li><a href="#">불만마법사</a></li>
					<li><a href="#">공지사항</a></li>
				</ul>
				<!-- smalldevice용 footer-text -->
			</div>
		</div>
	</div>
	<div class="col-info" style="display: none;">Col-Company 사업자 정보</div>
	<ul class="footer-small-text">
		<li><a href="">로그아웃</a></li>
		<li><a href="">고객센터</a></li>
		<li><a href="">마이페이지</a></li>
		<li><a href="">공지사항</a></li>
	</ul>
	<div class="text-copyright">
		<p>도매인은 통신판매중개자이며 통신판매의당사자가아닙니다.</p>
		<p>따라서 도매인은 상품/거래정보및 가격에대하여 책임을 지지않습니다.</p>
		<p>본 사이트/앱 상의 모든정보, 콘텐츠,UI등에 대한 무단복제,배포</p>
		<p>스크래핑등의 행위는 법에 의하여 엄격히 금지됩니다.</p>
		<p>CopyRight@Col-company.</p>

	</div>
	


</footer>

</body>
</html>