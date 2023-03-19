package com.turismorapidobackend.turismorapidobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.geom.Point2D;

@Data
@AllArgsConstructor
public class CidadeRequestDTO {
    Long id_cidade;

    String name;
    //Point2D.Double coordenada;

    public CidadeRequestDTO() {
    }
}
