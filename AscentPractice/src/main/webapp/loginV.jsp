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
 
 	<div>
 		<form action="login.do" method="get">
 			<div>
				<div>
					ID :
				</div>
				<div>
					<input type="text" name="userID" size="30" >
				</div>
			</div>
 			<div>
				<div>
					PW :
				</div>
				<div>
					<input type="password" name="userPW" size="30" >
				</div>
			</div>
 			<div>
				<button type="submit">LOGIN</button>
			</div>
 		</form>
 	</div>
 
 </div>

</body>
</html>