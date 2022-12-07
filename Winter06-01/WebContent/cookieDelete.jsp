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

	for(int i=0; i<cks.length; i++){  
		String str = cks[i].getName(); 
		if(str.equals("ckName")){
			out.println("쿠키 이름 : " + cks[i].getName() + "<br/>");
			cks[i].setMaxAge(0); //0으로 바꿔서 사용할 수 없게
			response.addCookie(cks[i]);
		}
	}
%>
	<a href="cookieTest.jsp">쿠키 삭제 확인하기</a>

</body>
</html>