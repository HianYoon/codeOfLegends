<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<style>
  #footer{
        width: 100%;
        height:auto;
        background: #808e95 ;
    }
 #footer   a{
        text-decoration: none;
        color:black;
    }
    #footer   li{
    list-style-type: none;
    }
    #footer  .footer-container{
        display:flex;
        color: #ffffff;
        border: 0 1px solid black; 
        
    }
   
   .footer-text-items{
       display:flex;
       margin-left: 10px;
       justify-items: baseline;
       align-items: baseline;
   }
   .footer-text-items li{
       margin-left: 30px;
   }
   
   .footer-text-items li a{
       font-size: 18px;
       font-weight: 1000;
        cursor: pointer;

   
   }
    #footer-sns-img{
        width: 50px;
        height:50px;
        box-sizing: border-box;

    }
    .text-copyright{
        margin-left: 80px;
        cursor: pointer;
    }
    .footer-small-text {
        display:none;
    }
    /* small-device */
    @media (max-width:768px){
        .footer-text-items{
            display: none;
        }
        .footer-text-items .displayNone{
            display: none;

        }
    
        
    .footer-text-items li a{
        font-size:15px;
       
    }
    .text-copyright{
        padding-bottom: 10px;
    }
    .footer-small-text{
        display: flex;
        width:auto;
        font-size: 8px;
        font-weight: 500;
        margin: 10px;
    }
    .footer-small-text li{
        width:25%;
        margin: 0 10px;
    }
    .footer-small-text li a{
        display: grid;
        grid-template-columns: auto auto auto auto;
        justify-content: center;
        align-items: center;
        text-align: center;
    }
    .text-copyright a{
        width:auto;
        font-size: 8px;
    }
 
}
</style>
<script>

</script>
</head>
<body>
<section class="container">
    <div class="group">
        <div id="mainNav">
            <div class="logo">
                <a href="#">
                    <img
					src="../../../../../../src\main\webapp\resources\images\profile\logo.png"
					alt=""
					/>
                </a>
            </div>
            <div class="search-box">
                <input type="text" class="search-txt" placeholder="검색">
                <a class="search-btn" href="#">
                    <i class="fas fa-search"></i>
                </a>
            </div>
            <ul>
                <li><a href="#">
                    <img
					src="../../../../../../src\main\webapp\resources\images\profile\notification.png"
					alt=""
					/>
                </a></li>
                <li><a href="#">
                    <img
					src="../../../../../../src\main\webapp\resources\images\profile\comment.png"
					alt=""
					/>
                </a></li>
                <li><a href="#">
                    <img
					src="../../../../../../src\main\webapp\resources\images\profile\add-to-basket.png"
					alt=""
					/>                
                </a></li>
                <li><a href="#">로그인</a></li>
                <li><a href="#">회원가입</a></li>
            </ul>
        </div>
        <div class="mainNav-bottom">
            <ul class="mainNav-bottom-inner">
                <li>
                    <a href="#">
	                    <img
						src="../../../../../../src\main\webapp\resources\images\profile\blind.png"
						alt=""
						/>                    
                        <p>블라인드 입찰</p>
                    </a>
                </li>
                <li>
                    <a href="#">
	                    <img
						src="../../../../../../src\main\webapp\resources\images\profile\talk.png"
						alt=""
						/>                    
                        <p>지식인</p>
                    </a>
                </li>
                <li>
                    <a href="#">
	                    <img
						src="../../../../../../src\main\webapp\resources\images\profile\review.png"
						alt=""
						/>                    
                        <p>불만 마법사</p>
                    </a>
                </li>
                <li>
                    <a href="#">
	                    <img
						src="../../../../../../src\main\webapp\resources\images\profile\home.png"
						alt=""
						/>                    
                        <p>마이 페이지</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="mobile">
        <ul class="mobile-in">
            <li>
                <a href="#">
	                <img
					src="../../../../../../src\main\webapp\resources\images\profile\search.png"
					alt=""
					/>                
                </a>
            </li>
            <li>
                <a href="#">
                    <img
					src="../../../../../../src\main\webapp\resources\images\profile\blind.png"
					alt=""
					/>                
                </a>
            </li>
            <li>
                <a href="#">
	                <img
					src="../../../../../../src\main\webapp\resources\images\profile\talk.png"
					alt=""
					/>                
                </a>
            </li>
            <li>
                <a href="#">
	                    <img
						src="../../../../../../src\main\webapp\resources\images\profile\review.png"
						alt=""
						/>                
                </a>
            </li>
            <li>
                <a href="#">
                    <img
					src="../../../../../../src\main\webapp\resources\images\profile\user.png"
					alt=""
					/>                
                </a>
            </li>
        </ul>
    </div>
</section>
    <script src="main.js"></script>
</body>
</html>