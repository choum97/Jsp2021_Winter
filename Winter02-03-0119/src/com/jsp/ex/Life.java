package com.jsp.ex;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Life")
public class Life extends HttpServlet {
	@PostConstruct //선처리 하려고 어노테이션 사용한 것
	public void initPostconstruct() { //그냥 메소드 만든것임
		System.out.println("여기에서 init()메소드 실행 직전 일들을 정의합니다.");
	}
	
	//init은 initialization의 약자 = 초기화
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()메소드 입니다. 처음에 생성될때 한번만 실행됨");
		System.out.println("여기에서 servlet 생성될 때 처리해야 할 일들을 정의합니다.");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 메소드 입니다");
		System.out.println("메롱 메롱~");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메소드입니다.");
		System.out.println("얼레리 꼴레리");
	}
	
	public void destroy() {
		System.out.println("destroy() 메소드입니다.");
		System.out.println("여기에서 servlet 종료될 때 처리해야 할 일들을 정의합니다.");
	}
	
	@PreDestroy
	public void preDestroy() { //종료 직후 실행될 메소드 만든 것
		System.out.println("destroy() 직후 처리 내용");
	}
}
