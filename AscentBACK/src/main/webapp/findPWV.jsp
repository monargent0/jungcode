<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
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
	
	<div>
		<h1>비밀번호 찾기</h1>
	</div>
	
		<form action="findPW.do" method="post" >
			<div>
				<div>
					<input type="text" name="userID" placeholder="아이디를 입력해 주세요" required="required" size="50" >
				</div>
				<div>
					<input type="text" name="userName" placeholder="이름을 입력해 주세요" required="required" size="50" >
				</div>
				<div>
					<input type="text" name="userEmail" placeholder="이메일을 입력해 주세요" required="required" size="50" >
				</div>
			</div>
			<div style="float: left;">
					<button onclick="window.close()">닫기</button>
			</div>	
			<div style="float: right;">
				<button type="submit">비밀번호 찾기</button>
			</div>
		</form>
	</div>

</body>
</html>