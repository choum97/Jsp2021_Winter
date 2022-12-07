package com.jsp.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginOk")
public class loginOk extends HttpServlet {
	String id = null;
	String pw = null;
	String name = null;
	String email = null;

	private Connection con = null;
	private Statement st = null;
	ResultSet rs = null;
	
	String drive = "org.mariadb.jdbc.Driver";
	//String url = "jdbc:mariadb://localhost:3307/winter";	
	String url = "jdbc:mariadb://localhost:3307/test";
	String did = "root";
	String dpw = "1234";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		action(request, response);
	}

	protected void action(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		//String query = "select * from w_member where m_id='" + id + "'and m_pw='" + pw + "'";
		String query = "select * from member where userID='" + id + "'and userPW='" + pw + "'";
		System.out.println(query);
		
		
		try{
			Class.forName(drive);
			con = DriverManager.getConnection(url,did,dpw);		
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
//				id = rs.getString("m_id");
//				pw = rs.getString("m_pw");
//				name = rs.getString("m_name");
//				email = rs.getString("m_email");
				id = rs.getString("userID");
				pw = rs.getString("userPW");
				name = rs.getString("userName");
				email = rs.getString("userEmail");
			}
			
			HttpSession session = request.getSession(); // 세션 사용
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			session.setAttribute("name", name);

			response.sendRedirect("loginResult.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
