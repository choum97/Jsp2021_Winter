package com.jsp.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//이런 (url?)패턴으로 들어오면 내가 실행해주세요 - 이걸로 접근됨 수정하면 바뀜, 컨트롤러(조정자) 역할 한다 서버에서
@WebServlet("/He") 
public class Hello extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여러분 열심히 해야 해요~~~"); //콘솔에 나옴
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
