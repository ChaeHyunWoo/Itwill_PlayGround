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
	
	//request.setAttribute("dto", dto);�� ������� -> �Ʒ����ִ� getDto��
	//�ְ� ���̵� �н����� �޼����� modelDriven���� �Ѱ��ش�.
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
			
			return INPUT;//��Ʈ������ ������ִ� ���� INPUT �ȿ� input�� ����ִ�.
		}
		
		//�ѱ涧 request�� ����ؼ� �����.( ��Ʈ����2�� �ʿ��Ҷ� �����.)
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//request�� �ѱ�
		request.setAttribute("message", "��Ʈ����2...");
		
		//request.setAttribute("dto", dto);
		
		return SUCCESS;
		
	}
	

}
