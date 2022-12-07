<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 페이지입니다.</h1>
	<hr>
		<form action="joinOk.jsp" method="post">
		ID : <input type="text" name="id" size="20"><br /> 
		PW : <input type="password" name="pw" size="20"><br /> 
		PW 재확인 : <input type="password" name="repw" size="20"><br /> 
		이름 : <input type="text" name="name" size="20"><br /> 
		이메일 : <input type="text" name="email" size="20"><br /> 		
		
		<input type="submit" value="회원가입하기"> &nbsp;&nbsp;&nbsp;  
		<input type="reset" value="취소하기" onclick="javascript:window.location='login.jsp'">
	</form>
</body>
</html>