<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1대1 문의</title>
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
</head>
<body bgcolor="#FFFAF6">

 <div class="contents">
	<table border="1">
		<form action="counselDelete.do" method="post">
			<tr>
				<td>글번호</td>
				<td><input type="text" name="counselCode" size="5" value="${counselDetailV.counselCode}" readonly="readonly"></td>
			</tr>			
			<tr>
				<td>문의종류</td>
				<td><input type="text" name="counselType" size="15" value="${counselDetailV.counselType}" readonly="readonly"></td>
			</tr>			
			<tr>
				<td>제목</td>
				<td><input type="text" name="counselTitle" size="61" value="${counselDetailV.counselTitle }" readonly="readonly"></td>
			</tr>			
			</tr>
				<td>문의내용</td>
				<td><textarea name="counselContent" rows="10" cols="50" maxlength="100" readonly="readonly">${counselDetailV.counselContent } </textarea></td>
			</tr>
			<tr>
				<td>게시일</td>
				<td><input type="text" name="counselDate" size="25" value="${counselDetailV.counselDate}" readonly="readonly"></td>
			</tr>						
			<tr>
				<td><a href="counselList.do">목록보기</a></td>
				<td colspan="2" align="right"><input type="submit" value="삭제"></td>
			</tr>
	</table>	
	</div>	
</body>
</html>