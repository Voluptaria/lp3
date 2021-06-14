package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.dto.DestinoDTO;
import com.voluptaria.vlpt.model.Destino;
import com.voluptaria.vlpt.repository.DestinoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DestinoService {

    private final DestinoRepository repository;

    public List<DestinoDTO> getDestinos(){

        return repository.findAll()
                .stream().map(DestinoDTO::createDTO).collect(Collectors.toList());
    }

    public DestinoDTO getDestinoById(long id){
        Destino destino = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Destino não encontrado"));
        return DestinoDTO.createDTO(destino);
    }
}
