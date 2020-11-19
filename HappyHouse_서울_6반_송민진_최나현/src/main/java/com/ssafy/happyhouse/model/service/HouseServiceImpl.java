package com.ssafy.happyhouse.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.happyhouse.model.dto.*;
import com.ssafy.happyhouse.model.dao.HouseDao;

@Service
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	HouseDao dao;

	@Override
	public List<SidoGugunCode> getDongName(String keyword) throws Exception {
		return dao.getDongName(keyword);
	}
	
	@Override
	public List<HouseInfo> getAptName(String keyword) throws Exception {
		return dao.getAptName(keyword);
	}
	
	
	@Override
	public List<SidoGugunCode> getSido() throws Exception {
		return dao.getSido();
	}

	@Override
	public List<SidoGugunCode> getGugunInSido(String sido) throws Exception {
		return dao.getGugunInSido(sido);
	}

	@Override
	public List<SidoGugunCode> getDongInGugun(String gugun) throws Exception {
		return dao.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfo> getAptInDong(String dong) throws Exception {
		return dao.getAptInDong(dong);
	}

	@Override
	public List<HouseInfo> search(String aptName, String dong) throws Exception {
		return dao.search(aptName, dong);
	}

	@Override
	public List<HouseInfo> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	public List<HouseDeal> detail(String aptName, String dong) {
		return dao.detail(aptName, dong);
	}

}
