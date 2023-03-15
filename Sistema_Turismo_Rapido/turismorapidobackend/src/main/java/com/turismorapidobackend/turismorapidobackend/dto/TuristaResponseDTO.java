package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Turista;

public class TuristaResponseDTO {
    
    Long id_turista;
    Long id_client;

    public TuristaResponseDTO(Turista turista){
        this.id_client = turista.getClient().getId_client();
        this.id_turista = turista.getId_turista();
    }
}
