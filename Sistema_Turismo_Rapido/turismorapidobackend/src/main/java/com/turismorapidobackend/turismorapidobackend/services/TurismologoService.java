package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.ClientRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.TurismologoRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.TurismologoResponseDTO;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.model.Turismologo;
import com.turismorapidobackend.turismorapidobackend.model.Turista;
import com.turismorapidobackend.turismorapidobackend.repository.ClientRepository;
import com.turismorapidobackend.turismorapidobackend.repository.TurismologoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurismologoService {
    @Autowired
    TurismologoRepository turismologoRepository;

    @Autowired
    TurismologoService turismologoService;

    @Autowired
    ClientRepository clientRepository;

    @Transactional
    public ResponseEntity<Object> save(TurismologoRequestDTO turismologoRequestDTO) {
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        BeanUtils.copyProperties(turismologoRequestDTO, clientRequestDTO);
        Client client = clientRequestDTO.toClient();

        clientRepository.save(client);

        Turismologo turismologo = new Turismologo();

        turismologo.setSomething("teste");
        turismologo.setClient(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(turismologoRepository.save(turismologo));
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Turismologo> turismologoOptional = turismologoRepository.findById(id);

        if(turismologoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new TurismologoResponseDTO(turismologoOptional.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turismologo não encontrado.");
        }
    }

    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                turismologoRepository.findAll().stream().map((turismologo)->new TurismologoResponseDTO(turismologo)).toList()
        );
    }
}
