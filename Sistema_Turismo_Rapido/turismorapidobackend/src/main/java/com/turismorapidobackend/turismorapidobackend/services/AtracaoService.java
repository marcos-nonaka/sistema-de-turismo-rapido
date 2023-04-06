package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.AtracaoRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.AtracaoResponseDTO;
import com.turismorapidobackend.turismorapidobackend.dto.CidadeRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.CidadeResponseDTO;
import com.turismorapidobackend.turismorapidobackend.exceptionhandler.ObjectNotFoundException;
import com.turismorapidobackend.turismorapidobackend.model.Atracao;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import com.turismorapidobackend.turismorapidobackend.repository.AtracaoRepository;
import com.turismorapidobackend.turismorapidobackend.repository.CidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AtracaoService {
    @Autowired
    AtracaoRepository atracaoRepository;

    @Autowired
    AtracaoService atracaoService;

    @Autowired
    CidadeRepository cidadeRepository;
    @Transactional
    public ResponseEntity<Object> save(AtracaoRequestDTO atracaoRequestDTO) {
        Cidade cidade = cidadeRepository.findById(atracaoRequestDTO.getId_cidade()).get();

        Atracao atracao = new Atracao();

        atracao.setName(atracaoRequestDTO.getName());
        atracao.setDescricao(atracaoRequestDTO.getDescricao());
        atracao.setTipo(atracaoRequestDTO.getTipo());
        atracao.setEndereco(atracaoRequestDTO.getEndereco());
        atracao.setTel_number(atracaoRequestDTO.getTel_number());
        atracao.setLongitude(atracaoRequestDTO.getLongitude());
        atracao.setLatitude(atracaoRequestDTO.getLatitude());

        atracao.setCidade(cidade);
        atracao = atracaoRepository.save(atracao);

        cidade.getAtracoes().add(atracao);
        cidadeRepository.save(cidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(new AtracaoResponseDTO(atracao));
    }

    @Transactional
    public ResponseEntity<Object> find(Optional<Long> id) {
        List<Atracao> list = new ArrayList<>();
        if (id.isPresent()) {
            list.add(this.findById(id));
        } else {
            list = atracaoRepository.findAll();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list.stream().map(AtracaoResponseDTO:: new).toList());
    }

    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                atracaoRepository.findAll().stream().map((atracao)->new AtracaoResponseDTO(atracao)).toList()
        );
    }

    @Transactional
    public Atracao findById(Optional<Long> id) {
        Optional<Atracao> atracao = atracaoRepository.findById(id.get());
        if (id.isPresent()) {
            return atracao.orElseThrow(() -> new ObjectNotFoundException(id.get()));
        } else {
            return null;
        }
    }

    @Transactional
    public ResponseEntity<Object> delete(Optional<Long> id) {
        atracaoRepository.delete(this.findById(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    public ResponseEntity<Object> update(Optional<Long> id, AtracaoRequestDTO atracaoRequestDTO) {
        Atracao atracao = this.findById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AtracaoResponseDTO(atracaoRepository.save((Atracao) atracaoRequestDTO.toObject(atracao))));
    }
}