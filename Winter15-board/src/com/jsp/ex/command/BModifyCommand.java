package com.jsp.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ex.model.BoardDAO;
import com.jsp.ex.model.BoardDTO;

public class BModifyCommand implements Command {
	// 글수정
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.modfiy(bId, bName, bTitle, bContent);
	}

}
