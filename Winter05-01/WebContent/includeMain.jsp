<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>includeMain.jsp 파일~~~</h1>
	<hr>
	flush - true/flase차이는 
	true는 버퍼비우고 감 이전(위에) 것 사용 불가함
	flase는 가지고 갔다가 복귀함 그래서 지시자랑 비슷하고 이전 것도 사용가능
	<jsp:include page="includeSub.jsp" flush="true" />
	<hr>
	<h1>
	다시
	    includeMain.jsp 파일~~
	</h1>
</body>
</html>