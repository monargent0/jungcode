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
		font-family: "나눔명조";
		color:#463D3D;
	}
	
	#warning{
		color: blue;
		font-size: 12px;
		text-align: center;
		font-family: "나눔명조"
	}
	
	#hyper{				
      	font-size: 14px;
      	font-family:"나눔명조";
      	color:#463D3D;
      }
   	
   	input{
   		margin: 7px 5px;
   	}
   	
    button{
	    background-color: #FFFAF6;
	    color: #463D3D;
	    border: 1px solid #999191;
	    font-size: 1.0em;
	    letter-spacing: 0px;
	    padding: 5px 10px;
	    cursor: pointer;
	    display: inline-block;
	   
	    transition: all 0.5s;    
	}
	button:hover{
	    background: #241571;
	    color: #FFFAF6;
	    transition: all 0.5s;
	}
</style>

<script type="text/javascript">
	let alertTxt = '<%=(String)session.getAttribute("alertTxt")%>' ;
	if(alertTxt !== "null"){
		alert(alertTxt);
		<%
		session.invalidate();
		%>
	}
	
	/* 필수입력  */
	function checkid(){
		let id = document.getElementById("userID").value;
		let pw = document.getElementById("userPW").value;
		let warning = document.getElementById("Warning");

		if(id == ""){
			warning.innerHTML = '<p id="warning"> 아이디를 입력해주세요 </p>';
			return document.log.userID.focus();
		}
		
		if(pw == ""){
			warning.innerHTML = '<p id="warning"> 비밀번호를 입력해주세요 </p>';
			return document.log.userPW.focus();
		}
		else{
		 document.log.submit();			
		}
	}

</script>

<body bgcolor="#FFFAF6">


 <div class="contents">

	<div>
		<h1>LOG IN</h1>
	</div>  
 
 	<div >
 		<form action="logIn.do" method="post" name="log">
 			<div>
				<div style="float: right;">
					<input type="text" name="userID" size="30" placeholder="아이디"
					 id="userID">
				</div>
			</div>
 			<div>
				<div style="float: right;">
					<input type="password" name="userPW" size="30" placeholder="비밀번호"
					id="userPW" >
				</div>
			</div>
				<div>&nbsp;</div>
				<div id="Warning"></div>
 			<div>
				<div  align="left" style="float: left;" ><button formaction="signInV.jsp">SING IN</button></div>
				<div  align="right" style="float: right;"><button type="button" onclick="checkid()">LOGIN</button></div> 
			</div>
 		</form>
 	</div>

 		<div style="float: right;">
 		<br><a id="hyper" href = "" target ="popup" onclick="window.open('findIDV.jsp','popup','width=600,height=600'); return false">아이디/비밀번호 찾기</a>
 		</div>
 
 </div>

</body>
</html>