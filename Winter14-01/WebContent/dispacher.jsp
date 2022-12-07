<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>RequsetDispatcher 결과 화면 - 3번째</h1>
	<hr>
	<h3>
		ID : <%=request.getAttribute("id") %><br/>
		PW : <%=request.getAttribute("pw") %><br/>
		
		--------------------<br>
		여기 2 안나옴 - 고객센터랑 실제 담당부서 비유 생각하면 됨 <br>
		ID2 : <%=request.getAttribute("id2") %><br/>
		PW2 : <%=request.getAttribute("pw2") %><br/>
		
		<%
			//여기 지우면 4로 넘어가짐
			//RequestDispatcher dispatcher = request.getRequestDispatcher("dis2.jsp");
			//dispatcher.forward(request, response);
		%>
	</h3>
</body>
</html>