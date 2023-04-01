package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Roteiro;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RoteiroResponseDTO {
    Long id_roteiro;
    Long id_cidade;
    List<Long> atracoes;
    List<Long> alimentacoes;
    List<Long> hotels;
    Double valor;

    public RoteiroResponseDTO(Roteiro roteiro){
        this.hotels = roteiro.getHoteis().stream().map(hotel -> hotel.getId_hotel()).toList();
        this.atracoes = roteiro.getAtracoes().stream().map(atracao -> atracao.getId_atracao()).toList();
        this.alimentacoes = roteiro.getAlimentacao().stream().map(alimentacao -> alimentacao.getId_alimentacao()).toList();
        this.id_cidade = roteiro.getCidade().getId_cidade();
        this.valor = roteiro.getValor();
    }
}
