<%@page import="com.jsp.ex.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>데이터 삽입 페이지~</h1>
	<hr>
	<%
		MemberDAO dao = new MemberDAO();
		dao.MemberInsert();
	%>
	새로운 멥버 삽입이 완료 되었습니다.

	<a href="memberView.jsp">회원 확인하러 가기</a>
</body>
</html>