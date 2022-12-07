<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! String id, pw; %>

<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	
	if(id.equals("abcd")&&pw.equals("1234")){
		Cookie ck = new Cookie("id",id);
		ck.setMaxAge(60);
		response.addCookie(ck); //쿠키 심어주기
		response.sendRedirect("welcome.jsp");
	} else{
		response.sendRedirect("login.html");
	}
	
%>

</body>
</html>