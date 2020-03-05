package com.myproject.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationDTO {

	private Long idReservation;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date cancelDate;
	private boolean flagCancelled;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date reservationDate;
	private Long idAccomodation;
	private Long idTourist;
	private Long idTravel;
	
	public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	public boolean isFlagCancelled() {
		return flagCancelled;
	}
	public void setFlagCancelled(boolean flagCancelled) {
		this.flagCancelled = flagCancelled;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Long getIdAccomodation() {
		return idAccomodation;
	}
	public void setIdAccomodation(Long idAccomodation) {
		this.idAccomodation = idAccomodation;
	}
	public Long getIdTourist() {
		return idTourist;
	}
	public void setIdTourist(Long idTourist) {
		this.idTourist = idTourist;
	}
	public Long getIdTravel() {
		return idTravel;
	}
	public void setIdTravel(Long idTravel) {
		this.idTravel = idTravel;
	}
	
	
}
