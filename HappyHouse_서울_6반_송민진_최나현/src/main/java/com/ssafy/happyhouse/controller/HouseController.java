package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.dto.SidoGugunCode;
import com.ssafy.happyhouse.model.service.HouseService;

@CrossOrigin
@RestController
public class HouseController {

	@Autowired
	HouseService service;

	@GetMapping(value="/house/{keyword}")
	public List<String> houseSearch(@PathVariable String keyword) {
		System.out.println("houseSearch : " + keyword);
		List<SidoGugunCode> donglist = null;
		List<HouseInfo> aptlist = null;
		List<String> result = new ArrayList<>(); // list에 {지역명/아파트명 여부, 지역이름/아파트이름, 시, 구, 동} 이렇게 넣어서 return
		
		try {
			donglist = service.getDongName(keyword); // keyword를 동 DB에서 검색 일치하는 값
			aptlist = service.getAptName(keyword); // keyword를 houseinfo DB에서 검색 일치하는 값
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int t = 0; t < donglist.size(); t++) {
			System.out.println(donglist.get(t) + " / " + donglist.get(t).getSidoName() + " " + donglist.get(t).getGugunCode() + " " + donglist.get(t).getGugunName());
			result.add(donglist.get(t).getSidoName() + " " + donglist.get(t).getGugunCode() + " " + donglist.get(t).getGugunName());
		}
		for (int t = 0; t < aptlist.size(); t++) {
			System.out.println(aptlist.get(t) + " / " + aptlist.get(t).getAptName());
			result.add(keyword + " " + aptlist.get(t).getAptName());
		}
		
		// list에 전체 값 넣어서 return
		return result;
	}

	@ResponseBody
	@GetMapping(value = "/map")
	public List<SidoGugunCode> searchByDong(HttpServletRequest request, Model model) throws Exception {
		String act = request.getParameter("act");
		System.out.println("ACT : " + act);

		if ("sido".equals(act)) {
			System.out.println("sido");
			List<SidoGugunCode> list = null;
			list = service.getSido();
			return list;
		} // sido
		else if ("gugun".equals(act)) {
			String sido = request.getParameter("sido");
			List<SidoGugunCode> list = null;
			list = service.getGugunInSido(sido);
			return list;
		} // gugun
		else if ("dong".equals(act)) {
			String gugun = request.getParameter("gugun");
			List<SidoGugunCode> list = null;
			list = service.getDongInGugun(gugun);
			return list;
		} // dong
		return null;
	}

	@ResponseBody
	@GetMapping(value = "/result")
	public List<HouseInfo> main(HttpServletRequest request) throws Exception {
		String dong = request.getParameter("dong");
		return service.getAptInDong(dong);
	}

	@ResponseBody
	@GetMapping(value = "/selectAll")
	public List<HouseInfo> selectAll() throws Exception {
		return service.selectAll();
	}

	@ResponseBody
	@GetMapping(value = "/search")
	public List<HouseInfo> search(HttpServletRequest request) throws Exception {
		String dong = request.getParameter("dong");
		String aptName = request.getParameter("aptName");
		return service.search(aptName, dong);
	}

	@ResponseBody
	@GetMapping(value = "/detail")
	public List<HouseDeal> detail(HttpServletRequest request) throws Exception {
		String aptName = request.getParameter("aptName");
		String dong = request.getParameter("dong");
		return service.detail(aptName, dong);
	}
}
