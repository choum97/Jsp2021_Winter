package com.jsp.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ex.command.BContentCommand;
import com.jsp.ex.command.BDeleteCommand;
import com.jsp.ex.command.BModifyCommand;
import com.jsp.ex.command.BWriteCommand;
import com.jsp.ex.command.BistCommand;
import com.jsp.ex.command.Command;
import com.jsp.ex.command.MJoin;
import com.jsp.ex.model.MemberDAO;

@WebServlet("*.do")  //멀로 올지 모르고, 컨트롤해서 DAO로 보내야 하기에 do임
public class BoardController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}
	
	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String cmd = uri.substring(ctxPath.length()); //ctx의 길이만큼 자름
		
		if(cmd.equals("/main.do")) {
			viewPage = "main.jsp";
		}else if(cmd.equals("/login.do")) { //로그인시
			int loginRe = 4;
			MemberDAO mDao = MemberDAO.getInstance();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			int lore = mDao.login(id, pw);
			if(lore == 1) {
				request.setAttribute("joinResult", 1);
				HttpSession session = request.getSession();
				session.setAttribute("sessionID", id);
				viewPage = "main.jsp";
			} else if(lore == 0){
				request.setAttribute("joinResult", 0);
				viewPage = "login.jsp";
			}
			
		} else if(cmd.equals("/join.do")) { //회원가입시
			int joinResult = 4;
			Command mCmd = new MJoin();
			mCmd.excute(request, response);
			joinResult = (int) request.getAttribute("joinResult");
			if (joinResult == 0) {
				viewPage = "join.jsp";
			}else if (joinResult == 1){
				viewPage = "main.jsp";
			}
			
		} else if (cmd.equals("/logOut.do")) { // 로그아웃
			HttpSession session = request.getSession();
			session.invalidate();
			viewPage = "login.jsp";
			
		}
		/////////////////////////
		
		if(cmd.equals("/list.do")) { // 게시판 보기 
			Command bCmd = new BistCommand();
			bCmd.excute(request, response);
			viewPage = "list.jsp";
		}else if(cmd.equals("/write_view.do")) {	// 글쓰기 창으로!
			viewPage = "write.jsp";
		} else if(cmd.equals("/write.do")) {	//글쓰기에서 작성버튼
			Command bcmd = new BWriteCommand();
			bcmd.excute(request, response);
			viewPage = "list.do";
		} else if(cmd.equals("/bViewContent.do")) {	//글내용보기
			Command bcmd = new BContentCommand();
			viewPage = "contentView.jsp";
		} else if(cmd.equals("/bModify.do")) { //수정하기
			Command bcmd =new BModifyCommand();
			bcmd.excute(request, response);
			viewPage = "modify.jsp";
		} else if(cmd.equals("/bContentModify.do")) {
			Command bcmd = new BModifyCommand();
			bcmd.excute(request, response);
			viewPage = "list.do";
		} else if(cmd.equals("/delete.do")) {
			Command bcmd = new BDeleteCommand(); //삭제
			bcmd.excute(request, response);
			viewPage = "list.do";
		}  
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); 
		dispatcher.forward(request, response);
	}

}
