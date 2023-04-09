package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Atracao;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtracaoResponseDTO {
    Long idAtracao;
    Long id_cidade;
    String name;
    String nameCidade;
    String descricao;

    public AtracaoResponseDTO() {
    }

    public AtracaoResponseDTO(Atracao atracao) {
        this.idAtracao = atracao.getIdAtracao();
        this.id_cidade = atracao.getCidade().getIdCidade();
        this.name = atracao.getName();
        this.nameCidade = atracao.getCidade().getName();
        this.descricao = atracao.getDescricao();
    }
}
