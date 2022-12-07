<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 base.jsp 페이지입니다.</h1>
	<hr>
	
	<%@include file="include.jsp" %>
	<hr>
	<!--html 주석 -->
	<h1>다시 base페이지 입니다</h1>
	
	<%
		/*
		GNB와 footer는 안바뀜 LNB는 GNB눌렀을때 그거인듯?
		*/
	%>
	
	<%-- 스크립틀릿 주석  --> 단축키 : Ctrl + Shift + /
		GNB와 footer는 안바뀜 LNB는 GNB눌렀을때 그거인듯?
	--%>
	
	
</body>
</html>