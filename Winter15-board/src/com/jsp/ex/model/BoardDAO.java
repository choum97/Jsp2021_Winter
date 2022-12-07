package com.jsp.ex.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class BoardDAO {
	private DataSource dataSRC;
	private static BoardDAO dao = new BoardDAO(); //싱글턴 패턴 적용
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public BoardDAO(){
		try {
			Context ctx = new InitialContext();
			dataSRC = (DataSource)ctx.lookup("java:comp/env/jdbc/maria");		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getInstance() {
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
	
	//글작성
	public void write(String bName, String bTitle, String bContent) {
		try {
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup,bStep, bIndent) values(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
			con = dataSRC.getConnection();
			psmt = con.prepareStatement(query);
			psmt.setString(1, bName);
			psmt.setString(2, bTitle);
			psmt.setString(3, bContent);
			rs = psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}
	//게시글 리스트 보기
	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		
		String query = "select * from mvc_board order by bGroup DESC, bStep ASC";
		try {
			con = dataSRC.getConnection();
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("bId");
				String name = rs.getString("bName");
				String title = rs.getString("bTitle");
				String content = rs.getString("bContent");
				Date date = rs.getDate("bDate");
				int hit = rs.getInt("bHit");
				int group = rs.getInt("bGroup");
				int step = rs.getInt("bStep");
				int indent = rs.getInt("bIndent");
				
				BoardDTO dto = new BoardDTO(id, name, title, content, date, hit, group, step, indent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
		
		return dtos;
	}
	
	//
	public BoardDTO contentView(String strID) {
		upHit(strID);
		
		BoardDTO dto =null;
		String query = "select * from mvc_board where bId = ?";
		try {
			con = dataSRC.getConnection();
			psmt = con.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(strID));
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("bId");
				String name = rs.getString("bName");
				String title = rs.getString("bTitle");
				String content = rs.getString("bContent");
				Date date = rs.getDate("bDate");
				int hit = rs.getInt("bHit");
				int group = rs.getInt("bGroup");
				int step = rs.getInt("bStep");
				int indent = rs.getInt("bIndent");
				
				dto = new BoardDTO(id, name, title, content, date, hit, group, step, indent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
		return dto;
	}
	
	//수정하기
	public void modfiy(String bId ,String bName, String bTitle, String bContent) {
		try {
			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			con = dataSRC.getConnection();
			psmt = con.prepareStatement(query);
			psmt.setString(1, bName);
			psmt.setString(2, bTitle);
			psmt.setString(3, bContent);
			psmt.setInt(4, Integer.parseInt(bId));
			int rn = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}
	
	//	삭제
	public void delete(String bId) {
		try {
			con = dataSRC.getConnection();
			String query = "delete from mvc_board where bId = ?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(bId));
			int rn = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}
	
	public BoardDTO reply_View(String str) {		
		BoardDTO dto =null;
		try {
			con = dataSRC.getConnection();
			String query = "select * from mvc_board where bId = ?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(str));
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("bId");
				String name = rs.getString("bName");
				String title = rs.getString("bTitle");
				String content = rs.getString("bContent");
				Date date = rs.getDate("bDate");
				int hit = rs.getInt("bHit");
				int group = rs.getInt("bGroup");
				int step = rs.getInt("bStep");
				int indent = rs.getInt("bIndent");
				
				dto = new BoardDTO(id, name, title, content, date, hit, group, step, indent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
		return dto;
	}
	
	public void reply(String bId ,String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		replyShape(bGroup, bStep);
		
		String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup,bStep, bIndent) values(mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		try {
			con = dataSRC.getConnection();
			psmt = con.prepareStatement(query);
			psmt.setString(1, bName);
			psmt.setString(2, bTitle);
			psmt.setString(3, bContent);
			psmt.setInt(4, Integer.parseInt(bGroup));
			psmt.setInt(5, Integer.parseInt(bStep) + 1);
			psmt.setInt(6, Integer.parseInt(bIndent) +1);
			int rn = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}
	
	private void replyShape(String strGroup, String strStep) {
		String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		try {
			con = dataSRC.getConnection();
			psmt = con.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(strGroup));
			psmt.setInt(2, Integer.parseInt(strStep));
			int rn = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}
	
	//조회수 증가
	private void upHit(String bId) {
		String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
		try {
			con = dataSRC.getConnection();
			psmt = con.prepareStatement(query);
			psmt.setString(1, bId);
			int rn = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}
}
