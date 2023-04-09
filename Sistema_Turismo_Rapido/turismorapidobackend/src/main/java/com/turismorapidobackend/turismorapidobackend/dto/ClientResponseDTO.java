package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientResponseDTO {
    String name;
    Long id_client;
    // Long id_turista;
    // Long id_turismologo;
    String photo;
    

    public ClientResponseDTO(Client client){
        this.name = client.getName();
        this.id_client = client.getId_client();
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
