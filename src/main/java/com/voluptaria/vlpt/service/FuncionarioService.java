package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.dto.FuncionarioDTO;
import com.voluptaria.vlpt.model.Funcionario;
import com.voluptaria.vlpt.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public List<FuncionarioDTO> getFuncionarios(){

        return repository.findAll()
                .stream().map(FuncionarioDTO::createDTO).collect(Collectors.toList());
    }

    public FuncionarioDTO getFuncionarioById(Long id){

        Funcionario funcionario = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Funcionario não encontrado"));
        return FuncionarioDTO.createDTO(funcionario);
    }
}
