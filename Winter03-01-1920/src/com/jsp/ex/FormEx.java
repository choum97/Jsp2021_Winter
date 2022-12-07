package com.jsp.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormEx")
public class FormEx extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요기는 doGet메소드 실행되는 구간입니다!"); //위아래 차이 Get인지 Post인지 차이임
		
		request.setCharacterEncoding("UTF-8");//한글로 읽어올꺼야
		
		String servletID = request.getParameter("id");
		String servletPW = request.getParameter("pw");
		String servletName = request.getParameter("name");
		String[] servletHobbys = request.getParameterValues("hobby"); //여러개 값을 받기 위해서
		String servletMajor = request.getParameter("major");
		String servletDream = request.getParameter("dream");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("Id : "+ servletID+"<br />");
		writer.println("PW : "+ servletPW+"<br />");
		writer.println("이름 : "+ servletName+"<br />");
		writer.println("취미 : "+ Arrays.toString(servletHobbys)+"<br />"); //이렇게 함
		writer.println("전공 : "+ servletMajor+"<br />");
		writer.println("희망 : "+ servletDream+"<br />");
		writer.println("</body>");
		writer.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요기는 doPost메소드 실행되는 구간입니다!");
		
		request.setCharacterEncoding("UTF-8");//한글로 읽어올꺼야
		
		String servletID = request.getParameter("id");
		String servletPW = request.getParameter("pw");
		String servletName = request.getParameter("name");
		String[] servletHobbys = request.getParameterValues("hobby"); //여러개 값을 받기 위해서
		String servletMajor = request.getParameter("major");
		String servletDream = request.getParameter("dream");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("Id : "+ servletID+"<br />");
		writer.println("PW : "+ servletPW+"<br />");
		writer.println("이름 : "+ servletName+"<br />");
		writer.println("취미 : "+ Arrays.toString(servletHobbys)+"<br />"); //이렇게 함
		writer.println("전공 : "+ servletMajor+"<br />");
		writer.println("희망 : "+ servletDream+"<br />");
		writer.println("</body>");
		writer.println("</html>");
		
	}

}
