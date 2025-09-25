package com.airline.Airline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.airline.Airline.entities.Flight;
import com.airline.Airline.entities.FlightSchedule;
import com.airline.Airline.Dto.SearchDto;
import com.airline.Airline.Exception.ObjectNotFoundException;
import com.airline.Airline.repositories.FlightRepository;
import com.airline.Airline.repositories.FlightSchduleRepository;

@Service
public class FlightSchduleService {

	FlightSchduleRepository flightSchduleRepository;
	FlightRepository flightRepository;

	public FlightSchduleService(FlightSchduleRepository flightSchduleRepository, FlightRepository flightRepository) {
		super();
		this.flightSchduleRepository = flightSchduleRepository;
		this.flightRepository = flightRepository;
	}

	public FlightSchedule schduleFlight(FlightSchedule flightSchedule) {
		FlightSchedule saved = this.flightSchduleRepository.save(flightSchedule);
		return saved;
	}

	public FlightSchedule getFlightSchduleById(Integer flightSchduleId) {

		FlightSchedule foundSchedule = this.flightSchduleRepository.findById(flightSchduleId)
				.orElseThrow(() -> new ObjectNotFoundException("Flight Schedule", flightSchduleId));
		return foundSchedule;

	}

	public List<FlightSchedule> getAllSchdule() {

		List<FlightSchedule> allSchedule = this.flightSchduleRepository.findAll();
		return allSchedule;
	}

	public void deleteFlightSchduleById(Integer schduleFlightId) {

		this.flightSchduleRepository.findById(schduleFlightId)
				.orElseThrow(() -> new ObjectNotFoundException("flight schdule", schduleFlightId));
		this.flightSchduleRepository.deleteById(schduleFlightId);

	}

	public List<FlightSchedule> searchFlight(SearchDto searchDto) {
		List<Flight> flights = this.flightRepository.findByOriginContainingAndDestinationContaining(searchDto.origin(),
				searchDto.destination());
		List<FlightSchedule> schedule = this.flightSchduleRepository.findAll();
		List<FlightSchedule> ans = new ArrayList<>();
		for (FlightSchedule s : schedule) {
			for (Flight f : flights) {
			  System.out.println("ABCD            :"+s.getFlightId()+"          "+f.getFlightId()+"         "+s.getDateOfTravel().getDate()+"          "+searchDto.date().getDate());
				if (s.getFlightId() == f.getFlightId() && s.getDateOfTravel().getDate() == searchDto.date().getDate()) {
					ans.add(s);
				}
			}
		}
		return ans;
	}

}
