<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
<%
	out.println("서버 : " + request.getServerName()+ "<br />");
	out.println("포트번호 : " + request.getServerPort()+ "<br />");
	out.println("Get방식/Post방식 : " + request.getMethod()+ "<br />");
	out.println("프로토콜 : " + request.getProtocol()+ "<br />");
	out.println("URL : " + request.getRequestURL()+ "<br />");
	out.println("URI-절대경로 : " + request.getRequestURI()+ "<br />"); //서버주소 뺀 나머지 부분이 URI
	out.println("ContextPath : " + request.getContextPath()+ "<br />"); // 프로젝트 이름이라 보면 됨
%>

</h1>

</body>
</html>