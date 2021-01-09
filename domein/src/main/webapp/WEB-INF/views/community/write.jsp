<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <link rel="stylesheet" href="${path }/resources/css/community/write.css?after"/>
 <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
 <script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
 
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section class="container">
	<form name="form1" class="form1" method = "post" action="${path }/community/insertBoard.do" enctype="multipart/form-data">
	<table width=100%>
		<tr>
			<td>제목</td>
			<td><input type="text" name="threadTitle" id="threadTitle" placeholder="제목을 입력해주세요" required></td>
		</tr>
		<tr>
			<td>파일</td>
			<td>
				<input type="file" name="upFile" id="upFile1">
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="5" cols="60" name="articleContent" id="articleContent" placeholder="내용을 입력해주세요" required></textarea>
			</td>
		</tr>
	</table>
	    <div class="sbm">
            <input type="submit" class="btn" id="btnSave" value="저장" />
            <input type="button" class="btn" id="btnR" value="취소"/>
        </div>
    </form>
</section>
    <script>
     $(function(){
        
        CKEDITOR.replace( 'articleContent', {//해당 이름으로 된 textarea에 에디터를 적용
            width:'100%',
            height:'400px',
            filebrowserImageUploadUrl: "${path}/community/imageUpload.do" //여기 경로로 파일을 전달하여 업로드 시킨다.
        });
         
         
        CKEDITOR.on('dialogDefinition', function( ev ){
            var dialogName = ev.data.name;
            var dialogDefinition = ev.data.definition;
          
            switch (dialogName) {
                case 'image': //Image Properties dialog
                    //dialogDefinition.removeContents('info');
                    break;
            }
        });
         
    });
/*      CKEDITOR.replace("ckeditor", {
    	fileborwserUploadUrl : "${path}/community/imageUpload.do"
    }); */
    $("#btnR").click(e => {
    	location.href = "${path}/community/communityList.do";
    })
/*     $(document).on('click', 'btnSave', function(e){
    	$("#write").submit();
    }) */
/*      $(document).ready(function(){
    	$("#btnSave").click(function(){
    		document.form1.action = "${path}/community/insertBoard.do";
    		document.form1.submit();
    	})
    }) */
    	$(function(){
    		$('[name=upFile]').on("change",function(){
    			var filename=$(this).prop('files')[0].name;
    			$(this).next(".custom-file-label").html(filename);
    		});
    	})
    </script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
