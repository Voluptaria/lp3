package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.FuncionarioDTO;
import com.voluptaria.vlpt.model.Funcionario;
import com.voluptaria.vlpt.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/funcionarios")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FuncionarioController {

    private final FuncionarioService service;

    @GetMapping()
    public ResponseEntity<List<FuncionarioDTO>> get() {
        return ResponseEntity.ok(service.getFuncionarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> get(@PathVariable Long id){
       return ResponseEntity.ok(service.getFuncionarioById(id));

    }
}
