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
	int age;
%>

<%
	String str = request.getParameter("age");
	age = Integer.parseInt(str); //Int로 바꿈 - Wrapper(래퍼)클래스
	
	if (age>=20){
		response.sendRedirect("passAge.jsp?age=" + age);
	} else{
		response.sendRedirect("ngAge.jsp?age="+ age);
	}
%>

</body>
</html>