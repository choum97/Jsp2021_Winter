package com.jsp.ex.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ex.DB.MemberDAO;
import com.jsp.ex.DB.MemberDTO;

public class AllMemberService implements Service{

	@Override
	public ArrayList<MemberDTO> exucute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = MemberDAO.getInstance();
		
		return dao.allMember(); //돌고나면 얘 자체가 DTO라서 된다함
	}
	
}
