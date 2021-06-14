package com.voluptaria.vlpt.service;

//import com.voluptaria.vlpt.api.dto.DestinoDTO;
import com.voluptaria.vlpt.model.entity.Destino;
import com.voluptaria.vlpt.model.repository.DestinoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinoService {


    private DestinoRepository repository;

    public DestinoService(DestinoRepository repository){
        this.repository = repository;
    }

    public List<Destino> getDestinos(){
        return repository.findAll();
    }

    public Optional<Destino> getDestinoById(long id){
        return repository.findById(id);
    }
}
