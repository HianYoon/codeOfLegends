<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <link rel="stylesheet" href="${path }/resources/css/community/write.css"/>
 <script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
 
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section class="container">
	<form action="${path }/community/write.do" class="form1" method = "post" >
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" placeholder="제목을 입력해주세요"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="5" cols="60" name="description" id="description"></textarea>
			</td>
		</tr>
		<tr>
			<td>이미지</td>
			<td>
				<input type="file" name="file1" id="file1">
			</td>
		</tr>
	</table>
	    <div class="sbm">
            <input type="submit" class="btn" value="확인" />
            <input type="button" class="btn" id="btnR" value="취소"/>
        </div>
    </form>
</section>
    <script>
    CKEDITOR.replace("ckeditor", {
    	fileborwserUploadUrl : "${path}/imageUpload.do"
    });
    $(".btn").click(e => {
    	location.href = "${path}/community/community.do";
    })
/*     $(document).on('click', #btnSave', function(e){
    	$("#form").submit();
    }); */
    </script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
