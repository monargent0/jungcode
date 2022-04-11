<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>
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
<body>
<div class="list">
	<h1>Order List</h1>
		<table >
			<tr>
				<th hidden="">userID</th>
				<th hidden="">orderCode</th>
				<th>orderNumber</th>
				<th>productCode</th>
				<th>productDetail</th>
				<th>productName</th>
				<th>productSize</th>
				<th>productPrice</th>
				<th>orderAmount</th>
				<th>orderSum</th>
			</tr>
			<c:forEach items="${orderList }" var="dto">
			<c:if test="dto=">
			<form method="get" name="orderList">
			<tr>
				<td align="center" hidden="">
				<input type="text" value="<%=request.getParameter("userID") %>" name="userID" readonly="readonly" style="text-align:center; ">
				</td>
				<td align="center" hidden="">
				<input type="text" value="${dto.orderCode }" name="orderCode" readonly="readonly" style="text-align:center; ">
				</td>
				<td align="center">
				<a href="orderDetail.do?orderNumber=${dto.orderNumber }">${dto.orderNumber }</a>
				</td>
				<td align="center">
				<input type="image" value="${dto.productDetail }" name="productDetail" readonly="readonly">
				</td>
				<td align="center">
				<input type="text" value="${dto.productName }" name="productName" readonly="readonly">
				</td>
				<td align="center">
				<input type="text" value="${dto.productSize }" name="productSize" readonly="readonly">
				</td>
				<td align="center">
				<input type="text" value="${dto.productPrice }" name="productPrice" readonly="readonly">
				</td>
				<td align="center">
				<input type="text" value="${dto.orderAmount }" name="orderAmount" readonly="readonly">
				</td>
				<td align="center">
				<input type="text" value="${dto.orderSum }" name="orderSum" readonly="readonly">
				</td>
				<td align="center">
				<input type="submit" value="후기 작성" formaction="reviewWrite.do?orderCode=${dto.orderCode }">
				<input type="submit" value="환불" formaction="refund.do?orderCode=${dto.orderCode }">	
				</td>
			</tr>
			</form>
			</c:if>
			</c:forEach>
		</table>
</div>
</body>
</html>