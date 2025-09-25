package com.airline.Airline.service;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.airline.Airline.Dto.BookingDto;
import com.airline.Airline.entities.Booking;
import com.airline.Airline.entities.Carrier;
import com.airline.Airline.entities.Flight;
import com.airline.Airline.entities.FlightSchedule;
import com.airline.Airline.entities.User;
import com.airline.Airline.Exception.ObjectNotFoundException;
import com.airline.Airline.repositories.BookingRepository;
import com.airline.Airline.repositories.CarrierRepository;
import com.airline.Airline.repositories.FlightRepository;
import com.airline.Airline.repositories.FlightSchduleRepository;
import com.airline.Airline.repositories.UserRepository;

@Service
public class BookingService {

	
	BookingRepository bookingRepository;
	UserRepository userRepository;
	FlightRepository flightRepository;
	CarrierRepository carrierRepository;
	FlightSchduleRepository flightSchduleRepository;
	
	




	public BookingService(BookingRepository bookingRepository, UserRepository userRepository,
			FlightRepository flightRepository, CarrierRepository carrierRepository,
			FlightSchduleRepository flightSchduleRepository) {
		super();
		this.bookingRepository = bookingRepository;
		this.userRepository = userRepository;
		this.flightRepository = flightRepository;
		this.carrierRepository = carrierRepository;
		this.flightSchduleRepository = flightSchduleRepository;
	}


	public Booking bookFlight(Booking booking) {
		booking.setBookingStatus("Booked");
		return this.bookingRepository.save(booking);
	}


	public Double calculateBookingAmount(BookingDto bookingDto) {
	
		
	FlightSchedule flightSchedule=this.flightSchduleRepository.findById(bookingDto.flightId()).orElseThrow(()-> new ObjectNotFoundException("flight", bookingDto.flightId()));
	Flight flight=this.flightRepository.findById(flightSchedule.getFlightId()).orElseThrow(()-> new ObjectNotFoundException("Flight Schedule", flightSchedule.getFlightScheduleId()));
	Carrier carrier=this.carrierRepository.findById(flight.getCarrierId()).orElseThrow(()-> new ObjectNotFoundException("Carrier", flight.getCarrierId()));
	User user=this.userRepository.findById(bookingDto.userId()).orElseThrow(()-> new ObjectNotFoundException("User", bookingDto.userId()));
	
	//Total fare for this flight
	Integer totalAirFare=flight.getAirFare();
	
	//calculating disocunt to be given based on user category(i.e silver , gold, platinum)
	Integer userCategoryDiscount=0;
	
	   if(user.getCustomerCategory().equalsIgnoreCase("Gold"))
		   userCategoryDiscount=carrier.getGoldUserDiscount();
	   else if (user.getCustomerCategory().equalsIgnoreCase("Silver"))
		   userCategoryDiscount=carrier.getSilverUserDiscount();
	   else
		   userCategoryDiscount=carrier.getPlatinumUserDiscount();
	   
	   
	//Calculating discount to be given based on date
	   Integer dateDiscount=0;
	   Date bookingDate=flightSchedule.getDateOfTravel();
	   Date currentDate=new Date();
	   long diffInMillis = bookingDate.getTime() - currentDate.getTime();
	   long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);
	   
	   if(diffInDays==30)
		   dateDiscount=carrier.getDiscountPercentageThirtyDaysAdvanceBooking();
	   else if(diffInDays==60)
		   dateDiscount=carrier.getDiscountPercentageSixDaysAdvanceBooking();
	   else 
			   dateDiscount=carrier.getDiscountPercentageNinteyDaysAdvanceBooking();
	   
	   
	   
	   
	   //Calculating discount based on seat category
	   Integer seatCategoryDiscount;
	   
	   String type=bookingDto.seatCategory();
	   if(type.equalsIgnoreCase("Economy"))
		   seatCategoryDiscount=flightSchedule.getEconomyClassBookedDiscount();
	   else if(type.equalsIgnoreCase("Bussiness"))
		   seatCategoryDiscount= flightSchedule.getBusinessClassBookedDiscount();
	   else 
		   seatCategoryDiscount=flightSchedule.getExecutiveClassBookedDiscount();
	   
	   
	   
	   Integer amountOfDiscount= totalAirFare-userCategoryDiscount-seatCategoryDiscount;
	   
	   

	   
	   Double  dateDiscountedin=(amountOfDiscount*dateDiscount)/100.0;
	   return amountOfDiscount-dateDiscountedin;
		
	}


	public Double cancelBookingById(Integer bookingId) {
		
		System.out.println("Bokking id readed in cancel booking by id"+bookingId);
		
		Booking booked=this.bookingRepository.findById(bookingId).orElseThrow(() -> new ObjectNotFoundException("Booking", bookingId));
		
		
		FlightSchedule flightSchedule=this.flightSchduleRepository.findById(booked.getBookingId()).get();
		Flight flight=this.flightRepository.findById(flightSchedule.getFlightId()).get();
		Carrier carrier=this.carrierRepository.findById(flight.getCarrierId()).get();
		
		
		//Calculating refund
		//Calculating discount to be given based on date
		   Integer refundPercentage=0;
		   Date bookingDate=booked.getDateOfTravel();
		   Date currentDate=new Date();
		   long diffInMillis = bookingDate.getTime() - currentDate.getTime();
		   long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);
		   
		   if(diffInDays==2)
			   refundPercentage=carrier.getRefundPercentageForTicketCancellation2DaysBeforeTravelDate();
		   else if(diffInDays==10)
			   refundPercentage=carrier.getRefundPercentageForTicketCancellation10DaysBeforeTravelDate();
		   else 
			   refundPercentage=carrier.getRefundPercentageForTicketCancellation20DaysBeforeTravelDate();
		   
		   
		   booked.setBookingStatus("Cancelled");
		   
		   this.bookingRepository.save(booked);
		   
		   return (booked.getBookingAmount()*refundPercentage)/100.0;
		
	}


	public List<Booking> getAllBooking(Integer userId) {
		return this.bookingRepository.findByUserId(userId);
	}
	
	

}


