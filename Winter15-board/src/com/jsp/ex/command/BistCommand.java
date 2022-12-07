package com.jsp.ex.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.jsp.ex.model.BoardDAO;
import com.jsp.ex.model.BoardDTO;

public class BistCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		BoardDAO dao = BoardDAO.getInstance();
		
		ArrayList<BoardDTO> dtos = dao.list(); //이거 두줄을 줄여쓴것
		request.setAttribute("list", dtos);
		
	}

}
