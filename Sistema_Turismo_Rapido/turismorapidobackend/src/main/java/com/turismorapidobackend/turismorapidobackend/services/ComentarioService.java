package com.turismorapidobackend.turismorapidobackend.services;

import com.turismorapidobackend.turismorapidobackend.dto.*;
import com.turismorapidobackend.turismorapidobackend.exceptionhandler.ObjectNotFoundException;
import com.turismorapidobackend.turismorapidobackend.model.*;
import com.turismorapidobackend.turismorapidobackend.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {
    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RoteiroRepository roteiroRepository;

    public ResponseEntity<Object> save(ComentarioRequestDTO comentarioRequestDTO) {
        Comentario comentario = new Comentario();
        comentario.setComentario(comentarioRequestDTO.getComentario());
        comentario.setClient(clientRepository.findById(comentarioRequestDTO.getId_client()).get());
        comentario.setRoteiro(roteiroRepository.findById(comentarioRequestDTO.getId_roteiro()).get());
        comentario = comentarioRepository.save(comentario);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ComentarioResponseDTO(comentario));
    }

    @Transactional
    public ResponseEntity<Object> find(Optional<Long> id, Optional<String> comment) {
        List<Comentario> list = new ArrayList<>();
        if (id.isPresent() && comment.isPresent()) {
            list = comentarioRepository.findByIdComentarioAndComentarioContainingIgnoreCase(id.get(), comment.get());
        } else if (id.isPresent()) {
            list.add(this.findById(id));
        } else if (comment.isPresent()) {
            list = comentarioRepository.findByComentarioContainingIgnoreCase(comment.get());
        } else {
            list = comentarioRepository.findAll();
        }
        if (list.isEmpty()) {
            throw new ObjectNotFoundException();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(list.stream().map(ComentarioResponseDTO:: new).toList());
    }

    @Transactional
    public Comentario findById(Optional<Long> id) {
        Optional<Comentario> comentario = comentarioRepository.findById(id.get());
        if (id.isPresent()) {
            return comentario.orElseThrow(() -> new ObjectNotFoundException(id.get()));
        } else {
            return null;
        }
    }

    @Transactional
    public ResponseEntity<Object> delete(Optional<Long> id) {
        comentarioRepository.delete(this.findById(id));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    public ResponseEntity<Object> update(Optional<Long> id, ComentarioRequestDTO comentarioRequestDTO) {
        Comentario comentario = this.findById(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ComentarioResponseDTO(comentarioRepository.save((Comentario) comentarioRequestDTO.toObject(comentario))));
    }

}
