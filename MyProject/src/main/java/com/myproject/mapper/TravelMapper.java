package com.myproject.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myproject.dto.TravelDTO;

@Mapper
public interface TravelMapper {
	
	public List<TravelDTO> getTravel();
	public List<TravelDTO> getTravelByDates(TravelDTO request);



}
