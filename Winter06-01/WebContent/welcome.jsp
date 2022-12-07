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

	for(int i=0; i<cks.length; i++){  //쿠키 찍어보는거
		String id = cks[i].getValue(); //실직적인 값을 가져와야 해서 
		if(id.equals("abcd")){
			out.println(id + "님 환영합니다. <br/> 로그인 되었습니다. <br/>");
		}
	}
%>
<a href="logout.jsp">로그아웃하기</a>

</body>
</html>