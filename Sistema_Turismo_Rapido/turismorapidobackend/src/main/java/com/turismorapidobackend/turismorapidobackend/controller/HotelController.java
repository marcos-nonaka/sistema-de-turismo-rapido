package com.turismorapidobackend.turismorapidobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismorapidobackend.turismorapidobackend.dto.HotelRequestDTO;
import com.turismorapidobackend.turismorapidobackend.services.HotelService;


@RestController
@RequestMapping("/hoteis")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody HotelRequestDTO hotelRequestDTO){
        return hotelService.save(hotelRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(name = "id") Long id){
        return hotelService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return hotelService.findAll();
    }
}
