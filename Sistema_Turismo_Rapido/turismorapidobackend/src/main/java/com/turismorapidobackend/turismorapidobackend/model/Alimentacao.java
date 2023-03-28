package com.turismorapidobackend.turismorapidobackend.model;

import java.util.List;

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

    Double longitude;

    Double latitude;

    @ManyToOne(targetEntity = Cidade.class)
    @JoinColumn(name = "cidade_id")
    Cidade cidade;

    @ManyToMany(targetEntity = Roteiro.class, mappedBy = "alimentacao")
    List<Roteiro> roteiros;

    public Alimentacao(){
        
    }
}
