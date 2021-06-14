package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.model.Destino;
import com.voluptaria.vlpt.service.DestinoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/destinos")
@RequiredArgsConstructor
public class DestinoController {

    private final DestinoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Destino> destinos = service.getDestinos();
        return ResponseEntity.ok(destinos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") long id){
        Optional<Destino> destino = service.getDestinoById(id);
        return ResponseEntity.ok(destino);

    }
}
