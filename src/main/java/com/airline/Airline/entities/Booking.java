package com.airline.Airline.entities;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Booking {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    Integer bookingId;
   
	
	//Later to add foreign key constraints
	Integer flightId;
	Integer userId;
	Integer noOfSeats;
	String  seatCategory;
	Date dateOfTravel;
	String bookingStatus;
	Integer bookingAmount;
	public Booking() {
		super();
	}
	public Booking(Integer bookingId, Integer flightId, Integer userId, Integer noOfSeats, String seatCategory,
			Date dateOfTravel, String bookingStatus, Integer bookingAmount) {
		super();
		this.bookingId = bookingId;
		this.flightId = flightId;
		this.userId = userId;
		this.noOfSeats = noOfSeats;
		this.seatCategory = seatCategory;
		this.dateOfTravel = dateOfTravel;
		this.bookingStatus = bookingStatus;
		this.bookingAmount = bookingAmount;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getSeatCategory() {
		return seatCategory;
	}
	public void setSeatCategory(String seatCategory) {
		this.seatCategory = seatCategory;
	}
	public Date getDateOfTravel() {
		return dateOfTravel;
	}
	public void setDateOfTravel(Date dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public Integer getBookingAmount() {
		return bookingAmount;
	}
	public void setBookingAmount(Integer bookingAmount) {
		this.bookingAmount = bookingAmount;
	}
	
	
}