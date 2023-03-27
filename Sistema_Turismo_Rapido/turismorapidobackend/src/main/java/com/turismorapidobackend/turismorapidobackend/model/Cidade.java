package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.geom.Point2D;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_cidade;

    String name;

    Long cep;

    Double longitude;

    Double latitude;

    @OneToMany(targetEntity = Atracao.class, cascade = CascadeType.ALL, mappedBy = "cidade")
    Set<Atracao> atracoes;

    @OneToMany(targetEntity = Atracao.class, cascade = CascadeType.ALL, mappedBy = "cidade")
    Set<Alimentacao> alimentacoes;

    @OneToMany(targetEntity = Hotel.class, cascade = CascadeType.ALL, mappedBy = "cidade")
    Set<Hotel> hotels;
    public Cidade() {
    }
}
