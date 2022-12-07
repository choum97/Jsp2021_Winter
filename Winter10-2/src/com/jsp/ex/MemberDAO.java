package com.jsp.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	private DataSource dataSRC;
	
	
	
	public MemberDAO() {	//생성되면서 접속
		try { 
			Context ctx = new InitialContext();
			dataSRC = (DataSource) ctx.lookup("java:comp/env/jdbc/maria");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> MemberSelect() {
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = "select * from member";
		
		try {
			
			con = dataSRC.getConnection(); //1에서 여기 바뀜	
			
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("userID");
				String pw = rs.getString("userPW");
				String name = rs.getString("userName");
				String email = rs.getString("userEmail");
				
				MemberDTO dto = new MemberDTO(id, pw, name, email);//하나 만들고
				dtos.add(dto); //여기에 추가
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
}
