package com.jsp.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.ex.model.MemberDAO;
import com.jsp.ex.model.MemberDTO;

public class MJoin implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDao = MemberDAO.getInstance();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		if (mDao.idCheck(id) == true) { // 중복확인
			request.setAttribute("joinResult", 0);
		} else if (mDao.idCheck(id) == false) { // 아이디 중복 아닐 경우
			MemberDTO mDto = new MemberDTO(id, pw, name, email);
			int joinResult = mDao.insertMember(mDto);
			request.setAttribute("joinResult", joinResult);
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", id);
		}

	}

}
