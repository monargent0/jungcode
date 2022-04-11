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
<title>ascent 1대1 문의</title>
</head>
<body bgcolor="#FFFAF6">

 <div class="contents">
	<h2>1대1 문의</h2>

	<table border="1">
		<tr>
			<th>글번호</th>
			<th>문의종류</th>
			<th>제목</th>
			<th>게시일</th>
			<th>답변여부</th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td style="text-align: center;"> ${dto.counselCode }</td>
				<td>${dto.counselType }</td>
				<td><a id="hyper" href="counselDetail.do?counselCode=${dto.counselCode }">${dto.counselTitle}</a></td>						
				<td>${dto.counselDate}</td>
				<td>${dto.c_ReplyCheck}</td>
			</tr>
		</c:forEach>
		<tr>
			<td align="right" colspan="5"><a id="hyper" href="counselWriteV.jsp">글작성</a></td>
		</tr>
	</table>	
	
		<br><a id="hyper" href="mainV.jsp">main</a> &nbsp; <a id="hyper" href="logOutH.jsp">로그아웃</a>
	</div>
</body>
</html>