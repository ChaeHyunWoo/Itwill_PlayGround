package com.fileTest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class FileTestForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private int num;
	private String subject;
	private String saveFileName;
	private String originalFileName;
	
	//Struts는 파일업로드할때 FormFile을 쓴다.
	private FormFile upload;
	
	//사용자정의 변수
	private int listNum; //일렬번호 재정렬
	private String urlFile; //파일 다운로드 경로
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public FormFile getUpload() {
		return upload;
	}
	public void setUpload(FormFile upload) {
		this.upload = upload;
	}
	public int getListNum() {
		return listNum;
	}
	public void setListNum(int listNum) {
		this.listNum = listNum;
	}
	public String getUrlFile() {
		return urlFile;
	}
	public void setUrlFile(String urlFile) {
		this.urlFile = urlFile;
	}
	
}