package com.ssafy.happyhouse.model.service;

import java.util.List;
import com.ssafy.happyhouse.model.dto.Board;

public interface BoardService {
	
	public List<Board> selectAll() throws Exception;
	public Board selectOne(String num) throws Exception;
	public int insert(Board board) throws Exception;
	public int countUp(String num) throws Exception;
	public int delete(String num) throws Exception;
	public List<Board> searchTitle(String keyword) throws Exception;
	public List<Board> searchName(String keyword) throws Exception;
	public int update(Board board) throws Exception;
	
}
