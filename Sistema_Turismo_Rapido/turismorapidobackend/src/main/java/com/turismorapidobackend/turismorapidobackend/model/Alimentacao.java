package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.*;
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

    @ManyToOne(targetEntity = Roteiro.class)
    @JoinColumn(name = "roteiro_id")
    Roteiro roteiro;

    public Alimentacao(){
        
    }
}
