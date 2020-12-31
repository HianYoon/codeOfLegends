<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>
	<c:set var="signedInMember" value="${signedInMember}"/>
  <link rel="stylesheet"
	href="${path }/resources/css/cart/cart.css" />
  <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
    
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value=""/>
</jsp:include>

<section id="content">
 <div id="octionPage">

        <div id="wrapper">    
            <!--탭 메뉴 영역 -->
            <ul class="tabs">
                <li><a href="#tab1">장바구니</a></li>
                <li><a href="#tab2">Action<br/>장바구니</a></li>
                <li><a href="#tab3">구매품목</a></li>
                <li><a href="#tab4">주문품목</a></li>
            
            </ul>
        </div>
        <div class="tab-container-group">

       
            <!--탭 콘텐츠 영역 -->
            <div class="tab_container">
                
                    
                    <div id="tab1" class="tab_content">
                        <!--Content-->
                        <h2>장바구니</h2>
              <c:choose>
                  <c:when test="${map.count }== 0">
                        		장바구니가 비어있습니다.
                     </c:when>
                  <c:otherwise>
                        	
                      
                      <form action="${path }" method="POST">
                        
                        <div class="cart-container">
                            <hr/>
                       <c:if test="${signedInMember !=null }" var="productList">
                         <c:forEach items="${map.list}" var="list" varStatus="status">
                           	<c:set value="${list.AMOUNT*list.PRICE }" var="sumPriceAmount" />
                                <div class="product-cart">
                                	<input type="hidden" value="${signedInMember.memberKey}" name="memberKey" id="memberKey"/>
                                	<input type="hidden" value="${list.PRODUCT_NO}" name="productNo" id="productNo"/>
                                    <input type="checkbox" name="cartCheck" value="${sumPriceAmount}" class="checkbox">
                                  

                                        <img src="${path }/resources/upload/product/${list.P_RENAMED_FILE_NAME}" alt="이미지">
                                        <div class="cartContent">

                                            <p>상품명:<c:out value="${list.TITLE }"/></p>
                                            <div id="cart--btnbox">
	                                            <input type="button" id="minus" onclick="minusDown(event,${list.PRODUCT_NO});" name="minus" value="-" />
	                                        	
		                                            <input type="text" id="amount" name="amount" value="${list.AMOUNT}" maxlength="" readonly/>
	                                   
	                                            <input type="button" id="plus" onclick="plusUp(event,${list.PRODUCT_NO});" name="plus" value="+" />
                                            </div>
                                              
                                            <div>가격
	                                            <input type="text" id="product-price" name="cartPrice" value="${sumPriceAmount}"readonly/>원
                                            </div>
            								<button type="button" id="cart--deleteBtn" onclick="deleteBtn(event);" class="btn btn-primary2">삭제</button>
                                        </div>
                                 
                   
                                 </div>
						</c:forEach>
                     </c:if>
                     
                                </div>
                                <hr/>
                                <div class="cart-total-price">
                                	<p>배송비: 100,000원 이하 5000원</p>
                                	<p id="All-qty"></p>
                                    <p >총가격:<span class="totlaPrice" id="total-price"></span>원</p>

                                </div>
                                <div class="cart-btn-group">
                                    <button type="button" id="checkbox"  class="btn btn-primary2">전체선택</button>
                                    <button type="button" id="deleteAllcart"  class="btn btn-primary2">삭제</button>
                                    <button type="button" id="" onclick="location.href='${path}/cart/cartIndex.do'" class="btn btn-primary2">쇼핑계속하기</button>
                                    <button type="submit" id=""  class="btn btn-primary2">결제하기</button>
                                </div>
                            </div>
                        </form>
               	</c:otherwise>
             </c:choose>
                 </div>
		<!--모달 박스  -->	
		
	 <div class="modal-wrapper" style="display: none;">
        <div class="modal">
            <div class="modal-title"><c:out value="${signedInMember.nickname }"/>님,진심입니까?</div>
            <p>당신의 선택은~~~~두구두구둥</p>
            <div class="close-wrapper1">
                <button id="modalSend" class="btn btn-primary2">구매하기</button>
                <button id="modalClose" class="btn btn-primary2">취소</button>
            </div>
        </div>
    </div>		
		<!--모달 박스  -->			

            <!-- 입찰 등록 form -->
                <div id="tab2" class="tab_content">
                    <h2>Action 거래중 COMPANY LIST</h2>

                    <form action="" method="POST">
                        <div class="cart-container">
                
                                <div class="product-cart">
                                     <input type="radio" name="cart-Oction" value="">
                                    <img src="" alt="이미지">
                                    
                                    <div class="cartContent">

                                        <p>제목:</p>
                                        <P>회사명</P>
                                        <P>거래일</P>
                                        <P>ORDER품목수:</P>
                                        
                                        <p>가격:</p>
        
                                    </div>
                                 </div>

                                </div>
                         
                                <div class="cart-total-price">
                                    <p>총가격:&nbsp;&nbsp;&nbsp;2000원</p>

                                </div>
                                <div class="cart-btn-group">
                                    <button type="button" id="" class="btn btn-primary2">주문하기</button>
                                </div>
                            </div>
                           
                      </form>
                         <!-- 구매한 품목 -->
                        <div id="tab3" class="tab_content">
                            <!--Content-->
                            <div class="date-search-group">
                                <form action="" method="POST">
                                    <input type="date" class="input--text">
                                    <input type="date" class="input--text">
                                    <button type="submit" class="btn btn--primary2">검색</button>
    
                                </form>

                            </div>
                            <h2>회사명</h2> 
                            <h3>주문날짜:20.11.20</h3>

                           
                            <div class="oction-orderList">
                                
                                <div class="end-list" style="">
                                    <div class="end-list-group .content">
                                        <ul>
                                            <li>번호</li>
                                            <li>상품명</li>
                                            <li>원산지</li>
                                            <li>등급</li>
                                            <li>갯수</li>
                                            <li>단위</li>
                                            <li>가격</li>
                                        </ul>
                                        <ul >
                                            <li>1</li>
                                            <li>등심</li>
                                            <li>수입:말레이시안</li>
                                            <li>등급</li>
                                            <li>2</li>
                                            <li>채</li>
                                            <li>500000원</li>
                                        </ul>

                                    </div>
                                    <div class="total-cart">
                                        <p>총 갯수:</p>
                                        <p>총 가격:</p>

                                    </div>
                                </div>
                            </div>
                            
                        </div>
                        
                        
                        
                        <!-- cart(주문 확인) -->
                        <div id="tab4" class="tab_content">
                            <!--Content-->
                            <div class="date-search-group">
                                <form action="" method="POST">
                                    <input type="date" class="input--text">
                                    <input type="date" class="input--text">
                                    <button type="submit" class="btn btn--primary2">검색</button>
    
                                </form>

                            </div>
                            <h2>회사명</h2> 
                            <h3>주문날짜:20.11.20</h3>

                           <form action="" method="POST">

                               <div class="oction-orderList">
                                   
                                   <div class="end-list" style="">
                                       <div class="end-list-group .content">
                                           <ul>
                                               
                                               <li>번호</li>
                                               <li>상품명</li>
                                               <li>원산지</li>
                                               <li>등급</li>
                                               <li>갯수</li>
                                               <li>단위</li>
                                               <li>가격</li>
                                               <li>선택</li>
                                           </ul>
                                           <ul >
                                               <li>1</li>
                                               <li>등심</li>
                                               <li>수입:말레이시안</li>
                                               <li>등급</li>
                                               <li>2</li>
                                               <li>채</li>
                                               <li>500000원</li>
                                               <li><input type="checkbox" name="orderEndUpdate"  class="cart-checkbox"></li>
                                           </ul>
   
                                       </div>
                                        <div class="total-cart">
                                            <p>총 갯수:</p>
                                            <p>총 가격:</p>

                                        </div>
                                   </div>
                                   <button type="submit" id="" class="btn btn-primary2">수정하기</button>
                               </div>
                           </form>
                            
                        </div>
                          
                </div>
                
                
    </div>
       
