package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.FuncionarioDTO;
import com.voluptaria.vlpt.dto.PacoteDTO;
import com.voluptaria.vlpt.model.Funcionario;
import com.voluptaria.vlpt.service.FuncionarioService;
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
@RequestMapping("/api/v1/funcionarios")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FuncionarioController {

    private final FuncionarioService service;

    @GetMapping()
    public ResponseEntity getAll() {
        List<Funcionario> funcionarios = service.getFuncionarios();
        return ResponseEntity.ok(funcionarios.stream().map(FuncionarioDTO::createDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        Optional<Funcionario> funcionario = service.getFuncionarioById(id);
        if(funcionario.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Funcionário não encontrado");
        }
       return ResponseEntity.ok(FuncionarioDTO.createDTO(funcionario.get()));
    }

    @GetMapping("/{id}/pacotes")
    public ResponseEntity getPacotes(@PathVariable Long id){
        Optional<Funcionario> funcionario = service.getFuncionarioById(id);
        if(funcionario.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Funcionário não encontrado");
        }
        return ResponseEntity.ok(funcionario.get().getPacotes()
                .stream().map(PacoteDTO::createDTO).collect(Collectors.toList()));
    }
}
