<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <link rel="stylesheet" href="${path }/resources/css/community/write.css"/>
 <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
 <script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
 
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section class="container">
<form action='<c:url value='/board/boardInsert'/>' method="post" enctype="multipart/form-data">
    <!-- 생략 -->
    <div class="form-group" id="file-list">
        <a href="#" onclick="addFile()">파일추가</a>
        <div class="file-group">
            <input type="file" name="file"><a href='#' name='file-delete'>삭제</a>
        </div>
    </div>
    <button type="submit" class="btn btn-default">작성하기</button>
</form>
</section>
 
<script type="text/javascript">
    $(document).ready(function() {
        $("a[name='file-delete']").on("click", function(e) {
            e.preventDefault();
            deleteFile($(this));
        });
    })
 
    function addFile() {
        var str = "<div class='file-group'><input type='file' name='file'><a href='#this' name='file-delete'>삭제</a></div>";
        $("#file-list").append(str);
        $("a[name='file-delete']").on("click", function(e) {
            e.preventDefault();
            deleteFile($(this));
        });
    }
 
    function deleteFile(obj) {
        obj.parent().remove();
    }
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
