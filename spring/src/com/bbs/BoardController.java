package com.bbs;
//��Ʈ�ѷ� : �й��(���� ���� ��� �й�)

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.util.MyUtil;
import com.util.dao.CommonDAO;

@Controller("bbs.boardController")
public class BoardController {
	
	//@Qualifier("com.salMap") �� �ΰ��� ��ģ�� @Resource�̴�,
	@Resource(name="dao") //�̸��� ������ �ͼ�
	private CommonDAO dao;// ���⿡ �־��
	
	@Resource(name="myUtil") //MyUtil�� �о�ͼ� 
	private MyUtil myUtil;// = new MyUtil();   / ���⿡ �־��
	
	@RequestMapping(value="/bbs/created.action",
			method= {RequestMethod.GET,RequestMethod.POST})
	public String created(BoardCommand command,
			HttpServletRequest request) throws Exception{
		
		//�Է�â���� ���������
		if (command==null||command.getMode()==null 
				|| command.getMode().equals("")) {
					
			//�Ѿ �� mode�� �������� �Ѵ�.
			request.setAttribute("mode", "insert");
					
			return "board/created";
		}
		
		
		//�Է��� ��Ű�� �ڵ��� ���ش�
		int boardNumMax = dao.getIntValue("bbs.boardNumMax");
				
		command.setBoardNum(boardNumMax + 1);
		command.setIpAddr(request.getRemoteAddr());
				
		dao.insertData("bbs.insertData", command);
				
		return "redirect:/bbs/list.action";//�����ּҰ� �ƴ� ���� �ּҶ� �ּ� �� ������Ѵ�
		
	}//end created()
	
	
	//list�� form�� ���°� �ƴ϶� get������� �Ѿ�´�. post�� ������ �Ǵµ� �׳� ����´�
	@RequestMapping(value="/bbs/list.action",
			method= {RequestMethod.GET,RequestMethod.POST})
	public String list(HttpServletRequest request) throws Exception{
		
		
		return "board/list";
	}
	
}
