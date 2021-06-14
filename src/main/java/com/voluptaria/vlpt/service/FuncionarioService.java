package com.voluptaria.vlpt.service;

//import com.voluptaria.vlpt.api.dto.FuncionarioDTO;
import com.voluptaria.vlpt.model.Funcionario;
import com.voluptaria.vlpt.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }

    public List<Funcionario> getFuncionarios(){
        return repository.findAll();
    }

    public Optional<Funcionario> getFuncionarioById(String cpf){
        return repository.findById(cpf);
    }
}
