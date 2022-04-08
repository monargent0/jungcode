<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오중간</title>
</head>
<script src='https://code.jquery.com/jquery-3.1.1.js'></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
	Kakao.init("791e000695f7cbdbad65f5580138d253");
	
	/* Kakao.Auth.authorize({
		redirectUri: 'https://localhost:8080/RnD/kakaoend.jsp',
		
	});  */
	
	Kakao.Auth.loginForm({
		success: function(authObj) {
			KaKao.API.request({
				url:'/v2/user/me',
				success: function(res){
					console.log(res);
					var id = res.id;
					var email = res.kakao_account.email;
					var name = res.properties.nickname;
					var html = email + '<br>' + name;
					$('body').append(html) ;
					/* lacation.href='kakaologinform.jsp?email=' + email +'&name=' + name;*/
				 }
			})
			
			console.log(authObj);
			var token = authObj.access_token;			
		},
		fail : function(err) {
			alert(JSON.stringfy(err));
		}
	}) 


</script>
<body>

</body>
</html>