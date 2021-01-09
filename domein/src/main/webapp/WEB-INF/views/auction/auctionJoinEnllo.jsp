<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <c:set var="path" value="${pageContext.request.contextPath }"/>    
<link rel="stylesheet"
	href="${path }/resources/css/auction/auction.css" />
  <link rel="stylesheet" href="${path }/resources/css/jihunTab/TabMedia.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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

        <div class="tab-container-group">

       
            <!--탭 콘텐츠 영역 -->
            <div class="tab_container">
                
                    
                 
        
                <div id="tab3" class="tab_content">
                   <!--Content-->
                   <h1>참여form</h1>
                   
                   <c:forEach items="${auction}" var="auction">
                            <div class="joinform-container">
                                <div class="User-container">
                                    <div class="oction--img-joinform">
                                        <div class="joinImg">
                                            <img src="${path}/resources/upload/boardauction/file/${auction.RENAMED_FILE_NAME}" alt="이미지" style="width:400px;height:250px; border: 1px solid red;">
                                            
                                            <p>
                                             <span class="small-img">
                                            	<img src="${path}/resources/upload/boardauction/file/${auction.RENAMED_FILE_NAME}" alt="">
                                            </span>
                                            </p>
                                            

                                        </div>
                                    </div>
                                    <div class="buyerList">
                                        <ul class="usercontent">
                                            <li >제목: ${auction.TITLE}</li>
                                            <li >사업자명: ${auction.BUSINESS_NAME}</li>
                                            <li><span >시작일:<fmt:formatDate value="${auction.START_DATE}" pattern="yyyy-MM-dd"/></span>
                                            <span >마감일:<fmt:formatDate value="${auction.END_DATE}" pattern="yyyy-MM-dd"/></span></li>
                                           
                                            <li >${auction.CONTENT}</li>
                                        </ul>

                                    </div>
                                </div>
                                <h3>목록작성</h3>
                                <form action="${path }/auction/joinEnlloEnd.do?=articleNo=${auction.ARTICLE_NO}"  method="POST" enctype="multipart/form-data" class="joinform">
                                   <div class="join-container">

                                       <div class="input-container">
                                           <div class="input-joingroup">
                                           
                                           		<input type="hidden" id="articleNo" name="articleNo" value="${auction.ARTICLE_NO}"/>
                                           		<input type="hidden" id="writerKey" name="writerKey" value="${auction.BUSINESS_KEY}"/>
                                           		<input type="hidden" id="bidStatusNo" name="bidStatusNo" value="1"/>
                                           
									</c:forEach>
                                               <input type="text" id="productName" name="products" class="input--text" placeholder="품명" required>
                                               <input type="text" id="productQuality" name="products" class="input--text" placeholder="등급/없으면 무"  value="" required>
                                               <input type="text" id="productOrigin" name="products" class="input--text" placeholder="원산지"  required>
                                               <input type="text" id="Quantity" name="products"class="input--text" placeholder="양"  required>
                                               
                                            </div>
                                            <div class="input-joingroup">
                                                <input type="text" id="measureUnit" name="products" class="input--text" placeholder="예)5kg또는20kgbox,box/set/개/kg/벌"  required>
                                                <input type="text" id="price" name="products" class="input--text" placeholder="가격"  required>
                                            </div>
                                            
                                        </div>
                                        <div>
                                            
                                            <button type="button" id="addList" class="btn btn--primary2">추가</button>
                                            <button type="button" id="selectList" class="btn btn--primary2">목록불러오기</button>
                                        </div>
                                    </div>
                                    <div>
                                        <h3>품목명</h3>
                                        <div id="log">
                                        	<table class="table table-striped">
                                        		<thead>
                                        			 <tr>
													    <th>번호</th>
														<th>상품명</th>
														<th>원산지</th>
														<th>등급</th>
														<th>양/갯수</th>
														<th>단위</th>
														<th>가격</th>
													 </tr>
                                        		</thead>
                                        		<tbody id="appendTo">
                                        		</tbody>
                                        	</table>
                                        </div>
                                    </div>
                                    <div class="joinformBtn">
                                         <button type="button" class="btn btn--primary" onclick="location.href='${path}/auction/auctionList.do'">완료</button>
                                          <c:forEach items="${auction}" var="auction">
                                        	 <button type="reset" class="btn btn--primary" onclick="location.href='${path}/auction/listAlldelete.do?articleNo=${auction.ARTICLE_NO}&writerKey=${auction.BUSINESS_KEY}'">취소</button>
                                  		</c:forEach>
                                    </div>
                      
                                </form>
                            </div>      
                 
                </div>



       
	</div>
