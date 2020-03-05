package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.TouristDAO;
import com.myproject.dto.TouristDTO;

@Service
public class TouristServiceImpl implements TouristService{

	@Autowired
	private TouristDAO dao;

	@Override
	public List<TouristDTO> getTourist() {
		
		return dao.getTourist();
	}
	
	@Override
	public List<TouristDTO> getTouristByName(TouristDTO request) {
		
		return dao.getTouristByName(request);
	}

	@Override
	public int insertTourist(TouristDTO request) {
		
		return dao.insertTourist(request);
	}

	@Override
	public int updateTourist(TouristDTO request) {
	
		return dao.updateTourist(request);
	}

	@Override
	public int deleteTourist(TouristDTO request) {
	
		return dao.deleteTourist(request);
	}

}
