<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
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
		sessionStorage.removeItem(alertTxt);
	}
</script> 

<body bgcolor="#FFFAF6">

<div class="contents">
	<div>
		<h1>SIGN OUT</h1>
	</div>

	<div>
		<form action="signOut.do" method="post" name="signOut">
			<div>
				<div>
					<label>비밀번호 확인</label>
				</div>
				<div>
					<input type="password" name="userPW" placeholder="비밀번호를 입력해 주세요." required="required" size="50" >
				</div>
			</div>
			<div>
				<button type="submit">회원탈퇴</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>