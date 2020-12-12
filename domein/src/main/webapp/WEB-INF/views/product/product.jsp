<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
 <link rel="stylesheet" href="${path }/resources/css/product/product.css"/>
  <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
 
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>
<style>
/* tab Media */
    @media (max-width: 700px){
        div#octionPage {
            display: contents;
            justify-content: center;
            align-items: center;
            width: 700px;
            height: auto;
        }
        div#wrapper {
            display: block;
            width: 100%;
            height: auto;
        }
        ul.tabs {
            display: flex;
            width: 700px;
            height:auto;
            background: #ffca28;
            margin: 0!important;
            
        }
        ul.tabs li{
            width: 100%;
            height:40px;
            margin-bottom: 10px;
           
        }
        .tabs li a{
            font-size: 18px !important;
            font-weight: 500;
        }
        .clearfix{
            content:"";
            clear: both;
            display: block;
        }
    }



/* 슬라이드 이미지 */
.slideshow-container{
    display: none;
}

body {
  box-sizing: border-box;
  font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {
  width:500px;
  height: 200px;
  vertical-align: middle;
 
}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.dot.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}
.tab_content{
    display:block;
    width: 900px;
    height: auto;
    

}
.direct-Product-container{
    display: block;
    width: 800px;
    height: auto;
    justify-content: center;
    align-content: center;
}
.product-textgroup {
    width: 600px;
    display: grid;
    grid-template-columns: auto;
    align-items: center;
    height: auto;
}
.product-textgroup input{
    margin-bottom: 10px;
}
.direct-img-file {
    width: 600px;
    height: 50px;
}
.direct-Product-container textarea {
    width: 600px;
    margin: 10px 0;
    border-radius: 5px;
}
.direct-btn-group {
    display: flex;
    margin: 10px 0;
    padding: 10px;
}
.direct-btn-group button{
    margin: 0 10px;
}
/* 상품list/ */
.oction--header {
    display: block;
      width: 900px;
      height: auto;
  }
  .oction-searchbox {
      display: flex;
      justify-content: center;
      align-items: center;
      margin-top: 10px;
  }
  .product--search-list ul{
      display: flex;
      justify-content: flex-end;
      align-items: center;
  }
  .product--search-list ul li{
      margin-right: 15px;
      
  }
  img#big-target {
    width: 180px;
    height: 150px;
}
.grid2-container {
    display: grid;
    grid-template-columns: auto auto auto auto auto;
    gap: 10px;
}
.oction--grid--container {
    width: 100%;
    height: auto;
    box-sizing: border-box;
}








@media (max-width: 700px){
    #oction-page{
        width: 700px;
        height: auto;
        margin: none;
        padding: none;
    }
    .tab_content{
        display:none;
    
        
    }
    .direct-Product-container {
        width: 600px;
        height: auto;
        display: block;
        justify-content: center;
        box-sizing: border-box;
      
    }
    .product-textgroup {
        width: 100%;
        display: grid;
        grid-template-columns: auto;
        align-items: center;
        height: auto;
    }
    .product-textgroup input{
        width:500px;
    }
 
    .direct-Product-container textarea {
        width: 500px;
        margin: 10px 0;
        border-radius: 5px;
    }
    .input-container input{
        width: 500px;
        height: 40px;
        margin-bottom: 10px;
    }
    div.double-date span input[type="date"] {
        width: 150px !important;
    }
    .product-register-btn{
        display: flex;
        justify-content: start;
        align-items: center;
    }
    .double-date {
        width: 300px;
        height: auto;
        box-sizing: border-box;
    }
    div.double-date input{
        width: 300px;
    }
    .product-register-btn button{
        margin-right: 20px;
    }
    .joinformBtn {
        display: flex;
    }
    .joinformBtn button{
       margin-right: 20px;
       
    }
    /* 상품List */

    .product--search-list ul {
        display: flex;
        justify-content: end;
        align-items: center;
        margin-bottom: 30px;
    }
  div#grid2 {
      width: 700px;
      height: auto;
           
        }
        .oction--grid--container {
            width: 70%;
            height: auto;
            position: relative;
        }
        .oction-img-group {
            display: block;
            width: 100%;
            height: 180px;
            margin-bottom: 5px;
            font-size: 15px;
            font-weight: 400;
            border: 1px solid red;
            box-sizing: border-box;
        }
        img#big-target {
            width: 150px !important;
            height: 150px;
        }
        .grid2-container {
            width: 700px;
            height: auto;
            gap: 30px;
            display: grid;
            grid-template-columns: auto auto  !important;
          
        }
}
        /* common */
