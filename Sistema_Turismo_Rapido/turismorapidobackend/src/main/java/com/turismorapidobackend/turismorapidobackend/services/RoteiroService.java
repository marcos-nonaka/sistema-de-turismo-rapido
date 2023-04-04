package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.RoteiroRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.RoteiroResponseDTO;
import com.turismorapidobackend.turismorapidobackend.model.*;
import com.turismorapidobackend.turismorapidobackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoteiroService {
    @Autowired
    RoteiroRepository roteiroRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    AlimentacaoRepository alimentacaoRepository;

    @Autowired
    AtracaoRepository atracaoRepository;

    @Autowired
    HotelRepository hotelRepository;

    public ResponseEntity<Object> save(RoteiroRequestDTO roteiroRequestDTO) {
        Roteiro roteiro = new Roteiro();

        Optional<Alimentacao> alimentacaoOptional = alimentacaoRepository.findById(roteiroRequestDTO.getId_alimentacao());
        Optional<Atracao> atracaoOptional = atracaoRepository.findById(roteiroRequestDTO.getId_atracao());
        Optional<Hotel> hotelOptional = hotelRepository.findById(roteiroRequestDTO.getId_hotel());
        Optional<Cidade> cidadeOptional = cidadeRepository.findById(roteiroRequestDTO.getId_cidade());
         /*if (alimentacaoOptional.isEmpty()) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alimentacao não encontrado");
         }*/

        roteiro.setValor(roteiroRequestDTO.getValor());

        List<Alimentacao> alimentacoes = new ArrayList<>();
        alimentacoes.add(alimentacaoOptional.get());
        roteiro.setAlimentacao(alimentacoes);

        List<Atracao> atracoes = new ArrayList<>();
        atracoes.add(atracaoOptional.get());
        roteiro.setAtracoes(atracoes);

        List<Hotel> hoteis = new ArrayList<>();
        hoteis.add(hotelOptional.get());
        roteiro.setHoteis(hoteis);

        roteiro.setCidade(cidadeOptional.get());

        roteiroRepository.save(roteiro);

        return ResponseEntity.status(HttpStatus.CREATED).body(new RoteiroResponseDTO(roteiro));
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Roteiro> roteiroOptional = roteiroRepository.findById(id);

        if(roteiroOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new RoteiroResponseDTO(roteiroOptional.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Roteiro não encontrado.");
        }
    }


    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                roteiroRepository.findAll().stream().map((roteiro)->new RoteiroResponseDTO(roteiro)).toList()
        );
    }
}
