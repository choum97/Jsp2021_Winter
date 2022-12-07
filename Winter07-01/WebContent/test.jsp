<%@page import="java.util.Enumeration"%>
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
out.println("----현재 세션 <br/>");
	Object obj1 = session.getAttribute("id"); // 세션 - 오브젝트
	String mySession = (String)obj1;	//세션이 오브젝트라서 형변환 해줘야함 
	out.println(mySession + "<br/>");

	out.println("-------------- <br/>");
	
	
	String sName, sValue;

	Enumeration enumeration = session.getAttributeNames();
	while(enumeration.hasMoreElements()){ //내용물이 없을때까지
		sName = enumeration.nextElement().toString();   // 이름 가져온 것
		// nextElement() 포인터 다음으로 가르키게 한 것
		// toString - 이름, 이름을 넣어주세요 라는 것 위에 코드
		sValue = session.getAttribute(sName).toString(); // 값을 가져온 것
		
		out.println("세션 이름 :  " + sName + "<br/>");
		out.println("세션 값 :  " + sValue + "<br/>");
	}
%>
<a href="welcome.jsp">이전으로</a><br/>
<a href="login.html">로그인으로 가기</a>
</body>
</html>