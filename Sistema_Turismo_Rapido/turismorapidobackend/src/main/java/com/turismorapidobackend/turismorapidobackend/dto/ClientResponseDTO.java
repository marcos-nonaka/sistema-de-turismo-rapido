package com.turismorapidobackend.turismorapidobackend.dto;

import java.time.LocalDate;
import java.util.List;

import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientResponseDTO {
    String name;
    Long idClient;
    String photo;
    LocalDate data_nascimento;
    Long tel_number;
    String mail;
    String username;
    Long cpf;
    List<Role> roles;

    public ClientResponseDTO(Client client){
        this.name = client.getName();
        this.idClient = client.getIdClient();
        this.photo = client.getPhoto();
        this.data_nascimento = client.getData_nascimento();
        this.tel_number = client.getTel_number();
        this.mail = client.getMail();
        this.username = client.getUsername();
        this.roles = client.getRoles();
        this.cpf = client.getCpf();
    }
}
