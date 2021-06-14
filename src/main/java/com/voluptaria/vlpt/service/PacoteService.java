package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.dto.PacoteDTO;
import com.voluptaria.vlpt.model.Pacote;
import com.voluptaria.vlpt.repository.PacoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PacoteService {

    private final PacoteRepository repository;

    public List<PacoteDTO> getPacotes(){

        return repository.findAll()
                .stream().map(PacoteDTO::createDTO).collect(Collectors.toList());
    }

    public PacoteDTO getPacoteById(Long id){

       Pacote pacote = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pacote não encontrado"));
       return PacoteDTO.createDTO(pacote);
    }
}
