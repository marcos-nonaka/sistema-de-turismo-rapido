package com.turismorapidobackend.turismorapidobackend.controller;

import com.turismorapidobackend.turismorapidobackend.dto.AtracaoRequestDTO;
import com.turismorapidobackend.turismorapidobackend.services.AtracaoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/atracoes")
public class AtracaoController {
    @Autowired
    AtracaoService atracaoService;

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody @Valid AtracaoRequestDTO atracaoRequestDTO){
        return atracaoService.save(atracaoRequestDTO);
    }

    @GetMapping(value= {"", "/", "/{id}"})
    public ResponseEntity<Object> find(
            @PathVariable(name = "id") Optional<Long> id,
            @RequestParam(value="name", required=false) Optional<String> name){
        return atracaoService.find(id, name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@NonNull @PathVariable(name = "id") Optional<Long> id){
        return atracaoService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@NonNull @PathVariable(name = "id") Optional<Long> id, @RequestBody AtracaoRequestDTO atracaoRequestDTO) {
        return atracaoService.update(id, atracaoRequestDTO);
    }
}