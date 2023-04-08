package com.turismorapidobackend.turismorapidobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turismorapidobackend.turismorapidobackend.model.Hotel;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List <Hotel>  findByHotelNameContainingIgnoreCase(String hotelName);
    List <Hotel>  findByIdHotelAndHotelNameContainingIgnoreCase(Long id, String name);
}
