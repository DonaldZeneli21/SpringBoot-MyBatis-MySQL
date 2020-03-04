package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.ReservationDAO;
import com.myproject.dto.ReservationDTO;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDAO dao;
	
	@Override
	public List<ReservationDTO> getReservation() {
		
		return dao.getReservation();
	}

	@Override
	public List<ReservationDTO> getReservationByDate(ReservationDTO request) {
	
		return dao.getReservationByDate(request);
	}

}
