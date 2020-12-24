     					//물건 count
                            window.addEventListener("load",function(){
                                var minus=document.querySelector(".minus");
                                var plus=document.querySelector(".plus");
                                var number=document.querySelector(".number");
								var price=document.querySelector("#pprice");
								var tagPrice=document.querySelector("#pprice1").value;
								pchange=parseInt(tagPrice);
								
								//콤마 정규표현식
								function comma(num){
								    var len, point, str; 
								       
								    num = num + ""; 
								    point = num.length % 3 ;
								    len = num.length; 
								   
								    str = num.substring(0, point); 
								    while (point < len) { 
								        if (str != "") str += ","; 
								        str += num.substring(point, point + 3); 
								        point += 3; 
								    } 
								     
								    return str;
								 
								}
								//count
									minus.onclick=function(str){
									  const ss=parseInt(number.value);
									  
									  if(ss==1) price.value=tagPrice;
									  if(ss>1){
									    number.value= ss-1;
									    totalnumber=pchange*(ss-1);
									     str=totalnumber;
									        price.value=str;
									
									  }else(ss<1) 
									
									    return ;       
									    };
									    plus.onclick=function(str){
									        const ss=parseInt(number.value);
									        if(ss>=1)
									        number.value=ss+1;
									        console.log(tagPrice);
									        totalnumber=pchange*(ss+1);
									        str=totalnumber;
									        price.value=str;
		       
	   								 
								};
                                })
                                //coment 댓글 토글 보여주기 /감추기
                                	var ProductComment=document.querySelector(".ProductComment");
									var reviewContainer=document.querySelector(".review-container");
									
									
									ProductComment.onclick=function(){
										if(reviewContainer.style.display=='none'){
											
											reviewContainer.style.display="block";
										}else{
											reviewContainer.style.display='none';
										}
				
									}
									//신고기능 토글
									var Declaration=document.querySelector("#Declaration");
									var hamburger=document.querySelector(".hamburger");
									
									hamburger.onclick=function(){
									if(Declaration.style.display=='none')
										Declaration.style.display="block";
									}	
										//reviewSingo form보여주기
									var singoForm=document.querySelector(".singoForm");
									var singo=document.querySelector(".singo");
									
									singo.onclick=function(){
									if(singoForm.style.display=='none')
										singoForm.style.display="block";
										
								}
								
                                
                                //신고 모달 box 기능
                                
                                  const open=document.querySelector(".singo");
                                  
                                  const close=document.querySelector("#modalClose");
                                  const form=document.querySelector(".singoForm");
                                  
                                  close.onclick=function(){
                                  
                                  	form.style.display='none';
                                  };
                                  
                                  open.onclick=function(){
                                  	form.style.display='flex';
                                  	
                                  };
                                  //title orderbox에 출력하기
                                  $("#product-select-List").change(function(){
                                  	var OptionVal=$(this).val();
                                  	$(".orderText").text(OptionVal);
                                  var ff= $(".orderText").text=OptionVal;
                                  	console.log(ff);
                                  });
                                  
                                  
