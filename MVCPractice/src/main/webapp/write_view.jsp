<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 작성</title>
</head>
<body>
	<form action="write.do" method="post">
		<table>
			<tr>
			<td>이름</td>
			<td><input type="text" name="pName" size="50"></td>
			</tr>
			<tr>
			<td>제목</td>
			<td><input type="text" name="pTitle" size="50"></td>
			</tr>
			<tr>
			<td><input type="submit" value="입력"> </td>
			<td align="right"><a href="list.do">목록보기</a></td>
			</tr>		
		</table>
	
	</form>
	
</body>
</html>