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
	<h1 align="center">게시판 목록 보기</h1>  <h3 align="right"> 접속자 ID : ${sessionID}
    <input type="button" value="로그아웃" onclick="javascript:window.location='logOut.do'"></h3>
	
	<hr>
	<table align="center" width="500" cellpadding="0" cellspadding="0" border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.id}</td>
			<td>
				<c:forEach begin="1" end="${dto.indent}">-</c:forEach> <!-- dto의 indent만큼  -->
				<a href="bViewContent.do?id=${dto.id}">${dto.title}</a>
			</td>
			<td>${dto.name}</td>
			<td>${dto.date}</td>
			<td>${dto.hit}</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5"><a href="writeView.do">작성하기</a> <a href="main.do">메인으로</a> </td>
		</tr>
	</table>
</body>
</html>