package com.myproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.dto.TravelDTO;
import com.myproject.mapper.TravelMapper;

@Repository
public class TravelDAOImpl implements TravelDAO{

	@Autowired
	protected TravelMapper mapper;
	
	@Override
	public List<TravelDTO> getTravel() {
	
		return mapper.getTravel();
	}

	@Override
	public List<TravelDTO> getTravelByDates(TravelDTO request) {
		
		return mapper.getTravelByDates(request);
	}

}
