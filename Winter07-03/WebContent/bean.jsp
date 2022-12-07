<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- scope="page"는 해당 페이지내에서만 가능 
	     scope="request"면 요청에 한해서만
		scope="session" 해당 세션에서만 
		application  이 전체 내에서 다 사용가능
	-->
	<jsp:useBean id="stu" class="com.jsp.ex.Student" scope="page" /><!--  사용한다고 객체만들어 놓은 것 -->
	
	<!-- Property : 속성 -->
	<jsp:setProperty value="김요한" property="name" name="stu"/>
	<jsp:setProperty value="융합소프트웨어" property="major" name="stu"/>
	<jsp:setProperty value="3" property="grade" name="stu"/>
	<jsp:setProperty value="C(사회맞춤형반)" property="classNum" name="stu"/>
	
	<h1>나의 소개</h1>
	<hr>
	
	이름 : <jsp:getProperty property="name" name="stu"/><br/>
	학과 : <jsp:getProperty property="major" name="stu"/><br/>
	학년 : <jsp:getProperty property="grade" name="stu"/><br/>
	반 : <jsp:getProperty property="classNum" name="stu"/><br/>
	
	
</body>
</html>