<%@page import="java.io.PrintWriter"%>
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
		
		if(id.equals("yohan")&&pw.equals("1111")){
			session.setAttribute("id", id);
			response.sendRedirect("welcome.jsp");
		} else{
		PrintWriter sc = response.getWriter();
		sc.println("<script>");
		sc.println("alert('다시 확인해주세요')");
		sc.println("location.href='login.html'");
		sc.println("</script>");
		}
	%>

</body>
</html>