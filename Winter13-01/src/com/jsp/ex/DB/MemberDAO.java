package com.jsp.ex.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	DataSource dataSrc;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			dataSrc = (DataSource)ctx.lookup("java:comp/env/jdbc/maria");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static MemberDAO instance = new MemberDAO(); //싱글턴 패턴 적용
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public ArrayList<MemberDTO> allMember(){
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String query = "select * from member";
		
		try {
			con = dataSrc.getConnection();
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				
				dto.setId(rs.getString("userID"));
				dto.setPw(rs.getString("userPW"));
				dto.setName(rs.getString("userName"));
				dto.setEmail(rs.getString("userEmail"));
				
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
	}
}
