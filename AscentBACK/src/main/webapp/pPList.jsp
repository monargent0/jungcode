<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/headers/">
    <!-- Bootstrap core CSS -->
	<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="css/productlist.css" rel="stylesheet" >
	  <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
	 <!-- Custom styles for this template -->
    <link href="headers.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
    rel="stylesheet" 
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
    crossorigin="anonymous">
  </head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
  <%-- 아이콘 --%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>ascent</title>

</head>
<!-- 메인홈바 -->
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
<style>

.form-control-dark {
  color: #fff;
  background-color: var(--bs-dark);
  border-color: var(--bs-gray);
}
.form-control-dark:focus {
  color: #fff;
  background-color: var(--bs-dark);
  border-color: #fff;
  box-shadow: 0 0 0 .25rem rgba(255, 255, 255, .25);
}
</style>

<!-- 상품에 마우스 올릴때 및 위치 조정  -->
<style>

 .py-5 div:hover {
       border-color:#333;     
 }   
  .col {
  padding:500px 0 0 100px;
  }  
  .detail-text-center {
  height:300px;
  }   
</style>

<body>
<!-- 메인 홈바  -->
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
					<li><a class="nav-link" href="main.do">Scent</a>
						<ul>
							
							<li><a href="sFList.do">Floral</a></li>
							<li><a href="sCList.do">Citrus</a></li>
							<li><a href="sFRList.do">Fresh</a></li>
							<li><a href="sFTList.do">Fruity</a></li>
							<li><a href="sWList.do">Woody</a></li>
							<li><a href="sOList.do">Oriental</a></li>
						</ul>
					</li>
					
						<!-- 상품별로 보여주기  -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="main.do" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Perfume </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="pPList.do">Eau de perfume</a></li>
							<li><a class="dropdown-item" href="pTList.do">Eau de toilette</a></li>
							<li><a class="dropdown-item" href="pCList.do">Eau de cologne</a></li>
							<li><a class="dropdown-item" href="pBList.do">Body Spray</a></li>
						</ul>
					</li>
					<!-- 1:1문의 ,공지사항, 상품문의  -->
					<li><a class="nav-link px-2" href="main.do">About</a>
						<ul>
							<li><a href="#">Notice</a></li>
							<li><a href="counselList.do">Q&A</a></li>
						</ul>
						
						
					</li>
				</ul>
				</ul>
				<!--로고 -->
			
      			  <div class="container col-12 col-lg-auto me-lg-auto mb-2 mb-md-0">
   					 <a class="navbar-brand" href="main.do">
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
					<%
					if(session.getAttribute("userID") == null){
					%>
					<i class="bi bi-person-fill" style="font-size:2.5rem;cursor: pointer;" onclick = "location.href='logInV.jsp'" ></i>
					<%
					}else if(session.getAttribute("userID") != null){
					%>
					<i class="bi bi-person-fill" style="font-size:2.5rem;cursor: pointer;" onclick = "location.href='myPageV.jsp'" ></i>
				  <% } %>
				  
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
	







<!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">shop</h1>
                    <p class="lead fw-normal text-white-50 mb-0">find your own scent</p>
                </div>
            </div>
        </header>

               			   <section class="py-5">
               			  <div class="row row-cols-1 row-cols-md-4 g-4">
		  					<c:forEach items="${appList }" var="dto"><%--반복문,dto --%>
 								 <div class="col">
   									 <div class="card h-100">
   									  <a class="card-image" href="http://localhost:8080/Ascent/productDetail.do?productCode=${dto.productCode }"><img class="card-img-top" src="${dto.productImages}" alt="" width="100%" /></a>
     								 <div class="card-body">
     								  <div class="detail-text-center">
                              	     <p class="pd.name">${dto.productName }</p>
                                    <!-- Product size-->
                             		<p class="pd.size">${dto.productSize }ml</p>
                                    <!-- Product price-->
                                	<p class="pd.price">${dto.productPrice }원</p>
                             	
    				 		 </div>
    				 		 </div>
    				 		 </div>
    				 		 </div>
               		 </c:forEach>
  				  </div>
  				  </section>
                            <!-- Product actions-->
                           
                            		 <!-- Product name-
                            		  <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <!-- 찜  
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">옵션 보기 </a></div>
                                <br> -->
                               <!--   <div class="text-center"><j class="text-center bi bi-heart" style="font-size:1.7rem;cursor: pointer;" href="#"></j></div>
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
                            	    </script> -->
                           
                 
           
           
           
           
           
           
           
           
           
           
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>