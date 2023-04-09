package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Roteiro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roteiro")
    Long idRoteiro;

    Double valor;

    String name;

    Integer numberOfDays;

    String description;

    @OneToOne(targetEntity = Cidade.class)
    @JoinColumn(name = "cidade_id")
    Cidade cidade;

    @ManyToMany(targetEntity = Hotel.class)
    @JoinTable(name = "roteiro_hotel",
        joinColumns = @JoinColumn(name = "roteiro_id"),
        inverseJoinColumns = @JoinColumn(name = "hotel_id"))
    List<Hotel> hoteis;

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

    @ManyToMany(
            targetEntity = Client.class,
            mappedBy = "roteiros")
    Set<Client> clients;

//     @ManyToMany(targetEntity = Client.class, fetch = FetchType.EAGER)
//     @JoinTable(name = "client_roteiro",
//             joinColumns = @JoinColumn(name = "client_id"),
//             inverseJoinColumns = @JoinColumn(name = "roteiro_id")
//     )
//     Set<Client> client;

}
