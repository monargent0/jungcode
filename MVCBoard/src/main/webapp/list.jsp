<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC게시판</title>
</head>
<body>

	<h1>MVC게시판</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="dto" >
			<tr>
				<td><a href="content_view.do?bId=${dto.bId}">${dto.bId}</a></td>
				<td>${dto.bName}</td>
				<td>${dto.bTitle}</td>
				<td>${dto.bDate}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view.do">글작성</a></td>
		</tr>
	</table>
</body>
</html>