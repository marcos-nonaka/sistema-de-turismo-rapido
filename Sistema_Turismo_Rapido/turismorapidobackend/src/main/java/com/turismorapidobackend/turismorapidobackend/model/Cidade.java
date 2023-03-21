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
    //Point2D.Double coordenada;

    @OneToOne(targetEntity = Atracao.class, cascade = CascadeType.ALL, mappedBy = "cidade")
    Atracao atracao;

    @OneToMany(targetEntity = Hotel.class, cascade = CascadeType.ALL, mappedBy = "cidade")
    Set<Hotel> hotels;
    public Cidade() {
    }
}
