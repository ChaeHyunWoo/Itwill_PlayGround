package com.test2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class TestAction extends ActionSupport 
	implements Preparable, ModelDriven<UserDTO> {

	private static final long serialVersionUID = 1L;
	
	private UserDTO dto;
	
	//request.setAttribute("dto", dto);를 대신해줌 -> 아래에있는 getDto가
	//애가 아이디 패스워드 메세지를 modelDriven으로 넘겨준다.
	public UserDTO getDto() {
		return dto;
	}

	@Override
	public UserDTO getModel() {
		return dto;
	}
	
	@Override
	public void prepare() throws Exception {
		dto = new UserDTO();
	}
	
	
	public String created() throws Exception {
		
		if(dto==null||dto.getMode()==null||dto.getMode().equals("")) {
			
			return INPUT;//스트럿츠에 내장되있는 변수 INPUT 안에 input이 들어있다.
		}
		
		//넘길때 request를 써야해서 만든다.( 스트럿츠2는 필요할때 만든다.)
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//request로 넘김
		request.setAttribute("message", "스트럿츠2...");
		
		//request.setAttribute("dto", dto);
		
		return SUCCESS;
		
	}
	

}
