<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1 align="center">글 작성하기 페이지</h1>  <h3 align="right"> 접속자 ID : ${sessionID}
    <input type="button" value="로그아웃" onclick="javascript:window.location='logOut.do'"></h3>
	<hr>
	
	<form action="write.do">
		<table align="center" width="500" cellpadding="0" cellspadding="0" border="1">		
			
			<tr>
				<td><input type="text" name="bId" value="${sessionID}" name="bName"></td>
			</tr>
			
			<tr>
				<td><input type="text" placeholder="글 제목" name="bTitle"> </td>
			</tr>

			<tr>
				
				<td><textarea rows="50" cols="100" placeholder="글 내용" name="bContent"></textarea></td>
			</tr>	
			<tr>
				<td colspan="5"><input type="submit" value="글쓰기"> <a href="list.do">취소</a> </td>
			</tr>
		</table>
	</form>	
</body>
</html>