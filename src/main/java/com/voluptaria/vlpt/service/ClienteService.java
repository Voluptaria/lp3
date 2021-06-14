package com.voluptaria.vlpt.service;

//import com.voluptaria.vlpt.api.dto.ClienteDTO;
import com.voluptaria.vlpt.model.entity.Cliente;
import com.voluptaria.vlpt.model.repository.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public List<Cliente> getClientes(){
        return repository.findAll();
    }

    public Optional<Cliente> getClienteById(String cpf){
        return repository.findById(cpf);
    }
}
