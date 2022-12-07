<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="paramSub.jsp">
		<jsp:param value="aaaa" name="id"/>
		<jsp:param value="1111" name="pw"/>
	</jsp:forward>

</body>
</html>