<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie ck = new Cookie("ckName","ckValue-1234"); // 쿠키(변수) 명, 쿠키 값
	ck.setMaxAge(60*60); // 60초x60 - 1시간
	response.addCookie(ck); // 클라이언트에 심어주는 것 , response로
%>
	<a href="cookieget.jsp">쿠키 가져오기</a>

</body>
</html>