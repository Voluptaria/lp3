package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.dto.ClienteDTO;
import com.voluptaria.vlpt.model.Cliente;
import com.voluptaria.vlpt.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {

    private final ClienteRepository repository;

    public List<ClienteDTO> getClientes(){

        return repository.findAll()
                .stream().map(ClienteDTO::createDTO).collect(Collectors.toList());
    }

    public ClienteDTO getClienteById(Long id){
        Cliente cliente = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
        return ClienteDTO.createDTO(cliente);
    }
}
