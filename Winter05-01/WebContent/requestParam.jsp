<%@page import="java.util.Arrays"%>
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
		String id, pw, name, major, dream;
		String[] hobbys;
	%>
	
	<%
		request.setCharacterEncoding("UTF-8"); //한글로 
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		major = request.getParameter("major");
		dream = request.getParameter("dream");
		hobbys = request.getParameterValues("hobby"); //배열은 이렇게 받아옴
	%>
	
	<h1>나의 소개</h1>
	<hr>
	<h3>
	ID : <%=id %><br/>
	Pw : <%=pw %><br/>
	이름 :  <%=name %><br/>
	취미 :  <%=Arrays.toString(hobbys) %><br/>
	전공 :  <%=major %><br/>
	장래희망 :  <%=dream %><br/>
	</h3>
	
</body>
</html>