package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class Roteiro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_roteiro;
    
    // @ManyToOne(targetEntity = Turismologo.class)
    // @JoinColumn(name = "turismologo_id")
    // Turismologo turismologo;

    // @ManyToMany(targetEntity = Turista.class, mappedBy = "roteiros")
    // Set<Turista> turistas;

    @OneToOne(targetEntity = Cidade.class)
    @JoinColumn(name = "cidade_id")
    Cidade cidade;

    // TODO: Arrumar relação para ManyToOne e OneToMany
    @ManyToOne(targetEntity = Hotel.class)
    @JoinTable(name = "roteiro_hotel",
        joinColumns = @JoinColumn(name = "roteiro_id"),
        inverseJoinColumns = @JoinColumn(name = "hotel_id"))
    Set<Hotel> hoteis;

    @ManyToMany(targetEntity = Alimentacao.class)
    @JoinTable(name = "alimentacao_roteiro",
            joinColumns = @JoinColumn(name = "alimentacao_id"),
            inverseJoinColumns = @JoinColumn(name = "roteiro_id")
    )
    List<Alimentacao> alimentacao;

    //TODO: Aticionar Atrações semelhante à alimentação
    @ManyToMany(targetEntity = Atracao.class)
    @JoinTable(name = "atracao_roteiro",
            joinColumns = @JoinColumn(name = "atracao_id"),
            inverseJoinColumns = @JoinColumn(name = "roteiro_id")
    )
    List<Atracao> atracoes;
    
}
