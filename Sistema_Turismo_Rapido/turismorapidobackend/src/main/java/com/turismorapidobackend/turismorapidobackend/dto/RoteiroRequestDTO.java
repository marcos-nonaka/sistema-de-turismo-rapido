package com.turismorapidobackend.turismorapidobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoteiroRequestDTO {
    Long id_cidade;
    Double valor;
    Long id_atracao;
    Long id_alimentacao;
    Long id_hotel;
    Long id_client;

    public RoteiroRequestDTO() {
    }
}
