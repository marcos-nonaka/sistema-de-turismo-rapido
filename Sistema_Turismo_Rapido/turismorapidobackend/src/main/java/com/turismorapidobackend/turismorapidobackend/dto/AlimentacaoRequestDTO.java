package com.turismorapidobackend.turismorapidobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlimentacaoRequestDTO {
    Long id_alimentacao;

    Long id_cidade;

    String local_name;

    String description;

    String phone_number;

    String street_name;

    String street_district;

    int street_number;

    Double longitude;

    Double latitude;

    public AlimentacaoRequestDTO() {
    }
}
