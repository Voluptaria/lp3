package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.*;
import com.voluptaria.vlpt.dto.EmpresaDTO;
import com.voluptaria.vlpt.exception.RegraNegocioException;
import com.voluptaria.vlpt.model.entity.Cliente;
import com.voluptaria.vlpt.model.entity.Empresa;
import com.voluptaria.vlpt.model.entity.Endereco;
import com.voluptaria.vlpt.service.EmpresaService;
import com.voluptaria.vlpt.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/empresas")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmpresaController {

    private final EmpresaService service;
    private final EnderecoService enderecoService;

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

    @PostMapping
    public ResponseEntity post(EmpresaDTO empresaDTO){
        try {
            Empresa empresa = convertToModel(empresaDTO);
            Endereco endereco = enderecoService.save(empresa.getEndereco());
            empresa.setEndereco(endereco);
            Empresa empresaSalvo = service.save(empresa);
            return ResponseEntity.status(HttpStatus.CREATED).body(empresaSalvo);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable Long id,@RequestBody EmpresaDTO empresaDTO){
        if(service.getEmpresaById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não Encontrado");
        }
        try {
            Empresa empresa = convertToModel(empresaDTO);
            empresa.setId(id);
            service.update(empresa);
            return ResponseEntity.ok(empresa);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Optional<Empresa> empresa = service.getEmpresaById(id);
        if (!empresa.isPresent()) {
            return new ResponseEntity("Empresa não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            service.delete(empresa.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Empresa convertToModel(EmpresaDTO empresaDTO){
        ModelMapper modelMapper = new ModelMapper();
        Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);
        Endereco endereco = modelMapper.map(empresaDTO, Endereco.class);
        empresa.setEndereco(endereco);
        return modelMapper.map(empresaDTO, Empresa.class);
    }
}
