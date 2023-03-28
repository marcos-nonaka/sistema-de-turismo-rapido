package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.AlimentacaoRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.AlimentacaoResponseDTO;
import com.turismorapidobackend.turismorapidobackend.dto.AtracaoResponseDTO;
import com.turismorapidobackend.turismorapidobackend.model.Alimentacao;
import com.turismorapidobackend.turismorapidobackend.model.Atracao;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import com.turismorapidobackend.turismorapidobackend.repository.AlimentacaoRepository;
import com.turismorapidobackend.turismorapidobackend.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

        //cidadeRepository.save(cidade);

        alimentacao.setCidade(cidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(alimentacaoRepository.save(alimentacao));
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Alimentacao> alimentacaoOptional = alimentacaoRepository.findById(id);

        if(alimentacaoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new AlimentacaoResponseDTO(alimentacaoOptional.get()));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alimentação não encontrada.");
        }
    }

    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                alimentacaoRepository.findAll().stream().map((alimentacao)->new AlimentacaoResponseDTO(alimentacao)).toList()
        );
    }
}
