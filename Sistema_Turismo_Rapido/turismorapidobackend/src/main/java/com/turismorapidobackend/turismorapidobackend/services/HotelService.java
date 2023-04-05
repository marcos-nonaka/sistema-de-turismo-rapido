package com.turismorapidobackend.turismorapidobackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.turismorapidobackend.turismorapidobackend.dto.CidadeRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.CidadeResponseDTO;
import com.turismorapidobackend.turismorapidobackend.exceptionhandler.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turismorapidobackend.turismorapidobackend.dto.HotelRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.HotelResponseDTO;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import com.turismorapidobackend.turismorapidobackend.model.Hotel;
import com.turismorapidobackend.turismorapidobackend.repository.CidadeRepository;
import com.turismorapidobackend.turismorapidobackend.repository.HotelRepository;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelService hotelService;

    @Autowired
    CidadeRepository cidadeRepository;
    @Transactional
    public ResponseEntity<Object> save(HotelRequestDTO hotelRequestDTO) {
        /*CidadeRequestDTO cidadeRequestDTO = new CidadeRequestDTO();
        BeanUtils.copyProperties(hotelRequestDTO, cidadeRequestDTO);
        Cidade cidade = cidadeRequestDTO.toCidade();*/
        Cidade cidade = cidadeRepository.findById(hotelRequestDTO.getId_cidade()).get();

        Hotel hotel = new Hotel();

        hotel.setHotel_name(hotelRequestDTO.getHotel_name());
        hotel.setDescription_hotel(hotelRequestDTO.getDescription_hotel());
        hotel.setStreet_district(hotelRequestDTO.getStreet_district());
        hotel.setStreet_name(hotelRequestDTO.getStreet_name());
        hotel.setPhone_number(hotelRequestDTO.getPhone_number());
        hotel.setStreet_number(hotelRequestDTO.getStreet_number());
        hotel.setLongitude(hotelRequestDTO.getLongitude());
        hotel.setLatitude(hotelRequestDTO.getLatitude());

        hotel.setCidade(cidade);
        hotel = hotelRepository.save(hotel);


        cidade.getHotels().add(hotel);
        cidadeRepository.save(cidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(new HotelResponseDTO(hotel));
    }

//    public ResponseEntity<Object> findAll() {
//        return ResponseEntity.status(HttpStatus.OK).body(
//                hotelRepository.findAll().stream().map((hotel)->new HotelResponseDTO(hotel)).toList()
//        );
//    }
    @Transactional
    public ResponseEntity<Object> find(Optional<Long> id) {
        List<Hotel> list = new ArrayList<>();
        if (id.isPresent()) {
            list.add(this.findById(id));
        } else {
            list = hotelRepository.findAll();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list.stream().map(HotelResponseDTO:: new).toList());
    }

    @Transactional
    public Hotel findById(Optional<Long> id) {
        Optional<Hotel> hotel = hotelRepository.findById(id.get());
        if (id.isPresent()) {
            return hotel.orElseThrow(() -> new ObjectNotFoundException(id.get()));
        } else {
            return null;
        }
    }

    @Transactional
    public ResponseEntity<Object> delete(Optional<Long> id) {
        hotelRepository.delete(this.findById(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    public ResponseEntity<Object> update(Optional<Long> id, HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = this.findById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new HotelResponseDTO(hotelRepository.save((Hotel) hotelRequestDTO.toObject(hotel))));
    }
}