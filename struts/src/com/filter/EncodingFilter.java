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
			//�������� �����͸� ������ ������Ʈ�� ���������� HTTP������Ʈ�� �Ѿ���µ�
			//�� �ȿ� ������ �����Ͱ� ����ġƼƼ�� �������� �����°ų� Ȯ���ϴ� ����
			
			HttpServletRequest req = (HttpServletRequest)request;
			
			uri = req.getRequestURI();
			
			if(req.getMethod().equalsIgnoreCase("POST")){ //Ŭ���̾�Ʈ���� �Ѿ���°� ����Ʈ ����̳�?
				//����Ʈ ����϶� ����Ǵ°ſ���
				
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
		
		charset = filterConfig.getInitParameter("charset");//web.xml���� �ִ� init
		
		if(charset==null) {
			charset = "UTF-8";
		}// Ȥ�ó� ��� �������� ĳ���ͼ��� ���� ���ٸ�, ���ڵ�����
		
	}

}
