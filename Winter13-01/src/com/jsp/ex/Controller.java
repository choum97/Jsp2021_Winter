package com.jsp.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ex.DB.MemberDTO;
import com.jsp.ex.service.AllMemberService;
import com.jsp.ex.service.Service;

@WebServlet("*.do")
public class Controller extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("URI의 값 : " + uri);//서버주소를 뺀 나머지가 uri
		String ctxPath = request.getContextPath();
		System.out.println("Context Path의 값 : " + ctxPath);
		String cmd = uri.substring(ctxPath.length()); //ctx의 길이만큼 자름
		System.out.println("입력된 명령 : " + cmd);
		
		if(cmd.equals("/allMember.do")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<html>");
			writer.println("<head>");
			writer.println("</head>");
			writer.println("<body>");
			writer.println("<h1>");
			writer.println("회원명부");
			writer.println("</h1>");
			writer.println("<hr>");
			Service service = new AllMemberService();
			ArrayList<MemberDTO> dtos = service.exucute(request, response);
			for(int i=0; i<dtos.size(); i++) {
				MemberDTO dto = dtos.get(i);
				
				String id = dto.getId();
				String pw = dto.getPw();
				String name = dto.getName();
				String email = dto.getEmail();
				
				writer.println("제 " + (i+1) + "의 회원입니다 <br/>");
				writer.println(id + ", " + pw + ", " + name + ", " + email + "<br/>");
				writer.println("---------------------------------------------<br/>");
			}
			writer.println("</body>");
			writer.println("</html>");
			
		} else if (cmd.equals("/inselt.do")) {
			//Service svc = new InsertMember(); //아직 구현안함 수업도 그냥 인터페이스만 만들고 이렇게만 씀 
			//svc.excute(request, response); 
			//.excute같은 이름일지만 다른 구현 방법으로 접근하기에 소스코드가 짧아짐
		} 
	}
}
