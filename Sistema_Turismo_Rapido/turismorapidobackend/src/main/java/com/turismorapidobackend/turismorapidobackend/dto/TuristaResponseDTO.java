package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Turista;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TuristaResponseDTO {
    
    Long id_turista;
    Long id_client;
    String something;

    public TuristaResponseDTO(Turista turista){
        this.id_client = turista.getClient().getId_client();
        this.id_turista = turista.getId();
        this.something = turista.getSomething();
    }
}
