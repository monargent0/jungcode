<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 수정</title>
</head>
<style>
	.contents{
		position: absolute;
		left : 50%;
		transform : translate(-50%,0%);
		padding: 50px ;
	}
	#warning{
		color: blue;
		font-size: 12px;
		text-align: center;
	}
</style>

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


</script>

<body bgcolor="#FFFAF6">

<div class="contents">

<h2>My Information Modify</h2>
	
				<form action="userModify.do" method="post">
<table>
				<tr> <td><h3>정보 수정</h3></td></tr>
				<tr>
					<td> 이름 </td> 
					<td> <input name="userName" value="<%= request.getParameter("userName")%>" size="20"
					id="NAME" onBlur="checkNAME()" onkeydown="typingNAME()"> </td>
				</tr>
				<tr><td id="NameWarning"></td></tr>
				<tr>
					<td> 이메일 </td> 
					<td> <input name="userEmail" value="<%= request.getParameter("userEmail")%>" size="20"
					id="email" onBlur="checkEM()" onkeydown="typingEM()"> </td>
				</tr>
				<tr><td id="EMWarning"></td></tr>
				<tr>
					<td> 전화번호 </td> 
					<td> <input name="userPhone" value="<%= request.getParameter("userPhone")%>" size="20"
					id="phone" onBlur="checkPH()" onkeydown="typingPH()"> </td>
				</tr>
				<tr><td id="PHWarning"></td></tr>
			<tr>
				<td colspan="2" align="right"> <button type="submit">수정하기</button> </td>
			</tr>

</table>
				</form>

</div>

</body>
</html>