package com.voluptaria.vlpt.service;

//import com.voluptaria.vlpt.api.dto.DestinoDTO;
import com.voluptaria.vlpt.model.Destino;
import com.voluptaria.vlpt.repository.DestinoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DestinoService {

    private final DestinoRepository repository;

    public List<Destino> getDestinos(){
        return repository.findAll();
    }

    public Destino getDestinoById(long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Destino não encontrado"));
    }
}
