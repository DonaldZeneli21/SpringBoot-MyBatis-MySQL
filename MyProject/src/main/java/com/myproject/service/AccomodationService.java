package com.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.dto.AccomodationDTO;

@Service
public interface AccomodationService {

	public List<AccomodationDTO> getAccomodation();
	public List<AccomodationDTO> getAccomodationByType(AccomodationDTO request);
	public int insertAccomodation(AccomodationDTO request);
	public int updateAccomodation(AccomodationDTO request);
	public int deleteAccomodation(AccomodationDTO request);

}
