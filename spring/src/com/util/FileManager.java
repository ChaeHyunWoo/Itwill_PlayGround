package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service("fileManager")
public class FileManager {
	
	//���� ���ε�
	public static String doFileUpload(InputStream is, String originalFileName, String path) throws IOException {
		
		String newFileName = null;
		
		
		//Ŭ���̾�Ʈ�� ���ε��� ���� �̸�			
		if(originalFileName.equals("")) {
			return null;
		}
		
		//Ȯ���� ����(abc.txt)
		String fileExt = 
				originalFileName.substring(originalFileName.lastIndexOf("."));		
		
		if(fileExt==null || fileExt.equals("")) {
			return null;
		}
		
		//������ ������ ���ο� �����̸� ����
		newFileName = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS",
				Calendar.getInstance());
		newFileName += System.nanoTime(); //10�� -9��
		newFileName += fileExt;
		
		//���Ͼ��ε�
		File f = new File(path);
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String fullFilePath = path + File.separator + newFileName;
		
		//�갡 ���� �ٿ�ε带 �޴´�. ��� �����̸� �԰���
		FileCopyUtils.copy(is, new FileOutputStream(fullFilePath));
		
		return newFileName;
		
	}
	
	
	//���� �ٿ�ε�
	public static boolean doFileDownload(HttpServletResponse response,
			String saveFileName, String originalFileName,String path) {
		
		try {
			
			String filePath = path + File.separator + saveFileName;
			
			if(originalFileName==null||originalFileName.equals("")) {
				originalFileName = saveFileName;				
			}
			
			//������ �ٿ�޾� Ŭ���̾�Ʈ �Ŀ� �����Ҷ� �ѱ��̸� ���� ����
			originalFileName = 
				new String(originalFileName.getBytes("euc-kr"),"ISO-8859-1");
			
			File f = new File(filePath);
			
			if(!f.exists()) {
				return false;
			}
			
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition",
					"attachment;fileName=" + originalFileName);
			
			BufferedInputStream bis = 
					new BufferedInputStream(new FileInputStream(f));
					
			OutputStream out = response.getOutputStream();
			
			int data;
			byte[] bytes = new byte[4096];
			while((data=bis.read(bytes, 0, 4096))!=-1) {
				out.write(bytes,0,data);
			}
			
			out.flush();
			out.close();
			bis.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
		return true;
	}
		
	
	//���� ����
	public static void doFileDelete(String fileName, String path) {
		
		try {
			
			String filePath = path + File.separator + fileName;
			
			File f = new File(filePath);
			
			if(f.exists())
				f.delete(); //���� ����
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}
	
	
	

}
