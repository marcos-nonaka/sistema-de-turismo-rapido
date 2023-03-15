package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientRequestDTO {
    
    String name;

    public ClientRequestDTO(){

    }

    public Client toClient(){

        Client client = new Client();

        client.setName(name);
        
        return client;

    }
}
