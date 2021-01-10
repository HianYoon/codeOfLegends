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
                <li><a href="#">구매품목</a></li>
                <li><a href="#">주문품목</a></li>
            
            </ul>
        </div>
        <div class="tab-container-group">

       
            <!--탭 콘텐츠 영역 -->
            <div class="tab_container">
                
                    
                    <div id="tab1" class="tab_content">
                        <!--Content-->
                        <h2>장바구니</h2>
           <c:if test="${signedInMember != null}">             
              <c:choose>
                  <c:when test="${map.count == 0}">
                        		장바구니가 비어있습니다.
                     </c:when>
                  <c:otherwise>
                        	
                   <%--   <c:when test="${map.count != 0}"> --%>
                      <form  id="orderForm" action="${path}/cart/goToOrder.do?memberKey=${signedInMember.memberKey}" method="POST">
                        
                        <div class="cart-container">
                            <hr/>
                       <c:if test="${signedInMember !=null }" var="productList">
                         <c:forEach items="${map.list}" var="list" varStatus="status">
                           	<c:set value="${list.AMOUNT*list.PRICE }" var="sumPriceAmount" />
                                <div data-tr_value="$" class="product-cart">
                                	<input type="hidden" value="${signedInMember.memberKey}" name="memberKey" id="memberKey"/>
                                	<input type="hidden" value="${list.PRODUCT_NO}" name="productNo" id="productNo"/>
                                	<input type="hidden" name="chk[]" id="chk" value=""/>
                                    <input type="checkbox" name="cartCheck" value="${sumPriceAmount}" data-cartNum="${list.PRODUCT_NO}" class="checkbox">
                                  

                                     <a  href="${path }/product/productDetail.do?productNo=${list.PRODUCT_NO}" ></a><img src="${path }/resources/upload/product/${list.P_RENAMED_FILE_NAME}" alt="이미지"></a>
                                        <div class="cartContent">

                                            <p>상품명:<c:out value="${list.TITLE }"/></p>
                                            <div id="cart--btnbox">
	                                            <input type="button" id="minus"  name="minus" value="-" />
	                                        	
		                                            <input type="text" id="amount" name="amount" value="${list.AMOUNT}" maxlength="" readonly/>
	                                   
	                                            <input type="button" id="plus"  name="plus" value="+" />
                                            </div>
                                              
                                            <div>가격
	                                            <input type="text" id="product-price" name="cartPrice" value="${sumPriceAmount}"readonly/>원
	                                            <input type="hidden" id="product--price" name="price" value="${list.PRICE}"readonly/>
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
                                    <p >총가격:<span class="totlaPrice" id="total-price">0</span>원</p>

                                </div>
                                <div class="cart-btn-group">
                                    <button type="button" id="checkbox"  class="btn btn-primary2">전체선택</button>
                                    <button type="button" id="" onclick="location.href='${path}/cart/cartIndex.do'" class="btn btn-primary2">쇼핑계속하기</button>
                               
                                    <button type="submit" id="orderToPay" class="btn btn-primary2">결제하기</button>
                                 
                                </div>
                            </div>
                        </form>
                     <%--    </c:when>  --%>
               	</c:otherwise>
             </c:choose>
                 </div>
          </c:if>
       <c:if test="${signedInMember == null}">
              <c:choose>
                  <c:when test="${map.count }== 0">
                        		장바구니가 비어있습니다.
                     </c:when>
                  <c:otherwise>
                        	
                      
                      <form action="${path}/cart/orderToPay.do" method="POST">
                       
                        <div class="cart-container">
                            <hr/>
                
                         <c:forEach items="${nomlist}" var="nomlist" varStatus="status">
                           	<c:set value="${nomlist.amount*nomlist.price }" var="sumPriceAmount" />
                                <div data-tr_value="$" class="product-cart">
                                	<input type="hidden" value="${signedInMember.memberKey}" name="memberKey" id="memberKey"/>
                                	<input type="hidden" value="${nomlist.productNo}" name="productNo" id="productNo"/>
                                    <input type="checkbox" id="chk" name="cartCheck" value="${sumPriceAmount}" class="checkbox" data-cartNum="${nomlist.productNo}">
                                  

                                     <a  href="${path }/product/productDetail.do?productNo=${nomlist.productNo}" ></a><img src="${path }/resources/upload/product/${nomlist.renamedFileName}" alt="이미지"></a>
                                        <div class="cartContent">

                                            <p>상품명:<c:out value="${nomlist.title }"/></p>
                                            <div id="cart--btnbox">
	                                            <input type="button" id="minus"  name="minus" value="-" />
	                                        	
		                                            <input type="text" id="amount" name="amount" value="${nomlist.amount}" maxlength="" readonly/>
	                                   
	                                            <input type="button" id="plus"  name="plus" value="+" />
                                            </div>
                                             
                                            <div>가격
	                                            <input type="text" id="product-price" name="cartPrice" value="${sumPriceAmount}"readonly/>원
	                                            <input type="hidden" id="product--price" name="price" value="${nomlist.price}"readonly/>
                                            </div>
            								<button type="button" id="cart--deleteBtn" onclick="location.replace='${path}/cart/nonDeleteBtn'" class="btn btn-primary2">삭제</button>
                                        </div>
                                 
                   
                                 </div>
						</c:forEach>
                   
                     
                                </div>
                                <hr/>
                                <div class="cart-total-price">
                                	<p>배송비: 100,000원 이하 5000원</p>
                                	<p id="All-qty"></p>
                                    <p >총가격:<span class="totlaPrice" id="total-price">0</span>원</p>

                                </div>
                                <div class="cart-btn-group">
                                    <button type="button" id="checkbox"  class="btn btn-primary2">전체선택</button>
                                    <button type="button" id="" onclick="location.href='${path}/cart/cartIndex.do'" class="btn btn-primary2">쇼핑계속하기</button>
                               
                                    <button type="button" id="orderToPay" onclick="location.href='${path}/memberLogin.do'" class="btn btn-primary2">결제하기</button>
                                 
                                </div>
                            </div>
                      
                        </form>
               	</c:otherwise>
             </c:choose>
                 </div>
       </c:if>
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
	
	if($("input[type=checkbox]").prop("checked")){
		$("input[type=checkbox]").prop("checked",true);
	}else{
		$("input[type=checkbox]").prop("checked",false);
	}
	if(confirm("삭제하시겠습니까?")){
		$("input[name=checkRow]:checked").each(function(){
			let tr_value=$(this).val();
			let tr=$("tr[data-tr_value='"+tr_value+"']");
			tr.parent().remove();
		});
	}else{
		return false;
	}
	 
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
					for(;tr.className != "cart-container"; tr=tr.parentElement);
						tr.parentElement.parentElement.remove();
				}				 
			 }
			 
		  }
	  })
};
 //플러스 수량더하기  
