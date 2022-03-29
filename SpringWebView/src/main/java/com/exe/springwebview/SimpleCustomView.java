package com.exe.springwebview;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

//클래스는 view기능이 없어 AbstractView를 상속받음
// - 클래스로 View를 만드는 방법
public class SimpleCustomView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>");
		out.print(model.get("message"));
		out.print("</h2>");
		out.print("</body>");
		out.print("</html>");
		
	}

}
