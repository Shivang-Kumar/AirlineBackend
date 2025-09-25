package com.airline.Airline.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.airline.Airline.Dto.BookingDto;
import com.airline.Airline.entities.Booking;

@Component
public class BookingToBookingDtoConverter implements Converter<Booking,BookingDto> {

	@Override
	public BookingDto convert(Booking source) {
		BookingDto bookingDto=new BookingDto(
				source.getBookingId(),
				source.getFlightId(),
				source.getUserId(),
				source.getNoOfSeats(),
				source.getSeatCategory(),
				source.getDateOfTravel(),
				source.getBookingStatus(),
				source.getBookingAmount()
				);
		
		return bookingDto;
	}

}