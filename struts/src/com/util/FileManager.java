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
	
	//���� ���ε�
	//��ȯ���� �ִ� ������ ������ ���ε��� �� a.txt�� �ø��� ���� .txt�� ��������
	//���Ӱ� �����ϴ� saveName���� �ٲٰ� �ٽ� Ȯ���ڸ� �ٿ�
	//DB�� ����(Original�̶� �̸��� �ٸ�)
	public static String doFileUpload(FormFile upload, String path) throws IOException {
		
		String newFileName = null;
		
		if(upload==null) {
			return null;
		}
		
		//Ŭ���̾�Ʈ�� ���ε��� ���� �̸�
		String originalFileName = upload.getFileName();//�������� ���ϳ����� �޾ƿ�
		
		if(originalFileName.equals("")) {
			return null;
		}
		
		//Ȯ���� ����(abc.txt)
		String fileExt = 
				originalFileName.substring(originalFileName.lastIndexOf("."));
		
		//Ȯ���ڰ� ���� �� -����
		if(fileExt==null || fileExt.equals("")) {
			return null;
		}
		
		//������ ������ ���ο� �����̸� ����
		newFileName = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", Calendar.getInstance());
		newFileName += System.nanoTime(); //����Ÿ�ӱ����ٿ� ���� �ߺ� x /10�� -9��
		newFileName += fileExt; //Ȯ���ڸ� �ٿ���
		
		//���� ���ε�
		File f = new File(path);
		
		if(!f.exists()) {
			f.mkdirs(); //���丮 ������
		}
		
		//fileData�� fullFilePath�� ��������.@�߿�@
		String fullFilePath = path + File.separator + newFileName;
		
		//���⼭ ���� ���ε�
		byte[] fileData = upload.getFileData();
		
		FileOutputStream fos = new FileOutputStream(fullFilePath);
		
		fos.write(fileData); //�������
		fos.close();
		
		return newFileName;
	}
	
	
	
	/*
	���� �ٿ�ε�
	
	saveFileName : ������ ����� ���ϸ�
	originalFileName : Ŭ���̾�Ʈ�� ���ε��� ���ϸ�
	path : ������ ����� ���� ���
	������ �ִ� ������ �о Ŭ���̾�Ʈ���� ������ ���̱� ������ req�� �ƴ϶� resp�� �Ű������� ���
	
	*/
	
	public static boolean doFileDownload(HttpServletResponse response, String saveFileName,
			String originalFileName, String path) {
		
		
		try {
			
			//���� ���
			String filePath = path + File.separator + saveFileName;
			
			//Ŭ���̾�Ʈ�� ������ ���ϸ��� ���� ��� ������ ����� ���ϸ����� �Է�
			if(originalFileName==null||originalFileName.equals("")) {
				originalFileName = saveFileName; //����
			}
		
			//������ �ٿ�޾� Ŭ���̾�Ʈ �Ŀ� �����Ҷ� �ѱ��̸� ��������
			originalFileName = new String(originalFileName.getBytes("euc-kr"),"ISO-8859-1");//���ڵ�
			//ISO�� �����ϰ� �ᵵ �ȴ�. �׶��� ����ٸ� ���ش�.
			
			File f = new File(filePath);
			
			//������ �������� ������ stop
			if(!f.exists()) {
				return false;				
			}//���⸦ ����Ѱ� ������ �Դٴ°�. �ٿ�ε�� �Ʒ� ��������
			
			//������ ����.ContentType�� ����
			// .txt�� ���� ����Ȯ���� �տ� �ٴ�.�� octet-stream�̶�� ��
			response.setContentType("application/octet-stream");
			
			//��� ���� - setHeader�� ���� �ٿ�ε尡 �Ǵ� ���� ���̰� �ϰ�, ���ϸ��� �˷���
			response.setHeader("Content-disposition", "attachment;fileName=" + originalFileName);
			
			//�������� Ŭ���̾�Ʈ�� ���� �� Fileinputstream���� ������ ���� �� bis�� ���� ��
			//���⼭ ���� ������ ��ǲ��Ʈ������ �о �ƿ�ǲ ��Ʈ������ ��������.
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
			
			//���� ������ ������ �� outputstream ���
			OutputStream out = response.getOutputStream();
			
			int data;
			byte[] bytes = new byte[4096]; 
			
			//byte�� 0���� �����Ͱ� �ִ¸�ŭ ��������
			while((data=bis.read(bytes, 0, 4096))!=-1) {//����Ʈ�� ����°, ���� 4096���� �о�Ͷ�
				out.write(bytes,0,data);//�����Ϳ� �ִ� ������ �� �о�Ͷ�
				
			}
			
			out.flush(); //flush �ݱ�
			out.close();
			bis.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		return true;
	}
	
	
	//���ϻ���
	public static void doFileDelete(String fileName, String path) {//�̸��� ��ġ�� �޾Ƽ�
		
		try {
			
			String filePath = path + File.separator + fileName;
			
			File f = new File(filePath);
			//�������� �Ѱ����
			if(f.exists())
				f.delete(); // �������� ���� ����
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	

}
