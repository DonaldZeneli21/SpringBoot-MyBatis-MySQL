package com.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.dto.DestinationDTO;

@Service
public interface DestinationService {

	public List<DestinationDTO> getDestination();
	public List<DestinationDTO> getDestinationByCountry(DestinationDTO request);
	public int insertDestination(DestinationDTO request);
	public int updateDestination(DestinationDTO request);
	public int deleteDestination(DestinationDTO request);

}
