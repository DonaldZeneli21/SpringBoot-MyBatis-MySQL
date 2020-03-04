package com.myproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dto.DestinationDTO;
import com.myproject.mapper.DestinationMapper;

@Repository
public class DestinationDAOImpl implements DestinationDAO{

	@Autowired
	protected DestinationMapper mapper;
	
	@Override
	public List<DestinationDTO> getDestination() {
		
		return mapper.getDestination();
	}

	@Override
	public List<DestinationDTO> getDestinationByCountry(DestinationDTO request) {
	
		return mapper.getDestinationByCountry(request);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertDestination(DestinationDTO request) {
		int inserted = mapper.insertDestination(request);
		return inserted;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateDestination(DestinationDTO request) {
		int updated = mapper.updateDestination(request);
		return updated;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteDestination(DestinationDTO request) {
		int deleted = mapper.deleteDestination(request);
		return deleted;

	}

}
