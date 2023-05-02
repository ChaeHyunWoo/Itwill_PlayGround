package com.exe.springwebview;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

//파일 다운로드
public class DownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		//response.setContentType("application/unknown"); 이렇게 써도 된다.
		
		response.addHeader("Content-Disposition", 
				"attachment;fileName=\"AOP.txt\"");
		
		String path = request.getSession()
				.getServletContext().getRealPath("/WEB-INF/files/AOP.txt");
		
		//이제 읽어낸다 (서버가 읽어낸다)
		BufferedInputStream bis = 
				new BufferedInputStream(new FileInputStream(path));//서버가 path에 있는 것을 읽어내고
		
		BufferedOutputStream bos =  //읽어낸 것을 내보낸다.
				new BufferedOutputStream(response.getOutputStream());
		
		//내보내는 위치
		int data;
		
		while((data=bis.read())!=-1) {
			
			bos.write(data);
		}
		
		bis.close();
		bos.close();
		
	}

}
