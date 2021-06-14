package com.voluptaria.vlpt.service;

//import com.voluptaria.vlpt.api.dto.PassagemDTO;

import com.voluptaria.vlpt.dto.PassagemDTO;
import com.voluptaria.vlpt.model.Passagem;
import com.voluptaria.vlpt.repository.PassagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PassagemService {

    private final PassagemRepository repository;

    public List<PassagemDTO> getPassagens(){

        return repository.findAll()
                .stream().map(PassagemDTO::createDTO).collect(Collectors.toList());
    }

    public PassagemDTO getPassagemById(Long id){

        Passagem passagem = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Passagem não encontrado"));
        return PassagemDTO.createDTO(passagem);
    }
}
