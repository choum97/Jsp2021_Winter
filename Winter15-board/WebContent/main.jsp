<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("sessionID") == null){ //로그인 되어있으면 바로 보내는거%>
	<jsp:forward page="login.jsp"/>
<%} %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1 align="center">경민 사이트</h1>
	<hr>
	<h3>
	${sessionID}님 환영합니다. &nbsp;&nbsp; <input type="button" value="로그아웃" onclick="javascript:window.location='logOut.do'">
	 <br/>
	
		<a href="list.do">게시판</a> &nbsp;&nbsp; 
		
	</h3>
</body>
</html>