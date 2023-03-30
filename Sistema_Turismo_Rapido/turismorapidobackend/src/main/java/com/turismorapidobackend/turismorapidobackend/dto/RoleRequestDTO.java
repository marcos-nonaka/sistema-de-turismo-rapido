package com.turismorapidobackend.turismorapidobackend.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleRequestDTO {
    Long id_client;
    List<Long> id_roles;

    public RoleRequestDTO(){
        
    }
}
