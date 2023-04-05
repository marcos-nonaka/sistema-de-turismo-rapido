package com.turismorapidobackend.turismorapidobackend.dto;
import java.time.LocalDate;
import java.util.List;

import com.turismorapidobackend.turismorapidobackend.enums.RoleName;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import static com.turismorapidobackend.turismorapidobackend.utils.Utils.getNullPropertyNames;

@Data
@AllArgsConstructor
public class ClientRequestDTO extends AbstractRequestDTO {
    
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

//    public Client toClient(){
//        Client client = new Client();
//        BeanUtils.copyProperties(this, client, getNullPropertyNames(this));
//        // client.setRolename(rolename);
//        return client;
//    }

}
