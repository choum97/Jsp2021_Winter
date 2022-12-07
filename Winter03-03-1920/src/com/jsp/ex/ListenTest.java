package com.jsp.ex;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener //리스너 - 어노테이션 사용하는 방법
public class ListenTest implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("웹 어플리케이션이 실행될 때, 이루어지는 일들을 기술하면 됩니다");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("웹 어플리케이션이 종료될 때, 이루어지는 일들을 기술하면 됩니다");
	}
}
