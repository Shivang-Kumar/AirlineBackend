package com.airline.Airline.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.airline.Airline.Dto.BookingDto;
import com.airline.Airline.entities.Booking;

@Component
public class BookingDtoToBookingConverter implements Converter<BookingDto, Booking> {

	@Override
	public Booking convert(BookingDto source) {
		Booking booking=new Booking();
		booking.setBookingId(source.bookingID());
		booking.setFlightId(source.flightId());
		booking.setUserId(source.userId());
		booking.setNoOfSeats(source.noOfSeats());
		booking.setSeatCategory(source.seatCategory());
		booking.setDateOfTravel(source.dateOfTravel());
		booking.setBookingStatus(source.bookingStatus());
		booking.setBookingAmount(source.bookingAmount());
		return booking;
	}
	
	

}





