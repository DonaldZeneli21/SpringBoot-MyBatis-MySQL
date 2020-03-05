package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.AccomodationDAO;
import com.myproject.dto.AccomodationDTO;

@Service
public class AccomodationServiceImpl implements AccomodationService{

	@Autowired
	private AccomodationDAO dao;
	
	@Override
	public List<AccomodationDTO> getAccomodation() {

		return dao.getAccomodation();
	}

	@Override
	public List<AccomodationDTO> getAccomodationByType(AccomodationDTO request) {
		
		return dao.getAccomodationByType(request);
	}

	@Override
	public int insertAccomodation(AccomodationDTO request) {
		
		return dao.insertAccomodation(request);
	}

	@Override
	public int updateAccomodation(AccomodationDTO request) {
		
		return dao.updateAccomodation(request);
	}

	@Override
	public int deleteAccomodation(AccomodationDTO request) {
	
		return dao.deleteAccomodation(request);
	}


}
