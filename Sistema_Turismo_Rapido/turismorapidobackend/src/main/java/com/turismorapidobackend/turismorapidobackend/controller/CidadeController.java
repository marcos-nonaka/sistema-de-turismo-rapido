package com.turismorapidobackend.turismorapidobackend.controller;

import com.turismorapidobackend.turismorapidobackend.dto.CidadeRequestDTO;
import com.turismorapidobackend.turismorapidobackend.services.CidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    @Autowired
    CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody CidadeRequestDTO cidadeRequestDTO){
        return cidadeService.save(cidadeRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(name = "id") Long id){
        return cidadeService.findById(id);
    }
}
