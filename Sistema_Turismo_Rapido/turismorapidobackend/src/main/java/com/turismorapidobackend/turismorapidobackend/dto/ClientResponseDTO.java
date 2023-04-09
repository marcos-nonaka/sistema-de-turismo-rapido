package com.turismorapidobackend.turismorapidobackend.dto;

import java.time.LocalDate;

import com.turismorapidobackend.turismorapidobackend.model.Client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientResponseDTO {
    String name;
    Long idClient;
    String photo;
    String cpf;
    LocalDate data_nascimento;
    Long tel_number;
    String mail;
    String username;
    // Long id_turista;
    // Long id_turismologo;

    public ClientResponseDTO(Client client){
        this.name = client.getName();
        this.idClient = client.getIdClient();
        this.photo = client.getPhoto();
        this.cpf = client.getCpf();
        this.data_nascimento = client.getData_nascimento();
        this.tel_number = client.getTel_number();
        this.mail = client.getMail();
        this.username = client.getUsername();
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
