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
		
		//mav.setViewName("simpleCustomView"); //jsp파일로 보냄
		
		//이제는 위의 방법말고 Class로 데이터를 넘길 것이다.
		mav.setView(new SimpleCustomView());
		mav.addObject("message","SimpleCustomView Class 입니다.");
		
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
				.getServletContext().getRealPath("/WEB-INF/files"); // 다운 위치 지정
		
		
		//하나의 파일을 업로드 다운로드 할때는 클라이언트가 직접 서버에게 다가갈수 없게 이미 경로를 만들어놔서 상관 없지만
		// 늘 상시적으로 웹페이지에 떠있는 이미지파일인 경우는 매번 클라이언트가 서버에게 요청을 해야하기 때문에
		//클라이언트가 직접적으로 접근 가능한 폴더에 이미지폴더를 만든다.
		//WEB-INF는 외부에서 접근을 못한다.(접근 금지 영역)
		//그래서 이미지를 보기 위해서 webapp 폴더 아래 폴더(image)를 만들거나
		//resources 폴더에 만들어야 접근 가능하다.(ex 이미지게시판)
		
		//getServletContext().getRealPath("/resources/image"); -> resources 안에 image폴더 만들었을 때
		//getServletContext().getRealPath("/image"); -> webapp에 image폴더 만들었을 때 경로
		
		//image폴더를 만든 경우 servlet-context.xml에서
		//<resources mapping="/**" location="/"> 이렇게 수정해줘야 함 - webapp안에 image폴더 만들었을 때
		//<resources mapping="/resources/**" location="/resources/"> -이건 resources 안에 image폴더 만들었을 때
		
		//파일 넘길 때는
		//String path = cp + "/resources/image로 경로 넘김
		
		MultipartFile file = request.getFile("upload"); //home.jsp의 input name인 upload를 적어줌
		
		if(file!=null && file.getSize()>0) {
			
			//파일 업로드는 try-catch로 묶어줘야 함
			try {
				//업로드 할 위치
				FileOutputStream fos = 
						new FileOutputStream(path + "/" + file.getOriginalFilename());
				//파일 읽기
				InputStream is = file.getInputStream();
				
				int data;
				byte[] buffer = new byte[4096];
				
				while((data=is.read(buffer, 0, buffer.length))!=-1) {
					
					fos.write(buffer,0,data);
				} //end while문
				
				is.close();
				fos.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}//end catch
			
			
		} // end If문
		
		return "uploadResult";
		
	} // end upload()
	
	
	@RequestMapping(value = "download.action")
	public ModelAndView download() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setView(new DownloadView());
		
		return mav;
	}

} // end Class
