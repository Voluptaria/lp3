package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.model.Empresa;
import com.voluptaria.vlpt.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empresas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmpresaController {

    private final EmpresaService service;

    @GetMapping()
    public ResponseEntity<List<Empresa>> get() {
        List<Empresa> empresas = service.getEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> get(@PathVariable Long id){
        return ResponseEntity.ok(service.getEmpresaById(id));

    }
}
