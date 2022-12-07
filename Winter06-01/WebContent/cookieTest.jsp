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
	Cookie[] cks = request.getCookies();

	if(cks != null){
		for(int i =0; i<cks.length;i++){
			out.println(cks[i].getName() + "<br/>");
			out.println(cks[i].getValue() + "<br/>");
			out.println("----------------------<br/>");
		}
	}
%>


</body>
</html>