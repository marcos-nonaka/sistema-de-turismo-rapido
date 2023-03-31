package com.turismorapidobackend.turismorapidobackend.controller;

import com.turismorapidobackend.turismorapidobackend.dto.RoteiroRequestDTO;
import com.turismorapidobackend.turismorapidobackend.services.RoteiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roteiros")
public class RoteiroController {
    @Autowired
    RoteiroService roteiroService;

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody RoteiroRequestDTO roteiroRequestDTO){
        return roteiroService.save(roteiroRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(name = "id") Long id){
        return roteiroService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return roteiroService.findAll();
    }
}
