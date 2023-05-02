package com.exe.springwebview;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomViewController {
	
	@RequestMapping(value = "/simpleCustomView.action")
	public ModelAndView custom() {
		
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("simpleCustomView"); //jsp���Ϸ� ����
		
		//������ ���� ������� Class�� �����͸� �ѱ� ���̴�.
		mav.setView(new SimpleCustomView());
		mav.addObject("message","SimpleCustomView Class �Դϴ�.");
		
		return mav;
	}
	
	
	@RequestMapping(value = "pdfView.action")
	public ModelAndView getPdfView() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setView(new CustomPdfView());
		mav.addObject("message","PDF FILE");
		
		return mav;
	}
	
	
	@RequestMapping(value = "excelView.action")
	public ModelAndView getExcelView() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setView(new CustomExcelView());
		
		return mav;
	}
	
	
	@RequestMapping(value = "upload.action", 
			method = {RequestMethod.POST, RequestMethod.GET})
	public String upload(MultipartHttpServletRequest request, String str)
		throws Exception {
		
		String path = request.getSession()
				.getServletContext().getRealPath("/WEB-INF/files"); // �ٿ� ��ġ ����
		
		
		//�ϳ��� ������ ���ε� �ٿ�ε� �Ҷ��� Ŭ���̾�Ʈ�� ���� �������� �ٰ����� ���� �̹� ��θ� �������� ��� ������
		// �� ��������� ���������� ���ִ� �̹��������� ���� �Ź� Ŭ���̾�Ʈ�� �������� ��û�� �ؾ��ϱ� ������
		//Ŭ���̾�Ʈ�� ���������� ���� ������ ������ �̹��������� �����.
		//WEB-INF�� �ܺο��� ������ ���Ѵ�.(���� ���� ����)
		//�׷��� �̹����� ���� ���ؼ� webapp ���� �Ʒ� ����(image)�� ����ų�
		//resources ������ ������ ���� �����ϴ�.(ex �̹����Խ���)
		
		//getServletContext().getRealPath("/resources/image"); -> resources �ȿ� image���� ������� ��
		//getServletContext().getRealPath("/image"); -> webapp�� image���� ������� �� ���
		
		//image������ ���� ��� servlet-context.xml����
		//<resources mapping="/**" location="/"> �̷��� ��������� �� - webapp�ȿ� image���� ������� ��
		//<resources mapping="/resources/**" location="/resources/"> -�̰� resources �ȿ� image���� ������� ��
		
		//���� �ѱ� ����
		//String path = cp + "/resources/image�� ��� �ѱ�
		
		MultipartFile file = request.getFile("upload"); //home.jsp�� input name�� upload�� ������
		
		if(file!=null && file.getSize()>0) {
			
			//���� ���ε�� try-catch�� ������� ��
			try {
				//���ε� �� ��ġ
				FileOutputStream fos = 
						new FileOutputStream(path + "/" + file.getOriginalFilename());
				//���� �б�
				InputStream is = file.getInputStream();
				
				int data;
				byte[] buffer = new byte[4096];
				
				while((data=is.read(buffer, 0, buffer.length))!=-1) {
					
					fos.write(buffer,0,data);
				} //end while��
				
				is.close();
				fos.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}//end catch
			
			
		} // end If��
		
		return "uploadResult";
		
	} // end upload()
	
	
	@RequestMapping(value = "download.action")
	public ModelAndView download() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setView(new DownloadView());
		
		return mav;
	}

} // end Class
