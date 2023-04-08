package com.turismorapidobackend.turismorapidobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.services.ClientService;

import java.util.Optional;

@RestController
@RequestMapping("/quatour")
public class QuatourController {

    @Autowired
    ClientService clientService;

    @GetMapping("/user")
    public ResponseEntity<Object> findClient(){
    Object principal = SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();

    if(principal instanceof Client client) {
        return ResponseEntity.status(HttpStatus.OK)
        .body(clientService.findById(Optional.of(client.getIdClient())));
    }else{
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    }

    
}
