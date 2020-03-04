package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.DestinationDAO;
import com.myproject.dto.DestinationDTO;

@Service
public class DestinationServiceImpl implements DestinationService{

	@Autowired
	private DestinationDAO dao;
	
	@Override
	public List<DestinationDTO> getDestination() {
	
		return dao.getDestination();
	}

	@Override
	public List<DestinationDTO> getDestinationByCountry(DestinationDTO request) {
		
		return dao.getDestinationByCountry(request);
	}

	@Override
	public int insertDestination(DestinationDTO request) {
	
		return dao.insertDestination(request);
	}

	@Override
	public int updateDestination(DestinationDTO request) {
		
		return dao.updateDestination(request);
	}

	@Override
	public int deleteDestination(DestinationDTO request) {

		return dao.deleteDestination(request);
	}

}
