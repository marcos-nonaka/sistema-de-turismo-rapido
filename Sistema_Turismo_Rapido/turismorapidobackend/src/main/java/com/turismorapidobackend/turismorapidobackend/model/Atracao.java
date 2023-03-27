package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Atracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id_atracao;

    String name;

    Long tel_number;

    String endereco;

    String descricao;

    String tipo;

    Double longitude;

    Double latitude;

    @ManyToOne(targetEntity = Cidade.class)
    @JoinColumn(name = "cidade_id")
    Cidade cidade;

    @ManyToMany(targetEntity = Roteiro.class, mappedBy = "atracoes")
    List<Roteiro> roteiros;
    public Atracao() {
    }
}
