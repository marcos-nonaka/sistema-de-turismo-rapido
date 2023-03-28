package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.AtracaoRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.AtracaoResponseDTO;
import com.turismorapidobackend.turismorapidobackend.dto.CidadeRequestDTO;
//import com.turismorapidobackend.turismorapidobackend.dto.TurismologoResponseDTO;
import com.turismorapidobackend.turismorapidobackend.model.Atracao;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
//import com.turismorapidobackend.turismorapidobackend.model.Turismologo;
import com.turismorapidobackend.turismorapidobackend.repository.AtracaoRepository;
import com.turismorapidobackend.turismorapidobackend.repository.CidadeRepository;
import com.turismorapidobackend.turismorapidobackend.repository.ClientRepository;
//import com.turismorapidobackend.turismorapidobackend.repository.TurismologoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

        return ResponseEntity.status(HttpStatus.CREATED).body(atracaoRepository.save(atracao));
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Atracao> atracaoOptional = atracaoRepository.findById(id);

        if(atracaoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new AtracaoResponseDTO(atracaoOptional.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atração não encontrada.");
        }
    }

    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                atracaoRepository.findAll().stream().map((atracao)->new AtracaoResponseDTO(atracao)).toList()
        );
    }
}
