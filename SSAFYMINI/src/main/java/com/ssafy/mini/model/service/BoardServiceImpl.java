package com.ssafy.mini.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.mini.model.dao.BoardDao;
import com.ssafy.mini.model.dto.Board;

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<Board> selectBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public int insertBoard(Board board) {
		return boardDao.insertBoard(board);
	}

}
