package com.turismorapidobackend.turismorapidobackend.dto;

import java.util.List;

import com.turismorapidobackend.turismorapidobackend.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleRequestDTO {
    Long client_id;
    RoleName roleName;

    public RoleRequestDTO(){
        
    }
}
