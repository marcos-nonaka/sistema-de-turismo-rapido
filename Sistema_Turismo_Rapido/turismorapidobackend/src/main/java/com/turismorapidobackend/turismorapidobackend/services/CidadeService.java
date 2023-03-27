package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.CidadeRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.CidadeResponseDTO;
import com.turismorapidobackend.turismorapidobackend.model.Atracao;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import com.turismorapidobackend.turismorapidobackend.repository.CidadeRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    CidadeRepository cidadeRepository;

    @Transactional
    public ResponseEntity<Object> save(CidadeRequestDTO cidadeRequestDTO) {
        Cidade cidade = new Cidade();

        cidade.setName(cidadeRequestDTO.getName());
        cidade.setCep(cidadeRequestDTO.getCep());
        cidade.setAtracoes(cidade.getAtracoes());
        cidade.setAlimentacoes(cidade.getAlimentacoes());
        cidade.setHotels(cidade.getHotels());
        cidade.setLongitude(cidadeRequestDTO.getLongitude());
        cidade.setLatitude(cidadeRequestDTO.getLatitude());

        cidadeRepository.save(cidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeRepository.save(cidade));
    }

    // vamos ter que alterar para buscar pelo nome e pelo cep
    public ResponseEntity<Object> findById(Long id) {
        Optional<Cidade> cidadeOptional = cidadeRepository.findById(id);

        if(cidadeOptional.isPresent()){
            return ResponseEntity.ok().body(new CidadeResponseDTO(cidadeOptional.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cidade não encontrada");
        }
    }
}
