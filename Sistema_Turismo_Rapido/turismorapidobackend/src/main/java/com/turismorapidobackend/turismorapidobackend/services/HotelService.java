package com.turismorapidobackend.turismorapidobackend.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turismorapidobackend.turismorapidobackend.dto.CidadeRequestDTO;
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

        //cidadeRepository.save(cidade);

        hotel.setCidade(cidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(hotelRepository.save(hotel));
    }

    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                hotelRepository.findAll().stream().map((hotel)->new HotelResponseDTO(hotel)).toList()
        );
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);

        if(hotelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new HotelResponseDTO(hotelOptional.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atração não encontrada.");
        }
    }
    
}
