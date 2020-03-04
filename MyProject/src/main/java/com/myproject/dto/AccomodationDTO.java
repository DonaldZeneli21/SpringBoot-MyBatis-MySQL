package com.myproject.dto;

public class AccomodationDTO {

	private Long idAccomodation;
	private String accomodationType;
	private String address;
	private double cost;
	private int roomNumber;
	
	
	public Long getIdAccomodation() {
		return idAccomodation;
	}
	public void setIdAccomodation(Long idAccomodation) {
		this.idAccomodation = idAccomodation;
	}
	public String getAccomodationType() {
		return accomodationType;
	}
	public void setAccomodationType(String accomodationType) {
		this.accomodationType = accomodationType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
}
