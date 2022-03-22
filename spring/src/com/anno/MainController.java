package com.anno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller�� ���� extends�� �ʿ���� ���������� ������ ��Ʈ�ѷ��� ��������� �ñ��.
//<bean name="listFormController" class="com.test.ListFormController"/> �̷������� @Controller�� �Ἥ �˾Ƽ� ��ü����

//ȥ�� ������Ʈ�� �ϸ� ��������� �����Ҷ� ������Ʈ�� ��ġ�� ���� ���� ��Ʈ�ѷ��� �浹�� ���� �ִ�.
// �׷��� @Controller("bbs.mainController")������ ���༭ �浹���� (��Ű��������� �̸������ش�)

@Controller("main.mainController")
@RequestMapping(value="/main.action") //�� �ּҸ� ġ�� MainController�� ����ȴ�.
public class MainController {
	
	//MainController main.Controller = new MainController();
	//MainController mainController = new MainController();
	
	
	//����ڰ� /main.action�� ġ�� MainController �޼��尡 ����Ǵµ�
	//�Ѿ�� ����� GET�̸� �� method()�� �����Ų��. 
	@RequestMapping(method=RequestMethod.GET)
	public String method() {
		
		return "/main"; // main.jsp�� ���� "/"��������
	}

}
