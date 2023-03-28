package com.turismorapidobackend.turismorapidobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtracaoRequestDTO {
    Long id_atracao;

    Long id_cidade;

    String name;

    Long tel_number;

    String endereco;

    String descricao;

    String tipo;

    Double longitude;

    Double latitude;

    public AtracaoRequestDTO() {
    }
}
