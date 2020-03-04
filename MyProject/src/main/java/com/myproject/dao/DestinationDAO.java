package com.myproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.dto.DestinationDTO;

@Repository
public interface DestinationDAO {

	public List<DestinationDTO> getDestination();
	public List<DestinationDTO> getDestinationByCountry(DestinationDTO request);
	public int insertDestination(DestinationDTO request);
	public int updateDestination(DestinationDTO request);
	public int deleteDestination(DestinationDTO request);
}
