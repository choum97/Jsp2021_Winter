<%@page import="com.jsp.ex.MemberDTO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.jsp.ex.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDAO dao = MemberDAO.getInstance(); //싱글턴 사용
	int checkIDNum = dao.userCheck(id, pw);
	
	if(-1 == checkIDNum){
%>
	<script laguage = "javascript">
		alert("ID가 존재하지 않습니다.")
		history.go(-1); /* 이전창으로 */
	</script>
<%
	} else if (0 == checkIDNum){
%>
		<script laguage = "javascript">
			alert("비밀번호가 다릅니다.")
			history.go(-1); /* 이전창으로 */
		</script>
<%
	} else if (1 == checkIDNum){
		MemberDTO dto = dao.getMember(id); //id로 값 가져오는듯
		
		if(dto == null){
%>
		<script laguage = "javascript">
			alert("회원이 존재하지 않습니다.")
			history.go(-1); /* 이전창으로 */
		</script>
<%			
		} else{
			String name = dto.getName(); //이름 가져옴 이거있어야 결과창에서 null안뜸
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("validMember", "OK");
			response.sendRedirect("loginResult.jsp");
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>