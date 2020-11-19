package com.ssafy.happyhouse.mapper;

import java.util.List;
import com.ssafy.happyhouse.model.dto.*;

public interface HouseMapper {
	
	List<SidoGugunCode> getDongName(String keyword) throws Exception;
	List<HouseInfo> getAptName(String keyword) throws Exception;
	
	List<SidoGugunCode> getSido() throws Exception;
	List<SidoGugunCode> getGugunInSido(String sido) throws Exception;
	List<SidoGugunCode> getDongInGugun(String gugun) throws Exception;
	List<HouseInfo> getAptInDong(String dong) throws Exception;
	List<HouseInfo> search(String aptName, String dong) throws Exception;
	List<HouseInfo> selectAll() throws Exception;
	List<HouseDeal> detail(String aptName, String dong);
	
}
