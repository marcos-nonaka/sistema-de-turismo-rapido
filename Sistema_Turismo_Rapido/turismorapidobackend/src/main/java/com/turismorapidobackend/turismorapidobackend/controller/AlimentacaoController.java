package com.turismorapidobackend.turismorapidobackend.controller;

import com.turismorapidobackend.turismorapidobackend.dto.AlimentacaoRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.AtracaoRequestDTO;
import com.turismorapidobackend.turismorapidobackend.services.AlimentacaoService;
import com.turismorapidobackend.turismorapidobackend.services.AtracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alimentacao")
public class AlimentacaoController {
    @Autowired
    AlimentacaoService alimentacaoService;

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody AlimentacaoRequestDTO alimentacaoRequestDTO){
        return alimentacaoService.save(alimentacaoRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(name = "id") Long id){
        return alimentacaoService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return alimentacaoService.findAll();
    }
}
