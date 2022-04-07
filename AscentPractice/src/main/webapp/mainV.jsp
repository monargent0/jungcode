<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>ascent</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.1/examples/headers/">



<!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>


<!-- Custom styles for this template -->
<link href="headers.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<%-- 아이콘 --%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>ascent</title>
</head>
<style>
#nav{				/*1단바 */
	list-style:none; /* 불릿 없애기 */
	height:10px;
	padding:5px 1px;
	margin:0;
	background:#FFFAF6;
}
#nav li{ /*전체 메뉴의 리스트에 대한 스타일*/
	float:left; /*-- 메뉴를 왼쪽부터 표시*/
	posiotion:relative; /*-- 순서대로 표시*/
	margin:5px 30px;
	padding:0;
}
#nav li a {		/*메인 메뉴 링크의 스타일*/
	display:block; /*메뉴칸을 블록레벨로 만듬*/
	font-family:"나눔명조";
	font-size:20px;			/*메인메뉴의 글씨 크기*/
	padding:7px 8px;
	margin:0;
	color:#463D3D; /*글자색 지정*/
	margin:0;
	text-decoration:none; /*글자의 밑줄 없애기*/
}
#nav li:hover >a { /*메인메뉴링크에 마우스 포인터 올렸을 떄 스타일 */
 	background:#FFCAB2;
	color:#463D3D; /*글자색 지정*/
	margin:0;
	padding:5px;
}
#nav ul{ /*서브메뉴 스타일*/
	list-style:none; /* 불릿 없애기 */
	margin:0;
	padding:0;
	posiotion:absolute; /*고정위치에 표시 */
	left:0;			/*부모 요소와 왼쪽 좌표값을 같게 한다 */
	top:40px;
	width:110px;	/*서브메뉴의 너비*/
	background:#FFFAF6;		/*서브 메뉴의 배경색*/
	text-align:center;
	opacity:0;   /*평상시에 안보이게 */
}
#nav li:hover ul{ /*메인메뉴에 마우스 포인터를 올려놨을 떄 서브 메뉴 스타일*/
	opacity:1; /*서브메뉴 보이게 설정*/
}
#nav li:hover ul li{ /*마우스 포인터를 올려놨을 떄 서브메뉴 스타일*/
	height:35px; /*서브메뉴의 높이*/
	overflow:visible;  /*영역을 넘어가는 내용이 있다면 표시*/
	padding:0;
}

#nav ul li{  /*서브메뉴 리스트들의 스타일*/			
	float:none; /*부모요소의 떠있는 속성을 해제하여 세로정렬*/
	margin:0;
	padding:0;
	font-size:10px;
}

#navBar{				/*navbar 크기, 조정  */
	background:#FFFAF6;	
	height:141px;
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.form-control-dark {
	color: #fff;
	background-color: var(- -bs-dark);
	border-color: var(- -bs-gray);
}

.form-control-dark:focus {
	color: #fff;
	background-color: var(- -bs-dark);
	border-color: #fff;
	box-shadow: 0 0 0 .25rem rgba(255, 255, 255, .25);
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.dropdown-toggle {
	outline: 0;
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}
.container{				/*class라서 ., 로고 아이디로 위치 수정 */
      	position: absolute;
      	top : 50%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      }
#hyper1{				/*id는 샵, 동영상 가운데 제목  아이디로 위치 수정 */
      	position: absolute;
      	top : 60%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      	font-size: 40px;
      	font-family:"나눔명조";  /*하이퍼 글씨  */
      	color:#FFFAF6;
      }
#hyper2{				/*id는 샵 동영상 하이퍼링크 아이디로 위치 수정 */
      	position: absolute;
      	top : 68%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      	font-size: 24px;
      	font-family:"나눔명조";
      	color:#FFFAF6;
      }
      

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<style><!--아이콘 -->
.bi-search{		/*검색*/
	font-size: 32px;
	line-height:32px;
	color: #463D3D;
}
.bi-search-heart{		/*검색클릭 후*/
	font-size: 32px;
	line-height: 32px;
	color: #463D3D;
}
.bi-person-fill {		/*마이페이지*/
	font-size: 32px;
	line-height: 32px;
	color:#463D3D;
}
.bi-bag-heart {			/*장바구니*/
	font-size: 32px;
	line-height: 32px;
	color: #463D3D;
}
.bi-bag-check-fill {	/*장바구니클릭 후*/
	font-size: 32px;
	line-height: 32px;
	color:#463D3D;
}


     

</style>
<!-- 비디오 -->
<style>
#videobcg {
	position: relative;
	top:0px;
	left:-15px;
	min-width:100%;
	min-height:100%;
	padding-bottom:70px;
	height:auto;
	margin:0;
	z-index:-1000;
}
/*상품구현 위치 */
#container1 {
		position: relative;
		top:300px;
		
}



