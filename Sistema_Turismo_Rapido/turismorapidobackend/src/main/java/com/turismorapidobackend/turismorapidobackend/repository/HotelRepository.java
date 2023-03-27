package com.turismorapidobackend.turismorapidobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turismorapidobackend.turismorapidobackend.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    
}
