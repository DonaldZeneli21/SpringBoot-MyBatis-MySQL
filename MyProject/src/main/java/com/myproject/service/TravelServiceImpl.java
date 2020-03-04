package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.TravelDAO;
import com.myproject.dto.TravelDTO;

@Service
public class TravelServiceImpl implements TravelService{

	@Autowired
	private TravelDAO dao;
	
	@Override
	public List<TravelDTO> getTravel() {
		
		return dao.getTravel();
	}

	@Override
	public List<TravelDTO> getTravelByDates(TravelDTO request) {
		
		return dao.getTravelByDates(request);
	}

}
