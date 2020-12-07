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
    <!-- footer -->
<footer id="footer">

    <div class="footer-container">
        <div class="footer-group">
            <ul class="footer-text-items displayNone">
                <li><a href="#"><img src="" alt="페이스북" id="footer-sns-img"></a></li>
                <li><a href="#"><img src="" alt="인스타" id="footer-sns-img"></a></li>
                <li><a href="#"><img src="" alt="카카오" id="footer-sns-img"></a></li>
                <li><a href="#"><img src="" alt="네이버" id="footer-sns-img"></a></li>
            </ul>
        </div>
        <div class="footer-text-group">
            <div class="footer-group">
                <ul class="footer-text-items displayNone">
                    <li><a href="#">회사소개</a></li>
                    <li><a href="#">전자금융약관</a></li>
                    <li><a href="#">개인정보처리방침</a></li>
                    <li><a href="#">판매자등록</a></li>
                    <li><a href="#">불만마법사</a></li>
                    <li><a href="#">공지사항</a></li>
                </ul>
                <!-- smalldevice용 footer-text -->
            </div>
        </div>
    </div>
    <div class="col-info" style="display:none;">Col-Company 사업자 정보</div>
    <ul class="footer-small-text">
        <li><a href="">로그아웃</a></li>
        <li><a href="">고객센터</a></li>
        <li><a href="">마이페이지</a></li>
        <li><a href="">공지사항</a></li>
    </ul>
    <div class="text-copyright">
        <p>도매인은 통신판매중개자이며 통신판매의당사자가아닙니다.</p>
        <p>따라서 도매인은 상품/거래정보및 가격에대하여 책임을 지지않습니다.</p>
        <p>본 사이트/앱 상의 모든정보, 콘텐츠,UI등에 대한 무단복제,배포</p>
        <p>스크래핑등의 행위는 법에 의하여 엄격히 금지됩니다.</p>
        <p>CopyRight@Col-company.</p>
        
    </div>
</div>


</footer>
	
	</body>
</html>