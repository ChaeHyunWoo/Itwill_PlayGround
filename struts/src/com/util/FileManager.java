package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class FileManager {
	
	/*
	���� �ٿ�ε�
	
	saveFileName : ������ ����� ���ϸ�
	originalFileName : Ŭ���̾�Ʈ�� ���ε��� ���ϸ�
	path : ������ ����� ���� ���
	������ �ִ� ������ �о Ŭ���̾�Ʈ���� ������ ���̱� ������ req�� �ƴ϶� resp�� �Ű������� ���
	
	*/
	
	
	public static boolean doFileDounload(HttpServletResponse response, String saveFileName,
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
