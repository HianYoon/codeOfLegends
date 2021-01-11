<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
     <c:set var="member" value="${signedInMember}"/> 
      <link rel="stylesheet" href="${path }/resources/css/community/community.css"/>
 <script src="https://kit.fontawesome.com/0185489875.js" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="http://lab.lepture.com/editor/editor.css" />
<script type="text/javascript" src="http://lab.lepture.com/editor/editor.js"></script>
<script type="text/javascript" src="http://lab.lepture.com/editor/marked.js"></script>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section class="container">
		
	        <div class="community-logo">
	        <p></p>
        	</div>
	        <div class="community-title">
	            <p>지식포럼</p>
	        </div>
	        <div class="community-bottom">
	            <div class="community-bottom-left">
	                <a href="">질문</a><br><br>
	                <a href="">노하우</a>
	            </div>
	            <div class="community-bottom-right">
	            	<p>총 <c:out value="${totalData }"/>건의 게시물이 있습니다.</p>
		                <table class="board_list">
		                    <thead>
		                        <tr>
		                        	<th>번호</th>
		                            <th>제목</th>
		                            <th>글쓴이</th>
		                            <th>추천수</th>
		                            <th>조회수</th>
		                            <th>날짜</th>
		                        </tr>
		                    </thead>
	 	                    <c:forEach items="${list }" var="b" varStatus="status">
	 	                    <c:set var="m" value="${signedInMember }"/>
		                    	<tr>
 			                    		<td class="tit" style="padding-left:4.5%">
			                    				<c:out value="${b.THREAD_KEY}"/>
			                    		</td>
			                    		<td class="tit" style="padding-left:5.5%">
			                    				<a href="${path }/community/bkbDetail.do?threadKey=${b.THREAD_KEY}"><c:out value="${b.THREAD_TITLE} ()"/></a>
			                    		</td>
			                    		
			                    		<td class="tit" style="padding-left:4.8%">
 			                    				<c:if test="${b.WRITER_KEY == m.memberKey }">
			                    				<c:out value="${m.nickname }"/>
			                    				</c:if>
			                    		</td>
			                    		<td class="tit" style="padding-left:5.5%">
			                    				<c:out value="${b.ACTOR_KEY}"/>
			                    		</td>
			                    		<td class="tit" style="padding-left:5.5%">
			                    				<c:out value="${b.READ_COUNT}"/>
			                    		</td>
			                    		<td class="tit" style="padding-left:10%">
			                    				<c:out value="${b.WRITTEN_DATE}"/>
			                    		</td>
		                    	</tr>
		                    </c:forEach>
		                </table>
	                	<div class="community-bottom-right-button">
	                    <img src="${path }/resources/images/profile/search.png" alt="" width="20px">
	                    
	                    <button type="button" class="btn" onclick="location.href='${path}/community/write.do'">글쓰기</button>
	                	</div>
				        <div class="pageBar">
						${pageBar }
				        </div>
	                </form>
	            </div>
	        </div>
    </section>
    <script>
     $(".write").click(e => {
    	location.href = "${path}/community/write.do";
    })
	var editor = new Editor({
	element: document.getElementById("editor")
	});
	// editor 객체 생성
	
	editor.render();
	// 랜더링!
	post
    </script>
<%--     <script src="${path }/resources/js/community/community.js"></script> --%>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
