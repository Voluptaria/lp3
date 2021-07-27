package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.model.Repository.EnderecoRepository;
import com.voluptaria.vlpt.model.entity.Endereco;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoService {

    private final EnderecoRepository repository;


    public List<Endereco> getEnderecos(){
        return repository.findAll();
    }

    public Optional<Endereco> getEnderecoById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Endereco save(Endereco endereco) {
        validar(endereco);
        return repository.save(endereco);
    }

    @Transactional
    public Endereco update(Endereco endereco) {
        Objects.requireNonNull(endereco.getId());
        return save(endereco);
    }

    private void validar(Endereco endereco) {

    }
}
