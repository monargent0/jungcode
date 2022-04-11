<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN MAIN</title>
</head>

<style>
	.contents{
		position: absolute;
		left : 50%;
		transform : translate(-50%,0%);
		padding: 50px ;
	}

</style>
<body bgcolor="#FFFAF6">

<div class="contents">

<!-- 개인정보수정,회원탈퇴 -->
<h2>ADMIN</h2>

<button onclick="location='.do'" style="width: 200px;">회원관리</button> <br>
<br>
<button onclick="location='.do'" style="width: 200px;">상품관리</button> <br>
<br>
<button onclick="location='.do'" style="width: 200px;" >주문내역관리</button> <br>
<br>
<button onclick="location='.do'" style="width: 200px;" >통계</button> <br>
<br>
<button onclick="location='.do'" style="width: 200px;" >게시판관리</button> <br>
<br>

	<a href="mainV.jsp">main</a> &nbsp; <a href="logOutH.jsp">로그아웃</a><br>
</div>

</body>
</html>