<%@page import="java.sql.DatabaseMetaData"%>
<%@page import="java.sql.DriverManager"%>
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
<%
	try{
		Class.forName("org.mariadb.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3307/test","root","1234");
		DatabaseMetaData meta = con.getMetaData();		
		//메타데이터는 정보의 다시 정보라고나 할까?라 함
		// 데이터의 대표 
		
		out.println("DataBase 이름: "+ meta.getDatabaseProductName() + "<br/>");
		out.println("DataBase 버전: "+ meta.getDatabaseProductVersion() + "<br/>");
		out.println("User 이름 : "+ meta.getUserName() + "<br/>");
	}catch(Exception e) {
		out.println(e);	
	}

%>
</body>
</html>