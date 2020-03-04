package com.myproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.dto.ReservationDTO;

@Repository
public interface ReservationDAO {

	public List<ReservationDTO> getReservation();
	public List<ReservationDTO> getReservationByDate(ReservationDTO request);
}
