package com.voluptaria.vlpt.service;

//import com.voluptaria.vlpt.api.dto.FuncionarioDTO;
import com.voluptaria.vlpt.model.Funcionario;
import com.voluptaria.vlpt.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public List<Funcionario> getFuncionarios(){
        return repository.findAll();
    }

    public Funcionario getFuncionarioById(Long id){

        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Funcionario não encontrado"));
    }
}
