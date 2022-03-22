package com.bbs;
//컨트롤러 : 분배기(어디로 갈지 경로 분배)

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.util.MyUtil;
import com.util.dao.CommonDAO;

@Controller("bbs.boardController")
public class BoardController {
	
	//@Qualifier("com.salMap") 이 두개를 합친게 @Resource이다,
	@Resource(name="dao") //이름을 가지고 와서
	private CommonDAO dao;// 여기에 넣어라
	
	@Resource(name="myUtil") //MyUtil를 읽어와서 
	private MyUtil myUtil;// = new MyUtil();   / 여기에 넣어라
	
	@RequestMapping(value="/bbs/created.action",
			method= {RequestMethod.GET,RequestMethod.POST})
	public String created(BoardCommand command,
			HttpServletRequest request) throws Exception{
		
		//입력창으로 만들어진다
		if (command==null||command.getMode()==null 
				|| command.getMode().equals("")) {
					
			//넘어갈 때 mode를 가져가야 한다.
			request.setAttribute("mode", "insert");
					
			return "board/created";
		}
		
		
		//입력을 시키는 코딩을 써준다
		int boardNumMax = dao.getIntValue("bbs.boardNumMax");
				
		command.setBoardNum(boardNumMax + 1);
		command.setIpAddr(request.getRemoteAddr());
				
		dao.insertData("bbs.insertData", command);
				
		return "redirect:/bbs/list.action";//실제주소가 아닌 가상 주소라서 주소 다 써줘야한다
		
	}//end created()
	
	
	//list는 form을 쓰는게 아니라 get방식으로 넘어온다. post를 지워도 되는데 그냥 써놓는다
	@RequestMapping(value="/bbs/list.action",
			method= {RequestMethod.GET,RequestMethod.POST})
	public String list(HttpServletRequest request) throws Exception{
		
		
		return "board/list";
	}
	
}
