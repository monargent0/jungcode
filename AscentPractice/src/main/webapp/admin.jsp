<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
 관리자 사이트
 <%
session.invalidate();
%>

<img id="preview" src="" width="300" height="300" alt="로컬에 있는 이미지가 보여지는 영역">
	<form action="mainV.jsp" method="get">
		<input type="file" id="upload" accept="image/*" >
		<input type="hidden" id="imgTxt" name="imgFile" >
		<input type="submit" value="리뷰등록">
	</form>
	
<script type="text/javascript">
	/* function img(){
		
	var file = document.getElementById('upload');
	file.onload = function(e) {
	  var files = e.target.files; // FileList 객체
	  console.log(files); // { 0: File, 1: File, length: 2 }
	  console.log(files[0]); // 아래에 적어놨습니다.
		}
	} */
	
	function readFile() {
	  
	  if (this.files && this.files[0]) {
	    
	    var FR = new FileReader();
	    
	    FR.onload = function(e) {
	    	//console.log(e.target.result);
	      document.getElementById("imgTxt").value = e.target.result;
	     // alert(document.getElementById("imgTxt").value)
	      document.getElementById("preview").src = e.target.result;
	    }; 
	    
	    FR.readAsDataURL( this.files[0] );
	  }
	  
	}
	
	document.getElementById("upload").addEventListener("change", readFile);
	
</script>
</body>
	
</html>