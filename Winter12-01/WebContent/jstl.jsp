<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL 실습</h1>
	<hr>
	<h3>
		<c:set var="name" value="변수의값" />
		변수 name의 값 : <c:out value="${name}" /><br/>
		<c:remove var="name"/>
		변수 name의 값 : <c:out value="${name}" /><br/>
		
		<hr>
		
		<c:catch var="error">
			<%=2/0 %>
		</c:catch><br/>	
		<c:out value="${error}"/>
		
		<hr>
	
		<c:if test="${(1+2)==3}">
			1 + 2 = 3; <br/>
			조건이 참일 때 실행되는 문장들을 작성한다. <br/>
		</c:if>	
		
		<c:if test="${(1+2)!=3}">
			1 + 2 = 3; <br/>
			이 친구는 아무리 해도 실행이 안됩니다. <br/>
		</c:if>	
		
		<hr>
		
		<c:forEach var="fEach" begin="0" end="15" step="3">
			${fEach} <br/>
		</c:forEach>		
		
	</h3>
</body>
</html>