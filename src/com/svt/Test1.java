package com.svt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test1 extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		try {
			
			PrintWriter out = response.getWriter();
			
			out.print("<html>");
			out.print("<head>");
			out.print("<title>");
			out.print("�������α׷�</title></head>");
			out.print("<body style='font-size:10pt;'>");
			out.print("ȭ�� �������� �������� JSP�� ���ϴ�");
			out.print("</body>");
			out.print("</html>");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}

}
