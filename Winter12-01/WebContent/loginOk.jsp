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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	%>
	<h1>EL의 내장 객체 출력</h1>
	<hr>
	<h3>
		ID : <%=id %><br/>
		PW : <%=pw %><br/>
		
		<hr>
		위는 처음 JSP 배울때 쓴 것 / 아래는 EL로 하는데 둘다 같은 것<br/>
		ID : ${param.id}<br/>
		PW : ${param.pw}<br/>

		ID : ${param["id"]}<br/>
		PW : ${param["pw"]}<br/>
		
		<hr>
		아래 두개는 전 페이지에 있어서 안나옴 <br/>
		applicationScope : ${applicationScope.app_name}<br/>
		sessionScope : ${session_name}<br/>
		pageScope : ${page_name}<br/>
		requestScope : ${request_name}<br/>	
		
		<hr>
		
		context 초기화 파라미터 <br/>
		${initParam.ctx_name}<br/>
		${initParam.ctx_id}<br/>
		${initParam.ctx_pw}<br/>
	</h3>
	
	
</body>
</html>