package com.jsp.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	String drive = "org.mariadb.jdbc.Driver";	
	String url = "jdbc:mariadb://localhost:3307/test";
	String did = "root";
	String dpw = "1234";
	
	public MemberDAO() {
		try {
			Class.forName(drive);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ArrayList<MemberDTO> MemberSelect() {
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = "select * from member";
		
		try {
			con = DriverManager.getConnection(url, did, dpw);	
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("userID");
				String pw = rs.getString("userPW");
				String name = rs.getString("userName");
				String email = rs.getString("userEmail");
				
				MemberDTO dto = new MemberDTO(id, pw, name, email);//하나 만들고
				dtos.add(dto); //여기 추가
				
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
	
	public void MemberInsert() {

		Connection con = null;
		PreparedStatement pst = null;

		String query = "insert into member (userID, userPW, userName, userEmail) value(?,?,?,?)";
		
		try {
			con = DriverManager.getConnection(url, did, dpw);	
			pst = con.prepareStatement(query);
			
			pst.setString(1, "fff");
			pst.setString(2, "777");
			pst.setString(3, "아이언맨");
			pst.setString(4, "fff@.com");
			
			int result = pst.executeUpdate();
			if(1==result) {
				System.out.println("데이터 레코드 삽입 성공");
			}else {
				System.out.println("레코드 삽입 실패~~~~~~");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
