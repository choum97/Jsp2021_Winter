
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${joinResult == 0}">
		<script>
			alert("아이디가 중복됩니다.");
		</script>
	</c:if>

	<h1>회원가입 페이지입니다.</h1>
	<hr>
	<form action="join.do" method="post">
		ID : <input type="text" name="id" size="20"><br />
		PW : <input type="password" name="pw" size="20"><br /> 
		이름 : <input type="text" name="name" size="20"><br /> 
		이메일 : <input type="text" name="email" size="20"><br /> 
		<input type="submit" value="회원가입하기"> &nbsp;&nbsp;&nbsp; 
		<input type="reset" value="취소하기" onclick="javascript:window.location='login.jsp'">
	</form>
</body>
</html>