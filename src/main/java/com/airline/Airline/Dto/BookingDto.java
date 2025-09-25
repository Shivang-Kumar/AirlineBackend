package com.airline.Airline.Dto;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.airline.Airline.validation.BookingAmount;
import com.airline.Airline.validation.BookingRegister;
import com.airline.Airline.validation.CancelBooking;
import com.airline.Airline.validation.FlightScheduleRegister;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookingDto(
		@NotNull(message="Booking Id is required" ,groups={CancelBooking.class})
		Integer bookingID ,

		@NotNull(message = "Flight ID is required",groups = {BookingRegister.class ,BookingAmount.class}) 
		Integer flightId,

		@NotNull(message = "User Id  is required",groups = {BookingRegister.class ,BookingAmount.class}) 
		Integer userId,

		@NotNull(message = "No of seats is required",groups = {BookingRegister.class ,BookingAmount.class })
		Integer noOfSeats,

		@NotEmpty(message = "Seat category is required",groups = {BookingRegister.class ,BookingAmount.class})
		String seatCategory,

		@DateTimeFormat(pattern = "yyyy-MM-dd") 
		@NotNull(message = "Date is required" , groups = {BookingRegister.class ,BookingAmount.class})
		@FutureOrPresent(message = "Schedule date should be present or future", groups = {BookingRegister.class }) 
		Date dateOfTravel,

		String bookingStatus,
		
		@NotNull(message="Booking Amount is Required" )
		Integer bookingAmount

	){

}


