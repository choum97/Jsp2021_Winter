package com.jsp.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}
	
	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("URI의 값 : " + uri);//서버주소를 뺀 나머지가 uri
		
		String ctxPath = request.getContextPath();
		System.out.println("Context Path의 값 : " + ctxPath);
		
		String cmd = uri.substring(ctxPath.length()); //ctx의 길이만큼 자름
		System.out.println("입력된 명령 : " + cmd);
		
		if(cmd.equals("/insert.do")) {
			System.out.println("/insert.do로 들어왔을 때 처리할 내용을 요기 작성한다");
			//response.sendRedirect();
		} else if (cmd.equals("/update.do")) {
			System.out.println("/update.do로 들어왔을 때 처리할 내용을 요기 작성한다");
		} else if (cmd.equals("/select.do")) {
			System.out.println("/select.do로 들어왔을 때 처리할 내용을 요기 작성한다");
		} else if (cmd.equals("/delete.do")) {
			System.out.println("/delete.do로 들어왔을 때 처리할 내용을 요기 작성한다");
		}
	}
}
