package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.PassagemDTO;
import com.voluptaria.vlpt.model.Passagem;
import com.voluptaria.vlpt.service.PassagemService;
import lombok.AllArgsConstructor;
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
@RequestMapping("/api/v1/passagens")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PassagemController {

    private final PassagemService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Passagem> passagens = service.getPassagens();
        return ResponseEntity.ok(passagens.stream().map(PassagemDTO::createDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        Optional<Passagem> passagem = service.getPassagemById(id);
        if(passagem.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Passagem não encontrada");
        }
        return ResponseEntity.ok(PassagemDTO.createDTO(passagem.get()));

    }
}
