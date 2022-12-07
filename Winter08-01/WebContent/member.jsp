<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	//시작 - 선언부분 
	Connection con;
	Statement st;
	ResultSet rs;
	
	String driver = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://localhost:3307/test";
	String id = "root";
	String pw = "1234";

	String query = "SELECT * from member";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원명단</h1>
	<hr>
<%
	try{
		Class.forName("org.mariadb.jdbc.Driver");
		con = DriverManager.getConnection(url, id, pw);
		st = con.createStatement();
		rs = st.executeQuery(query);
		
		while(rs.next()){
			String name = rs.getString("userName");
			String id = rs.getString("userID");
			String pw = rs.getString("userPW");
			String email = rs.getString("userEmail");
			
			out.println("이름 : " + name + "<br/>");
			out.println("ID : " + id + "<br/>");
			out.println("PW : " + pw + "<br/>");
			out.println("이메일 : " + email + "<br/>");
			out.println("------------------------<br/>");
		}
	}catch (Exception e){
		e.printStackTrace();
	} finally{
		try{
			rs.close();
			st.close();
			con.close();
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}
	
%>
	
</body>
</html>