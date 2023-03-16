package com.turismorapidobackend.turismorapidobackend.dto;
import java.time.LocalDate;

import com.turismorapidobackend.turismorapidobackend.model.Client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientRequestDTO {
    
    String name;
    String cpf;
    LocalDate data_nascimento;
    Long tel_number;
    String mail;
    String username;
    String password;

    public ClientRequestDTO(){

    }

    public Client toClient(){

        Client client = new Client();

        client.setName(name);
        client.setCpf(cpf);
        client.setData_nascimento(data_nascimento);
        client.setTel_number(tel_number);
        client.setMail(mail);
        client.setUsername(username);
        client.setPassword(password);

        return client;

    }
}
