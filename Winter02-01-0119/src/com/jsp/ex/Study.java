package com.jsp.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Study") //url 패턴지정 해준것
public class Study extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget()메소드가 실행되는 내용을 적습니다!");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();//스트림 형태로 파일을 전송
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>");
		writer.println("학과 : 융합소프트웨어 <br />");
		writer.println("<hr />");
		writer.println("학번:17831011 <br />");
		writer.println("이름: 김요한");
		writer.println("</h1>");
		writer.println("</body>");
		writer.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
