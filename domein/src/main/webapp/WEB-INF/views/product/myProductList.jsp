<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ page import="com.col.domein.member.model.vo.Member,java.util.List" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
 <c:set var="member" value="${signedInMember}"/> 
 <link rel="stylesheet" href="${path }/resources/css/product/product.css"/>
  <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
  <link rel="stylesheet" href="${path }/resources/css/sharedStyle.css"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>


<section id="content">
	<script>
    $(document).ready(function(){
        //로드될때
        $(".tab_content").hide();//모든탭을 숨겨~~
        $('ul.tabs li:last').addClass("active").show();//액티브된 처음탭보여줘
        $('.tab_content:last').show();//show first tab content

        //On Click Event
        $("ul.tabs li").click(function(){
            $('ul.tabs li').removeClass('active');//Remove any 'active' class
            $(this).addClass('active').attr('color','blue');//셀렉트된탭을 active해라
            $('.tab_content').hide();//Hide all tab content
            //e.preventDefault();//a태그로 전환시 이벤트는 남게해주는..

            var activeTab=$(this).find('a').attr('href');
            $(activeTab).fadeIn();//Fade in the active ID content
            return false;
        });
        //my상품조회
        var Mylist=document.querySelector(".myListSearch");
        Mylist.onclick=function(e){
      	  location.href="${path}/product/SelectMyList.do?businessKey=1";
        }

</script>

   <div id="octionPage">

        <div id="wrapper">    
            <!--탭 메뉴 영역 -->
            <ul class="tabs">
                <li><a href="#tab1">판매등록</a></li>
                <li><a href="#tab2">Action 참여</a></li>
                <li><a href="#tab3">my상품List</a></li>
                <li><a href="#tab4">상품List</a></li>
            </ul>
        
        </div>

        <div class="tab-container-group">


                        
             
             
             <div id="tab3" class="tab_content">
                 <!--Content-->
                  <button type="button"class="myListSearch">내상품조회</button>
                
                 <table class="table">
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">상품이름</th>
                        <th scope="col">가격</th>
                        <th scope="col">등록일</th>
                        <th scope="col">수정</th>
                        <th scope="col">삭제</th>
                    </tr>
                    <c:forEach items="${product}" var="p">
					
                        <tr>
                            <td><c:out value="${p.ARTICLE_NO }"/></td>
 		                    <td><c:out value="${p.TITLE }"/></td>
           			       	<td><c:out value="${p.PRODUCT_NAME }"/></td>
          	             	 <td><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${p.PRICE}"/>원</td>
                	         <td><fmt:formatDate value="${p.WRITTEN_DATE}" pattern="yyyy-MM-dd"/></td>
                       
                            <td>
                                <button  type="button" onclick="location.href='${path }/product/productUpdate.do?articleNo=${p.ARTICLE_NO}';" class="btn btn-primary2">수정</button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-primary2"
                                 onclick="location.href='${path}/product/productDelete.do?articleNo=${p.ARTICLE_NO }';">삭제</button>
                            </td>
                        </tr>
                        
                        
                    </c:forEach>
                    </table>
             </div>
     
        
 
        </div>
     </div>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>