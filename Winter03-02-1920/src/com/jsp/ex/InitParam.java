package com.jsp.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InitParam")
public class InitParam extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 실행부");
		
		String id = getInitParameter("id");
		String pw = getInitParameter("pw");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter wr = response.getWriter();
		
		wr.println("<html>");
		wr.println("<head>");
		wr.println("</head>");
		wr.println("<body>");
		wr.println("Id : " + id + "<br />");
		wr.println("PW : " + pw);
		wr.println("</body>");
		wr.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