ul li{
    list-style-type: none;
}

 /* 전체 html display  flex*/
 #octionPage{
    display:flex;
    width: 1200px;
    height: auto;
    gap:50px;
   
}
.tab-container-group{
    width:900px;
    height:auto;
    margin:10px 30px;
}
div#wrapper {
    width: 200px;
    background: #ffca28;
}
.tab-container-group{
    width:900px;
    height:auto;
    margin:10px 30px;
}

.tabs{
    margin-top: 80px;
}
.tabs li{
    list-style-type: none;
    margin-top: 20px;
}
.tabs li a{
    font-size: 30px;
    color:black;
}
a{
    text-decoration: none;
    color: black;
}

        /* 버튼 설정 */
.btn{
    height:35px;
    background:#eee linear-gradient(to bottom, #fcfcfc,#eee);
    border: 1px solid #d5d5d5;
    border-radius: 4px;
    /* display:inline-flex로 하게되면 안에 글자에 맞게 좌우로 크기가 변경됨ㄴ */
    display:flex;
    align-items: center;
    padding: 0 12px;
    font-size :14px;
    font-weight:1000;
    line-height: 1.5;
    /* 마우스가 올라갓을때 손가락모양으로 바뀌게 */
    cursor: pointer;
    /* 패딩이나 margin이 들어갓을때 커지는것을막아주는 css명령어 */
    box-sizing: border-box;
    position:relative;
}
.btn:hover::before{
    content:'';
    position:absolute;
    top:0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0,0,0,0.07);
}
.btn.btn--primary{
    border: 1px solid ;
    color: #fff;
    background: #1976d2 linear-gradient(#004ba0,#1976d2);

}
/* input설정 */
.input--text{
    height: 34px;
    padding:0 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-sizing: border-box;
    /* a태그 포커스 없애는css outline */
    outline:none;
    /* input안에 쉐도우가 생기게하는 inset추가 */
    box-shadow: inset 0 1px 2px rgba(0,0,0,0.075);
    font-size: 16px;
    
}
.input--text:focus{
    border-color: #51a7e8;
    box-shadow:inset 0 1px 2px rgba(0,0,0,0.075),
                    0 0 5px rgba(81,167,232,0.5);
}
/* Vendor Prefix(브라우저 업체별 접두사) */
.input--text::-webkit-input-placeholder{color:#cacaca;}
.input--text::-ms-input-placeholder{color:#cacaca;}
.input--text::-moz-input-placeholder{color:#cacaca;}
</style>
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

   <div id="octionPage">

        <div id="wrapper">    
            <!--탭 메뉴 영역 -->
            <ul class="tabs">
                <li><a href="#tab1">판매등록</a></li>
                <li><a href="#tab2">Action 참여</a></li>
                <li><a href="#tab3">상품수정</a></li>
                <li><a href="#tab4">상품List</a></li>
            </ul>
        
        </div>

        <div class="tab-container-group">


            <!--탭 콘텐츠 영역 -->
            
               

                 <div id="tab1" class="tab_content">
                        <!--Content-->
                            <!--Content-->
                 <div class="direct-Product-container">
                 
                		<form action="${path}/boardSaleContent/insert.do" method="post">
                                <label for="category-select">카테고리품목</label>
                                <select name="category" id="category-select">
                                    <option value="1">정육</option>
                                    <option value="2">수산</option>
                                    <option value="3">야채</option>
                                    <option value="4">과일</option>
                                    <option value="5">커피</option>
                                    <option value="6">애견</option>
                                    <option value="7">제과</option>
                                    <option value="8">기타</option>
                                </select>
                               
                                <input type="text" class="input--text" name="title" placeholder="제목"  required>
								 <textarea name="saleContent" id="" cols="30" rows="10" class="input-text"placeholder="내용설명">내용설명:
                       			 </textarea>
                       	 <div class="direct-btn-group">
		                            <button type="submit" class="btn btn--primary">등록하기</button>
		                            <button type="reset" class="btn btn--primary">취소하기</button>
                        </div>
                		</form>
                        <form action="${path }/product/insert.do" method="post" enctype="multipart/form-data" id="oction--form" >
                        
                            <div class="direct--product--img">
                                <h1>상품 등록</h1>
                            </div>
                             <select name="productStatusNo" id="productStatusNo">
                                	<option value="1" >판매시작</option>
                                	<option value="0">판매중단</option>
                                	
                                </select>
                            <div class="product-textgroup">

                                <input type="text" class="input--text" name="productName" placeholder="상품명" required>
                                <input type="text" class="input--text" name="Origin" placeholder="원산지" required>
                                <input type="text" class="input--text" name="productQuality" placeholder="등급" required>
                                <input type="text" class="input--text" name="productQuantity" placeholder="수량" required>
                                <input type="text" class="input--text" name="measureUnit" placeholder="단위:box/20kg-box/set/개/kg"required>
                                <input type="text" class="input--text" name="price" placeholder="가격"  required>
                               
                            </div>
                                
                                <div class="direct-img-container">
                                    <div class="direct-img-file1">
                                                
                                    </div>
                                    <div class="direct-img-file">
                                        <input type="file" class="input--text upFile" id="upFile" name="upFile" multiple="multiple" required />
                                  
        
                                    </div>
        
                                </div>
                          
                        <div class="direct-btn-group">
                            <button type="submit" class="btn btn--primary">등록하기</button>
                            <button type="reset" class="btn btn--primary">취소하기</button>
                        </div>
                    </form>
                    
                 </div>           
             </div>
     
             <div id="tab2" class="tab_content">
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
                                         <li name="title">title</li>
                                         <li name="name">name</li>
                                         <li>입찰마감일:</li>
                                         <li><span name="">startDate</span><span name="">endDate</span></li>
                                         <li>납품예정일:</li>
                                         <li><span name="">deleveryDate</span><span name="">deleveryEndDate</span></li>
                                         <li name="content">content</li>
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
                                   		  <textarea name="" id="" cols="30" rows="10" class="input-text"placeholder="내용설명">
                       					 </textarea>
                                     <div class="product-register-btn">
                                         
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

                        
             
             
             <div id="tab3" class="tab_content">
                 <!--Content-->
                 <div class="direct-Product-container">
                     
                     <form action="" method="post" enctype="multipart/form-data" id="oction--form" >
                        
                        <div class="direct--product--img">
                            <h1>상품 수정</h1>
                        </div>
                        <div class="product-textgroup">
                            
                            <input type="text" class="input--text" name="" placeholder="상품명" required>
                            <input type="text" class="input--text" name="" placeholder="원산지" required>
                            <input type="text" class="input--text" name="" placeholder="수량"  required>
                            <input type="text" class="input--text" name="" placeholder="단위:box/20kg-box/set/개/kg"  required>
                            <input type="text" class="input--text" name="" placeholder="가격"  required>
                            
                        </div>
                        
                        <div class="direct-img-container">
                            <div class="direct-img-file1">
                                
                            </div>
                            <div class="direct-img-file">
                                <input type="file" class="input--text upFile" id="upFile" name="imgFile"  multiple  readonly required />
                        
                        </div>
                        
                    </div>
                    

                    <div class="direct-btn-group">
                        <button type="submit" class="btn btn--primary">등록하기</button>
                        <button type="reset" class="btn btn--primary">취소하기</button>
                    </div>
                </form>
            </div>           
        </div>
        
        <div id="tab4" class="tab_content">
            
            
            <!--Content--> 
            <div class="oction--header">
                <form action="" method="Post">
                    <div class="oction-searchbox">
                        <input type="search" class="input--text oction--input"/>
                        <button type="submit" class="btn btn-primary2">검색</button>
                       
                    </div>
                    </form>
                 <div class="product--search-list">
                     <ul>
                         <li>인기순</li>
                         <li>등록순</li>
                         <li>마감순</li>
                         <li>조회순</li>
                     </ul>
                     
                     
                 </div>   
            </div>
            
            
            
            
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
     </div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
