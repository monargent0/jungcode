<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OneLine 게시판</title>
<style>
	  table {
        border-collapse: collapse;
        border: 3px solid #73AD21;
      }
      table, th, td {
        padding: 5px;
       }
      .divtable{
      	position: absolute;
      	top : 50%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      }
    </style>
</head>
<body>

	<h2>OneLine 게시판</h2>
	<div class="divtable">
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>날짜</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td align="center">${dto.pId}</td>
				<td>${dto.pName}</td>
				<td>${dto.pTitle}</td>
				<td>${dto.pDate}</td>
				<td align="center"><a href="delete.do?pId=${dto.pId}">X</a></td>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view.do">글 작성</a></td>
		</tr>
	</table>
	</div>

</body>
</html>