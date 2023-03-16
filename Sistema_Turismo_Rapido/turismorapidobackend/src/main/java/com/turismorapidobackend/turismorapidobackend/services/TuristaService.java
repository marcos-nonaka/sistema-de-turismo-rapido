package com.turismorapidobackend.turismorapidobackend.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.turismorapidobackend.turismorapidobackend.dto.ClientRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.TuristaRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.TuristaResponseDTO;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.model.Turista;
import com.turismorapidobackend.turismorapidobackend.repository.ClientRepository;
import com.turismorapidobackend.turismorapidobackend.repository.TuristaRepository;

import jakarta.transaction.Transactional;

@Service
public class TuristaService {
    
    @Autowired
    TuristaRepository turistaRepository;

    @Autowired
    ClientRepository clientRepository;

    public ResponseEntity<Object> findById(Long id) {
        Optional<Turista> turistaOptional = turistaRepository.findById(id);

        if(turistaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new TuristaResponseDTO(turistaOptional.get()));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
    }

    @Transactional
    public ResponseEntity<Object> save(TuristaRequestDTO turistaRequestDTO) {

        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        BeanUtils.copyProperties(turistaRequestDTO, clientRequestDTO);
        Client client = clientRequestDTO.toClient();

        clientRepository.save(client);

        Turista turista = new Turista();

        turista.setClient(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(turistaRepository.save(turista));

    }
}
