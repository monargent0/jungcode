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
	}


    
    </style>
<meta charset="UTF-8">
<title>ascent 공지사항</title>
</head>
<body bgcolor="#FFFAF6">

 <div class="contents">
	<h2>공지사항</h2>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>종류</th>
			<th>제목</th>
			<th>게시일</th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.noticeCode }</td>
				<td>${dto.noticeType }</td>
				<td>${dto.noticeTitle}</td>						
				<td>${dto.noticeDate}</td>
			</tr>
		</c:forEach>
	</table>	
	</div>
</body>
</html>