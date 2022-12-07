<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% if(session.getAttribute("validMember") !=null){ //로그인 되어있으면 바로 보내는거%>
	<jsp:forward page="loginResult.jsp"/>
<%} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지입니다.</h1>
	<hr>
	
	<h3>
		<form action="loginOk.jsp" method="post">
			ID : <input type="text" name="id" size="10"> <br/>
			PW : <input type="password" name="pw" size="10"> <br/>
			<input type="submit" value="로그인"> &nbsp;&nbsp; 
			<input type="button" value="회원가입" onclick="javascript:window.location='join.jsp'"> &nbsp;&nbsp;
			<input type="button" value="취소" onclick="javascript:window.location='main.jsp'"> 
		</form>
	</h3>
</body>
</html>