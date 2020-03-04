package com.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.dto.ReservationDTO;

@Service
public interface ReservationService {

	public List<ReservationDTO> getReservation();
	public List<ReservationDTO> getReservationByDate(ReservationDTO request);
}
