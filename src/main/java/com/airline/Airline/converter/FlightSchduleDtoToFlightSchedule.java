package com.airline.Airline.converter;



import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.airline.Airline.Dto.FlightScheduleDto;
import com.airline.Airline.entities.FlightSchedule;

@Component
public class FlightSchduleDtoToFlightSchedule implements Converter<FlightScheduleDto, FlightSchedule> {

	@Override
	public FlightSchedule convert(FlightScheduleDto source) {
	
		FlightSchedule  flightSchdule=new FlightSchedule();
		flightSchdule.setFlightScheduleId(source.flightScheduleId());
		flightSchdule.setFlightId(source.flightId());
		flightSchdule.setDateOfTravel(source.date());
		flightSchdule.setBusinessClassBookedDiscount(source.bussinessClassBookedDiscount());
		flightSchdule.setEconomyClassBookedDiscount(source.economyClassBookedDiscount());
		flightSchdule.setExecutiveClassBookedDiscount(source.executiveClassBookedDiscount());
		return flightSchdule;
		
		
	}

}