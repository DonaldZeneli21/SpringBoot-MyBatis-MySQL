package com.myproject.dto;

import java.util.Date;


public class TouristDTO {

	private Long idTourist;
	private String touristName;
	private String touristSurname;
	private Date touristBithdate;
	private String touristEmail;
	
	public Long getIdTourist() {
		return idTourist;
	}
	public void setIdTourist(Long idTourist) {
		this.idTourist = idTourist;
	}
	public String getTouristName() {
		return touristName;
	}
	public void setTouristName(String touristName) {
		this.touristName = touristName;
	}
	public String getTouristSurname() {
		return touristSurname;
	}
	public void setTouristSurname(String touristSurname) {
		this.touristSurname = touristSurname;
	}
	public Date getTouristBithdate() {
		return touristBithdate;
	}
	public void setTouristBirthdate(Date touristBithdate) {
		this.touristBithdate = touristBithdate;
	}
	public String getTouristEmail() {
		return touristEmail;
	}
	public void setTouristEmail(String touristEmail) {
		this.touristEmail = touristEmail;
	}
	
	
}
