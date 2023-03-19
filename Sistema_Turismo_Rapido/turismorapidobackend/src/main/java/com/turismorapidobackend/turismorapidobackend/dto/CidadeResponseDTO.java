package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Cidade;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CidadeResponseDTO {
    Long id_cidade;
    String name;

    public CidadeResponseDTO() {
    }

    public CidadeResponseDTO(Cidade cidade) {
        this.id_cidade = cidade.getId_cidade();
        this.name = cidade.getName();
    }
}
