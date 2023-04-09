package com.turismorapidobackend.turismorapidobackend.dto;
import java.time.LocalDate;
import java.util.List;

import com.turismorapidobackend.turismorapidobackend.enums.RoleName;
import com.turismorapidobackend.turismorapidobackend.model.Role;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientRequestDTO extends AbstractRequestDTO {
    
    @NotEmpty
    String name;
    String cpf;
    LocalDate data_nascimento;
    Long tel_number;
    String mail;
    String username;
    String password;
    String photo;

    RoleName rolename;

    List<Role> roles;

    public ClientRequestDTO(){

    }

//    public Client toClient(){
//        Client client = new Client();
//        BeanUtils.copyProperties(this, client, getNullPropertyNames(this));
//        // client.setRolename(rolename);
//        return client;
//    }

}
