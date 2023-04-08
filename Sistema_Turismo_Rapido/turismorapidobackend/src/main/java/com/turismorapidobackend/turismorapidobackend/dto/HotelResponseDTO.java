package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Hotel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelResponseDTO {
    Long idHotel;
    Long idCidade;
    String hotelName;
    String description_hotel;

    public HotelResponseDTO(Hotel hotel){
        this.idHotel = hotel.getIdHotel();
        this.idCidade = hotel.getCidade().getIdCidade();
        this.hotelName = hotel.getHotelName();
        this.description_hotel = hotel.getDescription_hotel();
    }
    
}
