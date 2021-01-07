<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
      <link rel="stylesheet" href="${path }/resources/css/community/community.css"/>
 <script src="https://kit.fontawesome.com/0185489875.js" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="http://lab.lepture.com/editor/editor.css" />
<script type="text/javascript" src="http://lab.lepture.com/editor/editor.js"></script>
<script type="text/javascript" src="http://lab.lepture.com/editor/marked.js"></script>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section class="container">
 <div class="board-container">
      <input type="text" class="form-control" placeholder="제목" 
      name="title" id="title" value="${board.threadTitle }" required>
      <input type="text" class="form-control" name="boardWriter" 
      value="${board.threadWriter }" readonly required>
		<c:if test="${not empty attachList }">
			<c:forEach items="${attachList }" var="a" varStatus="vs">
                  <button type="button" 
                  class="btn btn-outline-success btn-block"
                  onclick="location.href='${path}/community/fileDownload.do?oriname=${a.originalFilename}&rename=${a.renamedFilename}'"><c:out value="첨부파일 ${vs.count } - ${a.originalFilename }"/>
          		</button>
          	</c:forEach>
      	</c:if>
     <textarea class="form-control" name="ckeditor" 
     placeholder="내용" required><c:out value="${board.boardContent }"/></textarea>
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
