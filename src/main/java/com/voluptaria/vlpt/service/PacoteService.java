package com.voluptaria.vlpt.service;

//import com.voluptaria.vlpt.api.dto.PacoteDTO;
import com.voluptaria.vlpt.model.Pacote;
import com.voluptaria.vlpt.repository.PacoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PacoteService {

    private final PacoteRepository repository;

    public List<Pacote> getPacotes(){
        return repository.findAll();
    }

    public Pacote getPacoteById(Long id){

        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pacote não encontrado"));
    }
}
