package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    Long idHotel;

    @Column(name = "hotel_name")
    String hotelName;


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

    @ManyToMany(targetEntity = Roteiro.class, mappedBy = "hoteis")
    List<Roteiro> roteiros;

}
