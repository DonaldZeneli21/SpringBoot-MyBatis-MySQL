package com.myproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.dto.ReservationDTO;
import com.myproject.mapper.ReservationMapper;

@Repository
public class ReservationDAOImpl implements ReservationDAO{

	@Autowired
	protected ReservationMapper mapper;
	
	@Override
	public List<ReservationDTO> getReservation() {
		
		return mapper.getReservation();
	}

	@Override
	public List<ReservationDTO> getReservationByDate(ReservationDTO request) {
	
		return mapper.getReservationByDate(request);
	}

}
