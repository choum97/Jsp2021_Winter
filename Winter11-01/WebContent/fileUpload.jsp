<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드입니다</h1>
	<hr>
	<form action="fileUploadOK.jsp" method="post" enctype="multipart/form-data">
		파일 첨부 : <input type="file" name="file"><br/>
		<input type="submit" value="업로드">
		
	</form>
</body>
</html>