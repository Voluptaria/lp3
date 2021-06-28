package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.model.Cliente;
import com.voluptaria.vlpt.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {

    private final ClienteRepository repository;

    public List<Cliente> getClientes(){
        return repository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id){
        return repository.findById(id);
    }
}
