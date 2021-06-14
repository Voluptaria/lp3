package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.model.Funcionario;
import com.voluptaria.vlpt.service.FuncionarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Funcionario> funcionarios = service.getFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity get(@PathVariable("cpf") String cpf){
        Optional<Funcionario> funcionario = service.getFuncionarioById(cpf);
        return ResponseEntity.ok(funcionario);

    }
}
