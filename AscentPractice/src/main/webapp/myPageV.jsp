<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY PAGE MAIN</title>
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
	<a href="mainV.jsp">main</a> <a href="logOutH.jsp">로그아웃</a><br>

<!-- 개인정보수정,회원탈퇴 -->
<h2>MY PAGE</h2>

<button formaction="userDetail.do" style="width: 200px;">개인정보보기</button> <br>
<button formaction="addressList.do" style="width: 200px;">주소록</button> <br>
<button formaction="orderList.do" style="width: 200px;" >주문내역</button> <br>
<button formaction="reviewList.do" style="width: 200px;" >후기 목록</button> <br>
<button formaction="counselList.do" style="width: 200px;" >1대1문의조회</button> <br>

</div>

</body>
</html>