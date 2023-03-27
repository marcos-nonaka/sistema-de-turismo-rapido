package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.geom.Point2D;

@Data
@AllArgsConstructor
public class CidadeRequestDTO {
    Long id_cidade;

    String name;

    Long cep;

    Double longitude;

    Double latitude;

    public CidadeRequestDTO() {
    }
}
