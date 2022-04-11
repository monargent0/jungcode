<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cart List</title>
<style>
	  table {
        border-collapse: collapse;
        width: auto;
        height: auto;
      }
      
      table, th, td {
        padding: 5px;
       }
       th{
       border-top : 1px solid black;
       border-bottom: 1px solid black;
       }
       
      .list{
      	position: absolute;
      	top : 50%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      }
</style>
</head>
<script>
// all check
function checkBoxAll(event) {
	const query = 'input[name="check"]';
	const selectedEls = document.querySelectorAll(query);

	if (event.target.checked) {
		selectedEls.forEach((el) => {
			el.checked = true;
		});
	} else {
		selectedEls.forEach((el) => {
			el.checked = false;
		});
	}
}
// checked 값 받아오기
function checkBoxAllValue() {
	const query = 'input[name="check"]:checked';
	const selectedEls = document.querySelectorAll(query);

	// 선택된 목록에서 value 찾기
	let result = '';
	selectedEls.forEach((el) => {
		result += el.value + ',';
	});
	alert(result);
	
}
function cartCodeCheckA() {
	
	var check = document.getElementsByName('check');
	var cartCodeCheck; // 여기에 선택된 값이 담기게 된다.
	for(var i=0; i<check.length; i++) {
	    if(check[i].checked) {
	        cartCodeCheck += check[i].value + ',';
	    }
	}
	alert(cartCodeCheck);
	form.submit();
}
</script>
<body>
<div class="list">
	<h1>장바구니</h1>
	<table border="1">
			<tr>
				<th hidden="">userID</th>
				<th hidden="">cartCode</th>
				<th hidden="">productCode</th>
				<th><input type="checkbox" name="checkAll" id="allCheck" onclick="checkBoxAll(event)"></th>
				<th>이미지</th>
				<th>이름</th>
				<th>용량</th>
				<th>가격</th>
				<th>수량</th>
				<th>합계</th>
				<th colspan="2">action</th>
			</tr>
			<c:forEach items="${cartList }" var="dto" varStatus="status">
			<form>
			<tr>
				<td align="center" hidden="">
				<input type="text" value="<%=request.getParameter("userID") %>" name="userID" readonly="readonly" style="text-align:center; ">
				</td>
				<td align="center" hidden="">
				<input type="text" value="${dto.cartCode }" name="cartCode" readonly="readonly" style="text-align:center; ">
				</td>
				<td hidden="">
				<input type="text" value="${dto.productCode }" name="productCode" readonly="readonly">
				</td>
				<td>
				<input type="checkbox"  name="check" value="${dto.cartCode }">
				</td>
				<td align="center">
				<input type="image" value="${dto.productImages }" name="productImages" readonly="readonly" onclick="prodctDetail.do?productCode=${dto.productCode }">
				</td>
				<td align="center">
				<input type="text" value="${dto.productName }" name="productName" readonly="readonly" size="50">
				</td>
				<td align="center">
				<input type="text" value="${dto.productSize }" name="productSize" readonly="readonly" size="3">
				</td>
				<td align="center">
				<input type="text" value="${dto.productPrice }" name="productPrice" readonly="readonly" size="5">
				</td>
				<td align="center">
				<input type="text" value="${dto.cartAmount }" name="cartAmount" readonly="readonly" size="3">
				</td>
				<td align="center">
				<input type="text" value=${dto.cartSum } name="cartSum" readonly="readonly" size="5">
				</td>
				<td align="center">
				<input type="submit" value="선택상품 삭제" formaction="cartDelete.do">
				</td>
				</td>
				<td align="center">
				<input type="submit" value="선택상품 주문" formaction="orderWriteV.jsp">
				</td>
			</tr>
			</form>
			</c:forEach>
	</table><br>
	<form name="cartDelete" action="cartDelete.do" hidden="">
		<input type="button" value="선택 삭제" onclick="checkBoxAllValue()">
	</form>
	<form name="orderWrite" action="orderWrite.do?orderSum=" hidden="">
		<input type="button" value="선택 주문" onclick="cartCodeCheckA()">
	</form>
</div>
</body>
</html>
