package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ssafy.happyhouse.mapper.BoardMapper;
import com.ssafy.happyhouse.model.dto.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	BoardMapper mapper;

	@Override
	public List<Board> selectAll() throws Exception {
		return mapper.selectAll();
	}

	@Override
	public Board selectOne(String num) throws Exception {
		return mapper.selectOne(num);
	}

	@Override
	public int insert(Board board) throws Exception {
		return mapper.insert(board);
	}

	@Override
	public int countUp(String num) throws Exception {
		return mapper.countUp(num);
	}

	@Override
	public int delete(String num) throws Exception {
		return mapper.delete(num);
	}

	@Override
	public List<Board> searchTitle(String keyword) throws Exception {
		return mapper.searchTitle(keyword);
	}

	@Override
	public List<Board> searchName(String keyword) throws Exception {
		return mapper.searchName(keyword);
	}

	@Override
	public int update(Board board) throws Exception {
		return mapper.update(board);
	}

}
