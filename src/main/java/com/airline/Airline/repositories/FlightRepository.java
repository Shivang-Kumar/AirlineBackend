package com.airline.Airline.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.Airline.entities.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	List<Flight> findByOriginContainingAndDestinationContaining(String origin, String destination);

}
