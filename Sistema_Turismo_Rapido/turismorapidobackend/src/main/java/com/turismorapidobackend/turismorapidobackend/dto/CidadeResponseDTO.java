package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Cidade;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


@Data
@AllArgsConstructor
public class CidadeResponseDTO {
    Long id_cidade;
    String name;
    List<Long> atracoes;
    List<Long> alimentacoes;
    List<IdNameDTO> hotels;

    public CidadeResponseDTO() {
    }

    public CidadeResponseDTO(Cidade cidade) {
        this.id_cidade = cidade.getId_cidade();
        this.name = cidade.getName();
        this.atracoes = cidade.getAtracoes().stream().map(atracao -> atracao.getId_atracao()).toList();
        this.alimentacoes = cidade.getAlimentacoes().stream().map(alimentacao -> alimentacao.getId_alimentacao()).toList();
        this.hotels = cidade.getHotels().stream().map(hotel -> new IdNameDTO(hotel.getId_hotel(), hotel.getHotel_name()) ).toList();
    }
}
