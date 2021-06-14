package com.voluptaria.vlpt.api.controller;

import com.voluptaria.vlpt.model.entity.Cliente;
import com.voluptaria.vlpt.service.ClienteService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Cliente> clientes = service.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity get(@PathVariable("cnpj") String cnpj){
        Optional<Cliente> empresa = service.getClienteById(cnpj);
        return ResponseEntity.ok(empresa);

    }
}
