<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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

<table>

			<tr> <td><h3>기본정보</h3> </td></tr>	
			<tr>
				<td> 이름 </td> 
				<td> <input id = "read" value="${ads.userName}" readonly="readonly" size="20"> </td>
			</tr>
			<tr>
				<td> 생년월일 </td> 
				<td> <input id="read" value="${ads.userBirth }" readonly="readonly" size="20"> </td>
			</tr>
			<tr>
				<td> 성별 </td> 
				<%-- <td>
				<%	if(%>${dto.userGender}<% == "female"){
					%>
					<input id="read" value="여성" readonly="readonly" size="20"> 
					<%
					}else if(%>${dto.userGender}<% == "male"){
					%>
					<input id="read" value="남성" readonly="readonly" size="20"> 
				  <% } %>
				</td> --%>
				<td> <input id="read" value="${ads.userGender}" readonly="readonly" size="20"> </td>
			</tr>
			<tr> <td><h3>연락처정보</h3></td></tr>
			<tr>
				<td> 이메일 </td> 
				<td> <input id="read" value="${ads.userEmail }" readonly="readonly" size="20"> </td>
			</tr>
			<tr>
				<td> 전화번호 </td> 
				<td> <input id="read" value="${ads.userPhone }" readonly="readonly" size="20"> </td>
			</tr>
			<tr>
				<td> <button formaction="">비밀번호 변경</button> </td>
				<td align="right"> <button formaction="">개인정보 수정</button> </td>
			</tr>

</table>

</div>
</body>
</html>