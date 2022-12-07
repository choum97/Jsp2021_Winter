<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! //선언
		int i = 10;
		String str = "17831011 - 김요한";
	
		public int sum(int a,int b){
			return a+b;
		}
	%>

	<%	
	//아래에서 표현식 사용한 것
	// 표현식에서는 ; 사용 안함
	
		out.println("i = ");
		//out.println(i + "<br />");-> 이렇게하면 귀찮고 길어지니깐
	%>
	
	<%=i %><br />
	<%=str %><br />
	<%=sum(5,9) %><br /> 

</body>
</html>