package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Alimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_alimentacao;
    
    String local_name;
    String description;
    String phone_number;
    String street_name;
    String street_district;
    int street_number;

    public Alimentacao(){
        
    }
}
