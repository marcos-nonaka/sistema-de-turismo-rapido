package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.*;
import com.turismorapidobackend.turismorapidobackend.exceptionhandler.ObjectNotFoundException;
import com.turismorapidobackend.turismorapidobackend.model.*;
import com.turismorapidobackend.turismorapidobackend.repository.*;
import jakarta.transaction.Transactional;
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

    @Transactional
    public ResponseEntity<Object> find(Optional<Long> id, Optional<String> name) {
        List<Roteiro> list = new ArrayList<>();
        if (id.isPresent() && name.isPresent()) {
            list = roteiroRepository.findByIdRoteiroAndNameContainingIgnoreCase(id.get(), name.get());
        } else if (id.isPresent()) {
            list.add(this.findById(id));
        } else if (name.isPresent()) {
            list = roteiroRepository.findByNameContainingIgnoreCase(name.get());
        } else {
            list = roteiroRepository.findAll();
        }
        if (list.isEmpty()) {
            throw new ObjectNotFoundException();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(list.stream().map(RoteiroResponseDTO:: new).toList());
    }

    @Transactional
    public Roteiro findById(Optional<Long> id) {
        Optional<Roteiro> roteiro = roteiroRepository.findById(id.get());
        if (id.isPresent()) {
            return roteiro.orElseThrow(() -> new ObjectNotFoundException(id.get()));
        }

        return null;
    }

    @Transactional
    public ResponseEntity<Object> delete(Optional<Long> id) {
        roteiroRepository.delete(this.findById(id));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    public ResponseEntity<Object> update(Optional<Long> id, RoteiroRequestDTO roteiroRequestDTO) {
        Roteiro roteiro = this.findById(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(new RoteiroResponseDTO(roteiroRepository.save((Roteiro) roteiroRequestDTO.toObject(roteiro))));
    }
}
