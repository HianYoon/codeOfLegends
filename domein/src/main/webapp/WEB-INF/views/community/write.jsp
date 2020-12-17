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
        <div class="row">
            <table>
                <tr>
                    <th>제목</th>
                    <td>
                        <input
                            type="text"
                            name="text"
                            size=40
                        />
                    </td>
                </tr>
            </table>
        </div>
        <div class="row">
            <form method="post"></form>
                <textarea class = "editor4" name = "editor4"></textarea>
            </form>
        </div>
        <div class="sbm">
            <input type="submit" value="확인" />
            <input type="button" class="btn" value="취소"/>
        </div>
    </section>
    <script type="text/javascript">
    CKEDITOR.replace( 'editor4' );
    </script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
