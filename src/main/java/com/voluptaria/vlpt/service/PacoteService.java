package com.voluptaria.vlpt.service;

//import com.voluptaria.vlpt.api.dto.PacoteDTO;
import com.voluptaria.vlpt.model.entity.Pacote;
import com.voluptaria.vlpt.model.repository.PacoteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacoteService {

    private PacoteRepository repository;

    public PacoteService(PacoteRepository repository){
        this.repository = repository;
    }

    public List<Pacote> getPacotes(){
        return repository.findAll();
    }

    public Optional<Pacote> getPacoteById(long id){
        return repository.findById(id);
    }
}
