package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.CidadeRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.CidadeResponseDTO;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import com.turismorapidobackend.turismorapidobackend.repository.CidadeRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

    public ResponseEntity<Object> findById(Long id) {
        Optional<Cidade> cidadeOptional = cidadeRepository.findById(id);

        if(cidadeOptional.isPresent()){
            return ResponseEntity.ok().body(new CidadeResponseDTO(cidadeOptional.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cidade não encontrada");
        }
    }

    public List<Cidade> findAll(String name) {
        if (name.equals("")){
            return cidadeRepository.findAll();
        }
        else{
            return cidadeRepository.findAllByNameIgnoreCase(name);
        }
    }
}
