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
	Cookie[] cks = request.getCookies(); //몇개 있을지 몰라서 배열 형태로 받아옴
	
	if(cks != null){
		for(int i=0; i<cks.length; i++){
			if(cks[i].getValue().equals("abcd")){
				cks[i].setMaxAge(0); //0으로 만들고 
				response.addCookie(cks[i]); //이렇게 실어서 보내야함
			}
		}
	}
	
	response.sendRedirect("login.html");
%>


</body>
</html>