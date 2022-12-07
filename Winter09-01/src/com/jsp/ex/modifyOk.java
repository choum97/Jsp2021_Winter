package com.jsp.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/modifyOk")
public class modifyOk extends HttpServlet {
	String id = null;
	String pw = null;
	String name = null;
	String email = null;

	Connection con = null;
	Statement st = null;

	String drive = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://localhost:3307/test";
	String did = "root";
	String dpw = "1234";
	
	HttpSession session = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		action(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		action(request, response);
	}
	
	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		email = request.getParameter("email");
		
		session = request.getSession();
		
		if(pwCheck(pw)) {
			System.out.println("패스워드 확인 OK~");
			//String query = "update w_member set name='" + name +"', email = '" + email +"'  where id='" + id + "'";
			String query = "update member set userName='" + name +"', userEmail = '" + email +"' where userID='" + id + "'";
			
			try{
				Class.forName(drive);
				con = DriverManager.getConnection(url, did, dpw);	
				st = con.createStatement();
				int i = st.executeUpdate(query);
				
				if(1==i) {
					System.out.println("회원수정 성공!");
					session.setAttribute("name", name);
					response.sendRedirect("modifyResult.jsp");
				} else {
					System.out.println("회원수정 실패");
					response.sendRedirect("modify.jsp");
				}

			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					st.close();
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}else {
			 System.out.println("실패~~!");
	         response.sendRedirect("modify.jsp");
		}
		
	}
	
	//패스워드 확인한느 것
	private boolean pwCheck(String pw) {
		boolean result = false;
		
		
		String sPW = (String)session.getAttribute("pw");
		if(sPW.equals(pw)) {result = true;}
			
		return result;
	}
}
