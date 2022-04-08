<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	String postcode = request.getParameter("postcode");
	String mainAddress = request.getParameter("mainAddress");
	String detailAddress = request.getParameter("detailAddress");
	String extraAddress = request.getParameter("extraAddress");
	String usertype = request.getParameter("usertype");
	
	
	String url_mysql = "jdbc:mysql://localhost:3306/eclipse?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
			// 내가 접속할 localhost(ip주소) DB이름(eclipse) 현재시간 캐릭터타입 보안서버사용유무를 정해준다.
	String id_mysql = "root";
	String pw_mysql =  "qwer1234";

	PreparedStatement ps = null; // values 뒤에 ?를 해석해준다 , jar파일이 있어야 빨간줄이 안 뜬다. sql언어라고 변역하는 기능
	try{
		Class.forName("com.mysql.cj.jdbc.Driver"); // 아까 lib로 옮겨줬던 mysql jar파일 경로
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); // java.sql로 선택해야함. sql과 연결
		// 연결 끝
		Statement stmt_mysql = conn_mysql.createStatement();
		// 언어 변역
		/* String A = "insert into wtest (userid"; // 한줄로 써도 됨 
		String B = ") values (?)"; // 띄어쓰기 주의 */
		String A = "insert into apitest (postcode, mainAddress, detailAddress, extraAddress, usertype) values (?,?,?,?,?)";
		
		//ps = conn_mysql.prepareStatement(A+B);
		ps = conn_mysql.prepareStatement(A);
		ps.setString(1, postcode); // ?의 갯수대로 써줘야 한다. ? 두개면 ps.setString(2, userid);
		ps.setString(2, mainAddress); // ps.setint도 있다 
		ps.setString(3, detailAddress); // ps.setint도 있다 
		ps.setString(4, extraAddress); // ps.setint도 있다 
		ps.setString(5, usertype); // ps.setint도 있다 
		ps.executeUpdate();
		
		conn_mysql.close(); // DB연결 끊어준다. 서버 접속 인원제한이 있기 때문에 끊어주지 않으면 몇번 클릭하면 서버에 접속할 수 없게 된다 
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	response.sendRedirect("api3.jsp");
%>