package com.senpiper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senpiper.model.Center;

@Repository
public interface ICenterRepo extends JpaRepository<Center, Long> {
	Center findByContactEmail(String contactEmail); 
}
