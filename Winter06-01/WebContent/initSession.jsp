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
	session.setAttribute("sName", "sValue-1234");
	session.setAttribute("number", 970728);
%>
<a href="sessionTest.jsp">세션 확인하기 </a>
</body>
</html>