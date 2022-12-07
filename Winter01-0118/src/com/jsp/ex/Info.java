package com.jsp.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Info")
public class Info extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget() 메소드 실행입니다!");
		
		response.setContentType("text/html; charset=UTF-8"); //나중에 이렇게 하지는 않음
		
		PrintWriter writer = response.getWriter(); //스트림 보내는거 - 담아서 파일로 보내는것 
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>");
		writer.println("안녕하세요 저는 경민대학교 융합소프트웨어과 김요한입니다.");
		writer.println("</h1>");
		writer.println("</body>");
		writer.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
