package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*클라이언트가 request 데이터를 보냄 서버가 response를 통해 데이터를 보냄 
클라이언트가 list.do 로 ~로 보여줘 했으면 그냥 서버로 도착해서  서버가 받아서 처리작업을 해줬다. 
중간중간에 정수기들이 꼭지가 있으면 필터를 꽂아서  수돗물이 걸쳐서 물이 흘러나옴 그 필터이다. 
클라이언트가 보낸 데이터를 내 입맛에 맞게 가공한다. 필터를 여러개 만들어서 중간중간 가공 가능
내려보낼때도 가공해서 내려보내는게 필터이다. 
클라이언트 정보를 그대로 받지말고 가공해서 받는게 필터이다.
나이 - 숫자맞아? 필터로 검사해서 받아옴 
클라이언트가 보낸게 서버가 가공해서 받는다던가 */

//두 필터가 클라이언트와 서버를 지나갈때 시간을 잰다. 객체는 리퀘스트에 담겨서 오고, 리퀘스트는 영역이
//1:1의 관계이다. 필터를 받는 순간 리퀘스트느느 필터에서 다음으로 넘어가지 못하기 때문에,
//chain에서 푸쉬를 한번 더 해줘서 서버로 넘겨준다. 그래서 들어갈때 시간과 나갈때 시간을 넘겨준다.
//일반적으로 리스폰스는 잘 안쓰고, 리퀘스트 시에 많이 쓴다.

// 필터는 인터페이스


// init 를 거쳐서 서비스를 실행해서 destory로 나간다.
// 다시 들어오면 서비스를 실행한다.
public class TimerFilter implements Filter {
	
	private FilterConfig config;
	
	
	@Override
	public void destroy() {
		// 3. 필터에서 나갈 때 실행
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 2. 필터 작업
		
		
		
		// 반드시 써야함 
		// 클라이언트가 서버에 데이터를 요청했을때
		// 서버가 데이터를 처리해서 나한테 화면을 보여주는 갔다가 돌아오는 시간체크를 필터로 만들수있다.
		
		
		// 클라이언트와 서버 중간에 필터를 만듬 
		// 사진5
		// 필터에 도착할때  request 담겨서 옴 
		// 영역이 1:1관계 chain 역할을 하는게 한번더 request를 한번더 푸쉬해준다.
		// 서버에서 처리작업하고 f와서 시간한번잰다 들어갈떄 시간과 나올때 시간 체크
		// 필터를 걸쳐서 나옴 
		// chain.doFilter(request, response); 다음번 필터로 넘겨주게 한다. 
		// 처리가 되면 자동으로 넘어감 , doFilter가없으면 끝나버린다.
		
		long before = System.currentTimeMillis();//시작시간
		
		chain.doFilter(request, response);
		
		long after = System.currentTimeMillis();//종료시간
		
		String uri;
		
		if(request instanceof HttpServletRequest) {
			
			//필터는 뭐가 통과할지모르기때문에 통과하면 Object가 되서 다운캐스팅
			HttpServletRequest req = (HttpServletRequest)request;
			
			uri = req.getRequestURI();
			
			config.getServletContext().log(uri + ":" + (after-before) + "ms");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 1. 필터에 들어올 때 처음 실행
		this.config = filterConfig;
			
	}
		
}
