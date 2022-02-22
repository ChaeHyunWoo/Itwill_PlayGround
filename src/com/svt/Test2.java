package com.svt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. ServletConfig 인터페이스
		ServletConfig config = getServletConfig();
		String name = config.getInitParameter("name");
		String age = config.getInitParameter("age");
		
		//2. ServletContext인터페이스
		ServletContext context = getServletContext();
		String gender = context.getInitParameter("gender");
		
		//한글 인코딩
		resp.setContentType("text/html;charset=utf-8");
		
		//객체생성
		PrintWriter pw = resp.getWriter();
		
		pw.print("<html><body>");
		pw.print("name : " + name + "<br/>");
		pw.print("age : " + age + "<br/>");
		pw.print("gender : " + gender + "<br/>");
		pw.print("</body></html>");
		
		
	}
	
}