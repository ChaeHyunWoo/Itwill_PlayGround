package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*Ŭ���̾�Ʈ�� request �����͸� ���� ������ response�� ���� �����͸� ���� 
Ŭ���̾�Ʈ�� list.do �� ~�� ������ ������ �׳� ������ �����ؼ�  ������ �޾Ƽ� ó���۾��� �����. 
�߰��߰��� ��������� ������ ������ ���͸� �ȾƼ�  �������� ���ļ� ���� �귯���� �� �����̴�. 
Ŭ���̾�Ʈ�� ���� �����͸� �� �Ը��� �°� �����Ѵ�. ���͸� ������ ���� �߰��߰� ���� ����
������������ �����ؼ� ���������°� �����̴�. 
Ŭ���̾�Ʈ ������ �״�� �������� �����ؼ� �޴°� �����̴�.
���� - ���ڸ¾�? ���ͷ� �˻��ؼ� �޾ƿ� 
Ŭ���̾�Ʈ�� ������ ������ �����ؼ� �޴´ٴ��� */

//�� ���Ͱ� Ŭ���̾�Ʈ�� ������ �������� �ð��� ���. ��ü�� ������Ʈ�� ��ܼ� ����, ������Ʈ�� ������
//1:1�� �����̴�. ���͸� �޴� ���� ������Ʈ���� ���Ϳ��� �������� �Ѿ�� ���ϱ� ������,
//chain���� Ǫ���� �ѹ� �� ���༭ ������ �Ѱ��ش�. �׷��� ���� �ð��� ������ �ð��� �Ѱ��ش�.
//�Ϲ������� ���������� �� �Ⱦ���, ������Ʈ �ÿ� ���� ����.

// ���ʹ� �������̽�


// init �� ���ļ� ���񽺸� �����ؼ� destory�� ������.
// �ٽ� ������ ���񽺸� �����Ѵ�.
public class TimerFilter implements Filter {
	
	private FilterConfig config;
	
	
	@Override
	public void destroy() {
		// 3. ���Ϳ��� ���� �� ����
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 2. ���� �۾�
		
		
		
		// �ݵ�� ����� 
		// Ŭ���̾�Ʈ�� ������ �����͸� ��û������
		// ������ �����͸� ó���ؼ� ������ ȭ���� �����ִ� ���ٰ� ���ƿ��� �ð�üũ�� ���ͷ� ������ִ�.
		
		
		// Ŭ���̾�Ʈ�� ���� �߰��� ���͸� ���� 
		// ����5
		// ���Ϳ� �����Ҷ�  request ��ܼ� �� 
		// ������ 1:1���� chain ������ �ϴ°� �ѹ��� request�� �ѹ��� Ǫ�����ش�.
		// �������� ó���۾��ϰ� f�ͼ� �ð��ѹ���� ���� �ð��� ���ö� �ð� üũ
		// ���͸� ���ļ� ���� 
		// chain.doFilter(request, response); ������ ���ͷ� �Ѱ��ְ� �Ѵ�. 
		// ó���� �Ǹ� �ڵ����� �Ѿ , doFilter�������� ����������.
		
		long before = System.currentTimeMillis();//���۽ð�
		
		chain.doFilter(request, response);
		
		long after = System.currentTimeMillis();//����ð�
		
		String uri;
		
		if(request instanceof HttpServletRequest) {
			
			//���ʹ� ���� ��������𸣱⶧���� ����ϸ� Object�� �Ǽ� �ٿ�ĳ����
			HttpServletRequest req = (HttpServletRequest)request;
			
			uri = req.getRequestURI();
			
			config.getServletContext().log(uri + ":" + (after-before) + "ms");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 1. ���Ϳ� ���� �� ó�� ����
		this.config = filterConfig;
			
	}
		
}
