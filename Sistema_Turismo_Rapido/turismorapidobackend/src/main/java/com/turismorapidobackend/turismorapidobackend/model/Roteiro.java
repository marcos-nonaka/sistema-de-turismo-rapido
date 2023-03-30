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

    @OneToOne(targetEntity = Cidade.class)
    @JoinColumn(name = "cidade_id")
    Cidade cidade;

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

    @ManyToMany(targetEntity = Atracao.class)
    @JoinTable(name = "atracao_roteiro",
            joinColumns = @JoinColumn(name = "atracao_id"),
            inverseJoinColumns = @JoinColumn(name = "roteiro_id")
    )
    List<Atracao> atracoes;

    @ManyToMany(targetEntity = Client.class, fetch = FetchType.EAGER)
    @JoinTable(name = "client_roteiro",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "roteiro_id")
    )
    Set<Client> client;
    
}
