package com.voluptaria.vlpt.controller;

import com.voluptaria.vlpt.dto.*;
import com.voluptaria.vlpt.dto.FuncionarioDTO;
import com.voluptaria.vlpt.exception.RegraNegocioException;
import com.voluptaria.vlpt.model.entity.Endereco;
import com.voluptaria.vlpt.model.entity.Funcionario;
import com.voluptaria.vlpt.service.EnderecoService;
import com.voluptaria.vlpt.service.FuncionarioService;
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
@RequestMapping("/api/v1/funcionarios")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FuncionarioController {

    private final FuncionarioService service;
    private final EnderecoService enderecoService;

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

    @PostMapping
    public ResponseEntity post(FuncionarioDTO funcionarioDTO){
        try {
            Funcionario funcionario = convertToModel(funcionarioDTO);
            Endereco endereco = enderecoService.save(funcionario.getEndereco());
            funcionario.setEndereco(endereco);
            Funcionario funcionarioSalvo = service.save(funcionario);
            return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable Long id,@RequestBody FuncionarioDTO funcionarioDTO){
        if(service.getFuncionarioById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não Encontrado");
        }
        try {
            Funcionario funcionario = convertToModel(funcionarioDTO);
            funcionario.setId(id);
            service.update(funcionario);
            return ResponseEntity.ok(funcionario);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Optional<Funcionario> funcionario = service.getFuncionarioById(id);
        if (!funcionario.isPresent()) {
            return new ResponseEntity("Funcionario não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            service.delete(funcionario.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Funcionario convertToModel(FuncionarioDTO funcionarioDTO){
        ModelMapper modelMapper = new ModelMapper();
        Funcionario funcionario = modelMapper.map(funcionarioDTO, Funcionario.class);
        Endereco endereco = modelMapper.map(funcionarioDTO, Endereco.class);
        funcionario.setEndereco(endereco);
        return modelMapper.map(funcionarioDTO, Funcionario.class);
    }
}
