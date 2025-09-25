package com.airline.Airline.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.Airline.entities.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmailId(String emailID);

}