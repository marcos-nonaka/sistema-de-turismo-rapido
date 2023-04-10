package com.turismorapidobackend.turismorapidobackend.controller;

import com.turismorapidobackend.turismorapidobackend.dto.AlimentacaoRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.ClientRequestDTO;
import com.turismorapidobackend.turismorapidobackend.services.AlimentacaoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/alimentacao")
public class AlimentacaoController {
    @Autowired
    AlimentacaoService alimentacaoService;

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody @Valid AlimentacaoRequestDTO alimentacaoRequestDTO){
        return alimentacaoService.save(alimentacaoRequestDTO);
    }

    @GetMapping(value= {"", "/", "/{id}"})
    public ResponseEntity<Object> find(@PathVariable(name = "id") Optional<Long> id) {
        return alimentacaoService.find(id);
    }

//    @GetMapping("/")
//    public ResponseEntity<Object> findAll(){
//        return alimentacaoService.findAll();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@NonNull @PathVariable(name = "id") Optional<Long> id){
        return alimentacaoService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@NonNull @PathVariable(name = "id") Optional<Long> id, @RequestBody AlimentacaoRequestDTO alimentacaoRequestDTO) {
        return alimentacaoService.update(id, alimentacaoRequestDTO);
    }
}
