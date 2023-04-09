package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientResponseDTO {
    String name;
    Long idClient;
    String photo;
    // Long id_turista;
    // Long id_turismologo;

    public ClientResponseDTO(Client client){
        this.name = client.getName();
        this.idClient = client.getIdClient();
        this.photo = client.getPhoto();
        //usuario e senha
        //nome
        //email
        //token

        
        // if(client.getTurista() != null) {
        //     this.id_turista = client.getTurista().getId();
        // } else {
        //     this.id_turismologo = client.getTurismologo().getId();
        // }
    }
}
