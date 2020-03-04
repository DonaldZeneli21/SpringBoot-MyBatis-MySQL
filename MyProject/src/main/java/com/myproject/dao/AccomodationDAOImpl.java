package com.myproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.AccomodationDTO;
import com.myproject.mapper.AccomodationMapper;

@Repository
public class AccomodationDAOImpl implements AccomodationDAO{

	@Autowired
	protected AccomodationMapper mapper;
	
	@Override
	public List<AccomodationDTO> getAccomodation() {
		
		return mapper.getAccomodation();
	}

	@Override
	public List<AccomodationDTO> getAccomodationByType(AccomodationDTO request) {
		
		return mapper.getAccomodationByType(request);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertAccomodation(AccomodationDTO request) {
		int inserted = mapper.insertAccomodation(request);
		return inserted;

	}

}
