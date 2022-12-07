package com.jsp.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/joinOk")
public class joinOk extends HttpServlet {
	private String id, pw, name, email, major, dream;
	private String[] hobby;
	
	private Connection con;
	private Statement st;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		action(request, response); 
	}

	//꿀팁 - post든 get든 얘가 처리하도록 하게
	protected void action(HttpServletRequest request, HttpServletResponse response){
		
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		email = request.getParameter("email");
//		hobby = request.getParameterValues("hobby");
//		major = request.getParameter("major");
//		dream = request.getParameter("dream");
		
		//String query = "insert into w_member value('" + id + "','" + pw + "','" + name+ "','" + email + "','" + hobby + "','" + major + "','" + dream +"')";
		String query = "insert into member value('" + name + "','" + id + "','" + pw + "','" + email + "')";
		System.out.println(query);
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			//con = DriverManager.getConnection("jdbc:mariadb://localhost:3307/winter","root","1234");
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3307/test","root","1234");
			DatabaseMetaData meta = con.getMetaData();		
			st = con.createStatement();
			int i = st.executeUpdate(query);
			
			if(1==i) {
				System.out.println("회원가입 성공!");
				response.sendRedirect("joinResult.jsp");
			} else {
				System.out.println("회원가입 실패");
				response.sendRedirect("join.html");
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
	}
}
