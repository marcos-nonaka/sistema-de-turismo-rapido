// package com.turismorapidobackend.turismorapidobackend.controller;

// import com.turismorapidobackend.turismorapidobackend.dto.TurismologoRequestDTO;
// import com.turismorapidobackend.turismorapidobackend.services.TurismologoService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/turismologo")
// public class TurismologoController {
//     @Autowired
//     TurismologoService turismologoService;

//     @PostMapping
//     public ResponseEntity<Object> save(
//         @RequestBody TurismologoRequestDTO turismologoRequestDTO){
//         return turismologoService.save(turismologoRequestDTO);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Object> findById(
//             @PathVariable(name = "id") Long id){
//         return turismologoService.findById(id);
//     }

//     @GetMapping
//     public ResponseEntity<Object> findAll(){
//         return turismologoService.findAll();
//     }
// }
