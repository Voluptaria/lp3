package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.PacoteDTO;
import com.voluptaria.vlpt.model.Pacote;
import com.voluptaria.vlpt.service.PacoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacotes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PacoteController {

    private final PacoteService service;

    @GetMapping()
    public ResponseEntity<List<PacoteDTO>> get() {
        return ResponseEntity.ok(service.getPacotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacoteDTO> get(@PathVariable Long id){
       return ResponseEntity.ok(service.getPacoteById(id));

    }
}
