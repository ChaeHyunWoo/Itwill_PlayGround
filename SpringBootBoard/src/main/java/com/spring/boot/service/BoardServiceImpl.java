package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.BoardDTO;
import com.spring.boot.mapper.BoardMapper;

//BoardService 인터페이스를 구현한 클래스
@Service //객체 생성
public class BoardServiceImpl implements BoardService{
	
	@Autowired						 // boardMapper.xml에 있는 쿼리를 읽어온다.
	private BoardMapper boardMapper; // BoardMapper의 의존성 주입
	
	
	//경로 : BoardController -> BoardService(I) -> BoardServiceImpl(C) ->
	//		 BoardMapper(I) -> boardMapper.xml
	
	
	@Override
	public int maxNum() throws Exception {
		return boardMapper.maxNum();
	}

	@Override
	public void insertData(BoardDTO dto) throws Exception {
		boardMapper.insertData(dto);
	}

	@Override
	public int getDataCount(String searchKey, String searchValue) throws Exception {
		return boardMapper.getDataCount(searchKey, searchValue);
	}

	@Override
	public List<BoardDTO> getLists(int start, int end, String searchKey, String searchValue) throws Exception {
		return boardMapper.getLists(start, end, searchKey, searchValue);
	}

}
