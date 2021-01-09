<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="슬라이드 배너 요청검토 게시판"/>
</jsp:include>

<script>
	/* "롼리자가 아니면"으로 수정 필요 */
	<%
	if(session.getAttribute("signedInMember") == null){ %>
		location.href = path;
	<%
	}
	%>		
	if(${signedInMember.levelNo}!=99){
		alert("관리자만 이용가능한 서비스입니다.");
		location.href=path;
	}

</script>

<link rel="stylesheet" href="${path }/resources/css/admin/ads/slideBannerRequestBoard.css?after"/>

<section id="content">
	<div id="wholeback">
        <div class="tab_menu">
            <ul><h2>[관리자] 광고관리</h2>
                <li><a href="${path }/admin/admin_ads/adminBannerManage.do"><h5>슬라이드 배너 관리</h5></a></li>
                <li><a href="${path }/admin/admin_ads/adminBannerView.do"><h5>슬라이드 배너 요청 검토</h5></a></li>
                <li><a href="${path }/admin/admin_ads/adminDirectView.do"><h5>추천 게시글 요청 검토</h5></a></li>
            </ul>
        </div>
        <div id="container">
            <h2>슬라이드 배너 요청 검토</h2>
            <hr>
            <div class="div_boardTop">
                <div>현재 검토 대기중인 요청이 총 <b><c:out value="${pending }"/></b> 건 있습니다.</div>
                <div class="div_search">
                    <select name="searchType" id="searchType">
                        <option value="adsApplyDate">작성일</option>
                        <option value="adsStatus">상태</option>
                        <option value="adsTitle">제목</option>
                        <option value="nickName">작성자</option>
                    </select>
                </div>
            </div>
            <div class="div_table">
                <table id="table_requestBoard">
                    <thead>
                        <tr>                        	
                            <th>상태</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${boardContent }" var="bc" varStatus="vs">
                        <%-- <tr>                        	
                            <td><c:out value="${bc.adsStatus}"/></td>
                            <td><c:out value="${bc.adsTitle }"/></td>
                            <td><c:out value="${bc.nickName }"/></td>
                            <td><c:out value="${bc.applyDate }"/></td>
                        </tr>     --%>                    
                    </c:forEach>
                    </tbody>             
                </table>
            </div>
            <div class="div_pageBar">
                <%-- ${pageBar} --%>
            </div>           
            <br><br><br>     
        </div>
    </div>
</section>
<script>
	$(function(){
		$.ajax({
			url:"${path}/admin/admin_ads/adminBannerView.do",
			type:"get",
			dataType:"html",
			success:data=>{
				let board=JSON.parse("${boardContent}");	
			}				
		})
	})
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

