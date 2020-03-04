package com.myproject.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TravelDTO{

	private Long idTravel;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateFrom;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateTo;
	private Long idDestination;
	
	public Long getIdTravel() {
		return idTravel;
	}
	public void setIdTravel(Long idTravel) {
		this.idTravel = idTravel;
	}
	
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public Long getIdDestination() {
		return idDestination;
	}
	public void setIdDestination(Long idDestination) {
		this.idDestination = idDestination;
	}
	
	
	
	
	
	
}
