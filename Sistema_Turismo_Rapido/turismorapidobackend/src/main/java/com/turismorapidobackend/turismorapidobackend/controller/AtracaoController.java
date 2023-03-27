package com.turismorapidobackend.turismorapidobackend.controller;

import com.turismorapidobackend.turismorapidobackend.dto.AtracaoRequestDTO;
import com.turismorapidobackend.turismorapidobackend.services.AtracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atracoes")
public class AtracaoController {
    @Autowired
    AtracaoService atracaoService;

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody AtracaoRequestDTO atracaoRequestDTO){
        return atracaoService.save(atracaoRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(name = "id") Long id){
        return atracaoService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return atracaoService.findAll();
    }
}
