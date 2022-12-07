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
	Enumeration enumeration = session.getAttributeNames(); //이름들을 가져와서 열거형으로
	
	while(enumeration.hasMoreElements()){
		String name = enumeration.nextElement().toString(); // 이름 가져오기 위해서 - nextElement()
		String value = (String)session.getAttribute(name); 
		//name이 가지고 있는 값을 가져와서 형변환해서 넣음
		
		if(value.equals("yohan")){
			out.println(value +"님 환영합니다.<br/>");
			
		}
	}
%>
	<a href="test.jsp">세션확인</a><br/>
	<a href="logout.jsp">로그아웃하기</a>
</body>
</html>