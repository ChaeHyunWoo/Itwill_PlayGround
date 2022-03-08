package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{

	private String charset;
		
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String uri;
		
		if(request instanceof HttpServletRequest) {
			//서블릿에서 데이터를 보낼때 리퀘스트나 리스폰스는 HTTP리퀘스트로 넘어오는데
			//이 안에 들어오는 데이터가 에이치티티피 서블릿으로 들어오는거냐 확인하는 절차
			
			HttpServletRequest req = (HttpServletRequest)request;
			
			uri = req.getRequestURI();
			
			if(req.getMethod().equalsIgnoreCase("POST")){ //클라이언트에서 넘어오는게 포스트 방식이냐?
				//포스트 방식일때 실행되는거에요
				
					if(uri.indexOf("abc.do")!=-1) {
						
						req.setCharacterEncoding("euc-kr");
						
					}else {
						req.setCharacterEncoding(charset);

			}
		}
			
		
	}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		charset = filterConfig.getInitParameter("charset");//web.xml에서 주는 init
		
		if(charset==null) {
			charset = "UTF-8";
		}// 혹시나 어떠한 이유에서 캐릭터셋이 값이 없다면, 인코딩해줘
		
	}

}
