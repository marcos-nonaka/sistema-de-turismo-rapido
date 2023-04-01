package com.turismorapidobackend.turismorapidobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CidadeRequestDTO {
    Long id_cidade;

    String name;

    Long cep;

    Double longitude;

    Double latitude;

    public CidadeRequestDTO() {
    }
}
