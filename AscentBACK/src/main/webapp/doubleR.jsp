<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	
	function apply(){
		var txt = "check" ;
		var id =  "<%=request.getParameter("userID")%>" ;
		window.opener.document.signin.userID.value = id;
		window.opener.document.signin.idcheck.value = txt ;
		window.close();
	}

</script>
<body>

<div class="contents">
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("userID");
 	String txt = "";
 	if(session.getAttribute("idtxt") == "Nodouble"){
 		txt = "사용 가능한 아이디 입니다.";
		session.invalidate();
		
 	}else if(session.getAttribute("idtxt") == "Double"){
 		txt = "사용이 불가능한 아이디 입니다.";
 		session.invalidate();
 	}
 
 %>
		<div>
			<h3>아이디 중복 체크 결과	</h3>
		</div>
		<div>
			[ <%=  id %> ] 는 <br>
			<%= txt %>
		</div>
		
		<div style="float: left;">
			<% if( txt == "사용이 불가능한 아이디 입니다."){ %>
			<button type="button" onclick= "javascript:history.back()" >다시검색</button>
			<% }else if( txt == "사용 가능한 아이디 입니다."){ 	%>
			<button type="button" onclick= "apply()" >사용하기</button>			
  		    <% } %>
		</div>	
		


</div>



</body>
</html>