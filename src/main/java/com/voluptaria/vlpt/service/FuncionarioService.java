package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.model.entity.Funcionario;
import com.voluptaria.vlpt.model.Repository.EnderecoRepository;
import com.voluptaria.vlpt.model.Repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final EnderecoRepository enderecoRepository;

    public List<Funcionario> getFuncionarios(){
        return repository.findAll();
    }

    public Optional<Funcionario> getFuncionarioById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Funcionario save(Funcionario funcionario) {
        validar(funcionario);
        funcionario.setEndereco(enderecoRepository.save(funcionario.getEndereco()));
        return repository.save(funcionario);
    }

    @Transactional
    public Funcionario update(Funcionario funcionario) {
        Objects.requireNonNull(funcionario.getId());
        Funcionario funcionarioSalvo = repository.getById(funcionario.getId());
        funcionario.getEndereco().setId(funcionarioSalvo.getEndereco().getId());
        return save(funcionario);
    }

    private void validar(Funcionario funcionario) {
    }
}
