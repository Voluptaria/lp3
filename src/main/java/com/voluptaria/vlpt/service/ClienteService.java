package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.model.entity.Cliente;
import com.voluptaria.vlpt.model.Repository.ClienteRepository;
import com.voluptaria.vlpt.model.Repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {

    private final ClienteRepository repository;
    private final EnderecoRepository enderecoRepository;

    public List<Cliente> getClientes() {
        return repository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        validar(cliente);
        cliente.setEndereco(enderecoRepository.save(cliente.getEndereco()));
        return repository.save(cliente);
    }

    @Transactional
    public Cliente update(Cliente cliente) {
        Objects.requireNonNull(cliente.getId());
        Cliente clienteSalvo = repository.getById(cliente.getId());
        cliente.getEndereco().setId(clienteSalvo.getEndereco().getId());
        validar(cliente);
        return save(cliente);
    }

    @Transactional
    public void delete(Cliente cliente) {
        Objects.requireNonNull(cliente.getId());
        repository.delete(cliente);
    }

    private void validar(Cliente cliente) {
    }


}
