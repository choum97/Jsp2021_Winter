package com.jsp.ex.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ex.DB.MemberDTO;

public interface Service {
	//배열형태로 다 받아오기 위해서
	public ArrayList<MemberDTO> exucute(HttpServletRequest request, HttpServletResponse response);
	
}
