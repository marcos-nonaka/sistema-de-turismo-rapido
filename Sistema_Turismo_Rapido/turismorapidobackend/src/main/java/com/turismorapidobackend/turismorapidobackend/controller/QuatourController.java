package com.turismorapidobackend.turismorapidobackend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.model.Roteiro;
import com.turismorapidobackend.turismorapidobackend.repository.ClientRepository;
import com.turismorapidobackend.turismorapidobackend.repository.RoteiroRepository;
import com.turismorapidobackend.turismorapidobackend.services.ClientService;

@RestController
@RequestMapping("/quatour")
public class QuatourController {

    @Autowired
    ClientService clientService;

    @Autowired
    RoteiroRepository roteiroRepository;


    @GetMapping("/user")
    public ResponseEntity<Object> findClient(){
    Object principal = SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();

    if(principal instanceof Client client) {
        
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(client.getIdClient()).getBody());
    }else{
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    }

    // @GetMapping("/roteiros-salvos")
    // public ResponseEntity<Object> findRoteirosSalvos(){
    //     Object principal = SecurityContextHolder
    //     .getContext()
    //     .getAuthentication()
    //     .getPrincipal();

    //     if(principal instanceof Client client){
    //         Long client_id = client.getId_client();

    //         Optional<Roteiro> roteiroOptional = roteiroRepository.findById(client_id);

    //         return ResponseEntity.status(HttpStatus.OK)
    //             .body(clientService.findById(client.getId_client()).getBody());
    //         }else{
    //             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    //     }
    }

