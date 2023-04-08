package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.*;

import lombok.*;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cidade")
    Long idCidade;

    String name;

    Long cep;

    Double longitude;

    Double latitude;

    String description;

    @OneToMany(targetEntity = Roteiro.class, cascade = CascadeType.ALL, mappedBy = "cidade")
    Set<Roteiro> roteiros;

    @OneToMany(targetEntity = Atracao.class, cascade = CascadeType.ALL, mappedBy = "cidade")
    Set<Atracao> atracoes;

    @OneToMany(targetEntity = Alimentacao.class, cascade = CascadeType.ALL, mappedBy = "cidade")
    Set<Alimentacao> alimentacoes;

    @OneToMany(targetEntity = Hotel.class, cascade = CascadeType.ALL, mappedBy = "cidade")
    Set<Hotel> hotels;
}
