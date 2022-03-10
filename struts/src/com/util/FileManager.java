package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.upload.FormFile;

public class FileManager {
	
	//파일 업로드
	//반환값이 있는 이유는 파일을 업로드할 때 a.txt를 올리면 뒤의 .txt를 빼버리고
	//새롭게 저장하는 saveName으로 바꾸고 다시 확장자를 붙여
	//DB에 저장(Original이랑 이름이 다름)
	public static String doFileUpload(FormFile upload, String path) throws IOException {
		
		String newFileName = null;
		
		if(upload==null) {
			return null;
		}
		
		//클라이언트가 업로드한 파일 이름
		String originalFileName = upload.getFileName();//오리지날 파일네임을 받아옴
		
		if(originalFileName.equals("")) {
			return null;
		}
		
		//확장자 추출(abc.txt)
		String fileExt = 
				originalFileName.substring(originalFileName.lastIndexOf("."));
		
		//확장자가 없을 때 -검증
		if(fileExt==null || fileExt.equals("")) {
			return null;
		}
		
		//서버에 저장할 새로운 파일이름 생성
		newFileName = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", Calendar.getInstance());
		newFileName += System.nanoTime(); //나노타임까지붙여 절대 중복 x /10의 -9승
		newFileName += fileExt; //확장자를 붙여줌
		
		//파일 업로드
		File f = new File(path);
		
		if(!f.exists()) {
			f.mkdirs(); //디렉토리 만들어라
		}
		
		//fileData를 fullFilePath로 내보낸다.@중요@
		String fullFilePath = path + File.separator + newFileName;
		
		//여기서 실제 업로드
		byte[] fileData = upload.getFileData();
		
		FileOutputStream fos = new FileOutputStream(fullFilePath);
		
		fos.write(fileData); //여기까지
		fos.close();
		
		return newFileName;
	}
	
	
	
	/*
	파일 다운로드
	
	saveFileName : 서버에 저장된 파일명
	originalFileName : 클라이언트가 업로드한 파일명
	path : 서버에 저장된 실제 경로
	서버에 있는 파일을 읽어서 클라이언트에게 보내는 것이기 때문에 req가 아니라 resp가 매개변수로 사용
	
	*/
	
	public static boolean doFileDownload(HttpServletResponse response, String saveFileName,
			String originalFileName, String path) {
		
		
		try {
			
			//파일 경로
			String filePath = path + File.separator + saveFileName;
			
			//클라이언트가 설정한 파일명이 없을 경우 서버에 저장된 파일명으로 입력
			if(originalFileName==null||originalFileName.equals("")) {
				originalFileName = saveFileName; //검증
			}
		
			//파일을 다운받아 클라이언트 컴에 저장할때 한글이름 깨짐방지
			originalFileName = new String(originalFileName.getBytes("euc-kr"),"ISO-8859-1");//인코딩
			//ISO를 생략하고 써도 된다. 그때는 언더바를 써준다.
			
			File f = new File(filePath);
			
			//파일이 존재하지 않으면 stop
			if(!f.exists()) {
				return false;				
			}//여기를 통과한건 파일이 왔다는거. 다운로드는 아래 리스폰스
			
			//파일의 종류.ContentType를 설정
			// .txt와 같이 파일확장자 앞에 붙는.을 octet-stream이라고 함
			response.setContentType("application/octet-stream");
			
			//헤더 정보 - setHeader로 파일 다운로드가 되는 것을 보이게 하고, 파일명을 알려줌
			response.setHeader("Content-disposition", "attachment;fileName=" + originalFileName);
			
			//서버에서 클라이언트로 보낼 때 Fileinputstream으로 파일을 읽은 후 bis에 넣은 것
			//여기서 받은 정보는 인풋스트림으로 읽어서 아웃풋 스트림으로 내보낸다.
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
			
			//읽은 파일을 내보낼 때 outputstream 사용
			OutputStream out = response.getOutputStream();
			
			int data;
			byte[] bytes = new byte[4096]; 
			
			//byte를 0부터 데이터가 있는만큼 내보내라
			while((data=bis.read(bytes, 0, 4096))!=-1) {//바이트의 영번째, 부터 4096까지 읽어와라
				out.write(bytes,0,data);//데이터에 있는 내용을 다 읽어와라
				
			}
			
			out.flush(); //flush 닫기
			out.close();
			bis.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		return true;
	}
	
	
	//파일삭제
	public static void doFileDelete(String fileName, String path) {//이름과 위치를 받아서
		
		try {
			
			String filePath = path + File.separator + fileName;
			
			File f = new File(filePath);
			//파일한테 넘겨줘요
			if(f.exists())
				f.delete(); // 물리적인 파일 삭제
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	

}
