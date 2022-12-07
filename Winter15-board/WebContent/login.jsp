<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<% if(session.getAttribute("sessionID") != null){ //로그인 되어있으면 바로 보내는거%>
	<jsp:forward page="main.jsp"/>
<%} %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${loginResult == -1 || loginResult == 0}">
		<script>
			alert("아이디 혹은 비밀번호가 틀렸습니다.");
		</script>
	</c:if>
	<h1>로그인 페이지입니다.</h1>
	<hr>
	
	
	<form action="login.do" method="post">
		ID : <input type="text" name="id" size="10"> <br/>
		PW : <input type="password" name="pw" size="10"> <br/>
		<input type="submit" value="로그인"> &nbsp;&nbsp; 
		<input type="button" value="회원가입" onclick="javascript:window.location='join.jsp'"> &nbsp;&nbsp;
	</form>
	
</body>
</html>