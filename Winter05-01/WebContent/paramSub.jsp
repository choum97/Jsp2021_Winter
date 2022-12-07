<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! String id, pw; %>
	<%
		id = request.getParameter("id");
		pw = request.getParameter("pw");
	%>
	
	<h1>Sub 파일입니다</h1>
	<hr>
	<h3>
		ID : <%=id %><br/>
		PW : <%=pw %>
	</h3>
	
</body>
</html>