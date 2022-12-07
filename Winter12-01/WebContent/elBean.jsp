<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="stu" class="com.jsp.ex.Student" scope="page" />
	
	<jsp:setProperty name="stu" property="name" value="김요한"/>
	<jsp:setProperty name="stu" property="major" value="융합소프트웨어"/>
	<jsp:setProperty name="stu" property="grade" value="2학년"/>
	
	<h1>bean과 EL을 표현비교</h1>
	<hr>
	<h3>
		이름 : <jsp:getProperty property="name" name="stu"/><br/>
		학과 : <jsp:getProperty property="major" name="stu"/><br/>
		학년 : <jsp:getProperty property="grade" name="stu"/><br/>
		
		<hr>
	
		이름 : ${stu.name}<br/>
		학과 : ${stu.major}<br/>
		학년 : ${stu.grade}<br/>
	</h3>
</body>
</html>