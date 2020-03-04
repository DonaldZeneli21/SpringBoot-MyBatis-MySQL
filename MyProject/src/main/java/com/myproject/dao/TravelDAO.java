package com.myproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.dto.TravelDTO;

@Repository
public interface TravelDAO {

	public List<TravelDTO> getTravel();
	public List<TravelDTO> getTravelByDates(TravelDTO request);
}
