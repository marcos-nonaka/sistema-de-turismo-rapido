package com.turismorapidobackend.turismorapidobackend.dto;
import java.time.LocalDate;
import java.util.List;

import com.turismorapidobackend.turismorapidobackend.enums.RoleName;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.model.Role;

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

    RoleName rolename;

    List<Role> roles;

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
        client.setRoles(roles);
        // client.setRolename(rolename);

        return client;

    }
}
