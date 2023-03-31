package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.RoteiroRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.RoteiroResponseDTO;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import com.turismorapidobackend.turismorapidobackend.model.Roteiro;
import com.turismorapidobackend.turismorapidobackend.repository.CidadeRepository;
import com.turismorapidobackend.turismorapidobackend.repository.RoteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoteiroService {
    @Autowired
    RoteiroRepository roteiroRepository;

    @Autowired
    CidadeRepository cidadeRepository;
    public ResponseEntity<Object> save(RoteiroRequestDTO roteiroRequestDTO) {
        Cidade cidade = cidadeRepository.findById(roteiroRequestDTO.getId_cidade()).get();
        Roteiro roteiro = new Roteiro();

        /*roteiro.setAlimentacao(roteiroRequestDTO.get());
        roteiro.setHoteis(roteiroRequestDTO.getCep());
        roteiro.setAtracoes(roteiroRequestDTO.getAtracoes());
        //Perguntar ao Thalyson
        roteiro.setClient(roteiroRequestDTO.getAlimentacoes());
        roteiro.setValor(roteiroRequestDTO.getHotels());
        roteiro.setLongitude(roteiroRequestDTO.getLongitude());
        roteiro.setLatitude(roteiroRequestDTO.getLatitude());*/

        cidadeRepository.save(cidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeRepository.save(cidade));
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
