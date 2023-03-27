package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Hotel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelResponseDTO {
    Long id_hotel;
    Long id_cidade;
    String hotel_name;
    String description_hotel;

    public HotelResponseDTO(Hotel hotel){
        this.id_hotel = hotel.getId_hotel();
        this.id_cidade = hotel.getCidade().getId_cidade();
        this.hotel_name = hotel.getHotel_name();
        this.description_hotel = hotel.getDescription_hotel();
    }
    
}
