package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.*;
import com.turismorapidobackend.turismorapidobackend.exceptionhandler.ObjectNotFoundException;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.model.Hotel;
import com.turismorapidobackend.turismorapidobackend.repository.CidadeRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeService {
    @Autowired
    CidadeRepository cidadeRepository;

    @Transactional
    public ResponseEntity<Object> save(CidadeRequestDTO cidadeRequestDTO) {
        Cidade cidade = new Cidade();

        cidade.setName(cidadeRequestDTO.getName());
        cidade.setCep(cidadeRequestDTO.getCep());
        cidade.setAtracoes(new HashSet<>());
        cidade.setAlimentacoes(new HashSet<>());
        cidade.setHotels(new HashSet<>());
        cidade.setLongitude(cidadeRequestDTO.getLongitude());
        cidade.setLatitude(cidadeRequestDTO.getLatitude());
        cidade.setPhoto(cidadeRequestDTO.getPhoto());

        cidadeRepository.save(cidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeRepository.save(cidade));
    }

    @Transactional
    public ResponseEntity<Object> find(Optional<Long> id, Optional<String> name) {
        List<Cidade> list = new ArrayList<>();
        if (id.isPresent() && name.isPresent()) {
            list = cidadeRepository.findByIdCidadeAndNameContainingIgnoreCase(id.get(), name.get());
        } else if (id.isPresent()) {
            list.add(this.findById(id));
        } else if (name.isPresent()) {
            list = cidadeRepository.findByNameContainingIgnoreCase(name.get());
        } else {
            list = cidadeRepository.findAll();
        }
        if (list.isEmpty()) {
            throw new ObjectNotFoundException();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list.stream().map(CidadeResponseDTO:: new).toList());
    }


    @Transactional
    public Cidade findById(Optional<Long> id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id.get());
        if (id.isPresent()) {
            return cidade.orElseThrow(() -> new ObjectNotFoundException(id.get()));
        }
        return null;
    }

    @Transactional
    public ResponseEntity<Object> delete(Optional<Long> id) {
        cidadeRepository.delete(this.findById(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    public ResponseEntity<Object> update(Optional<Long> id, CidadeRequestDTO cidadeRequestDTO) {
        Cidade cidade = this.findById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CidadeResponseDTO(cidadeRepository.save((Cidade) cidadeRequestDTO.toObject(cidade))));
    }
}
