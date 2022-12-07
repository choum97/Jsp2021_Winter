<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>dis2 결과 화면 - 4</h1>
	<hr>
	<h3>
		메롱메롱 <br/>
		여기가 1<br>
		<%=request.getAttribute("id") %><br>
		<%=request.getAttribute("pw") %><br>
		--------------------<br>
		이거가 2 고객센터랑 실제 담당부서 비유 생각하면 됨 <br>
		<%=request.getAttribute("id2") %><br>
		<%=request.getAttribute("pw2") %><br>
	</h3>
</body>
</html>