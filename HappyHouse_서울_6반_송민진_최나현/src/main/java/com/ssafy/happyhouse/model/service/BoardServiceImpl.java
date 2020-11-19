package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.happyhouse.model.dao.BoardDao;
import com.ssafy.happyhouse.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;

	@Override
	public List<Board> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	public Board selectOne(String num) throws Exception {
		return dao.selectOne(num);
	}

	@Override
	public int insert(Board board) throws Exception {
		return dao.insert(board);
	}

	@Override
	public int countUp(String num) throws Exception {
		return dao.countUp(num);
	}

	@Override
	public int delete(String num) throws Exception {
		return dao.delete(num);
	}

	@Override
	public List<Board> searchTitle(String keyword) throws Exception {
		return dao.searchTitle(keyword);
	}

	@Override
	public List<Board> searchName(String keyword) throws Exception {
		return dao.searchName(keyword);
	}

	@Override
	public int update(Board board) throws Exception {
		return dao.update(board);
	}

}
