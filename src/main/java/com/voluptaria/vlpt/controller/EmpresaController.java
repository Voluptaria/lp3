package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.DestinoDTO;
import com.voluptaria.vlpt.dto.EmpresaDTO;
import com.voluptaria.vlpt.dto.PassagemDTO;
import com.voluptaria.vlpt.model.Empresa;
import com.voluptaria.vlpt.service.EmpresaService;
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
@RequestMapping("/api/v1/empresas")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmpresaController {

    private final EmpresaService service;

    @GetMapping()
    public ResponseEntity getAll() {
        List<Empresa> empresas = service.getEmpresas();
        return ResponseEntity.ok(empresas.stream().map(EmpresaDTO::createDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        Optional<Empresa> empresa = service.getEmpresaById(id);
        if(empresa.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empresa não encontrada");
        }
        return ResponseEntity.ok(EmpresaDTO.createDTO(empresa.get()));
    }

    @GetMapping("/{id}/destinos")
    public ResponseEntity getDestinos(@PathVariable Long id){
        Optional<Empresa> empresa = service.getEmpresaById(id);
        if(empresa.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empresa não encontrada");
        }
        return ResponseEntity.ok(empresa.get().getDestinos()
                .stream().map(DestinoDTO::createDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}/passagens")
    public ResponseEntity getPassagens(@PathVariable Long id){
        Optional<Empresa> empresa = service.getEmpresaById(id);
        if(empresa.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empresa não encontrada");
        }
        return ResponseEntity.ok(empresa.get().getPassagens()
                .stream().map(PassagemDTO::createDTO).collect(Collectors.toList()));
    }
}
