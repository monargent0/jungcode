<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 관리</title>
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
       th{
       border-bottom: 1px solid black;
       bor
       }
       
      .address{
        border: 10px solid lightblue;
      	position: absolute;
      	top : 50%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      }
    
    </style>
</head>
<body>

	<div class="address">
	<center><h2>주소록</h2></center>	
	<table >
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>전자우편</th>
			<th>관계</th>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td align="center"><a href="detail_view.do?aId=${dto.aId}">${dto.aId}</a></td>
				<td>${dto.aName}</td>
				<td>${dto.aTel}</td>
				<td>${dto.aAddress}</td>
				<td>${dto.aEmail}</td>
				<td>${dto.aRelation}</td>
		</c:forEach>
		<tr>
			<td colspan="6"><a href="write_view.do">주소록 추가 등록</a></td>
		</tr>
	</table>
	</div>

</body>
</html>