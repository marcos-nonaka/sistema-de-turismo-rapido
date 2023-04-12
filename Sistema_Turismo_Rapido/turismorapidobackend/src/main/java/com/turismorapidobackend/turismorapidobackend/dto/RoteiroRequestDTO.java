package com.turismorapidobackend.turismorapidobackend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoteiroRequestDTO extends AbstractRequestDTO {
    Long id_cidade;

    @NotNull(message="Insira uma média de preço para o roteiro")
    Double valor;
    
    Long id_atracao;
    Long id_alimentacao;
    Long id_hotel;
    Long id_client;
    Integer numberOfDays;

    public RoteiroRequestDTO() {
    }
}