</div>
</section>
<script type="text/javascript">

	
	//listReply2();//json리턴방식
	$("#addList").click(function(){
		let articleNo=$("#articleNo").val();
		console.log(articleNo);
		let writerKey=$("#writerKey").val();
		let bidStatusNo=$("#bidStatusNo").val();
		let productName=$("#productName").val();
		let productQuality=$("#productQuality").val();
		let productOrigin=$("#productOrigin").val();
		let Quantity=$("#Quantity").val();
		let measureUnit=$("#measureUnit").val();
		let price=$("#price").val();
		const bid="articleNo="+articleNo+"&writerKey="+writerKey+"&bidStatusNo="+bidStatusNo+
		"&productName="+productName+"&productQuality="+productQuality+"&productOrigin="+productOrigin+"&Quantity="+Quantity+
		"&measureUnit="+measureUnit+"&price="+price;
		
		$.ajax({
			type:"get",
			url:"${path}/auction/joinWriter.do",
			contentType:"application/json",
			dataType:"json",
			data:bid,
			success: function(result){
				alert("추가되었습니다.");
				//listReply2();
				console.log(result);
				let output="";
				/* output="<table class='table table-striped'";
				output="<thead>";
				output="<tr>";
				output="<th>번호</th>";
				output="<th>상품명</th>";
				output="<th>원산지</th>";
				output="<th>등급</th>";
				output="<th>양/갯수</th>";
				output="<th>단위</th>";
				output="<th>가격</th>";
				output="</tr>";
				output="</thead>"; */
				//arrayList로 출력할시에는 for in문이 아닌 for문으로 해야한다.
				//불러올시에는 bd컬럼명하고 똑같아야한다.
				for(let i =0;i <result.length; i++){
					output += "<tr>";
					
					output +="<td>"+result[i].BID_KEY+"</td>";
					output +="<td>"+result[i].PRODUCT_NAME+"</td>";
					output +="<td>"+result[i].PRODUCT_ORIGIN+"</td>";
					output +="<td>"+result[i].PRODUCT_QUALITY+"</td>";
					output +="<td>"+result[i].PRODUCT_QUANTITY+"</td>";
					output +="<td>"+result[i].MEASURE_UNIT+"</td>";
					output +="<td>"+result[i].PRICE+"</td>";
					output +="<td><input type='button' class='btn btn-Primary2' onclick='listUpdate();' value='수정'>";
					output +="<td><input type='button' class='btn btn-Primary2' id='listdelete' value='삭제' >";
					output +="</tr>";	
				}
			/* 	output +="</tbody>";
				output += "</table>"; */
				$("#appendTo").html(output);
			}
		});
		
	});
 

		$("#selectList").click(function(){
			let articleNo=$("#articleNo").val();
			console.log(articleNo);
			let writerKey=$("#writerKey").val();
			const list="articleNo="+articleNo+"&writerKey="+writerKey;
			$.ajax({
				type:"get",
				url:"${path}/auction/Selectlist",
				contentType:"alication/json",
				dataType:"json",
				data:list,
				success:function(data){
					console.log(data);
					let output="";
				//	output="<table class='table table-striped'>";
		/* 			output="<thead>";
					output="<tr>";
					output="<th>번호</th>";
					output="<th>상품명</th>";
					output="<th>원산지</th>";
					output="<th>등급</th>";
					output="<th>양/갯수</th>";
					output="<th>단위</th>";
					output="<th>가격</th>";
					output="</tr>";
					output="</thead>"; */
					//output="<tbody>";
					//arrayList로 출력할시에는 for in문이 아닌 for문으로 해야한다.
					//불러올시에는 bd컬럼명하고 똑같아야한다.
					for(let i =0;i <data.length; i++){
						output += "<tr id='updateList'>";
						output +="<td id='SbidKey'>"+data[i].BID_KEY+"</td>";
						output +="<td>"+data[i].PRODUCT_NAME+"</td>";
						output +="<td>"+data[i].PRODUCT_ORIGIN+"</td>";
						output +="<td>"+data[i].PRODUCT_QUALITY+"</td>";
						output +="<td>"+data[i].PRODUCT_QUANTITY+"</td>";
						output +="<td>"+data[i].MEASURE_UNIT+"</td>";
						output +="<td>"+data[i].PRICE+"</td>";
						output +="<td><input type='button' class='btn btn-Primary2' id='listUpdate' value='수정'><input type='button' class='btn btn-Primary2' id='listdelete' value='삭제' ></td>";
						output +="</tr>";
					}
					//output +="</tbody>";
				//	output += "</table>";
					$("#appendTo").html(output);
				}
			})
		})

	//데이터 삭제 
