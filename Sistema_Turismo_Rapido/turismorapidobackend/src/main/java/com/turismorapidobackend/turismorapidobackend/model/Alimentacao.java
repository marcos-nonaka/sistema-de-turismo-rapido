package com.turismorapidobackend.turismorapidobackend.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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

    Integer street_number;

    Double longitude;

    Double latitude;

    @ManyToOne(targetEntity = Cidade.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cidade_id")
    Cidade cidade;

    @ManyToMany(targetEntity = Roteiro.class, mappedBy = "alimentacao")
    List<Roteiro> roteiros;

}
