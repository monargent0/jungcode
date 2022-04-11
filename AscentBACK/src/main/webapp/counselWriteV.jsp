<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
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
      
      table, td {
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
<title>1대1 문의 작성</title>
</head>
<body bgcolor="#FFFAF6">

 <div class="contents">
	<h2>ascent 1대1 문의폼</h2>
		<table border="1">
		<form action="counselWrite.do" method="post">
			<tr>
				<td>문의종류</td>
				<td><select name="counselType">
					<option value= 환불>환불</option>
					<option value= 배송>배송</option>
					<option value= 주문결제>주문/결제</option>
					<option value= 회원>회원 관련</option>
					<option value= 상품>상품 관련</option>				
					<option value= 사이트이용>사이트 이용</option>				
					<option value= 기타문의>기타</option>				
				</select></td>
			</tr>	
			<tr>
				<td>제목</td>
				<td><input type="text" name="counselTitle" size="50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="counselContent" rows="10" cols="50" maxlength="100"></textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="image" accept="image/*" multiple></td>
			</tr>			
			<tr>
				<td><a href="counselList.do">목록보기</a></td>
				<td colspan="2" align="right"><input type="submit" value="입력"></td>
			</tr>
		</form>
	</table>	
	</div>
</body>
</html>