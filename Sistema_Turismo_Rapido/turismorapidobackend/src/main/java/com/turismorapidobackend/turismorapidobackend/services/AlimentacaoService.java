package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.*;
import com.turismorapidobackend.turismorapidobackend.exceptionhandler.ObjectNotFoundException;
import com.turismorapidobackend.turismorapidobackend.model.Alimentacao;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.repository.AlimentacaoRepository;
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
public class AlimentacaoService {
    @Autowired
    AlimentacaoRepository alimentacaoRepository;
    @Autowired
    CidadeRepository cidadeRepository;
    public ResponseEntity<Object> save(AlimentacaoRequestDTO alimentacaoRequestDTO) {
        Cidade cidade = cidadeRepository.findById(alimentacaoRequestDTO.getId_cidade()).get();

        Alimentacao alimentacao = new Alimentacao();

        alimentacao.setLocal_name(alimentacaoRequestDTO.getLocal_name());
        alimentacao.setDescription(alimentacaoRequestDTO.getDescription());
        alimentacao.setStreet_district(alimentacaoRequestDTO.getStreet_district());
        alimentacao.setStreet_name(alimentacaoRequestDTO.getStreet_name());
        alimentacao.setPhone_number(alimentacaoRequestDTO.getPhone_number());
        alimentacao.setStreet_number(alimentacaoRequestDTO.getStreet_number());
        alimentacao.setLongitude(alimentacaoRequestDTO.getLongitude());
        alimentacao.setLatitude(alimentacaoRequestDTO.getLatitude());

        alimentacao.setCidade(cidade);
        alimentacao = alimentacaoRepository.save(alimentacao);

        cidade.getAlimentacoes().add(alimentacao);
        cidadeRepository.save(cidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(new AlimentacaoResponseDTO(alimentacao));
    }

    public ResponseEntity<Object> find(Optional<Long> id) {
        List<Alimentacao> list = new ArrayList<>();
        if (id.isPresent()) {
            list.add(this.findById(id));
        } else {
            list = alimentacaoRepository.findAll();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list.stream().map(AlimentacaoResponseDTO:: new).toList());
    }

    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                alimentacaoRepository.findAll().stream().map((alimentacao)->new AlimentacaoResponseDTO(alimentacao)).toList()
        );
    }
    @Transactional
    public Alimentacao findById(Optional<Long> id) {
        Optional<Alimentacao> alimentacao = alimentacaoRepository.findById(id.get());
        if (id.isPresent()) {
            return alimentacao.orElseThrow(() -> new ObjectNotFoundException(id.get()));
        } else {
            return null;
        }
    }

    @Transactional
    public ResponseEntity<Object> delete(Optional<Long> id) {
        alimentacaoRepository.delete(this.findById(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    public ResponseEntity<Object> update(Optional<Long> id, AlimentacaoRequestDTO alimentacaoRequestDTO) {
        Alimentacao alimentacao = this.findById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AlimentacaoResponseDTO(alimentacaoRepository.save((Alimentacao) alimentacaoRequestDTO.toObject(alimentacao))));
    }
}
