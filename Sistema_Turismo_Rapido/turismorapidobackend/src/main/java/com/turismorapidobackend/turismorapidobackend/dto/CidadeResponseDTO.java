package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Cidade;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CidadeResponseDTO {
    Long idCidade;
    String name;
    List<IdNameDTO> atracoes;
    List<IdNameDTO> alimentacoes;
    List<IdNameDTO> hotels;

    public CidadeResponseDTO() {
    }

    public CidadeResponseDTO(Cidade cidade) {
        this.idCidade = cidade.getIdCidade();
        this.name = cidade.getName();
        this.atracoes = cidade.getAtracoes().stream().map(atracao -> new IdNameDTO(atracao.getId_atracao(), atracao.getName())).toList();
        this.alimentacoes = cidade.getAlimentacoes().stream().map(alimentacao -> new IdNameDTO(alimentacao.getId_alimentacao(), alimentacao.getLocal_name())).toList();
        this.hotels = cidade.getHotels().stream().map(hotel -> new IdNameDTO(hotel.getIdHotel(), hotel.getHotelName()) ).toList();
    }
}
