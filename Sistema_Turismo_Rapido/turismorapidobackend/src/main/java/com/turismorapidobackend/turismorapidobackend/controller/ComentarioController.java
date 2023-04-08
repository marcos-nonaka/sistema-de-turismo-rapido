package com.turismorapidobackend.turismorapidobackend.controller;

import com.turismorapidobackend.turismorapidobackend.dto.ComentarioRequestDTO;
import com.turismorapidobackend.turismorapidobackend.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ComentarioRequestDTO comentarioRequestDTO){
        return comentarioService.save(comentarioRequestDTO);
    }

    @GetMapping(value= {"", "/", "/{id}"})
    public ResponseEntity<Object> find(
            @PathVariable(name = "id") Optional<Long> id,
            @RequestParam(value="comment", required=false) Optional<String> comment) {
        return comentarioService.find(id, comment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@NonNull @PathVariable(name = "id") Optional<Long> id){
        return comentarioService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@NonNull @PathVariable(name = "id") Optional<Long> id, @RequestBody ComentarioRequestDTO comentarioRequestDTO) {
        return comentarioService.update(id, comentarioRequestDTO);
    }
}
