package com.myproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myproject.dto.ReservationDTO;

@Mapper
public interface ReservationMapper {

	public List<ReservationDTO> getReservation();
	public List<ReservationDTO> getReservationByDate(ReservationDTO request);
}
