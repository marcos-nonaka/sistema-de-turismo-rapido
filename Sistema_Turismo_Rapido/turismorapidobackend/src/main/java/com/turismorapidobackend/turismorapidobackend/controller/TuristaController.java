// package com.turismorapidobackend.turismorapidobackend.controller;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.turismorapidobackend.turismorapidobackend.dto.TuristaRequestDTO;
// import com.turismorapidobackend.turismorapidobackend.services.TuristaService;


// @RestController
// @RequestMapping("/turistas")
// public class TuristaController {

//     @Autowired
//     TuristaService turistaService;

//     @GetMapping("/{id}")
//     public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id){
//         return turistaService.findById(id);
//     }

//     @PostMapping
//     public ResponseEntity<Object> save(@RequestBody TuristaRequestDTO turistaRequestDTO){
//         return turistaService.save(turistaRequestDTO);
//     }
    
// }
