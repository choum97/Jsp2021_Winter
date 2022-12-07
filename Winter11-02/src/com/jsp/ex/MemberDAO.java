package com.jsp.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataSrc;
	
	public MemberDAO() {//생성되면서 접속
		try {
			Context ctx = new InitialContext();
			dataSrc = (DataSource) ctx.lookup("java:comp/env/jdbc/maria");
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	////여기부터
	private static MemberDAO instance = new MemberDAO(); //싱글턴 패턴 적용
	public static MemberDAO getInstance() {
		return instance;
	}//까지
	
	public int userCheck(String id, String pw) {
		int result = 0;
		String dbPW;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String query = "select userPW from member where userID = ?";
		try {
			con = dataSrc.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				dbPW = rs.getString("userPW"); //db에 있는 pw값
				if(dbPW.equals(pw)) { //DB PW값과 pw비교
					System.out.println("로그인 성공");
					result = 1;
				}else {
					System.out.println("비밀번호가 다릅니다.");
					result = 0;
				}
			} else {
				System.out.println("회원이(아이디가) 존재하지 않습니다");
				result = -1;
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
		return result;
	}
	
	public MemberDTO getMember(String id) {
		MemberDTO dto = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String query = "select * from member where userID = ?";
		
		try {
			con = dataSrc.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("userID"));
				dto.setPw(rs.getString("userPW"));
				dto.setName(rs.getString("userName"));
				dto.setEmail(rs.getString("userEmail"));
			}
			
		}catch (Exception e) {
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
		return dto;
	}
	
}
