<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
사용자 메인사이트
<br>
<a href="signOutV.jsp">회원탈퇴</a>
<br>
<a href="logOutH.jsp">로그아웃</a>
<br>
<%=session.getAttribute("userID") %>

</body>
</html>