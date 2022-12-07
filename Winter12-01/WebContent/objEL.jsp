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
		//앞이 변수이름 / 뒤에는 값들
		application.setAttribute("app_name", "1.현재앱_경민앱(실제이름)");
		session.setAttribute("session_name", "2.현재세션값(융소과)");
		pageContext.setAttribute("page_name", "3.현재페이지_구문값(실습파일)");
		request.setAttribute("request_name", "4.현재앱_실제이름");
	%>

	<h1>EL의 내장 객체 TEST</h1>
	<hr>
	<h3>
		<form action="loginOk.jsp" method="get">
			ID : <input type="text" name="id"><br/>
			pw : <input type="password" name="pw"><br/>
			<input type="submit" value="로그인">
		</form>
	
	</h3>
</body>
</html>