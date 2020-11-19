package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ssafy.happyhouse.mapper.HouseMapper;
import com.ssafy.happyhouse.model.dto.*;

@Repository
public class HouseDaoImpl implements HouseDao {
	
	@Autowired
	HouseMapper mapper;
	
	@Override
	public List<SidoGugunCode> getDongName(String keyword) throws Exception {
		return mapper.getDongName(keyword);
	}
	
	@Override
	public List<HouseInfo> getAptName(String keyword) throws Exception {
		return mapper.getAptName(keyword);
	}
	
	@Override
	public List<SidoGugunCode> getSido() throws Exception {
		return mapper.getSido();
	}

	@Override
	public List<SidoGugunCode> getGugunInSido(String sido) throws Exception {
		return mapper.getGugunInSido(sido);
	}

	@Override
	public List<SidoGugunCode> getDongInGugun(String gugun) throws Exception {
		return mapper.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfo> getAptInDong(String dong) throws Exception {
		return mapper.getAptInDong(dong);
	}

	@Override
	public List<HouseInfo> search(String aptName, String dong) throws Exception {
		return mapper.search(aptName, dong);
	}

	@Override
	public List<HouseInfo> selectAll() throws Exception {
		return mapper.selectAll();
	}

	@Override
	public List<HouseDeal> detail(String aptName, String dong) {
		return mapper.detail(aptName, dong);
	}

}
