<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! int age; %>
	<%
		String str = request.getParameter("age");
		age = Integer.parseInt(str);
	%>
	<h1>
	꼬맹이가 입력한 나이는 <%=age %>네~<br/>
	이놈 돌아가!<br/>
	<a href="age.html">처음으로!</a>
	
	</h1>
</body>
</html>