<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 작성</title>
<style>
	  table {
        border-collapse: collapse;
        border-top: 2px solid black;
        width: auto;
        height: auto;
      }
      
      table, th, td {
        padding: 5px;
       }
       
      .write{
      	position: absolute;
        border: 10px solid lightblue;
      	top : 50%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      }
    </style>
</head>

<script type="text/javascript">
	function checkAddress(){
		var regExpName = /^[a-zA-Z가-힣]*$/ 
		var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/ 
		var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/
		var regExpRel = /^[가-힣]*$/ 
		
		var form = document.address
		
		var aname = form.aName.value
		if(!regExpName.test(aname)){
			alert("이름은 한글과 영어만 입력해 주세요")
			form.aName.focus()
			return
		}
		var atel = form.aTel.value
		if(!regExpPhone.test(atel)){
			alert("연락처는 010-0000-0000 형식으로 입력해 주세요")
			form.aTel.focus()
			return
		}
		var email = form.aEmail.value
		if(!regExpEmail.test(email)){
			alert("이메일 입력을 확인해 주세요")
			form.aEmail.select()
			return
		}
		var relation = form.aRelation.value
		if(!regExpRel.test(relation)){
			alert("한글만 입력해 주세요")
			form.aRelation.focus()
			return
		}
		form.submit()
	}
</script>

<body>
	<div class="write">
	<center><h2>주소록 추가</h2></center>
		<form action="write.do" method="post" name="address">
	<table border="0">
			<tr>
				<td>이름</td>
				<td><input type="text" name="aName" size="20" > </td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="aTel" size="60"> </td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="aAddress" size="60"> </td>
			</tr>
			<tr>
				<td>전자우편</td>
				<td><input type="text" name="aEmail" size="60"> </td>
			</tr>
			<tr>
				<td>관계</td>
				<td><input type="text" name="aRelation" size="60"> </td>
			</tr>			
			<tr>
				<td align="left"><a href="list.do">목록으로</a> </td>
				<td colspan="4" align="right"> <input type="button" value="등록" onclick="checkAddress()"> </td>
			</tr>
	</table>
		</form>
	</div>



</body>
</html>