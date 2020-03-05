package com.myproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.dto.AccomodationDTO;

@Repository
public interface AccomodationDAO {

	public List<AccomodationDTO> getAccomodation();
	public List<AccomodationDTO> getAccomodationByType(AccomodationDTO request);
	public int insertAccomodation(AccomodationDTO request);
	public int updateAccomodation(AccomodationDTO request);
	public int deleteAccomodation(AccomodationDTO request);
}
