package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientResponseDTO {
    String name;
    Long id_turista;
    Long id_turismologo;

    public ClientResponseDTO(Client client){
        this.name = client.getName();
        this.id_turista = client.getId_client();
        this.id_turismologo = client.getId_client();
    }
}
