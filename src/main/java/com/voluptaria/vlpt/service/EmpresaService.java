package com.voluptaria.vlpt.service;

import com.voluptaria.vlpt.model.entity.Empresa;
import com.voluptaria.vlpt.model.Repository.EmpresaRepository;
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
public class EmpresaService {

    private final EmpresaRepository repository;

    private final EnderecoRepository enderecoRepository;

    public List<Empresa> getEmpresas(){
        return repository.findAll();
    }
    public Optional<Empresa> getEmpresaById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Empresa save(Empresa empresa) {
        validar(empresa);
        empresa.setEndereco(enderecoRepository.save(empresa.getEndereco()));
        return repository.save(empresa);
    }

    @Transactional
    public Empresa update(Empresa empresa) {
        Objects.requireNonNull(empresa.getId());
        Empresa empresaSalvo = repository.getById(empresa.getId());
        empresa.getEndereco().setId(empresaSalvo.getEndereco().getId());
        return save(empresa);
    }

    private void validar(Empresa empresa) {
    }
}