</style>
<body>
	
	<nav id="navBar" class="navbar navbar-expand-lg navbar">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					
						<!-- 상품 카테고리 한눈에 차라락 보여주기  -->
					
					<ul id="nav">
					<li><a class="nav-link" href="#">Shop</a>
						<ul>
							
							<li><a href="#">Floral</a></li>
							<li><a href="#">Citrus</a></li>
							<li><a href="#">Fresh</a></li>
							<li><a href="#">Fruity</a></li>
							<li><a href="#">Woody</a></li>
							<li><a href="#">Oriental</a></li>
						</ul>
					</li>
					
						<!-- 상품별로 보여주기  -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Perfume </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">Eau de perfume</a></li>
							<li><a class="dropdown-item" href="#">Eau de toillette</a></li>
							<li><a class="dropdown-item" href="#">Eau de cologne</a></li>
							<li><a class="dropdown-item" href="#">Body Spray</a></li>
						</ul>
					</li>
					<!-- 1:1문의 ,공지사항, 상품문의  -->
					<li><a class="nav-link px-2" href="#">About</a>
						<ul>
							<li><a href="#">Notice</a></li>
							<li><a href="#">Q&A</a></li>
						</ul>
						
						
					</li>
				</ul>
				</ul>
				<!--로고 -->
			
      			  <div class="container col-12 col-lg-auto me-lg-auto mb-2 mb-md-0">
   					 <a class="navbar-brand" href="#">
   					   <img src="assets/logo.png"  alt="" width="300" height="150">
  					  </a>
				  </div>
      			  
      			  
      			 <!--검색하기  -->
				<form  class="d-flex">
					<input class="form-control me-2" type="search" placeholder="검색하기" aria-label="Search"> 
				</form>
				<!--검색,마이페이지,장바구니 아이콘  -->
				<div class="text-end">
					<k class="bi bi-search" style="font-size:2.1rem; cursor: pointer;" href="#"></k>
					<script>
					var k = 0;
					$('k').on('click', function() {
						if (k == 0) {
							$(this).attr('class', 'bi-search-heart');
							k++;
						} else if (k == 1) {
							$(this).attr('class', 'bi-search');
							k--;
						}
					});
				</script>
					<i class="bi bi-person-fill" style="font-size:2.5rem;cursor: pointer; " href="#"></i>
				
					<j  class="bi bi-bag-heart" style="font-size:2.3rem; cursor: pointer;" href="#"></j>

				<script>
					var j = 0;
					$('j').on('click', function() {
						if (j == 0) {
							$(this).attr('class', 'bi-bag-check-fill');
							j++;
						} else if (j == 1) {
							$(this).attr('class', 'bi-bag-heart');
							j--;
						}
					});
				</script>
				</div>
			</div>
			
		</div>
	</nav>
	
		<!-- 비디오1  -->
		<!-- 비디오에 하이퍼링크 띄우기  -->
		<ul>
		<video id="videobcg" width="100%" height="480"  autoplay loop muted>
			<source	src="assets/pexels-rose.mp4" type="video/mp4" >
		</video>
			<div class="jb-text">
      	  <p id="hyper1">가드니아의 여름</p>
    	  </div>
		<a id="hyper2" href="#">More </a>		
		</ul>
		
	<!-- 상품 구현  -->
	    <!-- Section-->
        <section id="container1" class="py-5">
        
            <div class="container px-4 px-lg-10 mt-5">
            
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Perfume</h5>
                                    <!-- Product price-->
                             		50ml - 240000원 
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">옵션 보기 </a></div>
                                <br>
                                <!-- 찜  -->
                                 <div class="text-center"><j class="text-center bi bi-heart" style="font-size:1.7rem;cursor: pointer;" href="#"></j></div>
                                
                                <script>
                                var j = 0;
            					$('j').on('click', function() {
            						if (j == 0) {
            							$(this).attr('class', 'bi-heart-fill');
            							j++;
            						} else if (j == 1) {
            							$(this).attr('class', 'bi-heart');
            							j--;
            						}
            					});
                                
                                </script>
                            </div>
                        </div>
                        
                    </div>
                    
                    
                    <div class="col mb-5">
                    
                    
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">신상품</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Special Item</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star"></div>
                                        <div class="bi-star"></div>
                                    </div>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">$20.00</span>
                                    340000원 
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">장바구니에 담기 </a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Best</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Sale Item</h5>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">$50.00</span>
                                    $25.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">장바구니에 담기</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Popular Item</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    $40.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                   



	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>