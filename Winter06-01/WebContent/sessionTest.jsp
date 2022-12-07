<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Object obj1 = session.getAttribute("sName"); // 세션 - 오브젝트
	String mySession = (String)obj1;	//세션이 오브젝트라서 형변환 해줘야함 
	out.println(mySession + "<br/>");
	
	Object obj2 = session.getAttribute("number");
	Integer myNum = (Integer)obj2;
	out.println(myNum + "<br/>");
	
	out.println("---------------------------------<br/>");
	
	
	String sName, sValue;

	Enumeration enumeration = session.getAttributeNames();
	while(enumeration.hasMoreElements()){ //내용물이 없을때까지
		sName = enumeration.nextElement().toString();   // 이름 가져온 것
		// nextElement() 포인터 다음으로 가르키게 한 것
		// toString - 이름, 이름을 넣어주세요 라는 것 위에 코드
		sValue = session.getAttribute(sName).toString(); // 값을 가져온 것
		
		out.println("세션 이름 :  " + sName + "<br/>");
		out.println("세션 값 :  " + sValue + "<br/>");
	}
	
	out.println("---------------------------------<br/>");
	
	String sID = session.getId();
	out.println("세션 ID : "+ sID +"<br/>");
	int time = session.getMaxInactiveInterval();
	out.println("세션 유효시간 : "+ time +"<br/>");
	
	out.println("---------------------------------<br/>");
	
	session.removeAttribute("sName");   
	//아래는 지워진거 확인하려고 다시 찍음
	Enumeration enumeration2 = session.getAttributeNames();
	while(enumeration2.hasMoreElements()){ 
		sName = enumeration2.nextElement().toString();   
		sValue = session.getAttribute(sName).toString(); 
		out.println("세션 이름 :  " + sName + "<br/>");
		out.println("세션 값 :  " + sValue + "<br/>");
	}
	
	out.println("---------------------------------<br/>");
	
	session.invalidate(); // 모든 세션 삭제
	if(request.isRequestedSessionIdValid()){
		out.println("유효 세션 존재");
	} else{
		out.println("유효 세션 없다");
	}
%>

</body>
</html>
