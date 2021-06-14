package com.voluptaria.vlpt.service;

//import com.voluptaria.vlpt.api.dto.PassagemDTO;
import com.voluptaria.vlpt.model.Passagem;
import com.voluptaria.vlpt.repository.PassagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PassagemService {

    private final PassagemRepository repository;

    public List<Passagem> getPassagens(){
        return repository.findAll();
    }

    public Passagem getPassagemById(Long id){

        return repository.findById(id).orElseThrow(()-> new RuntimeException("Passagem não encontrado"));
    }
}
