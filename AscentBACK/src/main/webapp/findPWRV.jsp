<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 결과</title>
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
<%
 	String txt = "";
 	if(request.getAttribute("userPW") == null){
 		txt = "결과가 없습니다.";
 	}else{
 		txt = request.getAttribute("userPW") + "입니다.";
 	}
 
 %>

	<div class="contents">

		<div>
			<h3>
				찾으시는 비밀번호는 <%= txt %>
			</h3>
		</div>

		<div style="float: right;">
			<button onclick="window.close()">닫기</button>
		</div>	
		
	</div>
</body>
</html>