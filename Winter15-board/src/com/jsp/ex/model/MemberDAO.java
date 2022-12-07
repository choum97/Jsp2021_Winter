package com.jsp.ex.model;

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
	private static MemberDAO dao = new MemberDAO();
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	Statement st = null;
	public MemberDAO() {	//생성되면서 접속
		try { 
			Context ctx = new InitialContext();
			dataSRC = (DataSource) ctx.lookup("java:comp/env/jdbc/maria");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public void closeCon() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	// 회원가입
	public int insertMember(MemberDTO mdto) {
		String query = "insert into member value(?,?,?,?)";
		int insertOk = 0;
		try {
			con = dataSRC.getConnection();	
			psmt = con.prepareStatement(query);
			psmt.setString(1, mdto.getUserName());
			psmt.setString(2, mdto.getUserID());
			psmt.setString(3, mdto.getUserPW());
			psmt.setString(4, mdto.getUserEmail());
			int excuteQuery = psmt.executeUpdate();// 성공하면 1반환
			insertOk = excuteQuery;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeCon();
		}
		return insertOk;
	}
	
	//id 중복체크
	public boolean idCheck(String userId) {
		boolean getIdOk = false; //f - 아이디 사용가능
		String query = "select userID from member where userID=?";
		try {
			con = dataSRC.getConnection();	
			psmt = con.prepareStatement(query);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				getIdOk = true;  // t - 아이디 중복 사용불가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
		return getIdOk;
	}
	
	// 로그인
	public int login(String userID, String userPW) {
		String query = "select userPW from member where userID = ?";
		int loginOk = -1;
		try {
			con = dataSRC.getConnection();
			psmt = con.prepareStatement(query);
			psmt.setString(1, userID);
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("userPW").equals(userPW)) {
					loginOk =1;
					//return 1;// 로그인 성공
				} else {
					loginOk = 0;
					//return 0; // 비밀번호 불일치
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
		return loginOk;
		//return -1; // 로그인 실패
	}
	


}
