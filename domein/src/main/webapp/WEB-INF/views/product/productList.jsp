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
        //상품등록
        $('#productQuantity').change(function(){
            test(this);
        });
        function test(){
            var val=$('#productQuantity').val();
            $('#remaningQuantity').val(val);
            alert($('#remaningQuantity').val());
        }
     	//상품 조회
     	$(function(){
     		$("#searchBtn").click(function(){
     			self.location="${path}/product/searchTitle.do?"+'${pageMaker.makeQuery(1)}'+'&searchType='+$("select option:selected").val()
     			+'&keyword='+encodeURIComponent($('#keywordInput').val());
     		});
     	});
    });
 

</script>

   <div id="octionPage">

        <div class="tab-container-group">


            <!--탭 콘텐츠 영역 -->
  
     
        
        <div id="tab4" class="tab_content">
            
            
            <!--Content--> 
            <div class="oction--header">
                <form role="form" method="get">
                    <div class="oction-searchbox">
                    <select name="searchType" style="display:none">
		                    <option value="null"
		                    <c:out value="${scri.searchType == null? 'selected':''}"/>>
		                    ---없음---</option>
		                    <option value="title"
		                    <c:out value="${scri.searchType eq 'title'? 'selected':''}"/>>제목</option>
		                    <option value="content"
		                    <c:out value="${scri.searchType eq 'content'? 'selected':''}"/>>내용</option>
		                    <option value="all"
		                    <c:out value="${scri.searchType eq 'all'? 'selected':''}"/>>All</option>
	                   </select>
                         <input type="text" name="keyword" id="keywordInput" value="${scri.keyword }" class="input--text oction--input"/>
                         <button type="button" id="searchBtn" class="btn btn-primary2">검색</button>
                    
                   
                    </div>
                    </form>
                 <div class="product--search-list">
                     <ul>
                         <li>인기순</li>
                         <li>등록순</li>
                         <li>조회순</li>
                     </ul>
                     	
                     
                 </div>   
            </div>
            
            
            
            
            <div id="grid2" class="oction-list-container">
                <!-- grid-content -->
                <div class="grid2-container">
                    
                    <!-- 절제선 -->
                    <c:forEach items="${list}" var="l">
                    <div class="oction--grid--container">
                       		
                            <a class="oction-img-group" href="${path}/product/productDetail.do?articleNo=${l.ARTICLE_NO}&memberKey=${member.memberKey}">
                                <img id="big-target" src="${path}/resources/upload/product/${l.P_RENAMED_FILE_NAME}" alt="이미지" data-zoom="3"/>
                                
                            </a>
                            <div>

                                <ul class="grid-text-group" style="padding:0">
                                    <li><c:out value="${l.TITLE }"/></li>
                                    <li><fmt:formatNumber value="${l.PRICE}" pattern="###,###,###"/>원</li>
                                    <li>리뷰수<c:out value="${l.ATTAC }"/>
                                    <c:out value="${l.ARTICLE_NO}"/>

                                    </li>
                                      <li>
                                             <span><a href="${path}"><img src="${path }/resources/images/profile/jjim.png" alt="찜" style="width: 15px;height:15px;"></a></span>
                                             <span><a href="${path}"><img src="${path }/resources/images/profile/add-to-basket.png" alt="like" style="width: 15px;height:15px;"></a></span>
                
                                   </li>
                                    
                                </ul>
                            </div>
                     </div>
                  
                     </c:forEach>           
                              <!-- 절제선 -->
                      </div>
                      <div>
                      	   <ul>
                      			<c:if test="${pageMaker.prev }">
	                      			<li><a href="list${pageMaker.makeSearch(pageMaker.startPage -1 )}">이전</a></li>
                      			</c:if>
                      			<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage}" var="idx">
                      			
	                      			<li><a href="list${pageMaker.makeSearch(idx)}"></a></li>
                      			</c:forEach>
                      			<c:if test="${pageMaker.next&&pageMaker.endPage > 0 }">
                      			
	                      			<li><a href="list${pageMaker.makeSearch(pageMaker.endPage +1)}">다음</a></li>
                      			</c:if>
                      			
                      		</ul>
                      </div>
            <div id="grid2" class="oction-list-container">
                <!-- grid-content -->
                <div class="grid2-container">
                    
                    <!-- 절제선 -->
                    <c:forEach items="${board}" var="b">
                    <div class="oction--grid--container">
                       		
                            <a class="oction-img-group" href="${path}/product/productDetail.do?articleNo=${b.ARTICLE_NO}&memberKey=${member.memberKey}">
                                <img id="big-target" src="${path}/resources/upload/product/${b.P_RENAMED_FILE_NAME}" alt="이미지" data-zoom="3"/>
                                
                            </a>
                            <div>

                                <ul class="grid-text-group" style="padding:0">
                                    <li><c:out value="${b.TITLE }"/></li>
                                    <li><fmt:formatNumber value="${b.PRICE}" pattern="###,###,###"/>원</li>
                                    <li>리뷰수<c:out value="${b.ATTAC }"/>
                                    <c:out value="${b.ARTICLE_NO}"/>

                                    </li>
                                      <li>
                                             <span><a href="${path}"><img src="${path }/resources/images/profile/jjim.png" alt="찜" style="width: 15px;height:15px;"></a></span>
                                             <span><a href="${path}"><img src="${path }/resources/images/profile/add-to-basket.png" alt="like" style="width: 15px;height:15px;"></a></span>
                
                                   </li>
                                    
                                </ul>
                            </div>
                     </div>
                  
                     </c:forEach>           
                              <!-- 절제선 -->
                      </div>
                              <div id="pageBar">${pageBar }</div>
                  </div>
               </div>
        </div>
     </div>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>