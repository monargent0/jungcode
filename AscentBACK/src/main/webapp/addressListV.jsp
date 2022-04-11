<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
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
       
      .contents{
		position: absolute;
		left : 50%;
		transform : translate(-50%,0%);
		padding: 50px ;
		font-family:"나눔명조";
      	color:#463D3D;
	}
    
	#hyper{				
      	font-size: 14px;
      	font-family:"나눔명조";
      	color:#463D3D;
      }
    </style>
<meta charset="UTF-8">
<title>주소록</title>
</head>
<body bgcolor="#FFFAF6">

 <div class="contents">
	<h2>주소록</h2>

	<table border="1">
		<tr>
			<th>주소이름</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>아이디</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${address}" var="dto">
			<tr>
				<td>${dto.addressType}</td>
				<td>${dto.postcode }</td>
				<td>${dto.mainAddress}, ${dto.detailAddress} ${dto.extraAddress}</td>						
				<td>${dto.user_userID}</td>
				<td><a id="hyper" href="addressDelete.do?addressCode=${dto.addressCode }">X</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td align="right" colspan="5"><a id="hyper" href="addressWriteV.jsp">주소 추가</a></td>
		</tr>
	</table>	
	
		<br><a id="hyper" href="mainV.jsp">main</a> &nbsp; <a id="hyper" href="logOutH.jsp">로그아웃</a>
	</div>
</body>
</html>