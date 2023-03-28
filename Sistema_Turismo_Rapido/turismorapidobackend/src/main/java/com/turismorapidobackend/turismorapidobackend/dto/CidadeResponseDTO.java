package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Cidade;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CidadeResponseDTO {
    Long id_cidade;
    String name;
    List<Long> atracoes;
    List<Long> alimentacoes;
    List<Long> hotels;

    public CidadeResponseDTO() {
    }

    public CidadeResponseDTO(Cidade cidade) {
        this.id_cidade = cidade.getId_cidade();
        this.name = cidade.getName();
        this.atracoes = cidade.getAtracoes().stream().map(atracao -> atracao.getId_atracao()).toList();
        this.alimentacoes = cidade.getAlimentacoes().stream().map(alimentacao -> alimentacao.getId_alimentacao()).toList();
        this.hotels = cidade.getHotels().stream().map(hotel -> hotel.getId_hotel()).toList();
    }
}
