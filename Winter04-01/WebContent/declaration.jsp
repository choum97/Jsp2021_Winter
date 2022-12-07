<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% // !넣어도 됨 여기
		int i = 10;
		String str = "ABCD";
		String[] str2 = {"abc", "def","ghi"};
	%>	
		
	<%! //선언부
		public int sum(int a,int b){
			return a+b;
		}
	%>
		
	<%	
		out.println("i = " + i + "<br />");
		out.println("str = "+ str + "<br />");
		out.println("sum = "+ sum(2,3) + "<br />");
		out.println(Arrays.toString(str2));
	%>
	
</body>
</html>