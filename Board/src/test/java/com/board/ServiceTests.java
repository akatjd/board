package com.board;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceTests {
	
	@Autowired
	private BoardMapper boardMapper;

	@Test
	public void registerBoard(BoardDTO params) {
		int queryResult = 0;

		if (params.getIdx() == null) {
			queryResult = boardMapper.insertBoard(params);
		} else {
			queryResult = boardMapper.updateBoard(params);
		}

	}
	
	@Test
	public void testMultipleInsert() {
		for (int i = 2; i <= 50; i++) {
			BoardDTO params = new BoardDTO();
			params.setTitle(i + "번 게시글 제목");
			params.setContent(i + "번 게시글 내용");
			params.setWriter(i + "번 게시글 작성자");
			boardMapper.insertBoard(params);
		}
	}
	
}
