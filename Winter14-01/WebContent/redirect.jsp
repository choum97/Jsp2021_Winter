<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>??????????</h1>
	<hr>
	<h3>
	<%
		//여기가 시작 - 1
		request.setAttribute("id2", "asdasd");
		request.setAttribute("pw2", "1234");
		
		response.sendRedirect("RequsestIObj");
	%>
		
	</h3>
</body>
</html>