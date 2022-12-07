<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>FrontController 패턴 실습</h1>
	<hr>
	<h3>
		<a href="insert.do">삽입하기 </a> <br/><br/>
		<a href="http://localhost:8087<%=request.getContextPath()%>/update.do">정보변경 </a> <br/><br/><!-- 절대경로 -->
		<a href="http://localhost:8087/Winter13-01/select.do">가져오기 </a> <br/><br/>
		<a href="<%=request.getContextPath()%>/delete.do">삭제하기 </a><br/><br/>
	</h3>
	
</body>
</html>