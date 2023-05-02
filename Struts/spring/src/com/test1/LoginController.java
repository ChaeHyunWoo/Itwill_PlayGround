package com.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

// SimpleFormController : ����ڰ� ������ ��ưŬ���� submit�� ����Ǵµ� �ڵ����� onSubmit() �ڵ�ȣ��
// â�� ���� ���� �غ� �۾� ������ referenceData �� ������ â�� �������. 
// �׸��� ok��ư������ submit������ �Ǹ� onSubmit�� �����
public class LoginController extends SimpleFormController {
	
	private Authenticator authenticator;
	
	// ������ ����(DI) - setter�� �����.
	// Ŭ���� ���� �� �ڵ����� ����
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	
	//2. �α��ι�ư�� ������ submit�� ����Ǽ� �� �޼��带 �����Ѵ�.
	//   ����Ǹ鼭 DTO�� command�� �Ѿ�ͼ� ���⼭ �޾��ش�.
	//   �׸��� _ok�� �ִ� {message}�� �����ش�.
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, 
			HttpServletResponse response, Object command, //�Է��� �����ʹ� command�� ���´�.
			BindException errors) throws Exception {
		
		// ok��ư�� ������ onSubmit�� �ڵ����� ����Ǹ� , �����ʹ� Object command �� �Ѿ�´�.
		LoginCommand login = (LoginCommand)command;
		
		try {
			
			//�Ѿ�� ID,PWD�� �ѱ��.
			authenticator.authen(login.getUserId(), login.getUserPwd());
			
			String message = "id: " + login.getUserId();
			message += ", pwd: " + login.getUserPwd();
			message += ", type: " + login.getLoginType();
			
			request.setAttribute("message", message);
			
			// test1������ login_ok���� �ѱ��.
			return new ModelAndView("test1/login_ok");
			
		} catch (Exception e) {
			// �α��ι�ư�� ������ ȭ���� �ٲ�Ƿ� â�� �ٽ� �����ְ� �ؾ��Ѵ�.
			return showForm(request, response, errors);// �����޽����� ������ �Է�â�� �ٽ� ����.(�ٽ� �α����� �ϰԲ�)
		}
		
	}
	
	
	//1. ���⿡ �ڵ��� �κ��� login.jsp�� �㶧 �α��� Ÿ�Կ� �����͸� ����ش�. 
	//   �׷��� ���⿡�� Ÿ�Ժκп� �� ������ �ڵ� ( referenceData�� ���� ����ȴ�)
	@Override
	protected Map<String, List<String>> referenceData(HttpServletRequest request) throws Exception {
		
		List<String> loginTypes = new ArrayList<>();
		loginTypes.add("�Ϲ�ȸ��");
		loginTypes.add("���ȸ��");
		loginTypes.add("Ư��ȸ��");
		
		// �߰��� ����Ʈ�� �ʿ� �߰�
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("loginType", loginTypes);// loginType�̶�� �̸����� �ѱ��.
		
			
		return map;
		
	}
	
	
}