package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.DestinoDTO;
import com.voluptaria.vlpt.dto.PacoteDTO;
import com.voluptaria.vlpt.dto.PassagemDTO;
import com.voluptaria.vlpt.model.Pacote;
import com.voluptaria.vlpt.service.PacoteService;
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
@RequestMapping("/api/v1/pacotes")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PacoteController {

    private final PacoteService service;

    @GetMapping()
    public ResponseEntity getAll() {
        List<Pacote> pacotes = service.getPacotes();
        return ResponseEntity.ok(pacotes.stream().map(PacoteDTO::createDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        Optional<Pacote> pacote = service.getPacoteById(id);
        if(pacote.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pacote não encontrado");
        }
       return ResponseEntity.ok(PacoteDTO.createDTO(pacote.get()));
    }

    @GetMapping("/{id}/destinos")
    public ResponseEntity getDestinos(@PathVariable Long id){
        Optional<Pacote> pacote = service.getPacoteById(id);
        if(pacote.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pacote não encontrado");
        }
        return ResponseEntity.ok(pacote.get().getDestinos()
                .stream().map(DestinoDTO::createDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}/passagens")
    public ResponseEntity getPassagens(@PathVariable Long id){
        Optional<Pacote> pacote = service.getPacoteById(id);
        if(pacote.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pacote não encontrado");
        }
        return ResponseEntity.ok(pacote.get().getPassagens()
                .stream().map(PassagemDTO::createDTO).collect(Collectors.toList()));
    }
}
