package com.ssafy.happyhouse.controller;

import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ssafy.happyhouse.model.dto.Board;
import com.ssafy.happyhouse.model.service.BoardService;

@MapperScan(basePackages = {"com.ssafy.happyhouse.mapper"})
@CrossOrigin
@RestController
//@RequestMapping("/boards")
public class BoardController {

	@Autowired
	BoardService service;

	@GetMapping(value="/boards")
	public List<Board> selectAll() {
		System.out.println("REQUEST!! selectAll");
		List<Board> list = null;
		try {
			list = service.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@GetMapping(value="/boards/{num}")
	public Board selectOne(@PathVariable String num) {
		Board board = null;
		try {
			board = service.selectOne(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	@PostMapping(value="/boards")
	public int insert(@RequestBody Board board) {
		try {
			return service.insert(board);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@PutMapping(value="/boards/{num}")
	public int countUp(@PathVariable String num) {
		try {
			return service.countUp(num);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@DeleteMapping(value="/boards/{num}")
	public int delete(@PathVariable String num) {
		try {
			return service.delete(num);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@GetMapping(value="/boards/title/{keyword}")
	public List<Board> searchTitle(@PathVariable String keyword) {
		List<Board> list = null;
		try {
			list = service.searchTitle(keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@GetMapping(value="/boards/name/{keyword}")
	public List<Board> searchName(@PathVariable String keyword) {
		List<Board> list = null;
		try {
			list = service.searchName(keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@PutMapping(value="/boards")
	public int update(@RequestBody Board board) {
		System.out.println("UPDATE!! " + board.getTITLE() + " / " + board.getCONTENT());
		try {
			return service.update(board);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
