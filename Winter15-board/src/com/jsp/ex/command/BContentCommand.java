package com.jsp.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ex.model.BoardDAO;
import com.jsp.ex.model.BoardDTO;

public class BContentCommand implements Command {
	//글내용 보기
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bId = request.getParameter("bId");
		BoardDAO dao = BoardDAO.getInstance();
	
		BoardDTO dto = dao.contentView(bId);
		
		request.setAttribute("content_view", dto);
	}

}
