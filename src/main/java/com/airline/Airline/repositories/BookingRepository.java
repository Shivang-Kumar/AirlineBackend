package com.airline.Airline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.Airline.entities.Booking;


public interface BookingRepository extends JpaRepository<Booking,Integer> {


}





