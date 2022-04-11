<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 	<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Information</title>
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

<h2>My Information</h2>

	<form action="userModifyV.jsp" method="post">

<table>
			<tr> <td><h3>기본정보</h3> </td></tr>	
			
				<tr>
					<td> 이름 </td> 
					<td> <input name="userName" value="${uinfo.userName}" readonly="readonly" size="20"> </td>
				</tr>
				<tr>
					<td> 생년월일 </td> 
					<td> <input value="${uinfo.userBirth }" readonly="readonly" size="20"> </td>
				</tr>
				<tr>
					<td> 성별 </td> 
					<td> <input value="${uinfo.userGender}" readonly="readonly" size="20"> </td>
				</tr>
				<tr> <td><h3>연락처정보</h3></td></tr>
				<tr>
					<td> 이메일 </td> 
					<td> <input name="userEmail" value="${uinfo.userEmail }" readonly="readonly" size="20"> </td>
				</tr>
				<tr>
					<td> 전화번호 </td> 
					<td> <input name="userPhone" value="${uinfo.userPhone }" readonly="readonly" size="20"> </td>
				</tr>
			<tr>
				<td> <button onclick="location=''">비밀번호 변경</button> </td>
				<td align="right"> <button type="submit">개인정보 수정</button> </td>
			</tr>
			<tr>
				<td><a href="mainV.jsp">main</a> &nbsp; <a href="logOutH.jsp">로그아웃</a><br></td>
			</tr>
</table>
	</form>
	
	
</div>
</body>
</html>