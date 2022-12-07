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
		String str = cks[i].getName(); //쿠키이름 str에 넣기
		if(str.equals("ckName")){//내가 집어넣은 이름이랑 같으면 출력
			out.println("cks[" + i + "] 이름 : " + cks[i].getName() + "<br/>");
			out.println("cks[" + i + "] 값 : " + cks[i].getValue() + "<br/>");
			out.println("-----------------------------------<br/>");
		}
	}
%>
	<a href="cookieDelete.jsp">쿠키 삭제하기</a>


</body>
</html>