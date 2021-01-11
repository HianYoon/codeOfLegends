<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<link rel="stylesheet" href="${path }/resources/css/community/forum-dw.css"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section id="content" class="page-forum">
		<div class="container">
			<div class="wrap-inner">
			<c:forEach items="${list }" var="l" varStatus="status">
			<c:if test="${l.ARTICLE_STATUS_NO == 1 }">
				<div class="article">
					<c:if test="${status.first }">
						<div class="wrap-title">
								<h2 class="page-title"><c:out value="${l.THREAD_TITLE }"/></h2>
						</div>
					</c:if>
					<div class="wrap-contents">
						<div class="box-img">
							<img src="${l.PROFILE_URL }" alt="">
						</div>
						<div class="box-text">
							<div class="box-text-top">
								<div class="wrap-left">
									<p class="nickname"><c:out value="${l.NICKNAME }"/></p>
									<p class="date"><fmt:formatDate value="${l.WRITTEN_DATE }" pattern="yyyy년 MM월 DD일 HH시 mm분"/></p>
									<p class="date" id="writtenDate" style="display:none"><fmt:formatDate value="${l.WRITTEN_DATE }" pattern="yyyy-MM-DD'T'HH:mm:ss"/></p>
								</div>
								<c:if test="${signedInMember.nickname == l.NICKNAME }">
								<div class="box-button">
									<button class="btn-type-1 edit">수정</button>
									<button class="btn-type-1 delete">삭제</button>
								</div>		
								</c:if>
							</div>
							<div class="box-text-main">
								<p class="box-text-main-text">
									<c:out value="${l.ARTICLE_CONTENT }" escapeXml="false"/><BR>
									<img src="${path }/resources/upload/boardKnowBattle/${l.RENAMED_FILE_NAME}" alt="">
								</p>
								<div class="box-button">
									<button class="btn-like">
										<span class="number-like">3</span>
										<img src="${path }/resources/images/profile/jjim.png" alt="">
									</button>
								</div>
							</div>
							<c:if test="${status.first }">
								<div class="box-text-bottom">
									<dl class="info-article">
										<div><dt>등록일</dt><dd id="writeDateBefore"></dd></div>
										<div><dt>마지막 댓글</dt><dd id="lastestWriteDate">오늘</dd></div>
										<div><dt>댓글</dt><dd><c:out value="${list.size()-1 }"/></dd></div>
										<div><dt>조회수</dt><dd>19</dd></div>
										<div><dt>좋아요</dt><dd>3</dd></div>
									</dl>				
								</div>
							</c:if>
							<c:if test="${status.last }">
								<p class="date" id="lastestWrittenDate" style="display:none"><fmt:formatDate value="${l.WRITTEN_DATE }" pattern="yyyy-MM-DD'T'HH:mm:ss"/></p>
							</c:if>
						</div>
					</div>
				</div>
				</c:if>
				</c:forEach>
				<div class="comment-write">
					<form action="${path }/community/insertArticle.do" enctype="multipart/form-data" method="post">
						<div class="comment-write-inner">
							<div class="comment-write-content">
								<textarea name="content" placeholder="주제와 무관한 댓글, 타인의 권리를 침해하거나 명예를 훼손하는 게시물은 별도의 통보 없이 제재를 받을 수 있습니다."></textarea>
							</div>
							<div class="comment-write-footer">
								<input type='file' id="imageCheck" name='image' accept='image/jpeg,image/gif,image/png' onchange='chk_file_type(this)'>
								<input type="hidden" name="memberKey" value="${signedInMember.memberKey }">
								<input type="hidden" name="threadKey" value="${list.get(0).THREAD_KEY }">
								<button class="btn-type-1" type="submit">댓글 등록</button>
							</div>
						</div>
					</form>
				</div>
				<%-- <div class="article">
					<div class="wrap-contents">
						<div class="box-img">
							<img src="./images/profile/jonsnow.png" alt="">
						</div>
						<div class="box-text">
							<div class="box-text-top">
								<div class="wrap-left">
									<p class="nickname">개구리</p>
									<p class="date">2021.01.02 <span class="time">10:11</span></p>
								</div>
								<div class="box-button">
									<button class="btn-type-1 edit">수정</button>
									<button class="btn-type-1 delete">삭제</button>
								</div>
							</div>
							<div class="box-text-main">
								<p class="box-text-main-text">
									뜨끈~하고 든든한 국밥~<br>
									뜨끈~하고 든든한 국밥~
								</p>
								<div class="box-button">
									<button class="btn-like">
										<span class="number-like">1</span>
										<img src="${path }/resources/images/profile/jjim.png" alt="">
									</button>
								</div>
							</div>
						</div>
					</div>
				</div> --%>
			</div>
		</div>
	</section>
	<style>
	.comment-write-content{margin-top: 30px;}
	.comment-write-content textarea{width:940px; height:150px;}
	.comment-write-footer{align}
	</style>
	<script>
		function timeForToday(value){
			const today = new Date();
			const timeValue = new Date(value);
	       
			const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);
			
	        if (betweenTime < 1) return '방금 전';
	        if (betweenTime < 60) {
	        	
	        	return betweenTime+'분 전';
	        }

	        const betweenTimeHour = Math.floor(betweenTime / 60);
	        if (betweenTimeHour < 24) {
	        	return betweenTimeHour+'시간 전';
	        }

	        const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
	        
	        if (betweenTimeDay < 365) {
	            return betweenTimeDay+'일 전';
	        }

	        return Math.floor(betweenTimeDay / 365)+'년전';
		}
		const writtenDate = document.getElementById('writtenDate').innerText;
		const lastestWrittenDate = document.getElementById('lastestWrittenDate').innerText;
		console.log(timeForToday(writtenDate));
		document.getElementById('writeDateBefore').innerText = timeForToday(writtenDate);
		document.getElementById('lastestWriteDate').innerText = timeForToday(lastestWrittenDate);
		/* 1995-12-17T03:24:00 */
		function chk_file_type(obj) {

	var file_kind = obj.value.lastIndexOf('.');

	var file_name = obj.value.substring(file_kind+1,obj.length);

	var file_type = file_name.toLowerCase();

	var check_file_type=new Array();

	check_file_type=['jpg','gif','png','jpeg','bmp','tif'];



	if(check_file_type.indexOf(file_type)==-1) {

		alert('이미지 파일만 업로드 가능합니다.');

		var parent_Obj=obj.parentNode;

		var node=parent_Obj.replaceChild(obj.cloneNode(true),obj);



		document.getElementById("imageCheck").value = "";    //초기화를 위한 추가 코드

		document.getElementById("imageCheck").select();        //초기화를 위한 추가 코드

		document.selection.clear();                                                //일부 브라우저 미지원

		return false;
	}
}
	</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>