/*  $(function(){
	$("#plus").click(function(){
		let n=$("#plus").index(this);//자기자신을 가르킨다.
		let num=$("#amount:eq("+n+")").val();
		num=$("#amount:eq("+n+")").val(num*1+1);
		console.log(num);
	});
	$("#minus").click(function(){
		let n=$("#minus").index(this);//자기자신을 가르킨다.
		let num=$("#amount:eq("+n+")").val();
			num=$("#amount:eq("+n+")").val(num*1-1);
	});
	
})*/
$(document.body).on("click","#plus",function(){
	
	 let productCart=$(this).closest(".product-cart");//전체를 감싸는 div
	 const amount=productCart.find("#amount");//수량
	 let cheprice=productCart.find(".checkbox");//체크박스
	 let inputs=productCart.find("input[name=cartCheck]");//input 태그 
	 let totalPrice=$(".totlaPrice");//총가격
	 const n=amount.val();//수량
	 const sum=Number(n)+1;
	 amount.val(sum);
	 const price=productCart.find("#product-price");
	 const changePrice=parseFloat(price.val());
	 const total=productCart.find("#product--price");//개당 가격
	 console.log("plus");
	 const totalprice=Number(total.val());
	 price.val(sum*totalprice);//총가격 
	 cheprice.val(sum*totalprice);
	 if(inputs.is(":checked")==true){
		alert("안되냐?");
		totalPrice.text(sum*totalprice);
	 }else if(inputs.is(":checked")==true && Number(totalPrice.text()) !== 0){
		 totalPrice.text(Number(totalPrice.text())+(sum*totalprice));
	 }else{
		 totalPrice.text(0);
	 }
});
$(document.body).on("click","#minus",function(){
	
	 let productCart=$(this).closest(".product-cart");
	 let amount=productCart.find("#amount");
	 let cheprice=productCart.find(".checkbox");
	 let inputs=productCart.find("input[name=cartCheck]");
	 let totalPrice=$(".totlaPrice");
	 let n=amount.val();//수량
	 let sum=Number(n)-1;
	 if(sum>0){
	 amount.val(sum);
	 const price=productCart.find("#product-price");
	 const changePrice=parseFloat(price.val());
	 const total=productCart.find("#product--price");
	 console.log("minus");
	 const totalprice=Number(total.val());
	 price.val(sum*totalprice);//총가격 
	 cheprice.val(sum*totalprice); 
	 
	 if(inputs.is(":checked")==true){
			alert("안되냐?");
			console.log(sum*totalprice);
			totalPrice.text(sum*totalprice);
		 }
	 }else return;
});

 
/* function plusUp(e,productNo){
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
 */
     
    //자바스크립트  체크박스선택
    const cartContainer=document.querySelector(".cart-container");//장바구니 감싸는 container
    const productCart=cartContainer.querySelector(".product-cart");//상품
    const allCheckInBox=document.querySelector("#checkbox");//체크박스버튼
    const delBtn=cartContainer.querySelector("cart--deleteBtn");//삭제버튼
    const checkbox=cartContainer.querySelector(".checkbox");//input checkbox
    
    allCheckInBox.onclick=function(){
    	const inputs=cartContainer.querySelectorAll("input[type='checkbox']");
    	alert("진짜냐");
    		if($("input:checkbox[name=cartCheck]").is(":checked") ==false){
    			$("input[type='checkbox']").prop("checked",true);
    			console.log("1");
    		}else {
    			$("input[type='checkbox']").prop("checked",false);
    			 $(".totlaPrice").text(0);
    		}
    		//	for (let i=0; i<inputs.length;i++)
	        //		inputs[i].checked=allCheckInBox;//boolean값을 쓰기위해서 checked속성을 이용
    		//	console.log("true");
    		
	    //체크박스 선택시 총 가격구하기
	    //checkbox의 name값이 current_product이면서 체크되어 있는 함수를 each함수로 호출한다. 
	    
	    let sum=0;//담을 값을 선언해준다.
	    $("input[name=cartCheck]:checked").each(function(i){
	    				sum +=Number($(this).val());
	    				console.log(sum);
	    				$(".totlaPrice").text(sum);	
	    });
    };      
    $(".checkbox").click(function(){
    	if($("input:checkbox[name=cartCheck]").is(":checked") ==true){
    		alert("체크됨");
    	    let sum=0;//담을 값을 선언해준다.
    	    $("input[name=cartCheck]:checked").each(function(i){
    	    				sum +=Number($(this).val());
    	    				console.log(sum);
    	    				$(".totlaPrice").text(sum);	
    	    });
    	}else if($("input:checkbox[name=cartCheck]").is(":checked") ==false){
    		alert("안 체크됨");
    		   let sum=0;//담을 값을 선언해준다.
       	    $("input[name=cartCheck]:checked").each(function(i){
       	    				sum -=Number($(this).val());
       	    				console.log(sum);
       	    				$(".totlaPrice").text(sum);	
       	    });
    	}else{
    		$(".totlaPrice").text(0);	
    	}
    })
	              const open1=document.getElementById("modalOpen");
                  const close1=document.getElementById("modalClose");
                  const send=document.getElementById("modalSend");
                  const modal1=document.querySelector(".modal-wrapper");
			//구매버튼 이벤트 
			$(document.body).on("click","#orderToPay",function(){
				if(confirm("구매하시겠습니까?")){
					if($("input:checkbox[name=cartCheck]").is(":checked").length != 0){
		    			
		    		}else{
		    			confirm("선택된 상품이 없습니다.");
		    		}
					
				}
			});	
			$("#orderToPay").click(function(){
				var checkArr=new Array();
				//checked되어있는 row에 data-cartNum 속성값을 가져와 array에 넣어준다
				$("input[class='checkbox']:checked").each(function(){
					checkArr.push($(this).attr("data-cartNum"));
					
				});
				//input hidden으로 되어있는 id가 chk에 배열을 넣어준다.
				//넣어주면 chk[]이름으로 controller에 넘어가 method에서 @RequestParam으로 받기만 해주면된다.
				$("#chk").val(checkArr);
				if(confirm("주문완료 하시겠습니까?")){
					alert("주문감사합니다.");
					$("#orderForm").submit();
				}
			})	
				
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
