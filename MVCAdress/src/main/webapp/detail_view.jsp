<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 수정</title>
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
       
      .modify{
        border: 10px solid lightblue;
      	position: absolute;
      	top : 50%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      }
    </style>
</head>
<script type="text/javascript">
	function del(aId){
		if(confirm("정말 삭제하시겠습니까?")){
			location.href = "delete.do?aId="+ aId;
		}
	}
	
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
	<div class="modify">
	<center><h2>주소록 상세 및 수정</h2></center>
	<form action="modify.do" method="post" name="address">
		<table>
			<tr>
			<td>번호</td>
			<td><input type="text" name="aId" size="5" value="${detail_view.aId}" readonly="readonly"></td>
			</tr>
			<tr>
			<td>이름</td>
			<td><input type="text" name="aName" size="20" value="${detail_view.aName}"></td>
			</tr>
			<tr>
			<td>전화번호</td>
			<td><input type="text" name="aTel" size="50" value="${detail_view.aTel}"></td>
			</tr>
			<tr>
			<td>주소</td>
			<td><input type="text" name="aAddress" size="50" value="${detail_view.aAddress}"></td>
			</tr>
			<tr>
			<td>전자우편</td>
			<td><input type="text" name="aEmail" size="50" value="${detail_view.aEmail}"></td>
			</tr>
			<tr>
			<td>관계</td>
			<td><input type="text" name="aRelation" size="50" value="${detail_view.aRelation}"></td>
			</tr>
			<tr>
			<td colspan="1"><input type="button" value="수정" onclick="checkAddress()">
			<input type="button" value="삭제" onclick="del(${detail_view.aId })"></td>
			<td align="right"><a href="list.do">목록으로</a> </td>
			</tr>
		</table>
	</form>
	</div>
	
	
	


</body>
</html>