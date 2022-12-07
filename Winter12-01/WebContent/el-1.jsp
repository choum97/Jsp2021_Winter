<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 실습 내용</h1>
	<hr>
	
	${10}<br/>
	${99.99}<br/>
	${"abc"}<br/>
	${true}<br/>
	<hr>
	${1+7}<br/>
	${1*7}<br/>
	${1-7}<br/>
	${1/7}<br/>
	${1>7}<br/>
	${1<7}<br/>
	${(1>7)?1:7}<br/>
	${1>7||(1<7)}<br/>

	
</body>
</html>