<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String id = null;
		String pw = null;
		String name = null;
		String email = null;

		private Connection con = null;
		private Statement st = null;
		ResultSet rs = null;
	
		String drive = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3307/test";	
		String did = "root";
		String dpw = "1234";
	
	%>
	<%
	
		id = (String)session.getAttribute("id");
	
		String query = "select * from member where userID='" + id + "'";
		
		Class.forName(drive);
		con = DriverManager.getConnection(url,did,dpw);		
		st = con.createStatement();
		rs = st.executeQuery(query);
		
		while(rs.next()){
			/* pw = rs.getString("m_pw");
			name = rs.getString("m_name");
			email = rs.getString("m_email"); */
			pw = rs.getString("userPW");
			name = rs.getString("userName");
			email = rs.getString("userEmail");
		}
	%>
	<h1>회원정보 수정</h1>
	<hr>
	<form action="modifyOk" method="post">
		ID : <input type="text" name="id" value=<%=id %> readonly="readonly" resize="10"><br />
		<!--  readonly="readonly" 읽기만 가능-->
		PW : <input type="password" name="pw" size="10"><br /> 
		이름 : <input type="text" name="name" value=<%=name %> size="10"><br /> 
		이메일 : <input type="text" name="email" value=<%=email %> size="10"><br /> 
		
<!-- 		취미 : 
		<input type="checkbox" name="hobby" value="movie">영화감상
		<input type="checkbox" name="hobby" value="music">음악감상
		<input type="checkbox" name="hobby" value="walk">산책
		<input type="checkbox" name="hobby" value="cook">요리
		<input type="checkbox" name="hobby" value="sleep">낮잠 <br />
		
		전공 : 
		<input type="radio" name="major" value="컴퓨터학과">컴퓨터
		<input type="radio" name="major" value="국문학과">국문학과
		<input type="radio" name="major" value="영문학과">영문학과
		<input type="radio" name="major" value="체육학과" checked="checked">체육학과
		<input type="radio" name="major" value="실용음악과">음악학과<br />
		
		희망 : 
		<select name="dream">
			<option value="개발자">개발자</option>
			<option value="요리사">요리사</option>
			<option value="가수">가수</option>
			<option value="재벌" selected="selected">재벌</option>
		</select> <br /> -->
		
		<input type="submit" value="수정하기"> &nbsp; <input type="reset" value="취소하기">
	</form>
	

</body>
</html>