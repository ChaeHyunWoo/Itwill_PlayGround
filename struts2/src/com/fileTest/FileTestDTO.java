package com.fileTest;

import java.io.File;

public class FileTestDTO {
	
	private File upload;
	
	//������ ������ upload�� FileName ���ڸ� �ٿ��� ������ �����
	//Struts2�� �ڵ����� ������ �̸��� �־��ش�.
	//upload(���������) + FileName(����x) ������ ����.
	private String uploadFileName;
	
	private String mode;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	
	
	

}
