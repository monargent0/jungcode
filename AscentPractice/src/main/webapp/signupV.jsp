<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>

<script type="text/javascript">
	function checkPW()	{
		let pw = document.getElementById("userPW").value;
		let cfpw = document.getElementById("cfPW").value;
		let warning = document.getElementById("CFWarning");
		
		if (pw != cfpw ) {
			warning.innerHTML = "비밀번호가 일치하지 않습니다";
		}
	}
	function typingCFPW(){
		let warning = document.getElementById("CFWarning");
		warning.innerHTML = "";
	}
	
	function checkID(){
		let id = document.getElementById("userID").value;
		let warning = document.getElementById("IDWarning");
		var regExpID = /^[0-9a-zA-Z]*$/
		
		if(!regExpID.test(id)){
			warning.innerHTML = "영어 대소문자와 숫자만 입력 가능합니다.";
		}
		if(id.length < 3){
			warning.innerHTML = "아이디를 3글자 이상으로 입력해주세요";
		} 
		if(id.length > 13){
			warning.innerHTML = "아이디를 12글자 이하로만 입력해주세요";
		} 
	}

	function typingID(){
		let warning = document.getElementById("IDWarning");
		warning.innerHTML = "";
	}
</script>

<style>
	.contents{
		position: absolute;
		left : 50%;
		transform : translate(-50%,0%);
		padding: 50px;
	}
</style>

<body bgcolor="#FFFAF6">

<div class="contents">

	<div>
		<h1>회원가입 sign up</h1>
	</div>
	
	<div>
		<form action="#" method="get" name="signup">
			<div>
				<div>
					<label>Name</label>
				</div>
				<div>
					<input type="text" name="userName" placeholder="이름을 입력해 주세요." required="required" 
					id="userName"size="50">
				</div>
				<div id="NameWaring">
				</div>
			</div>
		
			<div>
				<div>
					<label>ID</label>
				</div>
				<div>
					<input type="text" name="userID" placeholder="아이디를 입력해 주세요." required="required" 
					onBlur="checkID()" onkeydown="typingID()" id="userID" size="50">
				</div>
				<div id="IDWarning">
				</div>
			</div>
		
			<div>
				<div>
					<label>Email</label>
				</div>
				<div>
					<input type="text" name="userEmail" placeholder="이메일을 입력해 주세요." required="required" size="50"
					id="email">
				</div>
				<div id="EMWarning">
					error
				</div>
			</div>
		
			<div>
				<div>
					<label>Phone</label>
				</div>
				<div>
					<input type="text"  name="userPhone" placeholder="핸드폰 번호를 입력해 주세요." required="required" size="50"
					id="phone">
				</div>
				<div id="PHWarning">
					error
				</div>
			</div>
			
			<div>
				<div>
					<label>PW</label>
				</div>
				<div>
					<input type="password" name="userPW" placeholder="비밀번호를 입력해 주세요." required="required" size="50"
					id="userPW">
				</div>
				<div id="PWWarning">
					error
				</div>
			</div>
			
			<div>
				<div>
					<label>PW Confirm</label>
				</div>
				<div>
					<input type="password" name="confirmPW" placeholder="비밀번호를 다시 입력해 주세요." required="required" size="50"
					id="cfPW" onBlur="checkPW()" onkeydown="typingCFPW()">
				</div>
				<div id="CFWarning">
					error
				</div>
			</div>
			
			<div>
				<div>
					<label>Birth Day</label>
				</div>
				<div>
					<input type="date" name="userBirth" required="required">
				</div>
			</div>
			
			<div>
				<div>
					<label>Gender</label>
				</div>
				<div>
					<input type="radio" name="userGender" value="female" > Female
					<input type="radio" name="userGender" value="male" > Male
				</div>
			</div>
			
			
			<div>
				<button type="submit">회원가입</button>
			</div>
			
		</form>
	</div>

</div>


</body>
</html>