</section>

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
//ajax 개별상품 삭제
function deleteBtn(event){
	const productNo=$("#productNo").val();
	const memberKey=$("#memberKey").val();
	 
	  $.ajax({
		  url:"${path}/cart/delete.do",
		  type:"POST",
		  data:{
			  "productNo":productNo,
			  "memberKey":memberKey
		  },
		  success:function(data){
			  alert("상품이 삭제되었습니다.");
			 const cartContainer=document.querySelector(".cart-container");
			 const productCart=cartContainer.querySelector(".product-cart");
			 productCart.onclick=(e)=>{
				 const tag=e.target;
				 e.preventDefalut;
				 if(tag.nodeName !="INPUT") return;
				 //같은 이름의 클래스를 포함하고있느지를 물어볼때는 classList.contains='클래스이름'
				if(tag.classList.contains("btn btn-primary2")){
					const tr=tag.parentElement;
					for(;tr.nodeName != "TR"; tr=tr.parentElement);
						tr.parentElement.parentElement.remove();
				}				 
			 }
			 
		  }
	  })
};
 //플러스 수량더하기  

function plusUp(e,productNo){
const amount=$("#amount").val();// 양
const ss=$("#amount"+productNo).val(Number(amount)+1);
console.log(ss);
 $.ajax({
	url:"${path}/cart/addToAmount",
	type:"POST",
	data:{
		"productNo":productNo,
		"memberKey":memberKey,
		"amount": 1
	},
	success:(data)=>{
		successRoutine(data);
		cartSuccessRoutine(data,productNo,$("#amount"+productNo).val());
	},
	fail: error =>{
		console.log(error);
	}
}); 
};

