package com.turismorapidobackend.turismorapidobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelRequestDTO {
    Long id_cidade;

    String hotel_name;

    Long phone_number;

    String street_name;

    int street_number;

    String street_district;

    String description_hotel;

    Double longitude;

    Double latitude;

    public HotelRequestDTO(){

    }

}
