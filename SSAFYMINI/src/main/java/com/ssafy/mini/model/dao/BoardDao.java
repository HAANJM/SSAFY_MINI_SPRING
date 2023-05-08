package com.ssafy.mini.model.dao;

import java.util.List;

import com.ssafy.mini.model.dto.Board;

public interface BoardDao {
	
	List<Board> selectBoardList();
	
	int insertBoard(Board board);

}
