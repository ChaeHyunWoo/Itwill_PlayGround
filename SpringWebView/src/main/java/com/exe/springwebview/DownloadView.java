package com.exe.springwebview;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

//���� �ٿ�ε�
public class DownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		//response.setContentType("application/unknown"); �̷��� �ᵵ �ȴ�.
		
		response.addHeader("Content-Disposition", 
				"attachment;fileName=\"AOP.txt\"");
		
		String path = request.getSession()
				.getServletContext().getRealPath("/WEB-INF/files/AOP.txt");
		
		//���� �о�� (������ �о��)
		BufferedInputStream bis = 
				new BufferedInputStream(new FileInputStream(path));//������ path�� �ִ� ���� �о��
		
		BufferedOutputStream bos =  //�о ���� ��������.
				new BufferedOutputStream(response.getOutputStream());
		
		//�������� ��ġ
		int data;
		
		while((data=bis.read())!=-1) {
			
			bos.write(data);
		}
		
		bis.close();
		bos.close();
		
	}

}
