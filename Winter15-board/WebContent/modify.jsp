<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">글 수정하기 페이지</h1>  <h3 align="right"> 접속자 ID : ${sessionID}
    <input type="button" value="로그아웃" onclick="javascript:window.location='logOut.do'"></h3>
	<hr>
	<table align="center" width="500" cellpadding="0" cellspadding="0" border="1">

		<tr>
			<td>번호</td>
			<td>${content_view.bId}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${content_view.bHit}</td>
		</tr>
		<tr>
			<td>글 제목</td>
			<td>${content_view.bTitle}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${content_view.bName}</td>
		</tr>
		<tr>
			<td>작성일자</td>
			<td>${content_view.bDate}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="50" cols="100">${content_view.bContent}</textarea></td>
		</tr>

		
		<tr>
			<td colspan="5"><a href="bContentModify.do">수정</a> <a href="list.do">목록</a> </td>
		</tr>
	</table>
	
	
	
</body>
</html>