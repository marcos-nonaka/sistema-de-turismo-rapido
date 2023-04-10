package com.turismorapidobackend.turismorapidobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import com.turismorapidobackend.turismorapidobackend.dto.HotelRequestDTO;
import com.turismorapidobackend.turismorapidobackend.services.HotelService;

import jakarta.validation.Valid;

import java.util.Optional;


@RestController
@RequestMapping("/hoteis")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody @Valid HotelRequestDTO hotelRequestDTO){
        return hotelService.save(hotelRequestDTO);
    }

    @GetMapping(value= {"", "/", "/{id}"})
    public ResponseEntity<Object> find(
            @PathVariable(name = "id") Optional<Long> id,
            @RequestParam(value="name", required=false) Optional<String> name) {
        return hotelService.find(id, name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@NonNull @PathVariable(name = "id") Optional<Long> id){
        return hotelService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@NonNull @PathVariable(name = "id") Optional<Long> id, @RequestBody HotelRequestDTO hotelRequestDTO) {
        return hotelService.update(id, hotelRequestDTO);
    }
}
