<%@page import="com.jsp.ex.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jsp.ex.MemberDAO"%>
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
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = new MemberDTO();
	ArrayList<MemberDTO> dtos = dao.MemberSelect();
%>

<%
	for(int i=0;i<dtos.size();i++){
		dto = dtos.get(i);
		String id = dto.getUserID();
		String pw = dto.getUserPW();
		String name = dto.getUserName();
		String email = dto.getUserEmail();
		
		out.println("ID : "+ id +"<br/>");
		out.println("PW : "+ pw +"<br/>");
		out.println("이름 : "+ name +"<br/>");
		out.println("이메일 : "+ email +"<br/>");
		out.println("--------------------<br/>");
	}
%>
</body>
</html>