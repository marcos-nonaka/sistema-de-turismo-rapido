package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_hotel;
    
    String hotel_name;

    Long phone_number;

    String street_name;

    int street_number;

    String street_district;

    String description_hotel;

    Double longitude;

    Double latitude;

    @ManyToOne(targetEntity = Cidade.class)
    @JoinColumn(name = "cidade_id")
    Cidade cidade;

    @OneToMany(targetEntity = Roteiro.class, mappedBy = "hoteis")
    Set<Roteiro> roteiros;


    /*public void setDescricao(String description_hotel2) {
    }*/

}
