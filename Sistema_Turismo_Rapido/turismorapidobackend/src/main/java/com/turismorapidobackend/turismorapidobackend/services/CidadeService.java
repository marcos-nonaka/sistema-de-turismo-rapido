package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.CidadeRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.CidadeResponseDTO;
import com.turismorapidobackend.turismorapidobackend.dto.ClientRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.ClientResponseDTO;
import com.turismorapidobackend.turismorapidobackend.exceptionhandler.ObjectNotFoundException;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import com.turismorapidobackend.turismorapidobackend.model.Client;
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

        cidadeRepository.save(cidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeRepository.save(cidade));
    }

    @Transactional
    public ResponseEntity<Object> find(Optional<Long> id) {
        List<Cidade> list = new ArrayList<>();
        if (id.isPresent()) {
            list.add(this.findById(id));
        } else {
            list = cidadeRepository.findAll();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list.stream().map(CidadeResponseDTO:: new).toList());
    }

    public List<Cidade> findAll(String name) {
        if (name.equals("")){
            return cidadeRepository.findAll();
        }
        else{
            return cidadeRepository.findAllByNameIgnoreCase(name);
        }
    }

    @Transactional
    public Cidade findById(Optional<Long> id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id.get());
        if (id.isPresent()) {
            return cidade.orElseThrow(() -> new ObjectNotFoundException(id.get()));
        } else {
            return null;
        }
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
