package com.myproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myproject.dto.AccomodationDTO;

@Mapper
public interface AccomodationMapper {

	public List<AccomodationDTO> getAccomodation();
	public List<AccomodationDTO> getAccomodationByType(AccomodationDTO request);
	public int insertAccomodation(AccomodationDTO request);
	public int updateAccomodation(AccomodationDTO request);
	public int deleteAccomodation(AccomodationDTO request);


}
