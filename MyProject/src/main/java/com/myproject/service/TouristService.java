package com.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.dto.TouristDTO;

@Service
public interface TouristService {

	public List<TouristDTO> getTourist();
	public List<TouristDTO> getTouristByName(TouristDTO request);
	public int insertTourist(TouristDTO request);
}