$(document.body).on("click","#listdelete",function(){
		const tbody=$(this).closest("#appendTo");
			let bidK=tbody.find("#SbidKey").text();
			let bidKey=Number(bidK);
			console.log(bidKey);
		const bik="bidKey="+bidKey;
		
	if(confirm("삭제하시겠습니까?")){
		console.log("bik:"+bik);
		
	}
	console.log("bik:"+bik);
	$.ajax({
		type:"get",
		url:"${path}/auction/joinEnllo",
		contentType: "aplication/json",
		dataType:"json",
		data:bik,
		success:function(data){
			alert("삭제되었습니다.");
			$("#SbidKey").parent().remove();
			
		}
	});
}); 
//수정 
$(document.body).on("click","#listUpdate",function(){ 
	const tbody=$(this).closest("#appendTo");
	let bidK=tbody.find("#SbidKey").text();
	let bidKey= Number(bidK);
	const bidOne="bidKey="+bidKey;
	console.log("bidOne:"+bidOne);
	if(confirm("수정하시겠습니까?")){
	}
	$.ajax({
		type:"get",
		url:"${path}/auction/auctionJoinUpdate.do",
		contentType:"aplication/json",
		dataType:"json",
		data:bidOne,
		success:function(data){
			alert("나오냐?");
			let out="";
			out="<form id='updateForm'>";
			for(let i = 0 ; i<data.length;i++){
				
			out +="<tr id='updatetr'>";
			out +="<td><input type='text' id='update' class='bidKey' name='bidKey' value='"+data[0].BID_KEY+"' readonly/></td>";
			out +="<td><input type='text' id='update' class='productName' name='productName' value='"+data[0].PRODUCT_NAME+"'/></td>";
			out +="<td><input type='text' id='update' class='productOrigin' name='productOrigin' value='"+data[0].PRODUCT_ORIGIN+"'/></td>";
			out +="<td><input type='text' id='update' class='productQuality' name='productQuality' value='"+data[0].PRODUCT_QUALITY+"'/></td>";
			out +="<td><input type='text' id='update' class='Quantity' name='Quantity' value='"+data[0].PRODUCT_QUANTITY+"'/></td>";
			out +="<td><input type='text' id='update' class='measureUnit' name='measureUnit' value='"+data[0].MEASURE_UNIT+"'/></td>";
			out +="<td><input type='text' id='update' class='price' name='price' value='"+data[0].PRICE+"'/></td>";
			out +="<td><button type='button' id='uploadBtn' class='btn btn-primary2'>등록</button></td> ";
			out +="</tr>";
			}
			out +="</form>";
		$("#updateList").html(out);
		}
	});
});
//form 데이터로로 보낼때 @RequestBody로 받지못하고 메시지컨버트예외가 발생하게되는데 이럴경우
//form data를 json으로 보낼수만 있다면 모두 해결되고 엘리먼트를 하나씩뽑아서json형태로 보내지않기위해서 
jQuery.fn.serializeObject= function(){
	var obj= null;
	try{
		if(this[0].tagName && this[0].tagName.toUpperCase() == "FORM"){
			var arr = this.serializeArray();
			if(arr){obj = {};
				JQuery.each(arr, function(){
					obj[this.name] = this.value;
				});
			}
		}
	}catch(e){
		alert(e.message);
	}finally{}
	return obj;
}

//form 데이터 형식으로 보내기 
$(document.body).on("click","#uploadBtn",function(){
	
	//var form=$(this).closest("#updateForm").serializeObject();
	let update=$("#updatetr");
	let bidK=$(".bidKey").val();
	let bidKey=Number(bidK);
	console.log("bidK"+bidKey);
	let productName=$(".productName").val();
	let productOrigin=$(".productOrigin").val();
	let productQuality=$(".productQuality").val();
	let Quanti=$(".Quantity").val();
	let Quantity=Number(Quanti);
	let measureUnit=$(".measureUnit").val();
	let price1=$(".price").val();
	let price=Number(price1);
	let article=$("#articleNo").val();
	let articleNo=Number(article);
	let writer=$("#writerKey").val();
	let writerKey=Number(writer);
	const list="articleNo="+articleNo+"&writerKey="+writerKey;
	let frm="bidKey="+bidKey+"&productName="+productName+"&productOrigin="+productOrigin+
	"&productQuality="+productQuality+"&Quantity="+Quantity+"&measureUnit="+measureUnit+"&price="+price+"&articleNo="+articleNo+"&writerKey="+writerKey;
	console.log(""+frm);
		$.ajax({
			url:"${path}/auction/auctionJoinUpdateEnllo.do",
			type:"get",
			contentType:'application/json',
			data:frm,
			dataType:"json",
			success:function(data){
				let form="";
				
				for(let i =0;i <data.length; i++){
					form += "<tr id='updateList'>";
					form +="<td id='SbidKey'>"+data[i].BID_KEY+"</td>";
					form +="<td>"+data[i].PRODUCT_NAME+"</td>";
					form +="<td>"+data[i].PRODUCT_ORIGIN+"</td>";
					form +="<td>"+data[i].PRODUCT_QUALITY+"</td>";
					form +="<td>"+data[i].PRODUCT_QUANTITY+"</td>";
					form +="<td>"+data[i].MEASURE_UNIT+"</td>";
					form +="<td>"+data[i].PRICE+"</td>";
					form +="<td><input type='button' class='btn btn-Primary2' id='listUpdate' value='수정'><input type='button' class='btn btn-Primary2' id='listdelete' value='삭제' ></td>";
					form +="</tr>";
				}
				$("#appendTo").html(form);
			},
			  error: function(){
	                alert("update err");
		}
		});
});



</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
