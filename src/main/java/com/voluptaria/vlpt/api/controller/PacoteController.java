package com.voluptaria.vlpt.api.controller;

import com.voluptaria.vlpt.model.entity.Pacote;
import com.voluptaria.vlpt.service.PacoteService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pacotes")
@RequiredArgsConstructor
public class PacoteController {

    private final PacoteService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Pacote> pacotes = service.getPacotes();
        return ResponseEntity.ok(pacotes);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity get(@PathVariable("cpf") Long id){
        Optional<Pacote> pacote = service.getPacoteById(id);
        return ResponseEntity.ok(pacote);

    }
}
