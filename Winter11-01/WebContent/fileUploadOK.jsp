<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		String path = request.getRealPath("File");
		
		int size = 1024 * 1024 * 10;
		String file = ""; //업로드 했을때 서버에 저장될 이름
		String oriFile = ""; // 오리지널 이름
		
		try{
			MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8",new DefaultFileRenamePolicy());
			
			Enumeration files = multi.getFileNames();
			String str = (String)files.nextElement(); //열거형이라 형변환?
			
			file = multi.getFilesystemName(str);
			oriFile = multi.getOriginalFileName(str);		
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	
	<h1>파일 업로드 완료!</h1>
</body>
</html>