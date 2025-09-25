package com.airline.Airline.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.airline.Airline.Dto.FlightDto;
import com.airline.Airline.entities.Flight;

@Component
public class FlightDtoToFlightConverter implements Converter<FlightDto, Flight> {

	@Override
	public Flight convert(FlightDto source) {
		
		Flight flight=new Flight();
	
		
		flight.setFlightId(source.flightId());
		flight.setCarrierId(source.carrierId());
		flight.setOrigin(source.origin());
		flight.setDestination(source.destination());
		flight.setAirFare(source.airFare());
		
		flight.setSeatCapacityEconomyClass(source.seatCapacityEconomyClass());
		flight.setSeatCapacityBusinessClass(source.seatCapacityBussinessClass());
		flight.setSeatCapacityExecutiveClass(source.seatCapacityExecutiveClass());
		return flight;
		
	}

}
