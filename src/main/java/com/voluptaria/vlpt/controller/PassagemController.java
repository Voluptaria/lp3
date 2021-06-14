package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.model.Passagem;
import com.voluptaria.vlpt.service.PassagemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passagens")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PassagemController {

    private final PassagemService service;

    @GetMapping()
    public ResponseEntity<List<Passagem>> get(){
        List<Passagem> passagens = service.getPassagens();
        return ResponseEntity.ok(passagens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passagem> get(@PathVariable Long id){
        return ResponseEntity.ok(service.getPassagemById(id));

    }
}
