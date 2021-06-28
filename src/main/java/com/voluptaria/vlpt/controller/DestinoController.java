package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.DestinoDTO;
import com.voluptaria.vlpt.model.Destino;
import com.voluptaria.vlpt.service.DestinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/destinos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DestinoController {

    private final DestinoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Destino> destinos = service.getDestinos();
        return ResponseEntity.ok(destinos.stream().map(DestinoDTO::createDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        Optional<Destino> destino = service.getDestinoById(id);
        if(destino.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Destino não encontrado");
        }
       return ResponseEntity.ok(DestinoDTO.createDTO(destino.get()));

    }
}
