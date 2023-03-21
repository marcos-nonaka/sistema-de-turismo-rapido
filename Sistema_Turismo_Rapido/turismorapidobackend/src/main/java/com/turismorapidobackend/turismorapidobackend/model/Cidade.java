package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.geom.Point2D;

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
    public Cidade() {
    }
}
