package com.turismorapidobackend.turismorapidobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtracaoRequestDTO {
    Long id_atracao;
    Long id_cidade;
    String name;
    String nameCidade;
    Long tel_number;
    String endereco;
    String descricao;
    String tipo;

    public AtracaoRequestDTO() {
    }
}
