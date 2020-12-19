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
                                //

                                //찜 클릭시 색변화
                                var jjim=document.querySelector("#jjim");
                                jjim.onclick=function(){
                                    jjim.style.color="red";
                                }
                                
                                //select box클릭시 박스 복사 및 텍스트값 복사
                           
                             var productSelect=document.querySelector(".productNames option:checked");//클릭대상
                             var addproductSelect=document.querySelector(".addProductname option:checked");//클릭대상
                             
                        
                             function cartBtn(){
                                 var ordd=document.querySelector(".order-product");
                                    var productClone=ordd.cloneNode(true);
                                    ordd.appendChild(productClone);
                                    alert("성공햇다!!");
    
                          
                             }
                           /*  	var addProduct=orderCount.cloneNode(true);
                            	orderCount.appendChild(addProduct); */
                           	 
                         
                           