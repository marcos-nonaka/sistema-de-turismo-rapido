package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Alimentacao;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlimentacaoResponseDTO {
    Long id_alimentacao;
    Long id_cidade;
    String nameCidade;
    String local_name;
    String description;

    public AlimentacaoResponseDTO(Alimentacao alimentacao) {
        this.id_alimentacao = alimentacao.getId_alimentacao();
        this.id_cidade = alimentacao.getCidade().getId_cidade();
        this.nameCidade = alimentacao.getCidade().getName();
        this.local_name = alimentacao.getLocal_name();
        this.description = alimentacao.getDescription();
    }
}
