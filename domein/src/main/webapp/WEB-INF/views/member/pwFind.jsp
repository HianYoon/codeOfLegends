<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=" " />
</jsp:include>
<link rel="stylesheet" href="${path }/resources/css/member/pwFind.css" />
<section id="context">
	<form class="finder-cont">
		<div class="finder-top-button-cont">
			<div class="id-cont">아이디 찾기</div>
			<div class="pw-cont">비밀번호 찾기</div>
		</div>
		<div class="finder-bottom-cont">
			<h3>비밀번호를 찾을 아이디의 이메일을 입력하세요</h3>
			<h5 class="result-cont"></h5>
			<input type="email" class="input--text" id="email" required>
			<button class="btn btn--primary" id="submit-btn"
				onclick="return false;">비밀번호 찾기</button>
		</div>
	</form>
</section>
<script>
$(".id-cont").click(e=>{
	location.href = path + "/member/idPwFind.do";
})
$(".pw-cont").click(e=>{
	location.href = path + "/member/pwFind.do";
})
$("#submit-btn").click((e)=>{
	$("#submit-btn").removeClass("btn--primary").addClass("btn--primary2").prop({"disabled":"disabled"});
		$.ajax({
			url: path+"/rest/member/password/find",
			method: "GET",
			async: false,
			data: {email: $("#email").val()},
			success: result =>{
				if(result){
					$(".result-cont").html("이메일로 변경 코드가 보내졌습니다. 24시간동안 유효합니다.");
				} else {
					$(".result-cont").html("해당하는 계정이 없습니다.");
				}
			}
		})
	})
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />