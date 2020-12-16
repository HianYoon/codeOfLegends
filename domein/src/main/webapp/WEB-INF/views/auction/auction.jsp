<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
   <link rel="stylesheet" href="${path }/resources/css/auction/auction.css"/>
  <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
  
     <c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
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
<section id="content">

 <div id="octionPage">

        <div id="wrapper">    
            <!--탭 메뉴 영역 -->
            <ul class="tabs">
                <li><a href="#tab1">입찰목록</a></li>
                <li><a href="#tab2">입찰등록</a></li>
                <li><a href="#tab3">입찰참여</a></li>
                <li><a href="#tab5">myOction<br>(판매자)</a></li>
               
            </ul>
        </div>
        <div class="tab-container-group">

       
            <!--탭 콘텐츠 영역 -->
            <div class="tab_container">
                
                    
                    <div id="tab1" class="tab_content">
                        <!--Content-->
                            <div class="oction--header">
                                <div class="oction-searchbox">
                                    <input type="search" class="input--text oction--input"/>
                                </div>
                                <ul>
                                    <li>인기순</li>
                                    <li>등록순</li>
                                    <li>마감순</li>
                                    <li>조회순</li>
                                </ul>
                                <ul class="grid">
                                    <li>
                                        <a href="#grid1">
                                            <img src="" alt="List">

                                        </a>
                                    </li>
                                    <li>
                                        <a href="#grid2">
                                            <img src="" alt="Grid">

                                          </a>
                                     </li>
                                </ul>
                            </div>
                        
                        <div id="grid1" class="oction-list-container">

                            <div class="oction_img">
                                <img src="#" alt="이미지" id="oction-img">
                                
                            </div> 
                            <div class="oction_textlist">
                                <a href="">
                                    
                                    <ul class="oction-list">
                                        <li><span>제목:</span>  
                                        </li>
                                        <li><span>상호명:</span></li>
                                        <li class="oction-dateBox"><span class="Oction-date">등록일:</span><span class="Oction-date">마감일:</span></li>
                                        
                                    </ul>
                                </a>
                            </div>
                            <div class="btn-oction-box">
                                        <p>조회수</p>
                                     <button class="btn">수정</button>    
                                     <button class="btn btn--primary">삭제</button>    
                                     <button class="btn btn--primary">참여</button>    
                                                
                            </div>
                              
                        </div>
                        
                        <!-- grid정렬 -->
                            <div id="grid2" class="oction-list-container">
                                <!-- grid-content -->
                                <div class="grid2-container">

                                    <!-- 절제선 -->
                                    <div class="oction--grid--container">
                       
                                        <div class="oction-img-group">
                                            <img id="big-target" src="" alt="이미지" data-zoom="3"/>
                                            
                                        </div>
                                        <div>
            
                                            <ul class="grid-text-group" style="padding:0">
                                                <li>제목</li>
                                                <li>상호명</li>
                                                <li><span>등록일</span><span>마감일</span></li>
                                                <li>조회수
                                                </li>
                                                  <li>
                                                         <span><a href=""><img src="" alt="찜" style="width: 15px;height:15px;"></a></span>
                                                         <span><a href=""><img src="" alt="like"></a></span>
                            
                                               </li>
                                                
                                            </ul>
                                        </div>
                                           
                                            
                                    
                                 </div>
                              
                                    <!-- 절제선 -->
                                </div>
                            </div>
                </div>
            </div>


            <!-- 입찰 등록 form -->
                <div id="tab2" class="tab_content">
                   <!--Content-->
                 <form action="" method="post" enctype="multipart/form-data" id="oction--form" >
                  
                       <div class="oction--register--img">
                           <h1>입찰 등록</h1>
                         
                               <input type="text" class="input--text inputMax" name="" placeholder="제목" required>
                               <input type="text" class="input--text inputMax" name="" placeholder="아이디" readonly>
                            <input type="text" class="input--text inputMax" name="" placeholder="상호명" readonly required>

                       
                        <div class="register-date-group">
                            <h4>입찰날짜</h4>
                            시작일:  <input type="date" class="input--text" name="" placeholder="시작일" id="startDate" required>
                            마감일:  <input type="date" class="input--text" name="" placeholder="마감일" id="endDate" required>
                        </div>
                        
                        <div class="register-date-group">
                            <h4>거래일자</h4>
                            시작일:  <input type="date" class="input--text" name="" placeholder="시작일" id="deleveryDate" required>
                            종료일:  <input type="date" class="input--text" name="" placeholder="마감일" id="deleveryEndDate" required>
                        </div>
                        
                        <div class="oction-img-container">
                            <div class="oction-img-file1">
                                
                            </div>
                            <div class="oction-img-file">
                                <input type="file" class="input--text upFile" id="upFile" name="imgFile"  multiple  readonly required />
                            
                            
                        </div>
                        
                    </div>
                    
                    
                    
                    
                    <textarea name="" id="" cols="30" rows="10" class="input-text"placeholder="요구사항">요구사항:
                    </textarea>
                    <div class="register-btn-group">
                        <button type="submit" class="btn btn--primary">등록하기</button>
                        <button type="reset" class="btn btn--primary">취소하기</button>
                    </div>
                </div>
                
                 </form>
                </div>
        
                <div id="tab3" class="tab_content">
                   <!--Content-->
                   <h1>참여form</h1>
                            <div class="joinform-container">
                                <div class="User-container">
                                    <div class="oction--img-joinform">
                                        <div>
                                            <img src="" alt="이미지" style="width:400px;height:400px; border: 1px solid red;">
                                            
                                            <p> <span class="small-img"><img src="" alt=""></span><span class="small-img"><img src="" alt=""></span><span class="small-img"><img src="" alt=""></span><span class="small-img"><img src="" alt=""></span><span class="small-img"><img src="" alt=""></span></p>
                                            

                                        </div>
                                    </div>
                                    <div class="buyerList">
                                        <ul class="usercontent">
                                            <li >title</li>
                                            <li >name</li>
                                            <li>입찰마감일:</li>
                                            <li><span >startDate</span><span >endDate</span></li>
                                            <li>납품예정일:</li>
                                            <li><span >deleveryDate</span><span >deleveryEndDate</span></li>
                                            <li >content</li>
                                        </ul>

                                    </div>

                                </div>
                                <h3>목록작성</h3>
                                <form action=""  method="POST" enctype="multipart/form-data" class="joinform">
                                   <div class="join-container">

                                       <div class="input-container">
                                           <div class="input-joingroup">
                                               <input type="text" id="productName" name="products" class="input--text" placeholder="품명" required>
                                               <input type="text" id="productQulity" name="products" class="input--text" placeholder="등급" required>
                                               <input type="text" id="productOrigin" name="products" class="input--text" placeholder="원산지"  required>
                                               <input type="text" id="productQuantity" name="products"class="input--text" placeholder="숫자"  required>
                                               
                                            </div>
                                            <div class="input-joingroup">
                                                <input type="text" id="measureUnit" name="products" class="input--text" placeholder="예)5kg또는20kgbox,box/set/개/kg/벌"  required>
                                                <input type="text" id="productPrice" name="products" class="input--text" placeholder="가격"  required>
                                                <input type="text" id="productDate" name="products" class="input--text" placeholder="생산일/요구사항이 있으면 기입" >
                                                <input type="text" id="productExpireDate" name="products" class="input--text" placeholder="유통기한" >
                                                
                                            </div>
                                            
                                        </div>
                                        <div>
                                            
                                            <button type="button" id="addInput" class="btn btn--primary2">추가</button>
                                            <button type="button" id="resetInput" class="btn btn--primary2">초기화</button>
                                        </div>
                                    </div>
                                    <div>
                                        <h3>품목명</h3>
                                        <p id="log"></p>
                                    </div>
                                    <div class="joinformBtn">
                                         <button type="submit" class="btn btn--primary">등록</button>
                                         <button type="reset" class="btn btn--primary">취소</button>
                                    </div>
                      
                                </form>
                            </div>      
                 
                </div>



       
                <!-- myOction(판매자페이지) -->
              <div id="tab5" class="tab_content">
                  <div class="OctionBuyer-text-container" >
                    <div class="action-container">

                        <div class="Oction-text-items">
                            
                            <ul>
                                <li><img src=""  class="big--img" alt="큰이미지" style="width:200px;height:200px; box-sizing: border-box; padding: 5px 3px 5px;"></li>
                                <li class="buyer-img"><span><img src="" alt=""></span>
                                    <span class="buyer-small-img"><img src="#" alt="img1"></span>
                                    <span><img src="#" alt="img2"></span>
                                    <span><img src="#" alt="img3"></span>
                                    <span><img src="#" alt="img4"></span>
                                    <span><img src="#" alt="img5"></span>
                                </li>
                            </ul>
                            <ul>
                                
                                <li><span>제목:</span><span>xxxxxxxxxxxxxx</span></li>
                                <li><span>구매자:</span><span>Col-company</span></li>
                                <li><span>입찰시작일:20.11.20 </span><span> 마감일:20.12.7</span></li>
                                <li><span>납품시작일:20.12.4 </span><span> 종료일:20.12.31</span></li>
                                <li><h4>요구사항</h4></li>
                                <li>
                                    
                                    <textarea name="" id="textarea" cols="20" rows="7" readonly>
                                        
                                    </textarea></li>
                                </ul>
                                
                                
                            </div>
                            <div class="slideshow-container">
                                
                                <div class="mySlides fade">
                                    <div class="numbertext">1 / 5</div>
                                    <img src="img_nature_wide.jpg" class="slideImg"  style="width:100%">
                                    <div class="text">Caption Text</div>
                                </div>
                                
                                <div class="mySlides fade">
                                    <div class="numbertext">2 / 5</div>
                                    <img src="img_snow_wide.jpg" class="slideImg" style="width:100%">
                                    <div class="text">Caption Two</div>
                                </div>
                                
                                <div class="mySlides fade">
                                    <div class="numbertext">3 / 5</div>
                                    <img src="img_mountains_wide.jpg" class="slideImg"  style="width:100%">
                                    <div class="text">Caption Three</div>
                                </div>
                                <div class="mySlides fade">
                                    <div class="numbertext">4 / 5</div>
                                    <img src="img_mountains_wide.jpg" class="slideImg"  style="width:100%">
                                    <div class="text">Caption Three</div>
                                </div>
                                <div class="mySlides fade">
                                    <div class="numbertext">5 / 5</div>
                                    <img src="img_mountains_wide.jpg" class="slideImg"  style="width:100%">
                                    <div class="text">Caption Three</div>
                                </div>
                                
                            </div>
                            <br>
                            
                            <div style="text-align:center">
                                <span class="dot"></span> 
                                <span class="dot"></span> 
                                <span class="dot"></span> 
                                <span class="dot"></span> 
                                <span class="dot"></span> 
                            </div>
                        </div>

                        <div class="OctionBuyerBar">
                             <ul>
                                 <li><a href="">Auction</a></li>
                                 <li><a href="">Q & A</a></li>
                                 <li><a href="">조회수</a></li>
                                 <li><a href="">참여수</a></li>
                             </ul>
                        </div>

                        <div class="choice-company-container">
                            <form action="">
                                <div class="choice-conpany-container">
                                    
                                    <ul>
                                        <li>
                                            <input type="radio" name="chocieCompany" value="" />
                                            
                                        </li>
                                        <li>A업체</li>
                                        <li>품목갯수:10개</li>
                                        <li>총가격: 2000원</li>
                                        <li>등록일자:</li>
                                        
                                    </ul>
                                </div>

                                
                                <!-- 모달스크립트 -->
                                <div class="modal-btn">
                                    
                                    <button id="modalOpen" class="btn btn--primary2">선택</button>
                                </div>
                                <div class="modal-wrapper1" style="display: none;">
                                    <div class="modal1">
                                        <div class="modal-title1">안녕하세요</div>
                                        <p>모달내용은 어쩌고 이러고..</p>
                                        <div class="close-wrapper1">
                                            <button id="modalSend" class="btn btn-primary2">최종선택</button>
                                            <button id="modalClose" class="btn btn-primary2">닫기</button>
                                        </div>
                                    </div>
                                </div>
                               
                               
                              
                            </form>
                              
                             <form action="" method="post" >
                                <div class="review-container">
                                         <!-- //점 이미지 -->
                                    <div class="top-comment"><span>업체</span><span><img src="" alt=""></span></div>
                                    <textarea name="" id="reviewComment" cols="30" rows="10" placeholder="문의사항을 남겨보세요!"></textarea>
                                    <div class="comment-group">
                                        <div >
                                            <span><img src="" alt="" class="comment-img"></span>
                                            <span><img src="" alt=""class="comment-img"></span>
                                        </div>
                                        <div>
                                           <p>등록</p>
                                        </div>
                                    </div>
                                </div>

                             </form>

            </div>
        </div>
       </div> 
	</div>
</div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
