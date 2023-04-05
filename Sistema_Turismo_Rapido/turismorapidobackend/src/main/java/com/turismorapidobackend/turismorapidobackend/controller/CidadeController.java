package com.turismorapidobackend.turismorapidobackend.controller;

import com.turismorapidobackend.turismorapidobackend.dto.CidadeRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.CidadeResponseDTO;
import com.turismorapidobackend.turismorapidobackend.dto.ClientResponseDTO;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.services.CidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<CidadeResponseDTO> findAll(@RequestParam(name="name", defaultValue="") String name){

        List<Cidade> list = cidadeService.findAll(name);

        return list.stream().map(CidadeResponseDTO:: new).toList();
    }
}
