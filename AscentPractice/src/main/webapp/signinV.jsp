<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>

<script type="text/javascript">
	
	/* 이름 유효성 검사 */
	function checkNAME(){
		let name = document.getElementById("NAME").value;
		let warning = document.getElementById("NameWarning");
		var regExpNAME = /^[가-힣]*$/
		
		if(!regExpNAME.test(name)){
			warning.innerHTML = '<p id="warning"> 한글만 입력 가능합니다. </p>';
		}
		if(name.length < 2){
			warning.innerHTML = '<p id="warning"> 이름은 2글자 이상 입력해주세요 </p>';
		} 
		if(name.length > 9){
			warning.innerHTML = '<p id="warning"> 입력하신 이름 정보를 확인해주세요 </p>';
		} 
	}

	function typingNAME(){
		let warning = document.getElementById("NameWarning");
		warning.innerHTML = "";
	}
	
	/* 아이디 유효성검사  */
	function checkID(){
		let id = document.getElementById("userID").value;
		let warning = document.getElementById("IDWarning");
		var regExpID = /^[0-9a-zA-Z]*$/
		
		if(!regExpID.test(id)){
			warning.innerHTML = '<p id="warning"> 영어 대소문자와 숫자만 입력 가능합니다. </p>';
		}
		if(id.length < 3){
			warning.innerHTML = '<p id="warning"> 아이디를 3글자 이상으로 입력해주세요 </p>';
		} 
		if(id.length > 13){
			warning.innerHTML = '<p id="warning"> 아이디를 12글자 이하로 입력해주세요 </p>';
		} 
	}

	function typingID(){
		let warning = document.getElementById("IDWarning");
		warning.innerHTML = "";
	}
	
	/* 아이디중복검사 */
	/* function doublecheck(){
		let id = = document.getElementById("userID").value;
	} */
	
	/* 이메일 유효성 검사 */
	function checkEM(){
		let email = document.getElementById("email").value;
		let warning = document.getElementById("EMWarning");
		var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/
		
		if(!regExpEmail.test(email)){
			warning.innerHTML = '<p id="warning"> 이메일 입력 정보를 확인해 주세요. </p>';
		}
	}

	function typingEM(){
		let warning = document.getElementById("EMWarning");
		warning.innerHTML = "";
	}
	
	/* 폰번호 유효성 검사 */
	function checkPH(){
		let phone = document.getElementById("phone").value;
		let warning = document.getElementById("PHWarning");
		var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/ 
		
		if(!regExpPhone.test(phone)){
			warning.innerHTML = '<p id="warning"> 연락처는 - 를 포함한 형식으로 입력해주세요. </p>';
		}
	}

	function typingPH(){
		let warning = document.getElementById("PHWarning");
		warning.innerHTML = "";
	}
	/* 비밀번호 유효성 검사 */
	function checkPW(){
		let pw = document.getElementById("userPW").value;
		let warning = document.getElementById("PWWarning");
		var regExpPW = /^[0-9a-zA-Z]*$/
		
		if(!regExpPW.test(pw)){
			warning.innerHTML = '<p id="warning"> 영어 대소문자와 숫자만 입력 가능합니다. </p>';
		}
		if(pw.length < 3){
			warning.innerHTML = '<p id="warning"> 비밀번호를 3자 이상 입력해주세요 </p>';
		} 
		if(pw.length > 16){
			warning.innerHTML = '<p id="warning"> 15자 이하로 입력해주세요 </p>';
		} 
	}

	function typingPW(){
		let warning = document.getElementById("PWWarning");
		warning.innerHTML = "";
	}
	
	/* 비밀번호 일치 검사 */
	function checkCFPW()	{
		let pw = document.getElementById("userPW").value;
		let cfpw = document.getElementById("cfPW").value;
		let warning = document.getElementById("CFWarning");
		
		if (pw != cfpw ) {
			warning.innerHTML = '<p id="warning"> 비밀번호가 일치하지 않습니다 </p>';
		}
		if (pw == cfpw ) {
			warning.innerHTML = '<p id="warning"> 비밀번호가 일치합니다 </p>';
		}
	}
	function typingCFPW(){
		let warning = document.getElementById("CFWarning");
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
	
	#warning{
		color: blue;
		font-size: 12px;
		text-align: center;
	}
</style>

<body bgcolor="#FFFAF6">

<div class="contents">

	<div>
		<h1>SIGN IN</h1>
	</div>
	
	<div>
		<form action="signin.do" method="post" name="signin">
			<div>
				<div>
					<label>Name</label>
				</div>
				<div>
					<input type="text" name="userName" placeholder="이름을 입력해 주세요." required="required" 
					id="NAME" onBlur="checkNAME()" onkeydown="typingNAME()" size="50" >
				</div>
				<div id="NameWarning"></div>
			</div>
		
			<div>
				<div>
					<label>ID</label>
				</div>
				<div>
					<input type="text" name="userID" placeholder="아이디를 입력해 주세요." required="required" 
					onBlur="checkID()" onkeydown="typingID()" id="userID" size="50">
				</div>
				<div>
					<button formaction="중복확인.do?" onclick="doublecheck()">아이디 중복 확인</button>
				</div>
				<div id="IDWarning"></div>
			</div>
		
			<div>
				<div>
					<label>Email</label>
				</div>
				<div>
					<input type="text" name="userEmail" placeholder="이메일을 입력해 주세요." required="required" size="50"
					id="email" onBlur="checkEM()" onkeydown="typingEM()">
				</div>
				<div id="EMWarning"></div>
			</div>
		
			<div>
				<div>
					<label>Phone</label>
				</div>
				<div>
					<input type="text"  name="userPhone" placeholder="핸드폰 번호를 입력해 주세요." required="required" size="50"
					id="phone" onBlur="checkPH()" onkeydown="typingPH()">
				</div>
				<div id="PHWarning"></div>
			</div>
			
			<div>
				<div>
					<label>PW</label>
				</div>
				<div>
					<input type="password" name="userPW" placeholder="비밀번호를 입력해 주세요." required="required" size="50"
					id="userPW" onBlur="checkPW()" onkeydown="typingPW()">
				</div>
				<div id="PWWarning"></div>
			</div>
			
			<div>
				<div>
					<label>PW Confirm</label>
				</div>
				<div>
					<input type="password" name="confirmPW" placeholder="비밀번호를 다시 입력해 주세요." required="required" size="50"
					id="cfPW" onBlur="checkCFPW()" onkeydown="typingCFPW()">
				</div>
				<div id="CFWarning"></div>
			</div>
			
			<div>
				<div>
					<label>Birth Date</label>
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