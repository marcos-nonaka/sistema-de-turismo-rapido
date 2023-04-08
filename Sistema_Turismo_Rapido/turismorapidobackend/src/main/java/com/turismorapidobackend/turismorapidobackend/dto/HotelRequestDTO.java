package com.turismorapidobackend.turismorapidobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelRequestDTO extends AbstractRequestDTO {
    Long idCidade;

    String hotelName;

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
