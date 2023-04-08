package com.turismorapidobackend.turismorapidobackend.controller;

import com.turismorapidobackend.turismorapidobackend.dto.CidadeRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.RoteiroRequestDTO;
import com.turismorapidobackend.turismorapidobackend.services.RoteiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/roteiros")
public class RoteiroController {
    @Autowired
    RoteiroService roteiroService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody RoteiroRequestDTO roteiroRequestDTO){
        return roteiroService.save(roteiroRequestDTO);
    }

    @GetMapping(value= {"", "/", "/{id}"})
    public ResponseEntity<Object> find(
            @PathVariable(name = "id") Optional<Long> id,
            @RequestParam(value="name", required=false) Optional<String> name){
        return roteiroService.find(id, name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@NonNull @PathVariable(name = "id") Optional<Long> id){
        return roteiroService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@NonNull @PathVariable(name = "id") Optional<Long> id, @RequestBody RoteiroRequestDTO roteiroRequestDTO) {
        return roteiroService.update(id, roteiroRequestDTO);
    }
}
