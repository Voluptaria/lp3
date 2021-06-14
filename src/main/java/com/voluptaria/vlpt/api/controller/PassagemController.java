package com.voluptaria.vlpt.api.controller;

import com.voluptaria.vlpt.model.entity.Passagem;
import com.voluptaria.vlpt.service.PassagemService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/passagens")
@RequiredArgsConstructor
public class PassagemController {


    private final PassagemService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Passagem> passagens = service.getPassagens();
        return ResponseEntity.ok(passagens);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Passagem> passagem = service.getPassagemById(id);
        return ResponseEntity.ok(passagem);

    }
}
