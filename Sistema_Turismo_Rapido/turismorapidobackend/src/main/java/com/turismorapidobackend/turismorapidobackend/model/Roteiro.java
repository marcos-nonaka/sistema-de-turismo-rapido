package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class Roteiro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_roteiro;
    
    @ManyToOne(targetEntity = Turismologo.class)
    @JoinColumn(name = "turismologo_id")
    Turismologo turismologo;

    @ManyToMany(targetEntity = Turista.class)
    @JoinTable(name = "roteiro_turista",
            joinColumns = @JoinColumn(name = "roteiro_id"),
            inverseJoinColumns = @JoinColumn(name = "turista_id"))
    Set<Turista> turistas;

    @OneToOne(targetEntity = Cidade.class)
    @JoinColumn(name = "cidade_id")
    Cidade cidade;

    @ManyToMany(targetEntity = Hotel.class)
    @JoinTable(name = "roteiro_hotel",
        joinColumns = @JoinColumn(name = "roteiro_id"),
        inverseJoinColumns = @JoinColumn(name = "hotel_id"))
    Set<Hotel> hoteis;

    @OneToMany(targetEntity = Alimentacao.class, mappedBy = "roteiro")
    Set<Alimentacao> alimentacao;
}
