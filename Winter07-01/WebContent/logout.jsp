<%@page import="java.util.Enumeration"%>
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
	Enumeration enumeration = session.getAttributeNames();

	while(enumeration.hasMoreElements()){
		String name = enumeration.nextElement().toString();
		String value = (String)session.getAttribute(name); //오브젝트 형태라서 형변환 함
		
		if(value.equals("yohan")){
			session.removeAttribute(name);
			//response.sendRedirect("login.html");
		}
		
	}
%>

<a href="test.jsp">세션종료 확인하기</a>
</body>
</html>