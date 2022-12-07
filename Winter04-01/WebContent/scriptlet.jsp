<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% //스크립트릿
		int i = 0;
		while(true){
			i++;
			out.println("2 * "+ i +" = " + (2*i) +"<br />"); //out은 내장객체 - 몇개에 클래스에 대해서 미리 객체를 만들어둔 것
	%>
	-----------------------<br />
	<%
			if(9<=i) break;//소스보기로 봐도 내용을 알 수 없음 - 보안성
		}
	%>
	
	

</body>
</html>