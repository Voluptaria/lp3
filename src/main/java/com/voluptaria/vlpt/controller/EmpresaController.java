package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.model.Empresa;
import com.voluptaria.vlpt.service.EmpresaService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Empresa> empresas = service.getEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity get(@PathVariable("cnpj") String cnpj){
        Optional<Empresa> empresa = service.getEmpresaById(cnpj);
        return ResponseEntity.ok(empresa);

    }
}
