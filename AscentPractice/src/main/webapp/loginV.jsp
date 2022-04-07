<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
</head>

<style>
	.contents{
		position: absolute;
		left : 50%;
		transform : translate(-50%,0%);
		padding: 50px ;
	}

</style>

<script type="text/javascript">
	let alertTxt = '<%=(String)session.getAttribute("alertTxt")%>';
	if(alertTxt!== "null"){
		alert(alertTxt);
		<%
		session.invalidate();
		%>
	}
</script>

<body bgcolor="#FFFAF6">


 <div class="contents">

	<div>
		<h1>LOG IN</h1>
	</div>  
 
 	<div >
 		<form action="login.do" method="post">
 			<div>
				<div style="float: right;">
					<input type="text" name="userID" size="30" placeholder="아이디">
				</div>
			</div>
 			<div>
				<div style="float: right;">
					<input type="password" name="userPW" size="30" placeholder="비밀번호" >
				</div>
			</div>
			<div>&nbsp;</div>
 			<div>
				<div  align="left" style="float: left;" ><button formaction="signinV.jsp">SING IN</button></div>
				<div  align="right" style="float: right;"><button type="submit">LOGIN</button></div> 
			</div>
 		</form>
 	</div>

 		<div style="float: right;">
 			<a href = "" target ="popup" onclick="window.open('findIDV.jsp','popup','width=600,height=600'); return false">아이디/비밀번호 찾기</a>
 			<!-- 
 			 <button onclick="location.href=''" >아이디/비밀번호 찾기</button>
 			 -->
 		</div>
 
 </div>

</body>
</html>