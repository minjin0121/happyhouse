package com.ssafy.happyhouse.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.dto.SidoGugunCode;
import com.ssafy.happyhouse.model.service.HouseService;

@Controller
public class HouseController {

	@Autowired
	HouseService service;

	@GetMapping(value="/")
	public String home() {
		System.out.println("HOME 화면");
		return "index";
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
