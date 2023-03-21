package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Atracao;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtracaoResponseDTO {
    Long id_atracao;
    Long id_cidade;
    String name;
    String nameCidade;
    String descricao;

    public AtracaoResponseDTO() {
    }

    public AtracaoResponseDTO(Atracao atracao) {
        this.id_atracao = atracao.getId_atracao();
        this.id_cidade = atracao.getCidade().getId_cidade();
        this.name = atracao.getName();
        this.nameCidade = atracao.getCidade().getName();
        this.descricao = atracao.getDescricao();
    }
}
