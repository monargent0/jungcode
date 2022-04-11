<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
</head>
<script type="text/javascript">
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

</script>
<body>


<div class="contents">

	<div>
		<h1>아이디 중복확인</h1>
	</div>

	<div>
		<form action="idDB.do" method="post" >
			<div>
				<div>
					<input type="text" name="userID" value="<%= request.getParameter("userID" )%>" 
					onBlur="checkID()" onkeydown="typingID()" size="50" >
				</div>
				<div id="IDWarning"></div>
				<div>
					<button type="submit" >중복 확인</button>
				</div>
			</div>
		</form>
	</div>
	
</div>



</body>
</html>