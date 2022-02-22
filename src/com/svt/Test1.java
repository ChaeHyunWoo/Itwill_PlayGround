package com.svt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test1 extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		//response 객체의 한글 인코딩
		//지금부터 클라이언트에게 전달하는 데이터 타입은
		//text 혹은 html 형식이고 UTF-8 인코딩 방식이다.
		response.setContentType("text/html;charset=utf-8");
		
		try {
			
			//JSP는 out.print로 작성하면 되지만
			//Servlet은 객체가 필요하면 요청해야함

			PrintWriter out = response.getWriter();
			
			out.print("<html>");
			out.print("<head>");
			out.print("<title>");
			out.print("예제프로그램</title></head>");
			out.print("<body style='font-size:10pt;'>");
			out.print("화면 디자인은 서블릿보다 JSP가 편하다");
			out.print("</body>");
			out.print("</html>");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}

}
