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
		String id, pw, name;
	%>
	<h1>로그인 결과!</h1>
	<hr>
	<%
		id = (String)session.getAttribute("id");
		pw = (String)session.getAttribute("pw");
		name = (String)session.getAttribute("name");
	%>
	
	<%=name %>님의 로그인을 환영합니다!!!!~ <br/>
	<a href="modify.jsp">정보수정하러가기</a>
	
</body>
</html>