package com.myproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.TouristDTO;
import com.myproject.mapper.TouristMapper;

@Repository
public class TouristDAOImpl implements TouristDAO{

	@Autowired
	protected TouristMapper mapper;
	
	@Override
	public List<TouristDTO> getTourist() {
	
		return mapper.getTourist();
	}
	
	@Override
	public List<TouristDTO> getTouristByName(TouristDTO request) {
		
		
		return mapper.getTouristByName(request);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertTourist(TouristDTO request) {
		int inserted = mapper.insertTourist(request);
		return inserted;

	}

}
