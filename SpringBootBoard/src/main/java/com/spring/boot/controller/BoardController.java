package com.spring.boot.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.dto.BoardDTO;
import com.spring.boot.service.BoardService;
import com.spring.boot.util.MyUtil;

@RestController //Spring Boot에서는 RestController
public class BoardController {
	
	@Resource
	private BoardService boardService; //BoardServiceImpl이 딸려 들어오게 된다.
	
	@Autowired
	MyUtil myUtil;
	
	@RequestMapping(value = "/")
	public ModelAndView index() throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index"); //html로 갈때는 setViewName /클래스로 갈때는 setView
		
		return mav;
	}
	
	@RequestMapping(value = "/created.action", method = {RequestMethod.GET})
	public ModelAndView created() throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("bbs/created"); //html로 갈때는 setViewName
		
		return mav;
	}
	
	@RequestMapping(value = "/created.action", method = {RequestMethod.POST})
	public ModelAndView created_ok(BoardDTO dto, 
			HttpServletRequest request) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		int maxNum = boardService.maxNum();
		
		dto.setNum(maxNum+1);
		dto.setIpAddr(request.getRemoteAddr());
		
		boardService.insertData(dto);
		
		mav.setViewName("redirect:/list.action");
		
		return mav;
	}
	
	@RequestMapping(value = "/list.action", 
			method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(HttpServletRequest request) throws Exception {
		
		String pageNum = request.getParameter("pageNum");

		int currentPage = 1;

		if(pageNum!=null)
			currentPage = Integer.parseInt(pageNum);

		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");

		if(searchValue==null) {//searchValue가 null이얌 ??
			//||searchValue.equals("") 원래 이렇게 두번씩 쓴다 무슨 오류가 있을 수 도 있기 때문에

			searchKey = "subject";
			searchValue = "";

		}else {

			if(request.getMethod().equalsIgnoreCase("GET")) {
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
		}

		int dataCount = boardService.getDataCount(searchKey, searchValue);

		int numPerPage = 5;
		int totalPage = myUtil.getPageCount(numPerPage, dataCount);

		if(currentPage>totalPage)
			currentPage = totalPage;

		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage;

		List<BoardDTO> lists =
				boardService.getLists(start, end, searchKey, searchValue);

		String param = "";
		if(searchValue!=null&&!searchValue.equals("")) {//서치벨류가 null이면
			param = "searchKey=" + searchKey;
			param+= "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
		}

		String listUrl = "/list.action";

		if(!param.equals("")) {
			listUrl += "?" + param;
		}

		String pageIndexList = 
				myUtil.pageIndexList(currentPage, totalPage, listUrl);

		//글보기 주소

		String articleUrl = "/article.action?pageNum=" + currentPage;

		if(!param.equals("")) {
			articleUrl += "&" + param;
		}


		ModelAndView mav = new ModelAndView();

		mav.addObject("lists", lists);
		mav.addObject("articleUrl", articleUrl);
		mav.addObject("pageIndexList", pageIndexList);
		mav.addObject("dataCount", dataCount);

		mav.setViewName("bbs/list");

		return mav;
		
	}
}
