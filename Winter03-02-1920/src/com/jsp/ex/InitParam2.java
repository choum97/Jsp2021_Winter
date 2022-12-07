package com.jsp.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/InitParam2"}, initParams = {@WebInitParam(name = "id",value = "ppp"), @WebInitParam(name = "pw",value = "999")})
public class InitParam2 extends HttpServlet {

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
