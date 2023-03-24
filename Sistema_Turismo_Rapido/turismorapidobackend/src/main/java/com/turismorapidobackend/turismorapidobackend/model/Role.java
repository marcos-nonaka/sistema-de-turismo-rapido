package com.turismorapidobackend.turismorapidobackend.model;

import org.springframework.security.core.GrantedAuthority;

import com.turismorapidobackend.turismorapidobackend.enums.RoleName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    RoleName role;

    

    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return role.toString();
    }
    
}
