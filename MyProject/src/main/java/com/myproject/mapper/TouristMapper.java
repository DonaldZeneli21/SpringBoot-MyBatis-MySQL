package com.myproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myproject.dto.TouristDTO;

@Mapper
public interface TouristMapper {

	public List<TouristDTO> getTourist();
	public List<TouristDTO> getTouristByName(TouristDTO request);
	public int insertTourist(TouristDTO request);

}