//minus클릭시
function minusDown(e,poductNo){
	let amount=$("#amount").val();// 양
	const ss=$("#amount"+productNo).val(Number(amount)-1);
	console.log(ss);
	$.ajax({
		url:"${path}/cart/minusToAmount",
		type:"POST",
		data:{
			"productNo":productNo,
			"memberKey":memberKey,
			"amount":1
		},
		success:(data)=>{
			successRoutine(data);
			cartSuccessRoutine(data,productNo,$("#amount"+productNo).val());
		},
		fail: error =>{
			console.log(error);
		}
	});
	};

     
    //자바스크립트  체크박스선택
    const cartContainer=document.querySelector(".cart-container");//장바구니 감싸는 container
    const productCart=cartContainer.querySelector(".product-cart");//상품
    const allCheckInBox=document.querySelector("#checkbox");//체크박스버튼
    const delBtn=cartContainer.querySelector("cart--deleteBtn");//삭제버튼
    const checkbox=cartContainer.querySelector(".checkbox");//input checkbox
    
    allCheckInBox.onclick=function(){
    	const inputs=cartContainer.querySelectorAll("input[type='checkbox']");
    			
    			for (let i=0; i<inputs.length;i++)
	        		inputs[i].checked=allCheckInBox;//boolean값을 쓰기위해서 checked속성을 이용
    			console.log("true");
    };      
	              const open1=document.getElementById("modalOpen");
                  const close1=document.getElementById("modalClose");
                  const send=document.getElementById("modalSend");
                  const modal1=document.querySelector(".modal-wrapper");

		//총합계 cart
	 	function cartSuccessRoutine(data, productNo, amount){
			if($("input:checkbox[name='checkbox']").is(":checked") == true){
				console.log("찍히니?");
				const ckprice=$("input[type='checkbox']").val();
				ckprice.each(function(i){
					const totalprice = Number(ckprice[i].val());
					console.log(totalprice);
					$("#total-price").text(totalprice);
			});
			}
		};

</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
