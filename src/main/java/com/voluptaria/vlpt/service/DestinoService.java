package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.model.Destino;
import com.voluptaria.vlpt.repository.DestinoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DestinoService {

    private final DestinoRepository repository;

    public List<Destino> getDestinos(){
        return repository.findAll();
    }

    public Optional<Destino> getDestinoById(Long id){
        return repository.findById(id);
    }
}
