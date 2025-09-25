package com.airline.Airline.entities;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Flight {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	     Integer flightId;
	    
	    
	    Integer carrierId; // FK (link to Carrier later if needed)

	    
	    String origin;

	
	    String destination;

	 
	    Integer airFare;

	
	    Integer seatCapacityEconomyClass;

	    Integer seatCapacityBusinessClass;

	    Integer seatCapacityExecutiveClass;
	    
	    

		public Flight() {
			super();
		}



		public Flight(Integer flightId, Integer carrierId, String origin, String destination, Integer airFare,
				Integer seatCapacityEconomyClass, Integer seatCapacityBusinessClass,
				Integer seatCapacityExecutiveClass) {
			super();
			this.flightId = flightId;
			this.carrierId = carrierId;
			this.origin = origin;
			this.destination = destination;
			this.airFare = airFare;
			this.seatCapacityEconomyClass = seatCapacityEconomyClass;
			this.seatCapacityBusinessClass = seatCapacityBusinessClass;
			this.seatCapacityExecutiveClass = seatCapacityExecutiveClass;
		}



		public Integer getFlightId() {
			return flightId;
		}



		public void setFlightId(Integer flightId) {
			this.flightId = flightId;
		}



		public Integer getCarrierId() {
			return carrierId;
		}



		public void setCarrierId(Integer carrierId) {
			this.carrierId = carrierId;
		}



		public String getOrigin() {
			return origin;
		}



		public void setOrigin(String origin) {
			this.origin = origin;
		}



		public String getDestination() {
			return destination;
		}



		public void setDestination(String destination) {
			this.destination = destination;
		}



		public Integer getAirFare() {
			return airFare;
		}



		public void setAirFare(Integer airFare) {
			this.airFare = airFare;
		}



		public Integer getSeatCapacityEconomyClass() {
			return seatCapacityEconomyClass;
		}



		public void setSeatCapacityEconomyClass(Integer seatCapacityEconomyClass) {
			this.seatCapacityEconomyClass = seatCapacityEconomyClass;
		}



		public Integer getSeatCapacityBusinessClass() {
			return seatCapacityBusinessClass;
		}



		public void setSeatCapacityBusinessClass(Integer seatCapacityBusinessClass) {
			this.seatCapacityBusinessClass = seatCapacityBusinessClass;
		}



		public Integer getSeatCapacityExecutiveClass() {
			return seatCapacityExecutiveClass;
		}



		public void setSeatCapacityExecutiveClass(Integer seatCapacityExecutiveClass) {
			this.seatCapacityExecutiveClass = seatCapacityExecutiveClass;
		}
	    
	    
	    
	    
	    
	
}
