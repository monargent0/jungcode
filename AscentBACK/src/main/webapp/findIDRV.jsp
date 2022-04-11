<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과</title>
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
 <%
 	String txt = "";
 	if(request.getAttribute("userID") == null){
 		txt = "결과가 없습니다.";
 	}else{
 		txt = request.getAttribute("userID") + "입니다.";
 	}
 
 %>
		<div>
			<h3>
				찾으시는 아이디는 <%=txt %>
			</h3>
		</div>
		<div style="float: left;">
			<button onclick="window.close()">닫기</button>
		</div>	
		<div style="float: right;">
			<button onclick="location.href='findPWV.jsp'" >비밀번호 찾기</button>
		</div>
		
	</div>
</body>
</html>