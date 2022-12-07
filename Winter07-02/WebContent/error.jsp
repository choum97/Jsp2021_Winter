<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%><!-- 에러페이지 맞아요~-->
<% response.setStatus(200); // 에러지만 정상이라고 처리해주는 것%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>요기에 에러 처리이미지 혹은 메세지 작성하면 됩니다</h1>
	<hr>
	<h3>에러 발생!!!<br/>
	<%= exception.getMessage()%>
	</h3>
	
</body>
</html>