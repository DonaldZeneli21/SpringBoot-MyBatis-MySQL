package com.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.dto.TravelDTO;

@Service
public interface TravelService {

	public List<TravelDTO> getTravel();
	public List<TravelDTO> getTravelByDates(TravelDTO request);
}
