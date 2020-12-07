<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
     <link rel="stylesheet" href="${path }/resources/css/admin/directComment.css"/>
  <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<section id="content">
	
<script>
    $(document).ready(function(){
        //로드될때
        $(".tab_content").hide();//모든탭을 숨겨~~
        $('ul.tabs li:first').addClass("active").show();//액티브된 처음탭보여줘
        $('.tab_content:first').show();//show first tab content

        //On Click Event
        $("ul.tabs li").click(function(){
            $('ul.tabs li').removeClass('active');//Remove any 'active' class
            $(this).addClass('active').attr('color','blue');//셀렉트된탭을 active해라
            $('.tab_content').hide();//Hide all tab content

            var activeTab=$(this).find('a').attr('href');
            $(activeTab).fadeIn();//Fade in the active ID content
            return false;
        });
    });

</script>

<body>
    <div id="octionPage">

        <div id="wrapper">    
            <!--탭 메뉴 영역 -->
            <ul class="tabs">
                <li><a href="#tab1">대기중인<br> 목록</a></li>
                <li><a href="#tab2">완료된 <br>1:1문의</a></li>
                <li><a href="#tab3">admin답변등록</a></li>
               
            </ul>
        
        </div>

        <div class="tab-container-group">
            <!--탭 콘텐츠 영역 -->  

             <div id="tab1" class="tab_content">
                        <!--Content-->
                        <form action="" method="POST">
                            <div class="oction-searchbox">
                                <input type="search" class="input--text oction--input"/>
                                <button type="submit" class="btn btn-primary2">검색</button>
                            
                            </div>
                            </form>
                            <div class="admin-inquired">
                                <ul>
                                    <li>문의순</li>
                                    <li>완료순</li>
                                    <li>답변순</li>
                                   
                                </ul>

                            </div>

                            <div class="admin-inquired-content">
                                <h2>대기중인 1:1 목록</h2>
                                <table>
                                    <tbody>
                                        <tr>
                                            <th>번호</th>
                                            <th>아이디</th>
                                            <th>제목</th>
                                            <th>신고번호</th>
                                            <th>날짜</th>
                                           
                                     </tr>
                                        <tr>
                                            <td>1</td>
                                            <td>형님</td>
                                            <td>잘살고계세요?</td>
                                            <td>100033222</td>
                                            <td>20.12.8</td>
                                            <td>
                                                <button type="button" class="btn btn-primary2">답변</button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                            <!--Content-->
               
               </div>
             <div id="tab2" class="tab_content">
                <!--Content-->
                <form action="" method="POST">
                    <div class="admin-searchbox">
                        <input type="search" class="input--text oction--input"/>
                        <button type="submit" class="btn btn-primary2">검색</button>
                    
                    </div>
                    </form>
                    <div class="admin-inquired">
                        <ul>
                            <li>날짜순</li>
                            <li>완료순</li>
                            <li>답변순</li>
                           
                        </ul>

                    </div>

                    <div class="admin-inquired-content-end">
                        <h2>답변된 1:1 목록</h2>
                        <table>
                            <tbody>
                                <tr>
                                    <th>번호</th>
                                    <th>아이디</th>
                                    <th>제목</th>
                                    <th>신고번호</th>
                                    <th>날짜</th>
                                    <th>완료날짜</th>
                                    <th>처리상태</th>
                                   
                             </tr>
                                <tr>
                                    <td>1</td>
                                    <td>형님</td>
                                    <td>잘살고계세요?</td>
                                    <td>100033222</td>
                                    <td>20.12.8</td>
                                    <td>20.12.8</td>
                                    <td>완료</td>
                                    <td>
                                        <button type="button" class="btn btn-primary2">수정</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                    </div>
              
             </div>

                        
             
             
             <div id="tab3" class="tab_content">
                 <!--Content-->
                <div class="admin-inquired-recomment">
                    <div>
                        <h2>답변하기</h2>

                    </div>
                        <p><span>번호:</span><span>1</span></p>
                        <p>아이디:</p>
                        <p>내용:</p>
                        <p>게시물번호:</p>
                        <p>문의날짜:</p>
                    
                        <form action="" method="POST">
                            <div class="admin-inquired-recomment-group">
                                <div>
        
                                    <input type="text" class="input--text" placeholder="관리자아이디" readonly>
                                </div>
                                <textarea name="" id="" cols="30" rows="3" placeholder="답변">
        
                                </textarea>
                                <div>

                                    <button type="submit" class="btn btn-primary2">등록</button>
                                </div>
                            </div>
                          </form>
                    
                </div>
        
                </div>
              <div id="tab4" class="tab_content">
            
            
                        <!--Content-->
                        <div class="oction--header">
                            
                            
                        </div>    
                                                   <!-- 절제선 -->
                      </div>
        </div> <!-- tab-container -->
        
     </div>
                
                
	
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
