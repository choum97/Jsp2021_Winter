<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정완료~</h1>
	<hr>
	
	<h3>
		<%=session.getAttribute("name") %>님의 정보 수정을 완료했습니다.
		<a href="logout.jsp">로그아웃 하기</a>
	</h3>
</body>
</html>