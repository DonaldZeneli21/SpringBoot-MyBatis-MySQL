package com.myproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.dto.TouristDTO;

@Repository
public interface TouristDAO {

	public List<TouristDTO> getTourist();
	public List<TouristDTO> getTouristByName(TouristDTO request);
	public int insertTourist(TouristDTO request);
	public int updateTourist(TouristDTO request);
	public int deleteTourist(TouristDTO request);

}
