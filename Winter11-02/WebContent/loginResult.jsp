<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	if(session.getAttribute("validMember") == null){
		//로그인 인증이 안된것
%>
		<jsp:forward page="login.jsp"/>
<%		
	}
	String name = (String)session.getAttribute("name");		
	String id = (String)session.getAttribute("id");	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>환영합니다!! 로그인되었습니다</h1>
	<hr>
	<h3>
		<%=name %>님 환영합니다
		<form action="logout.jsp">
			<input type="submit" value="로그아웃"> &nbsp;&nbsp;&nbsp;
			<input type="button" value="정보수정" onclick="javascript:window.location='modify.jsp'">&nbsp;&nbsp;&nbsp;
			<input type="button" value="메인화면" onclick="javascript:window.location='main.jsp'">&nbsp;
		</form>
	</h3>
	
	
</body>
</html>