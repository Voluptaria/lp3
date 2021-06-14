package com.voluptaria.vlpt.service;

//import com.voluptaria.vlpt.api.dto.PassagemDTO;
import com.voluptaria.vlpt.model.entity.Passagem;
import com.voluptaria.vlpt.model.repository.PassagemRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class PassagemService {

    private PassagemRepository repository;

    public PassagemService(PassagemRepository repository){
        this.repository = repository;
    }

    public List<Passagem> getPassagens(){
        return repository.findAll();
    }

    public Optional<Passagem> getPassagemById(long id){
        return repository.findById(id);
    }
}
