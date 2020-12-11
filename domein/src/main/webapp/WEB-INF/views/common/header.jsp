<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<style>
.container{
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}
.bg-black {
    background: #333 !important;
}

.txt-white a {
    color: #fff !important;
}
#mainNav ul a img{
    color: #fff !important;
}
#mainNav {
    display: flex;
    justify-content: space-between;
    padding: 0px; 
    position: fixed; 
    width:100%;
    top:0px;
    background: #fff;
    transition: background 0.4s;
}
#mainNav .logo{
    width: 20%;
}
#mainNav .logo img{
    width: 100%;
    height: 84px;
    transition: height 0.4s;
}

.window{
    display: inline-block;
    width: 300px; height: 20px;
    border: 3px solid black;
}
.search-box{
    width: 20%;
    /* margin-top: 2.1em; */
    padding: 0.5rem;
    position: absolute;
    top: 50%;
    left: 38%;
    transform: translate(-50%, -50%);
    height: 30px;
    border-radius: 30px;
    border: 2px solid rgb(213, 213, 213);
}
.search-txt{
    padding: 0;
    float:left;
    width: 80%;
    border: none;
    outline: none;
    float: left;
    font-size: 1rem;
    line-height: 30px;
    border-radius: 8%;
    /* color:white; */
}
.search-btn{
    float:right;
    width: 15%;
    text-decoration: none;
    display: flex;
    justify-content: center;
    align-items: center;
    width: 30px;
    height: 30px;
    border-radius: 30px;
    color: black;
}
#mainNav ul{
    /* float:right; */
    width:100%;
    list-style: none;
    display: flex;
    align-items: center;
    width: 400px;
    justify-content: space-around;
    margin-right: 1%;
}

#mainNav ul li a{
    width:50%;
    text-decoration: none;
    color:#333;
    font-weight:500;
    transition: color 0.4s;
    margin-left: 1rem;
    border-bottom: 3px solid transparent;
    padding: 10px 1px;
    transition: 500ms;
}
#mainNav ul li a:hover {
    border-color: #e7eb08;
}
.mainNav-bottom-inner{
    display:flex;
    justify-content: space-between;
    list-style:none;
    width: 40%;
    height: 4em;
    margin-top : 6em;
}
.mainNav-bottom-inner p{
    width: 100%;
    font-size: 0.7rem;
    padding-right: 60%;
    color: black;
}
.mobile-in{
    display: flex;
    justify-content: space-around;
    padding: 0px; 
    position: fixed; 
    width:100%;
    list-style: none;
    visibility: hidden;
}
.mainNav-bottom-inner a{
    text-decoration: none;

}
@media screen and (max-width: 768px) {
    .group{
        display:none;
    }
}
    @media screen and (max-width: 768px) {
        .mobile-in{
            display:flex;
            position:fixed;
            visibility:visible ;
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